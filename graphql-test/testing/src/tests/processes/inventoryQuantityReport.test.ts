import xlsx from 'node-xlsx';
import { PdfData } from 'pdfdataextract';
import { Ad_ProcessGetDocument, ReportOutput } from '../../__generated__/graphql';
import { query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeInventory, documentSubTypeSalesOrder } from '../../models';
import {
	changeWarehouse,
	createBusinessPartner,
	createInventory,
	createOrder,
	createProduct,
	runReport,
	tomorrow,
	yesterday,
} from '../../utils';

const reportUuid = '93d7c1bc-2885-43f4-985f-90f57a414e5f';

test('inventory quantity report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: beginDateParameter!.Name,
			Parameter: yesterday().toISOString(),
		},
		{
			AD_Process: { UU: process.UU },
			ParameterName: endDateParameter!.Name,
			Parameter: tomorrow().toISOString(),
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('filter by parameter name and column name is sent to report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	await createProduct(valueObject);

	valueObject.stepName = 'Create PO 1';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	valueObject.quantity = 10;
	await createOrder(valueObject);

	valueObject.stepName = 'Adjust inventory 1';
	valueObject.documentAction = documentAction.Complete;
	valueObject.quantity = 50;
	await valueObject.setDocumentBaseType(
		documentBaseType.MaterialPhysicalInventory,
		{ inventory: documentSubTypeInventory.PhysicalInventory },
		false,
		false,
		false,
	);
	await createInventory(valueObject);

	valueObject.stepName = 'Create sales order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.OnCreditOrder },
		true,
		false,
		false,
	);
	valueObject.quantity = 20;
	await createOrder(valueObject);

	valueObject.stepName = 'Create product 2';
	valueObject.clearProduct();
	await createProduct(valueObject);

	valueObject.stepName = 'Create PO 2';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	valueObject.quantity = 40;
	await createOrder(valueObject);

	valueObject.stepName = 'Change warehouse';
	await changeWarehouse(valueObject);

	valueObject.stepName = 'Adjust inventory 1';
	valueObject.documentAction = documentAction.Complete;
	valueObject.quantity = 150;
	await valueObject.setDocumentBaseType(
		documentBaseType.MaterialPhysicalInventory,
		{ inventory: documentSubTypeInventory.PhysicalInventory },
		false,
		false,
		false,
	);
	await createInventory(valueObject);

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');
	const storeroomParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Storeroom');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(storeroomParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: beginDateParameter!.Name,
			Parameter: yesterday().toISOString(),
		},
		{
			AD_Process: { UU: process.UU },
			ParameterName: endDateParameter!.Name,
			Parameter: tomorrow().toISOString(),
		},
		{
			AD_Process: { UU: process.UU },
			ParameterName: storeroomParameter!.Name,
			Parameter: valueObject.warehouse!.UU,
		},
	];
	valueObject.reportType = ReportOutput.Xlsx;
	await runReport(valueObject);

	const excelFile = xlsx.parse(valueObject.report!);
	const productRow = excelFile[0].data.filter((row) =>
		row.some((cell) => (cell?.toString() as string | undefined) === valueObject.product!.Name),
	)?.[0];
	expect(productRow).toBeTruthy();
	expect(productRow![1]).toBe(0);
	expect(productRow![2]).toBe(0);
	expect(productRow![3]).toBe(0);
	expect(productRow![4]).toBe(150);
	expect(productRow![5]).toBe(150);
});
