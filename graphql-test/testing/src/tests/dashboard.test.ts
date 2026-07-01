import { v4 } from 'uuid';
import {
	Ad_Ref_ListGetDocument,
	Bh_ConceptGetDocument,
	Bh_Encounter_DiagnosisSaveManyDocument,
	Bh_EncounterAndObservationsSaveManyDocument,
	Bh_EncounterSaveManyForVisitsDocument,
	Bh_Encounter_Type_WindowGetDocument,
	Bh_VisitGetDocument,
	Bh_VisitProcessDocument,
	Bh_VisitSaveDocument,
	C_BPartnerGetDocument,
	DashboardFinancialHistoricalGetDocument,
	DashboardFinancialVisitChargesGetDocument,
	DashboardGeneralDataGetDocument,
	DashboardInventoryHistoricalChargeEarningGetDocument,
	DashboardInventoryHistoricalValueGetDocument,
	DashboardVisitHistoryStatGetDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder, referenceUuid } from '../models';
import {
	createBusinessPartner,
	createInOutFromOrder,
	createInvoice,
	createOrder,
	createPatient,
	createPayment,
	createProduct,
	yesterday,
} from '../utils';
import type { ValueObject } from '../models/valueObject';

const CLINICAL_VITALS_WINDOW_UUID = '53b4d743-c311-40e5-aa8e-c0880c42c1b1';
const CLINICAL_DETAILS_WINDOW_UUID = '2e37e97b-aeb5-47d7-add3-0d602233c2aa';
const HEIGHT_FIELD_UUID = '2842fb94-b841-4973-903e-89c7f24455b2';

function startOfDayMs(date: Date): number {
	return Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(), 0, 0, 0, 0);
}

function endOfDayMs(date: Date): number {
	return Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(), 23, 59, 59, 999);
}

function dayKey(timestamp: number): string {
	const date = new Date(timestamp);
	return `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`;
}

/** Midday UTC on a calendar day — matches backdated visit tests and timestamptz storage. */
function stableTestDate(date: Date): Date {
	const copy = new Date(date);
	copy.setUTCHours(12, 0, 0, 0);
	return copy;
}

/** Isolated day for metric tests; unlikely to overlap other suites' yesterday/today visits. */
function daysAgo(days: number): Date {
	const date = new Date();
	date.setUTCDate(date.getUTCDate() - days);
	return stableTestDate(date);
}

async function getDashboardGeneralData(valueObject: ValueObject, beginDate: Date, endDate: Date) {
	return (
		await query(valueObject)({
			query: DashboardGeneralDataGetDocument,
			variables: {
				BeginDate: startOfDayMs(beginDate),
				EndDate: endOfDayMs(endDate),
			},
		})
	).data.DashboardGeneralDataGet;
}

async function preparePatient(valueObject: ValueObject) {
	valueObject.clearBusinessPartner();
	await createPatient(valueObject);
}

async function setupSellableProduct(valueObject: ValueObject) {
	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	valueObject.quantity = 10;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create material receipt';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);
	valueObject.quantity = 1;
}

async function getVisitTypeUuid(valueObject: ValueObject, name: string) {
	const visitTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.VISIT_TYPE }, isactive: true }),
			},
		})
	).data.AD_Ref_ListGet.Results;
	const visitType = visitTypes.find((type) => type.Name === name);
	expect(visitType).toBeTruthy();
	return visitType!.UU;
}

async function saveVisit(valueObject: ValueObject, visitTypeUuid?: string) {
	const visitUuid = (
		await mutate(valueObject)({
			mutation: Bh_VisitSaveDocument,
			variables: {
				Entity: {
					Description: valueObject.getStepMessageLong(),
					Patient: { UU: valueObject.businessPartner!.UU },
					BH_VisitDate: valueObject.date!.getTime(),
					BH_VisitType: visitTypeUuid ? { UU: visitTypeUuid } : undefined,
				},
			},
		})
	).data?.BH_VisitSave.UU;
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { Filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.Results[0];
	expect(valueObject.visit).toBeTruthy();
}

async function addVitalsEncounter(valueObject: ValueObject) {
	const clinicalVitalsEncounterTypeWindow = (
		await query(valueObject)({
			query: Bh_Encounter_Type_WindowGetDocument,
			variables: { Filter: JSON.stringify({ ad_window: { ad_window_uu: CLINICAL_VITALS_WINDOW_UUID } }) },
		})
	).data.BH_Encounter_Type_WindowGet.Results[0];
	expect(clinicalVitalsEncounterTypeWindow).toBeTruthy();
	const heightField = clinicalVitalsEncounterTypeWindow.AD_Window?.AD_Tabs?.[0].AD_Fields?.find(
		(field) => field.UU === HEIGHT_FIELD_UUID,
	);
	expect(heightField).toBeTruthy();

	const encounterUuid = v4();
	await mutate(valueObject)({
		mutation: Bh_EncounterAndObservationsSaveManyDocument,
		variables: {
			BH_Encounters: [
				{
					UU: encounterUuid,
					BH_Visit: { UU: valueObject.visit!.UU },
					BH_Encounter_Type: { UU: clinicalVitalsEncounterTypeWindow.BH_Encounter_Type.UU },
					BH_Encounter_Date: valueObject.date!.getTime(),
				},
			],
			BH_Observations: [
				{
					BH_Encounter: { UU: encounterUuid },
					AD_Field: { UU: heightField!.UU },
					BH_Value: '170',
				},
			],
		},
	});
}

async function addCodedDiagnosisEncounter(valueObject: ValueObject) {
	const codedDiagnosis = (
		await query(valueObject)({
			query: Bh_ConceptGetDocument,
			variables: {
				Size: 1,
				Filter: JSON.stringify({ BH_Source: { $text: 'BHGO' } }),
			},
		})
	).data.BH_ConceptGet.Results[0];
	expect(codedDiagnosis).toBeTruthy();

	const diagnosisEncounterTypeUuid = (
		await query(valueObject)({
			query: Bh_Encounter_Type_WindowGetDocument,
			variables: { Filter: JSON.stringify({ ad_window: { ad_window_uu: CLINICAL_DETAILS_WINDOW_UUID } }) },
		})
	).data.BH_Encounter_Type_WindowGet.Results[0].BH_Encounter_Type.UU;

	const encounterUuid = (
		await mutate(valueObject)({
			mutation: Bh_EncounterSaveManyForVisitsDocument,
			variables: {
				BH_Encounters: {
					BH_Encounter_Date: valueObject.date!.getTime(),
					BH_Encounter_Type: { UU: diagnosisEncounterTypeUuid },
					BH_Visit: { UU: valueObject.visit!.UU },
				},
			},
		})
	).data?.BH_EncounterSaveMany[0].UU;
	expect(encounterUuid).toBeTruthy();

	await mutate(valueObject)({
		mutation: Bh_Encounter_DiagnosisSaveManyDocument,
		variables: {
			BH_Encounter_Diagnoses: {
				BH_Concept: { UU: codedDiagnosis.UU },
				BH_Encounter: { UU: encounterUuid! },
				LineNo: 10,
			},
		},
	});
}

async function completeVisit(valueObject: ValueObject) {
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});
}

test('six-month time range always returned for historical finances', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardFinancialHistoricalGetDocument })).data
		.DashboardFinancialHistoricalGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());
});

test('six-month time range always returned for historical visit charges', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardFinancialVisitChargesGetDocument })).data
		.DashboardFinancialVisitChargesGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());
});

test('six-month time range always returned for historical inventory values', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardInventoryHistoricalValueGetDocument })).data
		.DashboardInventoryHistoricalValueGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());
});

test('six-month time range always returned for historical inventory charges and earnings', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardInventoryHistoricalChargeEarningGetDocument })).data
		.DashboardInventoryHistoricalChargeEarningGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());
});

test('vitals tracked percent excludes dental and other non-clinical visit types', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	await setupSellableProduct(valueObject);

	const opdVisitTypeUuid = await getVisitTypeUuid(valueObject, 'Outpatient (OPD)');
	const dentalVisitTypeUuid = await getVisitTypeUuid(valueObject, 'Dental');
	const testDay = daysAgo(14);

	const baselinePercent = Number((await getDashboardGeneralData(valueObject, testDay, testDay)).PercentVitalsTracked);

	await preparePatient(valueObject);
	valueObject.stepName = 'Complete OPD visit with vitals';
	valueObject.date = testDay;
	await saveVisit(valueObject, opdVisitTypeUuid);
	await addVitalsEncounter(valueObject);
	await completeVisit(valueObject);

	const afterEligibleVisitPercent = Number(
		(await getDashboardGeneralData(valueObject, testDay, testDay)).PercentVitalsTracked,
	);
	expect(afterEligibleVisitPercent).toBeGreaterThan(baselinePercent);

	valueObject.stepName = 'Complete dental visit without vitals';
	await preparePatient(valueObject);
	valueObject.date = testDay;
	await saveVisit(valueObject, dentalVisitTypeUuid);
	await completeVisit(valueObject);

	const afterExcludedVisitPercent = Number(
		(await getDashboardGeneralData(valueObject, testDay, testDay)).PercentVitalsTracked,
	);
	expect(afterExcludedVisitPercent).toBe(afterEligibleVisitPercent);
});

test('diagnoses coded percent excludes family planning visits', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	await setupSellableProduct(valueObject);

	const opdVisitTypeUuid = await getVisitTypeUuid(valueObject, 'Outpatient (OPD)');
	const familyPlanningVisitTypeUuid = await getVisitTypeUuid(valueObject, 'Family Planning');
	const testDay = daysAgo(15);

	const baselinePercent = Number((await getDashboardGeneralData(valueObject, testDay, testDay)).PercentDiagnosesCoded);

	await preparePatient(valueObject);
	valueObject.stepName = 'Complete OPD visit with coded diagnosis';
	valueObject.date = testDay;
	await saveVisit(valueObject, opdVisitTypeUuid);
	await addCodedDiagnosisEncounter(valueObject);
	await completeVisit(valueObject);

	const afterEligibleVisitPercent = Number(
		(await getDashboardGeneralData(valueObject, testDay, testDay)).PercentDiagnosesCoded,
	);
	expect(afterEligibleVisitPercent).toBeGreaterThan(baselinePercent);

	valueObject.stepName = 'Complete family planning visit without diagnosis';
	await preparePatient(valueObject);
	valueObject.date = testDay;
	await saveVisit(valueObject, familyPlanningVisitTypeUuid);
	await completeVisit(valueObject);

	const afterExcludedVisitPercent = Number(
		(await getDashboardGeneralData(valueObject, testDay, testDay)).PercentDiagnosesCoded,
	);
	expect(afterExcludedVisitPercent).toBe(afterEligibleVisitPercent);
});

test('visit history stats use one bucket per visit day', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	await setupSellableProduct(valueObject);

	const opdVisitTypeUuid = await getVisitTypeUuid(valueObject, 'Outpatient (OPD)');
	const yesterdayDate = yesterday();
	const todayDate = new Date();

	await preparePatient(valueObject);
	valueObject.stepName = 'Complete visit yesterday';
	valueObject.date = yesterdayDate;
	await saveVisit(valueObject, opdVisitTypeUuid);
	await completeVisit(valueObject);

	valueObject.stepName = 'Complete visit today';
	valueObject.date = todayDate;
	valueObject.setRandom();
	await saveVisit(valueObject, opdVisitTypeUuid);
	await completeVisit(valueObject);

	const visitHistory = (
		await query(valueObject)({
			query: DashboardVisitHistoryStatGetDocument,
			variables: {
				BeginDate: startOfDayMs(yesterdayDate),
				EndDate: endOfDayMs(todayDate),
			},
		})
	).data.DashboardVisitHistoryStatGet.filter((stat) => stat != null);

	const bucketDays = new Set(visitHistory.map((stat) => dayKey(stat.BucketValue)));
	expect(bucketDays.has(dayKey(yesterdayDate.getTime()))).toBe(true);
	expect(bucketDays.has(dayKey(todayDate.getTime()))).toBe(true);
	expect(bucketDays.size).toBeGreaterThanOrEqual(2);
	expect(visitHistory.length).not.toBe(6);
});

test('OTC visits appear under the OTC reference list, not alternate visit type', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	await setupSellableProduct(valueObject);

	await preparePatient(valueObject);
	valueObject.stepName = 'Complete regular patient visit';
	valueObject.date = new Date();
	await saveVisit(valueObject, await getVisitTypeUuid(valueObject, 'Outpatient (OPD)'));
	await completeVisit(valueObject);

	const otcPatient = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { Filter: JSON.stringify({ c_bp_group: { name: 'OTC Patient' } }) },
		})
	).data.C_BPartnerGet.Results[0];
	expect(otcPatient).toBeTruthy();

	valueObject.stepName = 'Complete OTC patient visit';
	valueObject.businessPartner = otcPatient;
	valueObject.setRandom();
	valueObject.date = new Date();
	await saveVisit(valueObject);
	await completeVisit(valueObject);

	const visitHistory = (
		await query(valueObject)({
			query: DashboardVisitHistoryStatGetDocument,
			variables: {
				BeginDate: startOfDayMs(valueObject.date!),
				EndDate: endOfDayMs(valueObject.date!),
			},
		})
	).data.DashboardVisitHistoryStatGet.filter((stat) => stat != null);

	const otcStats = visitHistory.filter((stat) => stat.BH_PatientType?.Value === 'ot');
	expect(otcStats.length).toBeGreaterThan(0);
	expect(otcStats.every((stat) => !stat.AlternateVisitType)).toBe(true);
	expect(visitHistory.find((stat) => stat.AlternateVisitType === 'Over the Counter (OTC)')).toBeUndefined();
	expect(
		visitHistory.some((stat) => stat.BH_PatientType?.Value !== 'ot' && stat.BH_PatientType?.Name === 'Outpatient (OPD)'),
	).toBe(true);
});
