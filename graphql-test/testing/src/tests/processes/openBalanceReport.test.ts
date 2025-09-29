import { PdfData } from 'pdfdataextract';
import {
	Ad_ProcessGetDocument,
	Ad_ProcessGetQuery,
	Bh_VisitProcessDocument,
	ProcessInfoParameterInput,
} from '../../__generated__/graphql';
import { mutate, query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import { RoleName } from '../../types/roleName';
import {
	createBusinessPartner,
	createInOutFromOrder,
	createOrder,
	createProduct,
	createVisit,
	runReport,
} from '../../utils';

const reportUuid = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505';
let process: Ad_ProcessGetQuery['AD_ProcessGet']['Results'][0];
let processInformationParameter: ProcessInfoParameterInput | undefined;

// Set up the data we'll be looking at
beforeAll(async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create material receipt';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];

	expect(process).toBeTruthy();
	expect(process.AD_Process_ParaList).toHaveLength(1);
	processInformationParameter = {
		AD_Process: { UU: process.UU },
		ParameterName: process.AD_Process_ParaList![0]!.Name,
		Parameter: valueObject.businessPartner!.UU,
	};
});

test('admin role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('clinic admin role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicAdmin);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('cashier/registration basic role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.CashierRegistrationBasic);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('cashier/registration basic plus role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.CashierRegistrationBasicPlus);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('cashier/registration advanced role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.CashierRegistrationAdvanced);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('inventory/pharmacy role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.InventoryPharmacyAdvanced);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('clinician/nurse basic role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicianNurseBasic);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('clinician/nurse advanced role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicianNurseAdvanced);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('triage role cannot run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.Triage);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	expect(runReport(valueObject)).rejects.toBeTruthy();
});

test('lab/radiology advanced role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.LabRadiologyAdvanced);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('lab/radiology basic role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.LabRadiologyBasic);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('accounting role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.Accounting);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('clinic user role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicUser);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.UU;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});
