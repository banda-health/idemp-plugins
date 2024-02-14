import { randomUUID } from 'crypto';
import xlsx from 'node-xlsx';
import { PdfData } from 'pdfdataextract';
import { v4 } from 'uuid';
import { mutate, query } from '../api';
import {
	documentAction,
	documentBaseType,
	documentStatus,
	documentSubTypeSalesOrder,
	referenceUuid,
	tenderTypeName,
} from '../models';
import {
	createBusinessPartner,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	loadBankAccount,
	loadCurrency,
	runReport,
	tomorrow,
	yesterday,
} from '../utils';
import {
	Ad_LanguageGetDocument,
	Ad_Ref_ListGetDocument,
	Bh_Coded_DiagnosisGetDocument,
	Bh_EncounterAndObservationsSaveManyDocument,
	Bh_EncounterDeleteDocument,
	Bh_EncounterGetDocument,
	Bh_EncounterObservationsAndEncounterDiagnosesSaveManyDocument,
	Bh_Encounter_Type_WindowGetDocument,
	Bh_ObservationsDeleteAndSaveManyAndEncounterDiagnosesDeleteDocument,
	Bh_ObservationsDeleteAndSaveManyAndEncounterDiagnosesSaveManyDocument,
	Bh_VisitDeleteAllDocument,
	Bh_VisitDeleteDocument,
	Bh_VisitGetDocument,
	Bh_VisitProcessDocument,
	Bh_VisitRemoveInsurancePayerDocument,
	Bh_VisitSaveAndProcessWithOrdersDocument,
	Bh_VisitSaveAndProcessWithOrdersInvoicesAndPaymentsDocument,
	Bh_VisitSaveWithEncountersObservationsOrdersInvoicesInsuranceAndPaymentsDocument,
	Bh_VisitSaveWithEncountersOrdersAndInvoicesDocument,
	Bh_VisitSaveWithOrdersAndInvoicesDocument,
	Bh_VisitSaveWithOrdersInvoicesPayerInformationAndPaymentsDocument,
	Bh_Voided_ReasonGetDocument,
	C_BPartnerGetDocument,
	C_BPartnerSaveDocument,
	C_Bp_GroupGetDocument,
	C_InvoiceAndOrderLineDeleteDocument,
	C_PaymentDeleteDocument,
	C_PaymentSaveDocument,
	C_PaymentSaveManyDocument,
	ReportOutput,
} from '../__generated__/graphql';

const CLINICAL_VITALS_WINDOW_UUID = '53b4d743-c311-40e5-aa8e-c0880c42c1b1';
const CHIEF_COMPLAINT_WINDOW_UUID = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed';
const CHIEF_COMPLAINT_FIELD_UUID = 'e1d01fe4-16b6-4125-a385-34cf4531c06f';
const HEIGHT_FIELD_UUID = '2842fb94-b841-4973-903e-89c7f24455b2';
const WEIGHT_FIELD_UUID = 'e0f68d60-0610-4caa-9dc3-b0143101ccd3';

xtest(`information saved correctly after completing a visit`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
});

test(`patient open balance is 0 after visit if complete payment was made`, async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
});

test(`visit saved from scratch is correct`, async () => {
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

	valueObject.stepName = 'Create and complete visit';
	await loadCurrency(valueObject);
	await loadBankAccount(valueObject);
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const tenderTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES } }) },
		})
	).data.AD_Ref_ListGet.results;
	const visitUuid = randomUUID();
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();
	const invoiceUuid = randomUUID();
	await mutate(valueObject)({
		mutation: Bh_VisitSaveAndProcessWithOrdersInvoicesAndPaymentsDocument,
		variables: {
			BH_Visit: {
				UUID: visitUuid,
				Description: valueObject.getStepMessageLong(),
				Patient: { UUID: valueObject.businessPartner!.UUID },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			C_Orders: [
				{
					UUID: orderUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					DateOrdered: valueObject.date?.getTime(),
					M_Warehouse: { UUID: valueObject.warehouse!.UUID },
					C_DocTypeTarget: { UUID: salesOrderDocumentType.UUID },
					IsSOTrx: salesOrderDocumentType.IsSOTrx,
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
				},
			],
			C_OrderLines: [
				{
					C_Order: { UUID: orderUuid },
					UUID: orderLineUuid,
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
				},
			],
			C_Invoices: [
				{
					UUID: invoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_Order: { UUID: orderUuid },
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
			],
			C_InvoiceLines: [
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
					C_OrderLine: { UUID: orderLineUuid },
				},
			],
			C_Payments: [
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 60,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CASH)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 40,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.MOBILE_MONEY)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
			UUID: visitUuid,
			DocumentAction: documentAction.Complete,
		},
	});
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.results[0];

	expect(valueObject.visit.C_Orders?.every((order) => order.DocStatus.Value === documentStatus.Completed));
	expect(valueObject.visit.C_Invoices?.every((invoice) => invoice.DocStatus.Value === documentStatus.Completed));
	expect(valueObject.visit.C_Payments?.every((payment) => payment.DocStatus.Value === documentStatus.Completed));

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
});

test(`patient open balance updated after visit if complete payment wasn't made`, async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 50;
	valueObject.tenderType = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				size: 1,
				filter: JSON.stringify({
					ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
					name: tenderTypeName.CASH,
				}),
			},
		})
	).data.AD_Ref_ListGet.results[0];
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(50);
});

test(`patient open balance reverted correctly after visit with partial payment is re-opened`, async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 50;
	valueObject.tenderType = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				size: 1,
				filter: JSON.stringify({
					ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
					name: tenderTypeName.CASH,
				}),
			},
		})
	).data.AD_Ref_ListGet.results[0];
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(50);

	valueObject.stepName = 'Reverse visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	const visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	const newPayment = visit.C_Payments?.find((payment) => payment.DocStatus.Value === documentStatus.Drafted)!;
	expect(newPayment).not.toBeUndefined();
	await mutate(valueObject)({
		mutation: C_PaymentSaveDocument,
		variables: { entity: { UUID: newPayment.UUID, PayAmt: 40 } },
	});
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(60);
});

test(`patient open balance correct with multiple payments`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	const totalCharge = 100;
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payments';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const tenderTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES } }) },
		})
	).data.AD_Ref_ListGet.results;

	valueObject.stepName = 'Complete visit';
	await loadCurrency(valueObject);
	await loadBankAccount(valueObject);
	let paymentTotal = 80; // Make this match the total below
	await mutate(valueObject)({
		mutation: C_PaymentSaveManyDocument,
		variables: {
			entities: [
				{
					PayAmt: 50,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CASH)!.UUID },
					C_DocType: { UUID: valueObject.documentType!.UUID },
					BH_Visit: { UUID: valueObject.visit!.UUID },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
				{
					PayAmt: 30,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.MOBILE_MONEY)!.UUID },
					C_DocType: { UUID: valueObject.documentType!.UUID },
					BH_Visit: { UUID: valueObject.visit!.UUID },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
		},
	});
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(totalCharge - paymentTotal);

	valueObject.stepName = 'Reverse visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	const newPayment = valueObject.visit.C_Payments?.find((payment) => payment.DocStatus.Value === 'DR')!;
	expect(newPayment).not.toBeUndefined();
	newPayment.PayAmt = 40;
	paymentTotal = valueObject.visit.C_Payments?.filter(
		(payment) => !['RE', 'VO'].includes(payment.DocStatus.Value),
	).reduce((runningTotal, payment) => runningTotal + payment.PayAmt, 0)!;
	await mutate(valueObject)({
		mutation: C_PaymentSaveManyDocument,
		variables: {
			entities: [
				{
					UUID: newPayment.UUID,
					PayAmt: newPayment.PayAmt,
				},
			],
		},
	});
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(totalCharge - paymentTotal);
});

test('payments can be removed and added to re-opened visit', async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = valueObject.salesStandardPrice;
	valueObject.tenderType = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				size: 1,
				filter: JSON.stringify({
					ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
					name: tenderTypeName.CASH,
				}),
			},
		})
	).data.AD_Ref_ListGet.results[0];
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Reverse visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	// Delete the any drafted payments created due to visit re-activation
	await mutate(valueObject)({
		mutation: C_PaymentDeleteDocument,
		variables: {
			uuids: valueObject.visit.C_Payments?.filter((payment) => payment.DocStatus.Value === 'DR').map(
				(payment) => payment.UUID,
			)!,
		},
	});
	await mutate(valueObject)({
		mutation: C_PaymentSaveManyDocument,
		variables: {
			entities: [
				{
					PayAmt: valueObject.salesStandardPrice,
					TenderType: {
						UUID: (
							await query(valueObject)({
								query: Ad_Ref_ListGetDocument,
								variables: {
									filter: JSON.stringify({
										ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
										name: tenderTypeName.MOBILE_MONEY,
									}),
								},
							})
						).data.AD_Ref_ListGet.results[0].UUID,
					},
					C_DocType: { UUID: valueObject.documentType!.UUID },
					BH_Visit: { UUID: valueObject.visit!.UUID },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
		},
	});
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Reverse visit again';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Re-completing visit again';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	// Delete the any drafted payments created due to visit re-activation
	await mutate(valueObject)({
		mutation: C_PaymentDeleteDocument,
		variables: {
			uuids: valueObject.visit.C_Payments?.filter((payment) => payment.DocStatus.Value === 'DR').map(
				(payment) => payment.UUID,
			)!,
		},
	});
	await mutate(valueObject)({
		mutation: C_PaymentSaveManyDocument,
		variables: {
			entities: [
				{
					PayAmt: valueObject.salesStandardPrice,
					TenderType: {
						UUID: (
							await query(valueObject)({
								query: Ad_Ref_ListGetDocument,
								variables: {
									filter: JSON.stringify({
										ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
										name: tenderTypeName.CHEQUE,
									}),
								},
							})
						).data.AD_Ref_ListGet.results[0].UUID,
					},
					C_DocType: { UUID: valueObject.documentType!.UUID },
					BH_Visit: { UUID: valueObject.visit!.UUID },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
		},
	});
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
});

test('re-opened visit returns voided/reversed invoices and payments', async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Reverse visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.ReActivate },
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	expect(
		valueObject.visit.C_Invoices?.some(
			(invoice) =>
				invoice.DocStatus.Value === documentStatus.Reversed || invoice.DocStatus.Value === documentStatus.Voided,
		),
	).toBeTruthy();
	expect(
		valueObject.visit.C_Payments?.some(
			(payment) =>
				payment.DocStatus.Value === documentStatus.Reversed || payment.DocStatus.Value === documentStatus.Voided,
		),
	).toBeTruthy();
});

test('tender amount set correctly for payments', async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await loadCurrency(valueObject);
	await loadBankAccount(valueObject);
	await mutate(valueObject)({
		mutation: C_PaymentSaveManyDocument,
		variables: {
			entities: [
				{
					PayAmt: valueObject.salesStandardPrice,
					BH_tender_amount: valueObject.salesStandardPrice! + 500,
					TenderType: {
						UUID: (
							await query(valueObject)({
								query: Ad_Ref_ListGetDocument,
								variables: {
									filter: JSON.stringify({
										ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
										name: tenderTypeName.CASH,
									}),
								},
							})
						).data.AD_Ref_ListGet.results[0].UUID,
					},
					C_DocType: { UUID: valueObject.documentType!.UUID },
					BH_Visit: { UUID: valueObject.visit!.UUID },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
		},
	});

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	expect(valueObject.visit.C_Payments?.[0].PayAmt).toBe(valueObject.salesStandardPrice);
	expect(valueObject.visit.C_Payments?.[0].BH_tender_amount).toBe(valueObject.salesStandardPrice! + 500);
});

test('voiding visit returns voided/reversed invoices and payments', async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Void visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Void },
	});
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];

	expect(
		valueObject.visit.C_Invoices?.every((invoice) => invoice.DocStatus.Value === documentStatus.Reversed),
	).toBeTruthy();
	expect(
		valueObject.visit.C_Payments?.every((payment) => payment.DocStatus.Value === documentStatus.Reversed),
	).toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
});

test(`completing a "future" visit doesn't cause problems with the payment`, async () => {
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
	valueObject.setDateOffset(5);
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
});

test('correct patient shown when patient changed after initial switch', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create first business partner';
	await createBusinessPartner(valueObject);
	const firstPatientName = valueObject.businessPartner!.Name;

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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create second patient';
	valueObject.businessPartner = undefined;
	valueObject.setRandom();
	await createBusinessPartner(valueObject);

	await mutate(valueObject)({
		mutation: Bh_VisitSaveWithOrdersAndInvoicesDocument,
		variables: {
			BH_Visit: { UUID: valueObject.visit!.UUID, Patient: { UUID: valueObject.businessPartner!.UUID } },
			C_Orders: [{ UUID: valueObject.order!.UUID, C_BPartner: { UUID: valueObject.businessPartner!.UUID } }],
			C_Invoices: [{ UUID: valueObject.invoice!.UUID, C_BPartner: { UUID: valueObject.businessPartner!.UUID } }],
		},
	});
	const secondPatientName = valueObject.businessPartner!.Name;

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	valueObject.stepName = 'Print the receipt';
	valueObject.processUuid = '30dd7243-11c1-4584-af26-5d977d117c84';
	valueObject.processInformationParameters = [
		{
			AD_Process: { UUID: valueObject.processUuid },
			ParameterName: 'billId',
			Parameter: valueObject.visit!.UUID,
		},
	];
	await runReport(valueObject);

	const pdfReceiptContent = (await PdfData.extract(valueObject.report!)).text?.join('');
	expect(pdfReceiptContent).toContain(secondPatientName.substring(0, 18));
	expect(pdfReceiptContent).not.toContain(firstPatientName.substring(0, 18));
});

test('create and complete pharmacy sales visit', async () => {
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

	const pharmacySalesPatients = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { filter: JSON.stringify({ c_bp_group: { name: 'OTC Patient' } }) },
		})
	).data.C_BPartnerGet.results;
	expect(pharmacySalesPatients.length).toBe(1);
	const pharmacySalesPatient = pharmacySalesPatients[0];

	valueObject.businessPartner = pharmacySalesPatient;

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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
});

test('can remove a payment from a re-opened visit', async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Reactivate visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.ReActivate },
	});
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];

	valueObject.stepName = 'Remove the payments';
	await mutate(valueObject)({
		mutation: C_PaymentDeleteDocument,
		variables: {
			uuids: valueObject.visit.C_Payments?.filter((payment) => payment.DocStatus.Value === documentStatus.Drafted).map(
				(payment) => payment.UUID,
			)!,
		},
	});

	valueObject.stepName = 'Re-complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(valueObject.salesStandardPrice);
});

test('can delete a drafted visit', async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Delete visit';
	expect(
		(
			await mutate(valueObject)({
				mutation: Bh_VisitDeleteAllDocument,
				variables: {
					visitUuids: [valueObject.visit!.UUID],
					orderUuids: [valueObject.order!.UUID],
					invoiceUuids: [valueObject.invoice!.UUID],
					paymentUuids: [valueObject.payment!.UUID],
				},
			})
		).data?.BH_VisitDelete,
	).toBe(true);
	expect(
		(
			await query(valueObject)({
				query: Bh_VisitGetDocument,
				variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
			})
		).data.BH_VisitGet.results[0],
	).toBeFalsy();
});

test(`product created and sold with more than received quantity throws an error`, async () => {
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
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	valueObject.quantity = 100;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	await expect(
		mutate(valueObject)({
			mutation: Bh_VisitProcessDocument,
			variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
		}),
	).rejects.toBeTruthy();
});

test(`selling more than in inventory error message is correct and is the same in every language`, async () => {
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
	valueObject.quantity = 100;
	await createOrder(valueObject);

	let negativeInventoryError: Error;
	try {
		await mutate(valueObject)({
			mutation: Bh_VisitProcessDocument,
			variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
		});
		expect(false).toBe(true);
		return;
	} catch (error) {
		negativeInventoryError = error as Error;
	}
	// Since we'll be using this message in the front-end, it needs to be this exact value
	const disallowNegativeInventoryMessage =
		/The .+ warehouse does not allow negative inventory for Product = (.+), ASI = .+, Locator = .+ \(Shortage of (\d+)\)/;
	expect(negativeInventoryError.message.split(' : ')[1]).toMatch(disallowNegativeInventoryMessage);

	const french = (
		await query(valueObject)({
			query: Ad_LanguageGetDocument,
			variables: { filter: JSON.stringify({ printname: 'Français' }) },
		})
	).data.AD_LanguageGet.results[0];
	expect(french).toBeTruthy();
	valueObject.language = french.AD_Language;
	await valueObject.login();

	valueObject.stepName = 'Create visit';
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
	valueObject.quantity = 100;
	await createOrder(valueObject);

	await expect(
		mutate(valueObject)({
			mutation: Bh_VisitProcessDocument,
			variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
		}),
	).rejects.toThrowError(negativeInventoryError);
});

test('voiding visits shows data on the report correctly', async () => {
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

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Void visit';
	const voidingReason = (await query(valueObject)({ query: Bh_Voided_ReasonGetDocument, variables: { size: 1 } })).data
		.BH_Voided_ReasonGet.results[0];
	await mutate(valueObject)({
		mutation: Bh_VisitSaveAndProcessWithOrdersDocument,
		variables: {
			BH_Visit: { UUID: valueObject.visit!.UUID, BH_Voided_Reason: { UUID: voidingReason.UUID } },
			C_Orders: [{ UUID: valueObject.order!.UUID, BH_Voided_Reason: { UUID: voidingReason.UUID } }],
			UUID: valueObject.visit!.UUID,
			DocumentAction: documentAction.Void,
		},
	});

	valueObject.stepName = 'Run the report';
	valueObject.processUuid = '20a623fb-e127-4c26-98d5-3604a6d100b2';
	valueObject.reportType = ReportOutput.Xlsx;
	valueObject.processInformationParameters = [
		{ AD_Process: { UUID: valueObject.processUuid! }, ParameterName: 'Begin Date', Parameter: yesterday() },
		{ AD_Process: { UUID: valueObject.processUuid! }, ParameterName: 'End Date', Parameter: tomorrow() },
	];
	await runReport(valueObject);

	const excelFile = xlsx.parse(valueObject.report!);
	const voidedVisitRow = excelFile[0].data.filter((row) =>
		(row[1]?.toString() as string | undefined)?.includes(valueObject.businessPartner!.Name.substring(0, 30)),
	)?.[0];
	expect(voidedVisitRow).toBeTruthy();
	expect(voidedVisitRow[4]).toBe(voidingReason.Name);
});

test('visit can be saved with really long chief complaint', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);
	const longChiefComplaint = 'this hurts '.repeat(2000);
	const chiefComplaintEncounterTypeWindow = (
		await query(valueObject)({
			query: Bh_Encounter_Type_WindowGetDocument,
			variables: { filter: JSON.stringify({ ad_window: { ad_window_uu: CHIEF_COMPLAINT_WINDOW_UUID } }) },
		})
	).data.BH_Encounter_Type_WindowGet.results[0];
	expect(chiefComplaintEncounterTypeWindow).toBeTruthy();
	const chiefComplaintField = chiefComplaintEncounterTypeWindow.AD_Window.AD_Tabs?.[0].AD_Fields?.find(
		(field) => field.UUID == CHIEF_COMPLAINT_FIELD_UUID,
	)!;
	expect(chiefComplaintField).toBeTruthy();

	const encounterUuid = v4();
	await mutate(valueObject)({
		mutation: Bh_EncounterAndObservationsSaveManyDocument,
		variables: {
			BH_Encounters: [
				{
					UUID: encounterUuid,
					BH_Encounter_Type: { UUID: chiefComplaintEncounterTypeWindow.BH_Encounter_Type.UUID },
					BH_Visit: { UUID: valueObject.visit!.UUID },
				},
			],
			BH_Observations: [
				{
					BH_Encounter: { UUID: encounterUuid },
					AD_Field: { UUID: chiefComplaintField?.UUID },
					BH_Value: longChiefComplaint,
				},
			],
		},
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	expect(valueObject.visit.BH_Encounters?.[0].BH_Observations?.[0].BH_Value).toBe(longChiefComplaint);
});

test('clinical vitals fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	const clinicalVitalsEncounterTypeWindow = (
		await query(valueObject)({
			query: Bh_Encounter_Type_WindowGetDocument,
			variables: { filter: JSON.stringify({ ad_window: { ad_window_uu: CLINICAL_VITALS_WINDOW_UUID } }) },
		})
	).data.BH_Encounter_Type_WindowGet.results[0];
	expect(clinicalVitalsEncounterTypeWindow).toBeTruthy();
	const fields = clinicalVitalsEncounterTypeWindow.AD_Window?.AD_Tabs?.[0].AD_Fields!;
	expect(fields?.length).toBeTruthy();

	const heightValue = '200';
	const weightValue = '100';

	const codedDiagnosis = (await query(valueObject)({ query: Bh_Coded_DiagnosisGetDocument, variables: { size: 1 } }))
		.data.BH_Coded_DiagnosisGet.results[0];
	expect(codedDiagnosis).toBeTruthy();
	const uncodedDiagnosisValue = 'Test uncoded diagnosis';
	const encounterUuid = v4();
	await mutate(valueObject)({
		mutation: Bh_EncounterObservationsAndEncounterDiagnosesSaveManyDocument,
		variables: {
			BH_Encounters: [
				{
					UUID: encounterUuid,
					BH_Visit: { UUID: valueObject.visit!.UUID },
					BH_Encounter_Type: { UUID: clinicalVitalsEncounterTypeWindow.BH_Encounter_Type.UUID },
				},
			],
			BH_Observations: [
				{
					BH_Encounter: { UUID: encounterUuid },
					AD_Field: { UUID: fields.find((field) => field.UUID === HEIGHT_FIELD_UUID)!.UUID },
					BH_Value: heightValue,
				},
			],
			BH_EncounterDiagnoses: [
				{
					BH_Encounter: { UUID: encounterUuid },
					LineNo: 1,
					BH_Uncoded_Diagnosis: uncodedDiagnosisValue,
				},
				{
					BH_Encounter: { UUID: encounterUuid },
					LineNo: 2,
					BH_Coded_Diagnosis: { UUID: codedDiagnosis.UUID },
				},
			],
		},
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];

	expect(valueObject.visit.BH_Encounters).toHaveLength(1);
	expect(valueObject.visit.BH_Encounters![0].BH_Observations).toHaveLength(1);
	expect(valueObject.visit.BH_Encounters![0].BH_Observations![0].BH_Value).toBe(heightValue);
	expect(valueObject.visit.BH_Encounters![0].BH_Encounter_DiagnosisList).toHaveLength(2);
	expect(valueObject.visit.BH_Encounters![0].BH_Encounter_DiagnosisList![0].BH_Uncoded_Diagnosis).toBe(
		uncodedDiagnosisValue,
	);
	expect(valueObject.visit.BH_Encounters![0].BH_Encounter_DiagnosisList![1].BH_Coded_Diagnosis!.UUID).toBeTruthy();
	expect(valueObject.visit.BH_Encounters![0].BH_Encounter_DiagnosisList![1].BH_Coded_Diagnosis!.UUID).toBe(
		codedDiagnosis.UUID,
	);

	valueObject.stepName = 'Change observations and remove diagnosis';
	await mutate(valueObject)({
		mutation: Bh_ObservationsDeleteAndSaveManyAndEncounterDiagnosesDeleteDocument,
		variables: {
			BH_ObservationUuids: valueObject.visit!.BH_Encounters![0].BH_Observations!.map((observation) => observation.UUID),
			BH_Observations: [
				{
					BH_Encounter: { UUID: encounterUuid },
					AD_Field: { UUID: fields.find((field) => field.UUID === WEIGHT_FIELD_UUID)!.UUID },
					BH_Value: weightValue,
				},
			],
			BH_EncounterDiagnosesUuids: valueObject.visit!.BH_Encounters![0].BH_Encounter_DiagnosisList!.map(
				(encounterDiagnosis) => encounterDiagnosis.UUID,
			),
		},
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];

	expect(valueObject.visit.BH_Encounters).toHaveLength(1);
	expect(valueObject.visit.BH_Encounters![0].BH_Observations).toHaveLength(1);
	expect(valueObject.visit.BH_Encounters![0].BH_Observations![0].BH_Value).toBe(weightValue);
	expect(valueObject.visit.BH_Encounters![0].BH_Encounter_DiagnosisList).toBeFalsy();

	valueObject.stepName = 'Add observations and re-add diagnosis';
	await mutate(valueObject)({
		mutation: Bh_ObservationsDeleteAndSaveManyAndEncounterDiagnosesSaveManyDocument,
		variables: {
			BH_ObservationUuids: valueObject.visit!.BH_Encounters![0].BH_Observations!.map((observation) => observation.UUID),
			BH_Observations: [
				{
					BH_Encounter: { UUID: encounterUuid },
					AD_Field: { UUID: fields.find((field) => field.UUID === HEIGHT_FIELD_UUID)!.UUID },
					BH_Value: heightValue,
				},
				{
					BH_Encounter: { UUID: encounterUuid },
					AD_Field: { UUID: fields.find((field) => field.UUID === WEIGHT_FIELD_UUID)!.UUID },
					BH_Value: weightValue,
				},
			],
			BH_EncounterDiagnoses: [
				{
					BH_Encounter: { UUID: encounterUuid },
					LineNo: 1,
					BH_Uncoded_Diagnosis: uncodedDiagnosisValue,
				},
			],
		},
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];

	expect(valueObject.visit.BH_Encounters).toHaveLength(1);
	expect(valueObject.visit.BH_Encounters![0].BH_Observations).toHaveLength(2);
	expect(valueObject.visit.BH_Encounters![0].BH_Observations![0].BH_Value).toBe(heightValue);
	expect(valueObject.visit.BH_Encounters![0].BH_Observations![1].BH_Value).toBe(weightValue);
	expect(valueObject.visit.BH_Encounters![0].BH_Encounter_DiagnosisList).toHaveLength(1);
	expect(valueObject.visit.BH_Encounters![0].BH_Encounter_DiagnosisList![0].BH_Uncoded_Diagnosis).toBe(
		uncodedDiagnosisValue,
	);
});

test(`visit with non-patient payment information can be deleted`, async () => {
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

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const visitUuid = randomUUID();
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();
	const invoiceUuid = randomUUID();
	const insurerInvoiceUuid = randomUUID();
	const insurerInvoiceLineUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	const tenderTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES } }) },
		})
	).data.AD_Ref_ListGet.results;
	const insurerOrDonorToUse = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { filter: JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'D'] } } }) },
		})
	).data.C_BPartnerGet.results.find((businessPartner) => businessPartner.BH_Payer_Info_FldList?.length)!;
	expect(insurerOrDonorToUse).toBeTruthy();
	const payerInformationFieldToUse = insurerOrDonorToUse.BH_Payer_Info_FldList!.find(
		(payerInformationField) => payerInformationField.BH_PayerInfoFieldDataType.Value === 'T',
	)!;
	expect(payerInformationFieldToUse).toBeTruthy();
	await loadCurrency(valueObject);
	await loadBankAccount(valueObject);
	await mutate(valueObject)({
		mutation: Bh_VisitSaveWithOrdersInvoicesPayerInformationAndPaymentsDocument,
		variables: {
			BH_Visit: {
				UUID: visitUuid,
				Description: valueObject.getStepMessageLong(),
				Patient: { UUID: valueObject.businessPartner!.UUID },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			C_Orders: [
				{
					UUID: orderUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					DateOrdered: valueObject.date?.getTime(),
					M_Warehouse: { UUID: valueObject.warehouse!.UUID },
					C_DocTypeTarget: { UUID: salesOrderDocumentType.UUID },
					IsSOTrx: salesOrderDocumentType.IsSOTrx,
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
				},
			],
			C_OrderLines: [
				{
					C_Order: { UUID: orderUuid },
					UUID: orderLineUuid,
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
				},
			],
			C_Invoices: [
				{
					UUID: invoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_Order: { UUID: orderUuid },
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
				{
					UUID: insurerInvoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: insurerOrDonorToUse.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
			],
			C_InvoiceLines: [
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
					C_OrderLine: { UUID: orderLineUuid },
				},
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					C_Charge: { UUID: insurerOrDonorToUse.C_BP_Group.AssociatedCustomerReceivablesCharge!.UUID },
					Qty: 1,
					Price: -50,
				},
				{
					UUID: insurerInvoiceLineUuid,
					C_Invoice: { UUID: insurerInvoiceUuid },
					Description: valueObject.getStepMessageLong(),
					C_Charge: { UUID: insurerOrDonorToUse.C_BP_Group.AssociatedCustomerReceivablesCharge!.UUID },
					Qty: 1,
					Price: 50,
				},
			],
			BH_BP_Specific_Payer_InfoList: [
				{
					C_InvoiceLine: { UUID: insurerInvoiceLineUuid },
					BH_Payer_Info_Fld: { UUID: payerInformationFieldToUse.UUID },
					Name: 'Some value!',
				},
			],
			C_Payments: [
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 10,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CASH)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 40,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.MOBILE_MONEY)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
		},
	});

	expect(
		(await mutate(valueObject)({ mutation: Bh_VisitDeleteDocument, variables: { uuids: [visitUuid] } })).data
			?.BH_VisitDelete,
	).toBeTruthy();
});

test(`visit invoice updates work`, async () => {
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

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	const tenderTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES } }) },
		})
	).data.AD_Ref_ListGet.results;
	const insurerOrDonorToUse = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { filter: JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'D'] } } }) },
		})
	).data.C_BPartnerGet.results.find((businessPartner) => businessPartner.BH_Payer_Info_FldList?.length)!;
	const payerInformationFieldToUse = insurerOrDonorToUse.BH_Payer_Info_FldList?.filter(
		(payerInformationField) => payerInformationField.BH_PayerInfoFieldDataType.Value === 'T',
	)[0]!;
	expect(payerInformationFieldToUse).toBeTruthy();
	await loadCurrency(valueObject);
	await loadBankAccount(valueObject);

	const clinicalVitalsEncounterTypeWindow = (
		await query(valueObject)({
			query: Bh_Encounter_Type_WindowGetDocument,
			variables: { filter: JSON.stringify({ ad_window: { ad_window_uu: CLINICAL_VITALS_WINDOW_UUID } }) },
		})
	).data.BH_Encounter_Type_WindowGet.results[0];
	expect(clinicalVitalsEncounterTypeWindow).toBeTruthy();
	const visitUuid = randomUUID();
	const encounterUuid = randomUUID();
	const invoiceUuid = randomUUID();
	const insurerInvoiceUuid = randomUUID();
	const insurerInvoiceLineUuid = randomUUID();
	await mutate(valueObject)({
		mutation: Bh_VisitSaveWithEncountersObservationsOrdersInvoicesInsuranceAndPaymentsDocument,
		variables: {
			BH_Visit: {
				UUID: visitUuid,
				Description: valueObject.getStepMessageLong(),
				Patient: { UUID: valueObject.businessPartner!.UUID },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			BH_Encounters: [
				{
					UUID: encounterUuid,
					BH_Visit: { UUID: visitUuid },
					BH_Encounter_Type: { UUID: clinicalVitalsEncounterTypeWindow.BH_Encounter_Type.UUID },
				},
			],
			BH_EncounterDiagnoses: [
				{
					BH_Encounter: { UUID: encounterUuid },
					LineNo: 1,
					BH_Uncoded_Diagnosis: 'In some pain...',
				},
			],
			BH_Observations: [
				{
					BH_Encounter: { UUID: encounterUuid },
					BH_Value: '100',
					AD_Field: {
						UUID: clinicalVitalsEncounterTypeWindow.AD_Window.AD_Tabs?.[0].AD_Fields?.find(
							(field) => field.UUID === HEIGHT_FIELD_UUID,
						)?.UUID!,
					},
				},
			],
			C_Orders: [
				{
					UUID: orderUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					DateOrdered: valueObject.date?.getTime(),
					M_Warehouse: { UUID: valueObject.warehouse!.UUID },
					C_DocTypeTarget: { UUID: salesOrderDocumentType.UUID },
					IsSOTrx: salesOrderDocumentType.IsSOTrx,
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
				},
			],
			C_OrderLines: [
				{
					C_Order: { UUID: orderUuid },
					UUID: orderLineUuid,
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
				},
			],
			C_Invoices: [
				{
					UUID: invoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_Order: { UUID: orderUuid },
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
				{
					UUID: insurerInvoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: insurerOrDonorToUse.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
			],
			C_InvoiceLines: [
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
					C_OrderLine: { UUID: orderLineUuid },
				},
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					C_Charge: { UUID: insurerOrDonorToUse.C_BP_Group.AssociatedCustomerReceivablesCharge!.UUID },
					Qty: 1,
					Price: -50,
				},
				{
					UUID: insurerInvoiceLineUuid,
					C_Invoice: { UUID: insurerInvoiceUuid },
					Description: valueObject.getStepMessageLong(),
					C_Charge: { UUID: insurerOrDonorToUse.C_BP_Group.AssociatedCustomerReceivablesCharge!.UUID },
					Qty: 1,
					Price: 50,
				},
			],
			BH_BP_Specific_Payer_InfoList: [
				{
					C_InvoiceLine: { UUID: insurerInvoiceLineUuid },
					BH_Payer_Info_Fld: { UUID: payerInformationFieldToUse.UUID },
					Name: 'Some value!',
				},
			],
			C_Payments: [
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 10,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CASH)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 40,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.MOBILE_MONEY)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
		},
	});
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.results[0];

	expect(valueObject.visit.C_Invoices).toHaveLength(2);
	expect(valueObject.visit.C_Invoices!.find((invoice) => invoice.C_InvoiceLines?.length === 2)).toBeTruthy();
	expect(valueObject.visit.C_Invoices!.find((invoice) => invoice.C_InvoiceLines?.length === 1)).toBeTruthy();
	expect(valueObject.visit.C_Payments).toHaveLength(2);

	valueObject.stepName = 'Remove insurance payer';
	await mutate(valueObject)({
		mutation: Bh_VisitRemoveInsurancePayerDocument,
		variables: {
			C_Invoice_UUIDS: valueObject
				.visit!.C_Invoices!.filter((invoice) => invoice.C_BPartner.UUID !== valueObject.businessPartner!.UUID)
				.map((invoice) => invoice.UUID),
			C_InvoiceLine_UUIDS: valueObject
				.visit!.C_Invoices!.filter((invoice) => invoice.C_BPartner.UUID === valueObject.businessPartner!.UUID)
				.flatMap((invoice) => invoice.C_InvoiceLines || [])
				.filter((invoiceLine) => invoiceLine.PriceActual < 0)
				.map((invoiceLine) => invoiceLine.UUID),
			C_Payments: [
				{
					UUID: valueObject.visit!.C_Payments![0].UUID,
					PayAmt: valueObject.visit!.C_Payments![0].PayAmt + 50, // Increase the cash payment by what the insurance was previously paying
				},
			],
		},
	});
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.results[0];

	expect(valueObject.visit.C_Invoices).toHaveLength(1);
	expect(valueObject.visit.C_Invoices![0].C_InvoiceLines).toHaveLength(1);
	expect(valueObject.visit.C_Payments).toHaveLength(2);
});

test(`open balances are correct after re-openings and voiding`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create insurer';
	await createBusinessPartner(valueObject);
	await mutate(valueObject)({
		mutation: C_BPartnerSaveDocument,
		variables: {
			entity: {
				UUID: valueObject.businessPartner!.UUID,
				C_BP_Group: {
					UUID: (
						await query(valueObject)({
							query: C_Bp_GroupGetDocument,
							variables: { filter: JSON.stringify({ bh_subtype: { $in: ['I'] } }) },
						})
					).data.C_BP_GroupGet.results[0].UUID,
				},
			},
		},
	});
	const insurer = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
		})
	).data.C_BPartnerGet.results[0];

	valueObject.stepName = 'Create business partner';
	valueObject.clearBusinessPartner();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	await loadCurrency(valueObject);
	await loadBankAccount(valueObject);
	const tenderTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES } }) },
		})
	).data.AD_Ref_ListGet.results;
	const visitUuid = randomUUID();
	const invoiceUuid = randomUUID();
	const insurerInvoiceUuid = randomUUID();
	const insurerInvoiceLineUuid = randomUUID();
	await mutate(valueObject)({
		mutation: Bh_VisitSaveAndProcessWithOrdersInvoicesAndPaymentsDocument,
		variables: {
			BH_Visit: {
				UUID: visitUuid,
				Description: valueObject.getStepMessageLong(),
				Patient: { UUID: valueObject.businessPartner!.UUID },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			C_Orders: [
				{
					UUID: orderUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					DateOrdered: valueObject.date?.getTime(),
					M_Warehouse: { UUID: valueObject.warehouse!.UUID },
					C_DocTypeTarget: { UUID: salesOrderDocumentType.UUID },
					IsSOTrx: salesOrderDocumentType.IsSOTrx,
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
				},
			],
			C_OrderLines: [
				{
					C_Order: { UUID: orderUuid },
					UUID: orderLineUuid,
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
				},
			],
			C_Invoices: [
				{
					UUID: invoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_Order: { UUID: orderUuid },
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
				{
					UUID: insurerInvoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: insurer.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
			],
			C_InvoiceLines: [
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: 1,
					Price: 100,
					C_OrderLine: { UUID: orderLineUuid },
				},
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					C_Charge: { UUID: insurer.C_BP_Group.AssociatedCustomerReceivablesCharge!.UUID },
					Qty: 1,
					Price: -50,
				},
				{
					UUID: insurerInvoiceLineUuid,
					C_Invoice: { UUID: insurerInvoiceUuid },
					Description: valueObject.getStepMessageLong(),
					C_Charge: { UUID: insurer.C_BP_Group.AssociatedCustomerReceivablesCharge!.UUID },
					Qty: 1,
					Price: 50,
				},
			],
			C_Payments: [
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 10,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CASH)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
				{
					BH_Visit: { UUID: visitUuid },
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					Description: valueObject.getStepMessageLong(),
					PayAmt: 40,
					TenderType: { UUID: tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.MOBILE_MONEY)!.UUID },
					C_DocType: { UUID: paymentReceiptDocumentType.UUID },
					C_BankAccount: { UUID: valueObject.bankAccount!.UUID },
					C_Currency: { UUID: valueObject.currency!.UUID },
				},
			],
			UUID: visitUuid,
			DocumentAction: documentAction.Complete,
		},
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: insurer.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(50);

	valueObject.stepName = 'Re-open visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: visitUuid, documentAction: documentAction.ReActivate },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: insurer.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Re-complete the visit as-is';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: visitUuid, documentAction: documentAction.Complete },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: insurer.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(50);

	valueObject.stepName = 'Re-re-open visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: visitUuid, documentAction: documentAction.ReActivate },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: insurer.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Check reversed invoices and payments';
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.results[0];
	const draftedInvoices = valueObject.visit!.C_Invoices?.filter(
		(invoice) =>
			![
				documentStatus.Voided as string,
				documentAction.ReverseAccrual as string,
				documentStatus.Reversed as string,
			].includes(invoice.DocStatus.Value),
	)!;
	expect(draftedInvoices).toHaveLength(2);
	const draftedPayments = valueObject.visit!.C_Payments?.filter(
		(payment) =>
			![
				documentStatus.Voided as string,
				documentAction.ReverseAccrual as string,
				documentStatus.Reversed as string,
			].includes(payment.DocStatus.Value),
	)!;
	expect(draftedPayments).toHaveLength(2);

	valueObject.stepName = 'Remove insurance payer';
	await mutate(valueObject)({
		mutation: Bh_VisitRemoveInsurancePayerDocument,
		variables: {
			C_Invoice_UUIDS: draftedInvoices!
				.filter((invoice) => invoice.C_BPartner.UUID !== valueObject.businessPartner!.UUID)
				.map((invoice) => invoice.UUID),
			C_InvoiceLine_UUIDS: draftedInvoices
				.filter((invoice) => invoice.C_BPartner.UUID === valueObject.businessPartner!.UUID)
				.flatMap((invoice) => invoice.C_InvoiceLines || [])
				.filter((invoiceLine) => invoiceLine.PriceActual < 0)
				.map((invoiceLine) => invoiceLine.UUID),
			C_Payments: [
				{
					UUID: draftedPayments[0].UUID,
					PayAmt: draftedPayments[0].PayAmt + 50, // Increase the cash payment by what the insurance was previously paying
				},
			],
		},
	});
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: visitUuid, documentAction: documentAction.Complete },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: insurer.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Void the visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: visitUuid, documentAction: documentAction.Void },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: insurer.UUID }) },
			})
		).data.C_BPartnerGet.results[0].TotalOpenBalance,
	).toBe(0);
});

test(`visit can be saved without order and invoice lines`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	valueObject.clearBusinessPartner();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	const visitUuid = randomUUID();
	const orderUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	await mutate(valueObject)({
		mutation: Bh_VisitSaveWithOrdersAndInvoicesDocument,
		variables: {
			BH_Visit: {
				UUID: visitUuid,
				Description: valueObject.getStepMessageLong(),
				Patient: { UUID: valueObject.businessPartner!.UUID },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			C_Orders: [
				{
					UUID: orderUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					DateOrdered: valueObject.date?.getTime(),
					M_Warehouse: { UUID: valueObject.warehouse!.UUID },
					C_DocTypeTarget: { UUID: salesOrderDocumentType.UUID },
					IsSOTrx: salesOrderDocumentType.IsSOTrx,
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
				},
			],
			C_Invoices: [
				{
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_Order: { UUID: orderUuid },
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
			],
		},
	});
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.results[0];

	expect(valueObject.visit).toBeTruthy();
	expect(valueObject.visit.C_Orders).toHaveLength(1);
	expect(valueObject.visit.C_Orders![0].C_OrderLines).toBeFalsy();
	expect(valueObject.visit.C_Invoices).toHaveLength(1);
	expect(valueObject.visit.C_Invoices![0].C_InvoiceLines).toBeFalsy();
});

test(`document number should be returned for saved visits`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.OnCreditOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	expect(valueObject.visit.DocumentNo).not.toBe('');
});

test(`can delete order & invoice lines at the same time`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);
	const product1 = valueObject.product!;

	valueObject.stepName = 'Create product 2';
	valueObject.salesStandardPrice = 120;
	valueObject.clearProduct();
	await createProduct(valueObject);
	const product2 = valueObject.product!;

	valueObject.stepName = 'Create visit';
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLine1Uuid = randomUUID();
	const orderLine2Uuid = randomUUID();
	const encounterTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.ENCOUNTER_TYPES } }) },
		})
	).data.AD_Ref_ListGet.results;
	const visitUuid = randomUUID();
	const invoiceUuid = randomUUID();
	await mutate(valueObject)({
		mutation: Bh_VisitSaveWithEncountersOrdersAndInvoicesDocument,
		variables: {
			BH_Visit: {
				UUID: visitUuid,
				Description: valueObject.getStepMessageLong(),
				Patient: { UUID: valueObject.businessPartner!.UUID },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			BH_Encounters: [
				{
					BH_Visit: { UUID: visitUuid },
					BH_Encounter_Type: { UUID: encounterTypes.find((referenceList) => referenceList.Value === 'V')!.UUID },
				},
			],
			C_Orders: [
				{
					UUID: orderUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					DateOrdered: valueObject.date?.getTime(),
					M_Warehouse: { UUID: valueObject.warehouse!.UUID },
					C_DocTypeTarget: { UUID: salesOrderDocumentType.UUID },
					IsSOTrx: salesOrderDocumentType.IsSOTrx,
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
				},
			],
			C_OrderLines: [
				{
					UUID: orderLine1Uuid,
					C_Order: { UUID: orderUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: product1.UUID },
					Qty: 1,
					Price: 200,
				},
				{
					UUID: orderLine2Uuid,
					C_Order: { UUID: orderUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: product2.UUID },
					Qty: 1,
					Price: 30000,
				},
			],
			C_Invoices: [
				{
					UUID: invoiceUuid,
					BH_Visit: { UUID: visitUuid },
					Description: valueObject.getStepMessageLong(),
					C_BPartner: { UUID: valueObject.businessPartner!.UUID },
					DateInvoiced: valueObject.date?.getTime(),
					C_Order: { UUID: orderUuid },
					C_DocTypeTarget: { UUID: customerInvoiceDocumentType.UUID },
					IsSOTrx: customerInvoiceDocumentType.IsSOTrx,
				},
			],
			C_InvoiceLines: [
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: product1.UUID },
					Qty: 1,
					Price: 200,
					C_OrderLine: { UUID: orderLine1Uuid },
				},
				{
					C_Invoice: { UUID: invoiceUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: product1.UUID },
					Qty: 1,
					Price: 20000,
					C_OrderLine: { UUID: orderLine2Uuid },
				},
			],
		},
	});

	valueObject.stepName = 'Remove order & invoice lines';
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.results[0];
	await mutate(valueObject)({
		mutation: C_InvoiceAndOrderLineDeleteDocument,
		variables: {
			C_OrderLineUUIDS: [orderLine1Uuid],
			C_InvoiceLineUUIDS: [
				valueObject.visit.C_Invoices![0].C_InvoiceLines!.find(
					(invoiceLine) => invoiceLine.C_OrderLine?.UUID === orderLine1Uuid,
				)?.UUID!,
			],
		},
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.results[0];
	expect(valueObject.visit).toBeTruthy();
	expect(valueObject.visit.C_Orders).toHaveLength(1);
	expect(valueObject.visit.C_Orders![0].C_OrderLines).toHaveLength(1);
	expect(valueObject.visit.C_Invoices).toHaveLength(1);
	expect(valueObject.visit.C_Invoices![0].C_InvoiceLines).toHaveLength(1);
});

test('can delete encounters', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	const clinicalVitalsEncounterTypeWindow = (
		await query(valueObject)({
			query: Bh_Encounter_Type_WindowGetDocument,
			variables: { filter: JSON.stringify({ ad_window: { ad_window_uu: CLINICAL_VITALS_WINDOW_UUID } }) },
		})
	).data.BH_Encounter_Type_WindowGet.results[0];
	expect(clinicalVitalsEncounterTypeWindow).toBeTruthy();
	const fields = clinicalVitalsEncounterTypeWindow.AD_Window.AD_Tabs?.[0].AD_Fields!;
	expect(fields).toBeTruthy();

	const codedDiagnosis = (await query(valueObject)({ query: Bh_Coded_DiagnosisGetDocument, variables: { size: 1 } }))
		.data.BH_Coded_DiagnosisGet.results[0];
	const uncodedDiagnosisValue = 'Test uncoded diagnosis';
	const encounter1Uuid = v4();
	const encounter2Uuid = v4();
	await mutate(valueObject)({
		mutation: Bh_EncounterObservationsAndEncounterDiagnosesSaveManyDocument,
		variables: {
			BH_Encounters: [
				{
					UUID: encounter1Uuid,
					BH_Visit: { UUID: valueObject.visit!.UUID },
					BH_Encounter_Type: { UUID: clinicalVitalsEncounterTypeWindow.BH_Encounter_Type.UUID },
				},
				{
					UUID: encounter2Uuid,
					BH_Visit: { UUID: valueObject.visit!.UUID },
					BH_Encounter_Type: { UUID: clinicalVitalsEncounterTypeWindow.BH_Encounter_Type.UUID },
				},
			],
			BH_Observations: [
				{
					BH_Encounter: { UUID: encounter1Uuid },
					AD_Field: { UUID: fields.find((field) => field.UUID === HEIGHT_FIELD_UUID)!.UUID },
					BH_Value: '200',
				},
				{
					BH_Encounter: { UUID: encounter2Uuid },
					AD_Field: { UUID: fields.find((field) => field.UUID === HEIGHT_FIELD_UUID)!.UUID },
					BH_Value: '200',
				},
			],
			BH_EncounterDiagnoses: [
				{
					BH_Encounter: { UUID: encounter1Uuid },
					LineNo: 1,
					BH_Uncoded_Diagnosis: uncodedDiagnosisValue,
				},
				{
					BH_Encounter: { UUID: encounter1Uuid },
					LineNo: 2,
					BH_Coded_Diagnosis: { UUID: codedDiagnosis.UUID },
				},
				{
					BH_Encounter: { UUID: encounter2Uuid },
					LineNo: 1,
					BH_Uncoded_Diagnosis: uncodedDiagnosisValue,
				},
				{
					BH_Encounter: { UUID: encounter2Uuid },
					LineNo: 2,
					BH_Coded_Diagnosis: { UUID: codedDiagnosis.UUID },
				},
			],
		},
	});

	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { filter: JSON.stringify({ bh_visit_uu: valueObject.visit!.UUID }) },
		})
	).data.BH_VisitGet.results[0];
	expect(valueObject.visit.BH_Encounters).toHaveLength(2);

	valueObject.stepName = 'Delete encounter';
	const encounterUuidsToDelete = valueObject.visit.BH_Encounters!.map((encounter) => encounter.UUID);
	await mutate(valueObject)({
		mutation: Bh_EncounterDeleteDocument,
		variables: { UUIDS: encounterUuidsToDelete },
	});
	expect(
		(
			await query(valueObject)({
				query: Bh_EncounterGetDocument,
				variables: { filter: JSON.stringify({ bh_encounter_uu: { $in: encounterUuidsToDelete } }) },
			})
		).data.BH_EncounterGet.results,
	).toHaveLength(0);
});

test('expression functions work in sorting', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit 1';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(-1);
	await createVisit(valueObject);
	const visit1 = valueObject.visit!;

	valueObject.stepName = 'Create visit 2';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(1);
	valueObject.date!.setHours(12);
	await createVisit(valueObject);
	const visit2 = valueObject.visit!;

	valueObject.stepName = 'Create visit 3';
	valueObject.documentAction = undefined;
	valueObject.date!.setHours(11);
	await createVisit(valueObject);
	const visit3 = valueObject.visit!;

	const sortedVisits = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: {
				sort: JSON.stringify([
					['$date(bh_visitdate)', 'DESC'],
					['bh_visitdate', 'ASC'],
				]),
				filter: JSON.stringify({ bh_visit_uu: { $in: [visit1.UUID, visit2.UUID, visit3.UUID] } }),
			},
		})
	).data.BH_VisitGet.results;
	expect(sortedVisits).toHaveLength(3);
	expect(sortedVisits[0].UUID).toBe(visit3.UUID);
	expect(sortedVisits[1].UUID).toBe(visit2.UUID);
	expect(sortedVisits[2].UUID).toBe(visit1.UUID);
});
