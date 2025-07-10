package com.chuboe.test.populate;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.util.Trx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChuBoeDeleteEntity {
	public static void deletevisits(ChuBoePopulateVO valueObject, Set<String> uuids){
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}
	
		Map<String, MBHVisit> visitsByUuid = getByUuids(valueObject.getContext(), valueObject.getTransactionName(), uuids);
		Set<Integer> visitIds = visitsByUuid.values().stream().map(MBHVisit::getBH_Visit_ID).collect(Collectors.toSet());

		// Get child entities
		Map<Integer, List<MOrder_BH>> ordersByVisitId =
				getGroupsByIds(valueObject.getContext(), MOrder_BH.Table_Name, null, MOrder_BH::getBH_Visit_ID,
						MOrder_BH.COLUMNNAME_BH_Visit_ID, visitIds);
		Map<Integer, List<MInOut_BH>> inOutsByVisitId =
				getGroupsByIds(valueObject.getContext(), MInOut_BH.Table_Name, null, MInOut_BH::getBH_Visit_ID,
						MInOut_BH.COLUMNNAME_BH_Visit_ID, visitIds);
		Map<Integer, List<MInvoice_BH>> invoicesByVisitId =
				getGroupsByIds(valueObject.getContext(), MInvoice_BH.Table_Name, null, MInvoice_BH::getBH_Visit_ID,
						MInvoice_BH.COLUMNNAME_BH_Visit_ID, visitIds);
		Map<Integer, List<MPayment_BH>> paymentsByVisitId =
				getGroupsByIds(valueObject.getContext(), MPayment_BH.Table_Name, null, MPayment_BH::getBH_Visit_ID,
						MPayment_BH.COLUMNNAME_BH_Visit_ID, visitIds);

		// Get grandchildren entities
		Map<Integer, List<MOrderLine_BH>> orderLinesByOrderId =
				getGroupsByIds(valueObject.getContext(), MOrderLine_BH.Table_Name, null, MOrderLine_BH::getC_Order_ID,
						MOrderLine_BH.COLUMNNAME_C_Order_ID,
						ordersByVisitId.values().stream().flatMap(Collection::stream).map(MOrder_BH::getC_Order_ID)
								.collect(Collectors.toSet()));
		Map<Integer, List<MInOutLine>> inOutLinesByOrderId =
				getGroupsByIds(valueObject.getContext(), MInOutLine.Table_Name, null, MInOutLine::getM_InOut_ID,
						MInOutLine.COLUMNNAME_M_InOut_ID,
						inOutsByVisitId.values().stream().flatMap(Collection::stream).map(MInOut_BH::getM_InOut_ID)
								.collect(Collectors.toSet()));
		Map<Integer, List<MInvoiceLine>> invoiceLinesByInvoiceId =
				getGroupsByIds(valueObject.getContext(), MInvoiceLine.Table_Name, null, MInvoiceLine::getC_Invoice_ID,
						MInvoiceLine.COLUMNNAME_C_Invoice_ID,
						invoicesByVisitId.values().stream().flatMap(Collection::stream).map(MInvoice_BH::getC_Invoice_ID)
								.collect(Collectors.toSet()));

		// Get great grandchildren entities
		Map<Integer, List<MBHBPSpecificPayerInfo>> businessPartnerSpecificPayerInformationByInvoiceLineId =
				getGroupsByIds(valueObject.getContext(), MBHBPSpecificPayerInfo.Table_Name, null,
						MBHBPSpecificPayerInfo::getC_InvoiceLine_ID, MBHBPSpecificPayerInfo.COLUMNNAME_C_InvoiceLine_ID,
						invoiceLinesByInvoiceId.values().stream().flatMap(Collection::stream).map(MInvoiceLine::getC_InvoiceLine_ID)
								.collect(Collectors.toSet()));

		for (String uuid : uuids) {
			Trx deleteVisitTransaction = Trx.get(Trx.createTrxName("DeleteVisit"), true);
			try {
				MBHVisit visit = visitsByUuid.get(uuid);
				if (visit == null) {
					throw new AdempiereException("Visit is null");
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

				 visit.delete(true);
				if (!deleteVisitTransaction.commit(true)) {
					return;
				}
			} catch (Exception ex) {
				try {
					if (!deleteVisitTransaction.rollback(true)) {
						return;
					}
				} catch (SQLException e) {
				e.printStackTrace();
				}
				throw new AdempiereException(ex.getLocalizedMessage());
			} finally {
				if (!deleteVisitTransaction.close()) {
					throw new AdempiereException("Could not close visit transaction");
				}
			}
		}

	}

	private static <T extends PO> Map<String, T> getByUuids(Properties idempiereContext,
			String transactionName, Set<String> uuids) {
		
		if (uuids.isEmpty()) {
			return new HashMap<>();
		}
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(uuids, parameters);
		List<T> models = new Query(idempiereContext, MBHVisit.Table_Name, MBHVisit.COLUMNNAME_BH_Visit_UU + " in(" + whereCondition + ")", transactionName).setParameters(parameters).list();
		return models.stream().collect(
				Collectors.toMap(model -> model.get_Value(model.get_ColumnIndex(model.getUUIDColumnName())).toString(),
						model -> model));
	}
	private static <T extends PO> Map<Integer, List<T>> getGroupsByIds(Properties idempiereContext, String tableName,
			String transactionName, Function<T, Integer> groupingFunction, String columnToSearch, Set<Integer> ids) {
		List<Object> parameters = new ArrayList<>();
		if (ids == null || ids.isEmpty()) {
			return new HashMap<>();
		}
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(ids, parameters);
		if (!columnToSearch.contains(".")) {
			columnToSearch = tableName + "." + columnToSearch;
		}
		String whereClause = null;
		if (!StringUtil.isNullOrEmpty(whereCondition)) {
			whereClause = columnToSearch + " IN (" + whereCondition + ")";
		}
		List<T> models =
				new Query(idempiereContext, tableName, whereClause , transactionName).setParameters(parameters).list();
		return models.stream().collect(Collectors.groupingBy(groupingFunction));
	}
}
