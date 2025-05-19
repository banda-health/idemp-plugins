import { PdfData } from 'pdfdataextract';
import { v4 } from 'uuid';
import {
	Ad_ProcessGetDocument,
	Bh_BPartner_TagsSaveDocument,
	Bh_ConceptSaveDocument,
	Bh_Encounter_DiagnosisSaveManyDocument,
	Bh_Encounter_Type_WindowGetDocument,
	Bh_EncounterSaveManyForVisitsDocument,
	Bh_TagSaveDocument,
} from '../../__generated__/graphql';
import { mutate, query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import {
	createBusinessPartner,
	createOrder,
	createProduct,
	createVisit,
	runReport,
	tomorrow,
	yesterday,
} from '../../utils';

const reportUuid = '7c29028a-8dd3-4025-a5af-87701748d81f';
const clinicalDetailsWindowUU = '2e37e97b-aeb5-47d7-add3-0d602233c2aa';

test('diagnosis report is runnable', async () => {
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
	const codedDiagnosisParameter = process.AD_Process_ParaList?.find(
		(parameter) => parameter.Name === 'Coded Diagnosis',
	);
	const uncodedDiagnosisParameter = process.AD_Process_ParaList?.find(
		(parameter) => parameter.Name === 'Uncoded Diagnosis',
	);

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(codedDiagnosisParameter).toBeTruthy();
	expect(uncodedDiagnosisParameter).toBeTruthy();

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

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test('can filter by tags', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner 1';
	await createBusinessPartner(valueObject);
	const businessPartner1 = valueObject.businessPartner!;

	valueObject.stepName = 'Create product';
	await createProduct(valueObject);
	const firstBusinessPartnerName = valueObject.businessPartner!.Name;

	valueObject.stepName = 'Create purchase order';
	valueObject.quantity = 10;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create first coded diagnosis';
	let conceptUU = (
		await mutate(valueObject)({
			mutation: Bh_ConceptSaveDocument,
			variables: {
				BH_Concept: { BH_Display_Name: valueObject.random.toString(), Ocl_Uuid: valueObject.random.toString() },
			},
		})
	).data?.BH_ConceptSave.UU;

	valueObject.stepName = 'Create first visit';
	await createVisit(valueObject);

	valueObject.stepName = 'Create first visit diagnosis';
	let encounterUU = (
		await mutate(valueObject)({
			mutation: Bh_EncounterSaveManyForVisitsDocument,
			variables: {
				BH_Encounters: {
					BH_Encounter_Date: new Date().getTime(),
					BH_Encounter_Type: {
						UU: (
							await query(valueObject)({
								query: Bh_Encounter_Type_WindowGetDocument,
								variables: { Filter: JSON.stringify({ ad_window: { ad_window_uu: clinicalDetailsWindowUU } }) },
							})
						).data.BH_Encounter_Type_WindowGet.Results[0].BH_Encounter_Type.UU,
					},
					BH_Visit: { UU: valueObject.visit!.UU },
				},
			},
		})
	).data?.BH_EncounterSaveMany[0].UU;
	await mutate(valueObject)({
		mutation: Bh_Encounter_DiagnosisSaveManyDocument,
		variables: {
			BH_Encounter_Diagnoses: {
				BH_Concept: { UU: conceptUU! },
				BH_Encounter: { UU: encounterUU! },
				LineNo: 10,
			},
		},
	});

	valueObject.stepName = 'Create first sales order';
	valueObject.quantity = 1;
	valueObject.setRandom();
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.OnCreditOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create second business partner';
	valueObject.businessPartner = undefined;
	valueObject.setRandom();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create tag 1';
	const tag1UU = v4();
	await mutate(valueObject)({
		mutation: Bh_TagSaveDocument,
		variables: {
			Entity: {
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
				Name: valueObject.random + valueObject.getStepMessageLong(),
				UU: tag1UU,
			},
		},
	});
	await mutate(valueObject)({
		mutation: Bh_BPartner_TagsSaveDocument,
		variables: { Entity: { BH_Tag: { UU: tag1UU }, C_BPartner: { UU: valueObject.businessPartner!.UU } } },
	});

	valueObject.stepName = 'Create second coded diagnosis';
	conceptUU = (
		await mutate(valueObject)({
			mutation: Bh_ConceptSaveDocument,
			variables: {
				BH_Concept: { BH_Display_Name: valueObject.random.toString(), Ocl_Uuid: valueObject.random.toString() },
			},
		})
	).data?.BH_ConceptSave.UU;

	valueObject.stepName = 'Create second visit';
	await createVisit(valueObject);

	valueObject.stepName = 'Create second visit diagnosis';
	encounterUU = (
		await mutate(valueObject)({
			mutation: Bh_EncounterSaveManyForVisitsDocument,
			variables: {
				BH_Encounters: {
					BH_Encounter_Date: new Date().getTime(),
					BH_Encounter_Type: {
						UU: (
							await query(valueObject)({
								query: Bh_Encounter_Type_WindowGetDocument,
								variables: { Filter: JSON.stringify({ ad_window: { ad_window_uu: clinicalDetailsWindowUU } }) },
							})
						).data.BH_Encounter_Type_WindowGet.Results[0].BH_Encounter_Type.UU,
					},
					BH_Visit: { UU: valueObject.visit!.UU },
				},
			},
		})
	).data?.BH_EncounterSaveMany[0].UU;
	await mutate(valueObject)({
		mutation: Bh_Encounter_DiagnosisSaveManyDocument,
		variables: {
			BH_Encounter_Diagnoses: {
				BH_Concept: { UU: conceptUU! },
				BH_Encounter: { UU: encounterUU! },
				LineNo: 10,
			},
		},
	});

	valueObject.stepName = 'Create second sales order';
	valueObject.quantity = 1;
	valueObject.setRandom();
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.OnCreditOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');
	const tagsParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Tags');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(tagsParameter).toBeTruthy();

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
			ParameterName: tagsParameter!.Name,
			Parameter: [tag1UU],
		},
	];
	await runReport(valueObject);

	const reportText = (await PdfData.extract(valueObject.report!)).text?.[0].replaceAll(' ', '');
	expect(reportText).toBeTruthy();
	expect(reportText?.includes(businessPartner1.Name.replaceAll(' ', ''))).toBeFalsy();
	expect(reportText?.includes(valueObject.businessPartner!.Name.replaceAll(' ', ''))).toBeTruthy();
});
