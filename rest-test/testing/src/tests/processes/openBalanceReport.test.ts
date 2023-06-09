import { PdfData } from 'pdfdataextract';
import { processApi, visitApi } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import { Process, ProcessInfoParameter } from '../../types/org.bandahealth.idempiere.rest';
import { RoleName } from '../../types/roleName';
import {
	createOrder,
	createPatient,
	createProduct,
	createPurchaseOrder,
	createVendor,
	createVisit,
	runReport,
} from '../../utils';

const reportUuid = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505';
let process: Process | undefined;
let processInformationParameter: ProcessInfoParameter | undefined;

// Set up the data we'll be looking at
beforeAll(async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	process = (
		await processApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ad_process_uu: reportUuid }))
	).results[0];

	expect(process).toBeTruthy();
	expect(process.parameters).toHaveLength(1);
	processInformationParameter = {
		processParameterUuid: process.parameters[0]!.uuid,
		parameter: valueObject.businessPartner!.uuid,
	} as ProcessInfoParameter;
});

test('admin role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('clinic admin role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicAdmin);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('cashier/registration basic role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.CashierRegistrationBasic);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('cashier/registration advanced role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.CashierRegistrationAdvanced);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('inventory/pharmacy role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.InventoryPharmacy);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('clinician/nurse basic role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicianNurseBasic);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('clinician/nurse advanced role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicianNurseAdvanced);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('triage role cannot run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.Triage);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	expect(runReport(valueObject)).rejects.toBeTruthy();
});

test('lab/radiology role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.LabRadiology);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('accounting role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.Accounting);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('clinic user role can run report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicUser);

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process!.uuid;
	valueObject.processInformationParameters = [processInformationParameter!];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
