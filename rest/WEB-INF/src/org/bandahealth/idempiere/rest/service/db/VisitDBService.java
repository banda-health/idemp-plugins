package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.Encounter;
import org.bandahealth.idempiere.rest.model.Invoice;
import org.bandahealth.idempiere.rest.model.InvoiceLine;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.PatientType;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.model.ProcessStage;
import org.bandahealth.idempiere.rest.model.Referral;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MRefList;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Visit/billing functionality
 *
 * @author andrew
 */
@Component
public class VisitDBService extends BaseDBService<Visit, MBHVisit> {

	@Autowired
	private PaymentDBService paymentDBService;
	@Autowired
	private OrderDBService orderDBService;
	@Autowired
	private OrderLineDBService orderLineDBService;
	@Autowired
	private InvoiceDBService invoiceDBService;
	@Autowired
	private InvoiceLineDBService invoiceLineDBService;
	@Autowired
	private UserDBService userDBService;
	@Autowired
	private EntityMetadataDBService entityMetadataDBService;
	@Autowired
	private VoidedReasonDBService voidedReasonDBService;
	@Autowired
	private BusinessPartnerDBService businessPartnerDBService;
	@Autowired
	private EncounterDBService encounterDBService;
	@Autowired
	private DocumentTypeDBService documentTypeDBService;

	private final Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(MBPartner_BH.Table_Name,
					"LEFT JOIN " + MBPartner_BH.Table_Name + " ON " + MBHVisit.Table_Name + "."
							+ MBHVisit.COLUMNNAME_Patient_ID + " = " + MBPartner_BH.Table_Name + "."
							+ MBPartner_BH.COLUMNNAME_C_BPartner_ID);
			put(MUser.Table_Name,
					"LEFT JOIN " + MUser.Table_Name + " ON " + MBHVisit.Table_Name + "."
							+ MBHVisit.COLUMNNAME_BH_Clinician_User_ID + " = " + MUser.Table_Name + "."
							+ MUser.COLUMNNAME_AD_User_ID);
		}
	};

	public static Map<Integer, Integer> getVisitCountsByPatients(Set<Integer> patientIds) {
		List<Object> parameters = new ArrayList<>();
		String sqlWhere = "WHERE " + MBHVisit.COLUMNNAME_BH_Visit_ID + " IN (SELECT " + MOrder_BH.COLUMNNAME_BH_Visit_ID
				+ " FROM " + MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND "
				+ MOrder_BH.COLUMNNAME_DocStatus + "!=? AND " + MOrder_BH.COLUMNNAME_AD_Client_ID + "=?) AND "
				+ MBHVisit.COLUMNNAME_Patient_ID + " IN (";

		parameters.add("Y");
		parameters.add("VO");
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		String patientIdInWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters);

		return SqlUtil.getGroupCount(MBHVisit.Table_Name, sqlWhere + patientIdInWhereClause + ")",
				MBHVisit.COLUMNNAME_Patient_ID, parameters, (resultSet -> {
					try {
						return resultSet.getInt(1);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return 0;
				}));
	}

	public static Map<Integer, String> getLastVisitDateByPatients(Set<Integer> patientIds) {
		if (patientIds.isEmpty()) {
			return new HashMap<>();
		}
		List<Object> parameters = new ArrayList<>();
		String whereClause = "WHERE " + MBHVisit.COLUMNNAME_Patient_ID + " IN ("
				+ QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters) + ") AND "
				+ MBHVisit.COLUMNNAME_AD_Client_ID + "=?";
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));

		String sql = "SELECT " + MBHVisit.COLUMNNAME_Patient_ID + ", MAX(" + MBHVisit.COLUMNNAME_BH_VisitDate
				+ ") FROM " + MBHVisit.Table_Name + " " + whereClause + " GROUP BY " + MBHVisit.COLUMNNAME_Patient_ID;

		Map<Integer, String> lastVisitDatesByPatientId = new HashMap<>();
		patientIds.forEach(patientId -> {
			lastVisitDatesByPatientId.put(patientId, null);
		});

		SqlUtil.executeQuery(sql, parameters, null, (resultSet) -> {
			try {
				lastVisitDatesByPatientId.put(resultSet.getInt(1), DateUtil.parseDateOnly(resultSet.getTimestamp(2)));
			} catch (Exception e) {
				log.severe(e.getMessage());
			}
		});

		return lastVisitDatesByPatientId;
	}

	public Visit processDependentEntities(String uuid, String docAction) throws Exception {
		if (!orderDBService.isDocActionValidForUser(DocumentDBService.DOCUMENTNAME_BILLS, docAction)) {
			return null;
		}

		// Create a transaction so all parts of the visit can pass or fail together
		Trx processVisitTransaction = Trx.get(Trx.createTrxName("ProcessVisit"), true);
		try {
			MBHVisit visit = getEntityByUuidFromDB(uuid);
			List<MOrder_BH> visitsOrders =
					orderDBService.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID,
							Collections.singleton(visit.get_ID())).get(visit.get_ID());
			Map<Integer, MDocType_BH> documentTypesById = documentTypeDBService.getByIds(
					visitsOrders.stream().map(MOrder_BH::getC_DocTypeTarget_ID).collect(Collectors.toSet()));
			// TODO: Update this when we have multiple orders, since we may not want to process all at the same time
			for (MOrder_BH order : visitsOrders) {
				order.set_TrxName(processVisitTransaction.getTrxName());
				ModelUtil.processDocumentOrError(orderDBService.getDocumentProcessId(), order, docAction);

				// Handle the invoices (if the order document type is appropriate)
				MDocType_BH documentType = documentTypesById.containsKey(order.getC_DocTypeTarget_ID()) ?
						documentTypesById.get(order.getC_DocTypeTarget_ID()) : new MDocType_BH(Env.getCtx(), 0, null);
				if (!MDocType.DOCSUBTYPESO_OnCreditOrder.equals(documentType.getDocSubTypeSO()) &&
						!MDocType.DOCSUBTYPESO_POSOrder.equals(documentType.getDocSubTypeSO()) &&
						!MDocType.DOCSUBTYPESO_PrepayOrder.equals(documentType.getDocSubTypeSO())) {
					List<MInvoice_BH> existingInvoices =
							invoiceDBService.getGroupsByIds(MInvoice_BH::getBH_Visit_ID, MInvoice_BH.COLUMNNAME_BH_Visit_ID,
											Collections.singleton(visit.get_ID())).get(visit.get_ID()).stream()
									.peek(invoice -> invoice.set_TrxName(processVisitTransaction.getTrxName()))
									.collect(Collectors.toList());
					Collection<MInvoice_BH> existingUnfinalizedInvoices = existingInvoices.stream()
							.filter(
									invoice -> !invoice.isComplete() || invoice.getDocStatus().equals(MInvoice_BH.DOCSTATUS_Completed))
							.collect(Collectors.toList());
					// If this is a reversal, we also need to take care of the invoices
					if (docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Accrual) ||
							docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Correct) ||
							docAction.equalsIgnoreCase(DocAction.ACTION_ReActivate)) {

						for (MInvoice_BH invoice : existingUnfinalizedInvoices) {
							MInvoice_BH newInvoice = invoice.copy();
							invoice.setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
							ModelUtil.processDocumentOrError(invoiceDBService.getDocumentProcessId(), invoice,
									MInvoice_BH.DOCACTION_Reverse_Accrual);

							newInvoice.setDocStatus(MInvoice_BH.DOCSTATUS_Drafted);
							newInvoice.setBH_Visit_ID(visit.get_ID());
							newInvoice.saveEx();
						}
					} else {
						for (MInvoice_BH invoice : existingUnfinalizedInvoices) {
							invoice.setDocAction(docAction);
							ModelUtil.processDocumentOrError(invoiceDBService.getDocumentProcessId(), invoice, docAction);
						}
					}
				}

				// Handle the payments
				List<MPayment_BH> existingPayments = paymentDBService.getByUuids(
								paymentDBService.getPaymentsByVisitId(visit.get_ID()).stream().map(Payment::getUuid)
										.collect(Collectors.toSet())).values().stream()
						.peek(payment -> payment.set_TrxName(processVisitTransaction.getTrxName())).collect(Collectors.toList());
				Collection<MPayment_BH> existingUnfinalizedPayments = existingPayments.stream()
						.filter(payment -> !payment.isComplete() || payment.getDocStatus().equals(MPayment_BH.DOCSTATUS_Completed))
						.collect(Collectors.toList());
				// If this is a reversal, we also need to take care of the payments
				if (docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Accrual)
						|| docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Correct)
						|| docAction.equalsIgnoreCase(DocAction.ACTION_ReActivate)) {

					for (MPayment_BH payment : existingUnfinalizedPayments) {
						MPayment_BH newPayment = payment.copy();
						payment.setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
						ModelUtil.processDocumentOrError(paymentDBService.getDocumentProcessId(), payment,
								MPayment_BH.DOCACTION_Reverse_Accrual);

						newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
						newPayment.setBH_Visit_ID(visit.get_ID());
						newPayment.saveEx();
					}
				} else {
					for (MPayment_BH payment : existingUnfinalizedPayments) {
						payment.setDocAction(docAction);
						ModelUtil.processDocumentOrError(paymentDBService.getDocumentProcessId(), payment, docAction);
					}
				}
			}
			if (!processVisitTransaction.commit(true)) {
				logger.severe("Could not commit visit transaction");
			}
			visit.setBH_Process_Stage(null);
			visit.saveEx();

			return createInstanceWithAllFields(getEntityByUuidFromDB(visit.getBH_Visit_UU()));
		} catch (Exception exception) {
			if (!processVisitTransaction.rollback(true)) {
				logger.severe("Could not roll back visit transaction");
			}
			throw exception;
		} finally {
			if (!processVisitTransaction.close()) {
				logger.severe("Could not close visit transaction");
			}
		}
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	public Visit saveEntity(Visit entity) {
		return createInstanceWithAllFields(getEntityByUuidFromDB(saveOnlyWithoutChildDataFetch(entity).getUuid()));
	}

	/**
	 * This method is implemented to speed up processing by avoiding an unnecessary data fetch.
	 * TODO: Remove this when we have GraphQL
	 *
	 * @param entity The visit to save
	 * @return A somewhat updated visit (has the new UUID & ID on it for other use)
	 */
	public Visit saveOnlyWithoutChildDataFetch(Visit entity) {
		MBHVisit visit = getEntityByUuidFromDB(entity.getUuid());
		if (visit == null) {
			visit = new MBHVisit(Env.getCtx(), 0, null);
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				visit.setBH_Visit_UU(entity.getUuid());
			}
		}

		if (entity.getPatientType() != null && entity.getPatientType().getValue() != null) {
			visit.setBH_PatientType(entity.getPatientType().getValue());
		}

		if (entity.getReferral() != null && entity.getReferral().getValue() != null) {
			visit.setbh_referral(entity.getReferral().getValue());
		}

		if (entity.isNewVisit() != null) {
			visit.setBH_NewVisit(entity.isNewVisit());
		}

		if (entity.getClinician() != null && entity.getClinician().getUuid() != null) {
			// get user id
			MUser user = new Query(Env.getCtx(), MUser.Table_Name, MUser.COLUMNNAME_AD_User_UU + " =?", null)
					.setParameters(entity.getClinician().getUuid()).first();
			if (user != null) {
				visit.setBH_Clinician_User_ID(user.get_ID());
			}
		}

		if (entity.getProcessStage() != null && entity.getProcessStage().getValue() != null) {
			visit.setBH_Process_Stage(entity.getProcessStage().getValue());
		}

		ModelUtil.setPropertyIfPresent(entity.getVisitDate(), visit::setBH_VisitDate);
		ModelUtil.setPropertyIfPresent(entity.getReferredFromTo(), visit::setBH_ReferredFromTo);

		if (entity.getVoidedReason() != null && entity.getVoidedReason().getUuid() != null) {
			MBHVoidedReason voidingReason = voidedReasonDBService.getEntityByUuidFromDB(entity.getVoidedReason().getUuid());
			if (voidingReason != null) {
				visit.setBH_Voided_Reason_ID(voidingReason.get_ID());
				// Set for all orders as well
				entity.getOrders().forEach(order -> order.setVoidedReason(entity.getVoidedReason()));
			}
		}

		MBPartner_BH businessPartner;
		if (entity.getPatient() != null && entity.getPatient().getUuid() != null &&
				(businessPartner = businessPartnerDBService.getEntityByUuidFromDB(entity.getPatient().getUuid())) != null) {
			visit.setPatient_ID(businessPartner.get_ID());
			entity.getOrders().forEach(order -> {
				order.setBusinessPartner(new BusinessPartner());
				order.getBusinessPartner().setUuid(businessPartner.getC_BPartner_UU());
			});
		}

		// We're going to log to try and see how long things take to try and identify the cause of deadlocks
		String randomUuid = UUID.randomUUID().toString();
		long startTime = System.currentTimeMillis();
		visit.saveEx();
		logger.info("Visit_" + randomUuid + " millisecond save time: " + (System.currentTimeMillis() - startTime));
		int visitId = visit.get_ID();
		entity.setId(visitId);

		// save encounter
		entity.getEncounters().forEach(encounter -> {
			encounter.setVisitId(visitId);
			long internalStartTime = System.currentTimeMillis();
			encounterDBService.saveOnlyWithoutChildDataFetch(encounter);
			logger.info(
					"Encounter_" + randomUuid + " millisecond save time: " + (System.currentTimeMillis() - internalStartTime));
		});

		// TODO: Eventually handle when orders are removed/added...
		if (entity.getOrders() == null) {
			entity.setOrders(new ArrayList<>());
		}
		List<Order> updatedOrders = new ArrayList<>();
		for (Order order : entity.getOrders()) {
			order.setVisitId(visit.get_ID());
			order.setDateOrdered(entity.getVisitDate());
			order.setDateAccount(entity.getVisitDate());

			startTime = System.currentTimeMillis();
			updatedOrders.add(orderDBService.saveOnlyWithoutChildDataFetch(order, false));
			logger.info(
					"OrderFirstRound_" + randomUuid + " millisecond save time: " + (System.currentTimeMillis() - startTime));
		}

		List<OrderLine> updatedOrderLines =
				orderLineDBService.getOrderLinesByOrderIds(updatedOrders.stream().map(Order::getId).collect(Collectors.toSet()))
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		List<MInvoice_BH> visitsInvoices =
				invoiceDBService.getGroupsByIds(MInvoice_BH::getBH_Visit_ID, MInvoice_BH.COLUMNNAME_BH_Visit_ID,
						Collections.singleton(entity.getId())).get(entity.getId());
		// For any invoices that aren't in the set, remove them
		List<String> invoiceUuidsToBeSaved =
				entity.getInvoices().stream().map(Invoice::getUuid).collect(Collectors.toList());
		if (!visitsInvoices.stream().filter(Predicate.not(MInvoice_BH::isComplete)).map(MInvoice_BH::getC_Invoice_UU)
				.filter(invoiceUuid -> !invoiceUuidsToBeSaved.contains(invoiceUuid)).allMatch(invoiceDBService::deleteEntity)) {
			throw new AdempiereException("Error saving invoices");
		}
		for (Invoice invoice : entity.getInvoices()) {
			invoice.setVisitId(visit.get_ID());

			// Update order associations, if there is any need
			if (invoice.getOrder() != null && !StringUtil.isNullOrEmpty(invoice.getOrder().getUuid())) {
				// Set the order ID with what has been saved
				invoice.setOrderId(
						updatedOrders.stream().filter(order -> Objects.equals(order.getUuid(), invoice.getOrder().getUuid()))
								.findFirst().orElseThrow().getId());

				// Now set order line IDs, if there are any
				List<InvoiceLine> invoiceLinesWithOrderLineAssociations;
				if (invoice.getInvoiceLines() != null && !(invoiceLinesWithOrderLineAssociations =
						invoice.getInvoiceLines().stream().filter(invoiceLine -> invoiceLine.getOrderLine() != null &&
										!StringUtil.isNullOrEmpty(invoiceLine.getOrderLine().getUuid()))
								.collect(Collectors.toList())).isEmpty()) {
					// There are, so set the order line IDs
					invoiceLinesWithOrderLineAssociations.forEach(invoiceLine -> invoiceLine.setOrderLineId(
							updatedOrderLines.stream()
									.filter(orderLine -> Objects.equals(orderLine.getUuid(), invoiceLine.getOrderLine().getUuid()))
									.findFirst().orElseThrow().getId()));
				}
			}

			startTime = System.currentTimeMillis();
			invoiceDBService.saveOnlyWithoutChildDataFetch(invoice);
			logger.info("Invoice_" + randomUuid + " millisecond save time: " + (System.currentTimeMillis() - startTime));
		}

		// Now that we've (potentially) deleted invoice lines, we can delete any necessary order lines
		entity.getOrders().forEach(order -> {
			long internalStartTime = System.currentTimeMillis();
			orderDBService.saveOnlyWithoutChildDataFetch(order, true);
			logger.info(
					"OrderSecondRound_" + randomUuid + " millisecond save time: " +
							(System.currentTimeMillis() - internalStartTime));
		});

		// list of persisted payment line ids
		StringBuilder lineIds = new StringBuilder();
		List<Payment> payments = entity.getPayments();
		if (payments != null && !payments.isEmpty()) {
			int count = 0;
			// We only update incomplete payments
			Set<String> completePaymentUuids = paymentDBService
					.getByUuids(payments.stream().map(Payment::getUuid).collect(Collectors.toSet())).values().stream()
					.filter(MPayment_BH::isComplete).map(MPayment_BH::getC_Payment_UU).collect(Collectors.toSet());
			payments = payments.stream().filter(payment -> !completePaymentUuids.contains(payment.getUuid()))
					.collect(Collectors.toList());
			for (Payment payment : payments) {
				payment.setVisitId(visit.get_ID());
				payment.setTransactionDate(DateUtil.parse(entity.getVisitDate()));
				// Read the patient assigned to the entity
				// NOTE: DO NOT use the mPatient property because this class is a singleton and
				// there exists the possibility
				// that the property has been overridden by another save request between when it
				// was set for this order and now
				if (entity.getPatient() != null) {
					payment.setBusinessPartner(new BusinessPartner());
					payment.getBusinessPartner().setUuid(entity.getPatient().getUuid());
				}

				startTime = System.currentTimeMillis();
				Payment response = paymentDBService.saveOnlyWithoutChildDataFetch(payment);
				logger.info("Payment_" + randomUuid + " millisecond save time: " + (System.currentTimeMillis() - startTime));
				lineIds.append("'").append(response.getUuid()).append("'");
				if (++count < payments.size()) {
					lineIds.append(",");
				}
			}
		}

		// delete payment lines not in request
		paymentDBService.deletePaymentLinesByVisit(visit.get_ID(), lineIds.toString());

		return new Visit(visit);
	}

	@Override
	public Boolean deleteEntity(String uuid) {
		Trx deleteVisitTransaction = Trx.get(Trx.createTrxName("DeleteVisit"), true);
		try {
			MBHVisit visit = getEntityByUuidFromDB(uuid);
			if (visit == null) {
				return true;
			}
			visit.set_TrxName(deleteVisitTransaction.getTrxName());

			// If this visit has any completed orders, shipments, invoices, or payments, we
			// can't delete it
			List<MOrder_BH> visitsOrders = new Query(Env.getCtx(), MOrder_BH.Table_Name,
					MOrder_BH.COLUMNNAME_BH_Visit_ID + "=?", deleteVisitTransaction.getTrxName())
					.setParameters(visit.get_ID()).list();
			List<MInOut_BH> visitsInOuts = new Query(Env.getCtx(), MInOut_BH.Table_Name,
					MInOut_BH.COLUMNNAME_BH_Visit_ID + "=?", deleteVisitTransaction.getTrxName())
					.setParameters(visit.get_ID()).list();
			List<MInvoice_BH> visitsInvoices = new Query(Env.getCtx(), MInvoice_BH.Table_Name,
					MInvoice_BH.COLUMNNAME_BH_Visit_ID + "=?", deleteVisitTransaction.getTrxName())
					.setParameters(visit.get_ID()).list();
			List<MPayment_BH> visitsPayments = new Query(Env.getCtx(), MPayment_BH.Table_Name,
					MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?", deleteVisitTransaction.getTrxName())
					.setParameters(visit.get_ID()).list();

			Predicate<DocAction> isNotDrafted = (
					DocAction entity) -> !DocumentEngine.STATUS_Drafted.equals(entity.getDocStatus());
			if (visitsOrders.stream().anyMatch(isNotDrafted) || visitsInOuts.stream().anyMatch(isNotDrafted)
					|| visitsInvoices.stream().anyMatch(isNotDrafted)
					|| visitsPayments.stream().anyMatch(isNotDrafted)) {
				throw new AdempiereException("Visit is already completed");
			}

			// Handle invoice & order lines separately
			if (!visitsInvoices.isEmpty()) {
				visitsInvoices.forEach(invoice -> invoiceLineDBService.deleteInvoiceLinesByInvoice(invoice.get_ID(), ""));
			}
			if (!visitsOrders.isEmpty()) {
				visitsOrders.forEach(order -> orderLineDBService.deleteOrderLinesByOrder(order.get_ID(), ""));
			}

			Predicate<PO> deleteEntity = (PO entity) -> entity.delete(true);
			if (!(visitsPayments.stream().allMatch(deleteEntity) && visitsInvoices.stream().allMatch(deleteEntity)
					&& visitsInOuts.stream().allMatch(deleteEntity) && visitsOrders.stream().allMatch(deleteEntity))) {
				throw new AdempiereException("Could not delete dependent entities");
			}

			boolean didDelete = visit.delete(true);
			if (!deleteVisitTransaction.commit(true)) {
				logger.severe("Could not commit visit transaction");
				return false;
			}
			return didDelete;
		} catch (Exception ex) {
			try {
				if (!deleteVisitTransaction.rollback(true)) {
					logger.severe("Could not roll back visit transaction");
				}
			} catch (SQLException e) {
				logger.severe("Could not roll back visit transaction: " + e.getLocalizedMessage());
			}
			throw new AdempiereException(ex.getLocalizedMessage());
		} finally {
			if (!deleteVisitTransaction.close()) {
				logger.severe("Could not close visit transaction");
			}
		}
	}

	@Override
	protected Visit createInstanceWithDefaultFields(MBHVisit instance) {
		return new Visit(instance);
	}

	@Override
	protected Visit createInstanceWithAllFields(MBHVisit instance) {
		return batchChildDataCalls(transformData(Collections.singletonList(instance))).get(0);
	}

	@Override
	protected MBHVisit getModelInstance() {
		return new MBHVisit(Env.getCtx(), 0, null);
	}

	/**
	 * Get In-complete Visits
	 *
	 * @param pagingInfo
	 * @return
	 */
	public BaseListResponse<Visit> getVisitQueue(Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");
		parameters.add(MOrder_BH.DOCSTATUS_Drafted);

		try {
			List<Visit> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(),
					MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " + MOrder_BH.COLUMNNAME_DocStatus + " = ?", null)
					.setClient_ID().setOnlyActiveRecords(true);

			query = query.setParameters(parameters);

			// default sorting i.e created desc
			String orderBy = getOrderBy(null, null);
			if (orderBy != null) {
				query = query.setOrderBy(orderBy);
			}

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MOrder_BH> entities = query.list();

			if (!entities.isEmpty()) {
				for (MOrder_BH entity : entities) {
					if (entity != null) {
						// get patient
						MBPartner_BH businessPartner = businessPartnerDBService.getEntityByIdFromDB(entity.getC_BPartner_ID());
						if (businessPartner == null) {
							continue;
						}
						Visit visit = new Visit();
						visit.setCreated(DateUtil.parseQueueTime(entity.getCreated()));
						visit.setCreatedTimestamp(entity.getCreated());
						visit.setUuid(entity.getC_Order_UU());
						visit.setPatient(new BusinessPartner(businessPartner));
						results.add(visit);
					}
				}
			}

			return new BaseListResponse<Visit>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	/**
	 * Get Open Visits (exclude today's visits) Count
	 *
	 * @return count
	 */
	public Integer getOpenVisitDraftsCount() {
		List<Object> parameters = new ArrayList<>();
		String sqlWhere = "WHERE " +
				buildOpenDraftsWhereClauseAndParameters(parameters);

		return SqlUtil.getCount(MOrder_BH.Table_Name, sqlWhere, parameters);
	}

	/**
	 * Get Open Visits
	 *
	 * @param pagingInfo
	 * @param sortJson
	 * @return
	 */
	public BaseListResponse<Visit> getOpenVisitDrafts(Paging pagingInfo, String sortJson) {
		List<Object> parameters = new ArrayList<>();
		String sqlWhere = buildOpenDraftsWhereClauseAndParameters(parameters);

		return super.getAll(sqlWhere, parameters, pagingInfo, sortJson, null);
	}

	private String buildOpenDraftsWhereClauseAndParameters(List<Object> parameters) {
		String sqlWhere = MOrder_BH.COLUMNNAME_AD_Client_ID + " =?" +
				AND_OPERATOR + MOrder_BH.COLUMNNAME_AD_Org_ID + " =?" + AND_OPERATOR +
				MOrder_BH.COLUMNNAME_IsActive + " =?" + AND_OPERATOR +
				MOrder_BH.COLUMNNAME_DocStatus + " =? " + AND_OPERATOR + "to_char(" +
				MOrder_BH.COLUMNNAME_Created + ", 'YYYY-MM-DD')" + " < ? " + AND_OPERATOR +
				MOrder_BH.COLUMNNAME_IsSOTrx + " = ?";

		if (parameters == null) {
			parameters = new ArrayList<>();
		}

		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));
		parameters.add("Y");
		parameters.add(MOrder_BH.DOCSTATUS_Drafted);
		parameters.add(DateUtil.parseDateOnly(new Timestamp(System.currentTimeMillis())));
		parameters.add("Y");

		return sqlWhere;
	}

	@Override
	public List<Visit> transformData(List<MBHVisit> dbModels) {
		// This will only return what's needed for the list page for performance reasons, but it should NOT do this
		// This will be replaced once we implement GraphQL
		Set<Integer> visitIds = dbModels.stream().map(MBHVisit::get_ID).collect(Collectors.toSet());

		// Orders will be duplicated between this and batchChildDataCalls for now
		Map<Integer, List<MOrder_BH>> ordersByVisitId =
				orderDBService.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID, visitIds);

		// Get BPs
		Map<Integer, BusinessPartner> businessPartnersById = businessPartnerDBService.transformData(new ArrayList<>(
				businessPartnerDBService.getByIds(dbModels.stream().map(MBHVisit::getPatient_ID).collect(Collectors.toSet()))
						.values())).stream().collect(Collectors.toMap(BusinessPartner::getId, businessPartner -> businessPartner));

		Map<String, MRefList> patientTypesByValue =
				entityMetadataDBService.getTypes(EntityMetadataDBService.PATIENT_TYPE).stream()
						.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		// Get the patient types
		return dbModels.stream().map(model -> {
			Visit visit = new Visit(model);
			visit.setPatient(businessPartnersById.get(visit.getPatientId()));
			visit.setOrders(ordersByVisitId.getOrDefault(visit.getId(), new ArrayList<>()).stream().map(Order::new)
					.collect(Collectors.toList()));

			if (patientTypesByValue.containsKey(visit.getPatientTypeValue())) {
				visit.setPatientType(new PatientType(visit.getPatientTypeValue(),
						patientTypesByValue.get(visit.getPatientTypeValue()).getName()));
			}
			return visit;
		}).collect(Collectors.toList());
	}

	public List<Visit> batchChildDataCalls(List<Visit> models) {
		Set<Integer> visitIds = models.stream().map(Visit::getId).collect(Collectors.toSet());

		List<MOrder_BH> orders = orderDBService
				.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID, visitIds).values().stream()
				.flatMap(Collection::stream).collect(Collectors.toList());

		Map<Integer, List<Order>> orderIdsByVisitId = orderDBService.transformData(orders).stream()
				.collect(Collectors.groupingBy(Order::getVisitId));

		Map<Integer, List<OrderLine>> orderLinesByOrderId = orderLineDBService
				.getOrderLinesByOrderIds(orders.stream().map(MOrder_BH::get_ID).collect(Collectors.toSet()));

		// Get invoices
		Map<Integer, List<Invoice>> invoicesByVisitId = invoiceDBService.transformData(
						invoiceDBService.getGroupsByIds(MInvoice_BH::getBH_Visit_ID, MInvoice_BH.COLUMNNAME_BH_Visit_ID, visitIds)
								.values().stream().flatMap(Collection::stream).collect(Collectors.toList())).stream()
				.collect(Collectors.groupingBy(Invoice::getVisitId));
		Map<Integer, List<InvoiceLine>> invoiceLinesByInvoiceId = invoiceLineDBService.transformData(
				invoiceLineDBService.getGroupsByIds(MInvoiceLine::getC_Invoice_ID, MInvoiceLine.COLUMNNAME_C_Invoice_ID,
								invoicesByVisitId.values().stream().flatMap(Collection::stream).map(Invoice::getId)
										.collect(Collectors.toSet())).values().stream().flatMap(Collection::stream)
						.collect(Collectors.toList())).stream().collect(Collectors.groupingBy(InvoiceLine::getInvoiceId));

		Map<Integer, List<Encounter>> encountersByVisitId = encounterDBService
				.transformData(encounterDBService
						.getGroupsByIds(MBHEncounter::getBH_Visit_ID, MBHEncounter.COLUMNNAME_BH_Visit_ID, visitIds)
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(Encounter::getVisitId));

		Map<Integer, List<Payment>> paymentIdsByVisitId = paymentDBService
				.transformData(paymentDBService
						.getGroupsByIds(MPayment_BH::getBH_Visit_ID, MPayment_BH.COLUMNNAME_BH_Visit_ID, visitIds)
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(Payment::getVisitId));

		List<MUser_BH> clinicians = userDBService.getClinicians(null);

		return models.stream().peek(visit -> {
			visit.setOrders(orderIdsByVisitId.getOrDefault(visit.getId(), new ArrayList<>()));
			visit.getOrders().forEach(
					order -> order.setOrderLines(orderLinesByOrderId.getOrDefault(order.getId(), new ArrayList<>())));
			visit.setPayments(paymentIdsByVisitId.getOrDefault(visit.getId(), new ArrayList<>()));
			visit.setEncounters(encountersByVisitId.getOrDefault(visit.getId(), new ArrayList<>()));
			visit.setInvoices(invoicesByVisitId.getOrDefault(visit.getId(), new ArrayList<>()));
			visit.getInvoices().forEach(
					invoice -> invoice.setInvoiceLines(invoiceLinesByInvoiceId.getOrDefault(invoice.getId(),
							new ArrayList<>())));
			visit.setProcessStage(new ProcessStage(visit.getProcessStageValue()));
			visit.setReferral(new Referral(visit.getReferralValue()));

			if (visit.getClinicianId() > 0) {
				clinicians.stream().filter(user -> user.getAD_User_ID() == visit.getClinicianId()).findFirst()
						.ifPresent(clinician -> visit.setClinician(new User(clinician)));
			}
		}).collect(Collectors.toList());
	}
}
