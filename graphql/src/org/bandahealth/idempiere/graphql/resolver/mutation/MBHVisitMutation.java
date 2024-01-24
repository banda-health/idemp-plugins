package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.MBHVisitInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.DocumentUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MBHVisitMutation extends X_BH_VisitMutation {
	public MBHVisit BH_VisitProcess(String uuid, String documentAction, DataFetchingEnvironment environment)
			throws SQLException {
		if (!DocumentUtil.isDocActionValidForUser(MDocType_BH.DOCBASETYPE_SalesOrder, documentAction)) {
			return null;
		}

		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		// Create a transaction so all parts of the visit can pass or fail together
		Trx processVisitTransaction = Trx.get(Trx.createTrxName("ProcessVisit"), true);
		try {
			MBHVisit visit =
					Repository.getByUuid(idempiereProperties, MBHVisit.Table_Name, processVisitTransaction.getTrxName(), uuid);
			List<MOrder_BH> visitsOrders =
					Repository.getGroupsByIds(idempiereProperties, MOrder_BH.Table_Name, processVisitTransaction.getTrxName(),
									MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID, Collections.singleton(visit.get_ID()))
							.get(visit.get_ID());
			Map<Integer, MDocType_BH> documentTypesById =
					Repository.getByIds(idempiereProperties, MDocType_BH.Table_Name, processVisitTransaction.getTrxName(),
							visitsOrders.stream().map(MOrder_BH::getC_DocTypeTarget_ID).collect(Collectors.toSet()));
			// TODO: Update this when we have multiple orders, since we may not want to process all at the same time
			for (MOrder_BH order : visitsOrders) {
				DocumentUtil.processDocumentOrError(MProcess_BH.PROCESSID_PROCESS_ORDERS, order, documentAction);

				// Handle the invoices (if the order document type is appropriate)
				MDocType_BH documentType = documentTypesById.containsKey(order.getC_DocTypeTarget_ID()) ?
						documentTypesById.get(order.getC_DocTypeTarget_ID()) : new MDocType_BH(Env.getCtx(), 0, null);
				//
				if (!MDocType.DOCSUBTYPESO_OnCreditOrder.equals(documentType.getDocSubTypeSO()) &&
						!MDocType.DOCSUBTYPESO_POSOrder.equals(documentType.getDocSubTypeSO()) &&
						!MDocType.DOCSUBTYPESO_PrepayOrder.equals(documentType.getDocSubTypeSO())) {
					//
					List<MInvoice_BH> existingInvoices = Repository.getGroupsByIds(idempiereProperties, MInvoice_BH.Table_Name,
							processVisitTransaction.getTrxName(), MInvoice_BH::getBH_Visit_ID, MInvoice_BH.COLUMNNAME_BH_Visit_ID,
							Collections.singleton(visit.get_ID())).getOrDefault(visit.get_ID(), new ArrayList<>());
					//
					Collection<MInvoice_BH> existingUnfinalizedInvoices = existingInvoices.stream()
							.filter(
									invoice -> !invoice.isComplete() || invoice.getDocStatus().equals(MInvoice_BH.DOCSTATUS_Completed))
							.collect(Collectors.toList());
					// If this is a reversal, we also need to take care of the invoices
					if (documentAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Accrual) ||
							documentAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Correct) ||
							documentAction.equalsIgnoreCase(DocAction.ACTION_ReActivate)) {

						for (MInvoice_BH invoice : existingUnfinalizedInvoices) {
							MInvoice_BH newInvoice = invoice.copy();
							invoice.setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
							DocumentUtil.processDocumentOrError(MProcess_BH.PROCESSID_PROCESS_INVOICE, invoice,
									MInvoice_BH.DOCACTION_Reverse_Accrual);

							newInvoice.setDocStatus(MInvoice_BH.DOCSTATUS_Drafted);
							newInvoice.setBH_Visit_ID(visit.get_ID());
							newInvoice.saveEx();
						}
					} else {
						for (MInvoice_BH invoice : existingUnfinalizedInvoices) {
							invoice.setDocAction(documentAction);
							DocumentUtil.processDocumentOrError(MProcess_BH.PROCESSID_PROCESS_INVOICE, invoice, documentAction);
						}
					}
				}

				// Handle the payments
				List<MPayment_BH> existingPayments =
						Repository.getGroupsByIds(idempiereProperties, MPayment_BH.Table_Name,
										processVisitTransaction.getTrxName(),
										MPayment_BH::getBH_Visit_ID, MPayment_BH.COLUMNNAME_BH_Visit_ID,
										Collections.singleton(visit.get_ID()))
								.getOrDefault(visit.get_ID(), new ArrayList<>());
				//
				Collection<MPayment_BH> existingUnfinalizedPayments = existingPayments.stream()
						.filter(payment -> !payment.isComplete() || payment.getDocStatus().equals(MPayment_BH.DOCSTATUS_Completed))
						.collect(Collectors.toList());

				// If this is a reversal, we also need to take care of the payments
				if (documentAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Accrual)
						|| documentAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Correct)
						|| documentAction.equalsIgnoreCase(DocAction.ACTION_ReActivate)) {

					for (MPayment_BH payment : existingUnfinalizedPayments) {
						MPayment_BH newPayment = payment.copy();
						payment.setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
						DocumentUtil.processDocumentOrError(MProcess_BH.PROCESSID_PROCESS_PAYMENT, payment,
								MPayment_BH.DOCACTION_Reverse_Accrual);

						newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
						newPayment.setBH_Visit_ID(visit.get_ID());
						newPayment.saveEx();
					}
				} else {
					for (MPayment_BH payment : existingUnfinalizedPayments) {
						payment.setDocAction(documentAction);
						DocumentUtil.processDocumentOrError(MProcess_BH.PROCESSID_PROCESS_PAYMENT, payment, documentAction);
					}
				}
			}
			if (!processVisitTransaction.commit(true)) {
				log.severe("Could not commit visit transaction");
			}
			visit.setBH_Process_Stage(null);
			visit.saveEx();

			return visit;
		} catch (Exception exception) {
			if (!processVisitTransaction.rollback(true)) {
				log.severe("Could not roll back visit transaction");
			}
			throw exception;
		} finally {
			if (!processVisitTransaction.close()) {
				log.severe("Could not close visit transaction");
			}
		}
	}

	@Override
	protected boolean delete(List<String> uuids, DataFetchingEnvironment environment) {
		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		Map<String, MBHVisit> visitsByUuid =
				Repository.getByUuids(idempiereProperties, MBHVisit.Table_Name, null, new HashSet<>(uuids));
		Set<Integer> visitIds = visitsByUuid.values().stream().map(MBHVisit::getBH_Visit_ID).collect(Collectors.toSet());

		// Get child entities
		Map<Integer, List<MOrder_BH>> ordersByVisitId =
				Repository.getGroupsByIds(idempiereProperties, MOrder_BH.Table_Name, null, MOrder_BH::getBH_Visit_ID,
						MOrder_BH.COLUMNNAME_BH_Visit_ID, visitIds);
		Map<Integer, List<MInOut_BH>> inOutsByVisitId =
				Repository.getGroupsByIds(idempiereProperties, MInOut_BH.Table_Name, null, MInOut_BH::getBH_Visit_ID,
						MInOut_BH.COLUMNNAME_BH_Visit_ID, visitIds);
		Map<Integer, List<MInvoice_BH>> invoicesByVisitId =
				Repository.getGroupsByIds(idempiereProperties, MInvoice_BH.Table_Name, null, MInvoice_BH::getBH_Visit_ID,
						MInvoice_BH.COLUMNNAME_BH_Visit_ID, visitIds);
		Map<Integer, List<MPayment_BH>> paymentsByVisitId =
				Repository.getGroupsByIds(idempiereProperties, MPayment_BH.Table_Name, null, MPayment_BH::getBH_Visit_ID,
						MPayment_BH.COLUMNNAME_BH_Visit_ID, visitIds);

		// Get grandchildren entities
		Map<Integer, List<MOrderLine_BH>> orderLinesByOrderId =
				Repository.getGroupsByIds(idempiereProperties, MOrderLine_BH.Table_Name, null, MOrderLine_BH::getC_Order_ID,
						MOrderLine_BH.COLUMNNAME_C_Order_ID,
						ordersByVisitId.values().stream().flatMap(Collection::stream).map(MOrder_BH::getC_Order_ID)
								.collect(Collectors.toSet()));
		Map<Integer, List<MInOutLine>> inOutLinesByOrderId =
				Repository.getGroupsByIds(idempiereProperties, MInOutLine.Table_Name, null, MInOutLine::getM_InOut_ID,
						MInOutLine.COLUMNNAME_M_InOut_ID,
						inOutsByVisitId.values().stream().flatMap(Collection::stream).map(MInOut_BH::getM_InOut_ID)
								.collect(Collectors.toSet()));
		Map<Integer, List<MInvoiceLine>> invoiceLinesByInvoiceId =
				Repository.getGroupsByIds(idempiereProperties, MInvoiceLine.Table_Name, null, MInvoiceLine::getC_Invoice_ID,
						MInvoiceLine.COLUMNNAME_C_Invoice_ID,
						invoicesByVisitId.values().stream().flatMap(Collection::stream).map(MInvoice_BH::getC_Invoice_ID)
								.collect(Collectors.toSet()));

		// Get great grandchildren entities
		Map<Integer, List<MBHBPSpecificPayerInfo>> businessPartnerSpecificPayerInformationByInvoiceLineId =
				Repository.getGroupsByIds(idempiereProperties, MBHBPSpecificPayerInfo.Table_Name, null,
						MBHBPSpecificPayerInfo::getC_InvoiceLine_ID, MBHBPSpecificPayerInfo.COLUMNNAME_C_InvoiceLine_ID,
						invoiceLinesByInvoiceId.values().stream().flatMap(Collection::stream).map(MInvoiceLine::getC_InvoiceLine_ID)
								.collect(Collectors.toSet()));

		boolean wereDeletesSuccessful = true;
		for (String uuid : uuids) {
			Trx deleteVisitTransaction = Trx.get(Trx.createTrxName("DeleteVisit"), true);
			try {
				MBHVisit visit = visitsByUuid.get(uuid);
				if (visit == null) {
					return true;
				}
				visit.set_TrxName(deleteVisitTransaction.getTrxName());

				// If this visit has any completed orders, shipments, invoices, or payments, we
				// can't delete it
				List<MOrder_BH> visitsOrders = ordersByVisitId.getOrDefault(visit.get_ID(), new ArrayList<>());
				List<MInOut_BH> visitsInOuts = inOutsByVisitId.getOrDefault(visit.get_ID(), new ArrayList<>());
				List<MInvoice_BH> visitsInvoices = invoicesByVisitId.getOrDefault(visit.get_ID(), new ArrayList<>());
				List<MPayment_BH> visitsPayments = paymentsByVisitId.getOrDefault(visit.get_ID(), new ArrayList<>());

				Predicate<DocAction> isNotDrafted = (
						DocAction entity) -> !DocumentEngine.STATUS_Drafted.equals(entity.getDocStatus());
				if (visitsOrders.stream().anyMatch(isNotDrafted) || visitsInOuts.stream().anyMatch(isNotDrafted)
						|| visitsInvoices.stream().anyMatch(isNotDrafted)
						|| visitsPayments.stream().anyMatch(isNotDrafted)) {
					throw new AdempiereException("Visit " + visit.getBH_Visit_UU() + " is already completed");
				}

				// Handle invoice & order lines separately
				Consumer<PO> deleteEntityForEach = (PO entity) -> entity.deleteEx(true);
				visitsInvoices.forEach(invoice -> {
					invoiceLinesByInvoiceId.getOrDefault(invoice.get_ID(), new ArrayList<>()).forEach(invoiceLine -> {
						businessPartnerSpecificPayerInformationByInvoiceLineId.getOrDefault(invoiceLine.getC_InvoiceLine_ID(),
								new ArrayList<>()).forEach(deleteEntityForEach);
						invoiceLine.deleteEx(true);
					});
				});
				visitsOrders.forEach(
						order -> orderLinesByOrderId.getOrDefault(order.get_ID(), new ArrayList<>()).forEach(deleteEntityForEach));

				Predicate<PO> deleteEntity = (PO entity) -> entity.delete(true);
				if (!(visitsPayments.stream().allMatch(deleteEntity) && visitsInvoices.stream().allMatch(deleteEntity)
						&& visitsInOuts.stream().allMatch(deleteEntity) && visitsOrders.stream().allMatch(deleteEntity))) {
					throw new AdempiereException("Could not delete dependent entities");
				}

				boolean didDelete = visit.delete(true);
				if (!deleteVisitTransaction.commit(true)) {
					log.severe("Could not commit visit transaction");
					return false;
				}
				return didDelete;
			} catch (Exception ex) {
				try {
					if (!deleteVisitTransaction.rollback(true)) {
						log.severe("Could not roll back visit transaction");
					}
				} catch (SQLException e) {
					log.severe("Could not roll back visit transaction: " + e.getLocalizedMessage());
				}
				throw new AdempiereException(ex.getLocalizedMessage());
			} finally {
				if (!deleteVisitTransaction.close()) {
					log.severe("Could not close visit transaction");
					throw new AdempiereException("Could not close visit transaction");
				}
			}
		}
		return wereDeletesSuccessful;
	}
}
