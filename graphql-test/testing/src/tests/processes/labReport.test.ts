/*import { PdfData } from 'pdfdataextract';
import {
	Ad_ProcessGetDocument,
	Bh_VisitProcessDocument,
	Bh_Encounter_Type_WindowGetDocument,
	Bh_ConceptGetDocument,
	Bh_VisitGetDocument,
	Bh_EncounterSaveManyForVisitsDocument,
} from '../../__generated__/graphql';
import { readFileSync } from 'fs';
import path from 'path';
import { v4 } from 'uuid';
import { mutate, query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import {
	createBusinessPartner,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	runReport,
} from '../../utils';

const reportUuid = '1a7175fe-2afe-4404-9c56-58d2fda9bc57';

test('Lab report is runnable', async () => {
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

	const encounterTypeWindow = (
		await query(valueObject)({
			query: Bh_Encounter_Type_WindowGetDocument,
			variables: { Filter: JSON.stringify({ ad_window: { ad_window_uu: '12071666-e1ad-4a91-9fd4-ca46c8ebb622' } }) },
		})
	).data.BH_Encounter_Type_WindowGet.Results[0];
	expect(encounterTypeWindow).toBeTruthy();

	const diagnostic = (await query(valueObject)({
		query: Bh_ConceptGetDocument, variables: {
			Size: 1,
			Filter: JSON.stringify({ BH_Source: { $text: 'BHLabs' } })
		}
	}))
		.data.BH_ConceptGet.Results[0];
	expect(diagnostic).toBeTruthy();
	const encounterUuid = v4();
	await mutate(valueObject)({
		mutation: Bh_EncounterSaveManyForVisitsDocument,
		variables: {
			BH_Encounters: [
				{
					UU: encounterUuid,
					BH_Visit: { UU: valueObject.visit!.UU },
					BH_Encounter_Type: { UU: encounterTypeWindow.BH_Encounter_Type.UU },
					BH_Encounter_Date: valueObject.date?.getTime(),
				},
			],
			BH_EncounterDiagnostics: [
				{
					BH_Encounter: { UU: encounterUuid },
					LineNo: 1,
					BH_Concept: { UU: diagnostic.UU },
				},
			],
		},
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { Filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UU }) },
		})
	).data.BH_VisitGet.Results[0];

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: process.AD_Process_ParaList![0].Name,
			Parameter: valueObject.visit!.UU,
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
*/
