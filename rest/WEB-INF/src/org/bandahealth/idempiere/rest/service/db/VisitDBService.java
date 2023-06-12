package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.CodedDiagnosis;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.model.PatientType;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
	private CodedDiagnosisDBService codedDiagnosisDBService;
	@Autowired
	private PatientDBService patientDBService;
	@Autowired
	private PaymentDBService paymentDBService;
	@Autowired
	private OrderDBService orderDBService;
	@Autowired
	private OrderLineDBService orderLineDBService;
	@Autowired
	private UserDBService userDBService;
	@Autowired
	private EntityMetadataDBService entityMetadataDBService;
	@Autowired
	private VoidedReasonDBService voidedReasonDBService;
	@Autowired
	private BusinessPartnerDBService businessPartnerDBService;

	private Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(MBPartner_BH.Table_Name,
					"LEFT JOIN " + MBPartner_BH.Table_Name + " ON " + MBHVisit.Table_Name + "." + MBHVisit.COLUMNNAME_Patient_ID +
							" = " + MBPartner_BH.Table_Name + "." + MBPartner_BH.COLUMNNAME_C_BPartner_ID);
			put(MUser.Table_Name, "LEFT JOIN " + MUser.Table_Name + " ON " + MBHVisit.Table_Name + "." +
					MBHVisit.COLUMNNAME_BH_Clinician_User_ID + " = " + MUser.Table_Name + "." + MUser.COLUMNNAME_AD_User_ID);
			put(MOrder_BH.Table_Name,
					"LEFT JOIN (SELECT bh_visit_id, MIN(dateordered) as dateordered FROM c_order GROUP BY bh_visit_id) " +
							MOrder_BH.Table_Name + " ON " + MBHVisit.Table_Name + "." + MBHVisit.COLUMNNAME_BH_Visit_ID + " = " +
							MOrder_BH.Table_Name + "." + MOrder_BH.COLUMNNAME_BH_Visit_ID);
		}
	};

	public static Map<Integer, Integer> getVisitCountsByPatients(Set<Integer> patientIds) {
		List<Object> parameters = new ArrayList<>();
		String sqlWhere =
				"WHERE " + MBHVisit.COLUMNNAME_BH_Visit_ID + " IN (SELECT " + MOrder_BH.COLUMNNAME_BH_Visit_ID + " FROM " +
						MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " +
						MOrder_BH.COLUMNNAME_DocStatus + "!=? AND " + MOrder_BH.COLUMNNAME_AD_Client_ID + "=?) AND " +
						MBHVisit.COLUMNNAME_Patient_ID + " IN (";

		parameters.add("Y");
		parameters.add("VO");
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		String patientIdInWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters);

		return SqlUtil.getGroupCount(MBHVisit.Table_Name, sqlWhere + patientIdInWhereClause + ")",
				MBHVisit.COLUMNNAME_Patient_ID,
				parameters, (resultSet -> {
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
		String whereClause = "WHERE " + MBHVisit.COLUMNNAME_Patient_ID + " IN (" +
				QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters) + ") AND " +
				MBHVisit.COLUMNNAME_AD_Client_ID + "=?";
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));

		String sql = "SELECT " + MBHVisit.COLUMNNAME_Patient_ID + ", MAX(" + MBHVisit.COLUMNNAME_BH_VisitDate + ") FROM " +
				MBHVisit.Table_Name + " " + whereClause + " GROUP BY " + MBHVisit.COLUMNNAME_Patient_ID;

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
		if (!orderDBService.isDocActionValidForUser(docAction)) {
			return null;
		}

		// Create a transaction so all parts of the visit can pass or fail together
		Trx processVisitTransaction = Trx.get(Trx.createTrxName("ProcessVisit"), true);
		try {
			MBHVisit visit = getEntityByUuidFromDB(uuid);
			List<MOrder_BH> visitsOrders =
					orderDBService.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID,
							Collections.singleton(visit.get_ID())).get(visit.get_ID());
			// TODO: Update this when we have mulitple orders, since we may not want to process all at the same time
			for (MOrder_BH order : visitsOrders) {
				order.set_TrxName(processVisitTransaction.getTrxName());
				ModelUtil.processDocumentOrError(orderDBService.getDocumentProcessId(), order, docAction);

				List<MPayment_BH> existingPayments = paymentDBService.getByUuids(
								paymentDBService.getPaymentsByVisitId(visit.get_ID()).stream().map(Payment::getUuid)
										.collect(Collectors.toSet())).values().stream()
						.peek(payment -> payment.set_TrxName(processVisitTransaction.getTrxName())).collect(Collectors.toList());
				Collection<MPayment_BH> existingUnfinalizedPayments = existingPayments.stream()
						.filter(payment -> !payment.isComplete() || payment.getDocStatus().equals(MPayment_BH.DOCSTATUS_Completed))
						.collect(Collectors.toList());
				// If this is a reversal, we also need to take care of the payments
				if (docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Accrual) ||
						docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Correct) ||
						docAction.equalsIgnoreCase(DocAction.ACTION_ReActivate)) {

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
				if (!processVisitTransaction.commit(true)) {
					logger.severe("Could not commit visit transaction");
				}
			}
			visit.setBH_Process_Stage(null);
			visit.saveEx();

			Visit model = createInstanceWithAllFields(visit);
			model.setOrders(orderDBService.transformData(
					orderDBService.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID,
							Collections.singleton(visit.get_ID())).get(visit.get_ID())));
			model.setPayments(paymentDBService.getPaymentsByVisitId(model.getId()));
			return model;
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
		MBHVisit visit = getEntityByUuidFromDB(entity.getUuid());
		if (visit == null) {
			visit = new MBHVisit(Env.getCtx(), 0, null);
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				visit.setBH_Visit_UU(entity.getUuid());
			}
		}

		if (StringUtil.isNotNullAndEmpty(entity.getClinicalNotes())) {
			visit.setBH_ClinicalNotes(entity.getClinicalNotes());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getLabNotes())) {
			visit.setBH_LabNotes(entity.getLabNotes());
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

		if (entity.getChiefComplaint() != null) {
			visit.setBH_ChiefComplaint(entity.getChiefComplaint());
		}

		if (entity.getTemperature() != null) {
			visit.setBH_Temperature(entity.getTemperature());
		}

		if (entity.getPulse() != null) {
			visit.setBH_Pulse(entity.getPulse());
		}

		if (entity.getRespiratoryRate() != null) {
			visit.setBH_RespiratoryRate(entity.getRespiratoryRate());
		}

		if (entity.getSystolicBloodPressure() != null) {
			visit.setbh_systolic_blood_pressure(entity.getSystolicBloodPressure());
		}

		if (entity.getDiastolicBloodPressure() != null) {
			visit.setbh_diastolic_blood_pressure(entity.getDiastolicBloodPressure());
		}

		if (entity.getHeight() != null) {
			visit.setBH_Height(entity.getHeight());
		}

		if (entity.getWeight() != null) {
			visit.setBH_Weight(entity.getWeight());
		}

		if (entity.getPrimaryCodedDiagnosis() != null || entity.getSecondaryCodedDiagnosis() != null) {
			Set<String> uuids = new HashSet<>();

			if (entity.getPrimaryCodedDiagnosis() != null) {
				uuids.add(entity.getPrimaryCodedDiagnosis().getUuid());
			}
			if (entity.getSecondaryCodedDiagnosis() != null) {
				uuids.add(entity.getSecondaryCodedDiagnosis().getUuid());
			}
			// prefetch coded diagnosis list
			Map<String, MBHCodedDiagnosis> codedDiagnosesByUuid = codedDiagnosisDBService.getByUuids(uuids);

			if (entity.getPrimaryCodedDiagnosis() != null &&
					codedDiagnosesByUuid.containsKey(entity.getPrimaryCodedDiagnosis().getUuid())) {
				visit.setBH_PrimaryCodedDiagnosis_ID(
						codedDiagnosesByUuid.get(entity.getPrimaryCodedDiagnosis().getUuid()).get_ID());
			}

			if (entity.getSecondaryCodedDiagnosis() != null &&
					codedDiagnosesByUuid.containsKey(entity.getSecondaryCodedDiagnosis().getUuid())) {
				visit.setbh_secondarycodeddiagnosis_ID(
						codedDiagnosesByUuid.get(entity.getSecondaryCodedDiagnosis().getUuid()).get_ID());
			}
		}

		if (entity.getPrimaryUnCodedDiagnosis() != null) {
			visit.setbh_primaryuncodeddiagnosis(entity.getPrimaryUnCodedDiagnosis());
		}

		if (entity.getSecondaryUnCodedDiagnosis() != null) {
			visit.setbh_secondaryuncodeddiagnosis(entity.getSecondaryUnCodedDiagnosis());
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

		ModelUtil.setPropertyIfPresent(entity.getReferredFromTo(), visit::setBH_ReferredFromTo);
		ModelUtil.setPropertyIfPresent(entity.getVisitDate(), visit::setBH_VisitDate);
		visit.setBH_OxygenSaturation(entity.getOxygenSaturation());

		visit.saveEx();
		entity.setId(visit.get_ID());

		// TODO: Eventually handle when orders are removed/added...
		// Now take care of the orders
		Optional<MDocType> onCreditOrderDocumentType =
				Arrays.stream(MDocType_BH.getOfDocBaseType(Env.getCtx(), MDocType_BH.DOCBASETYPE_SalesOrder)).filter(
								documentType -> documentType.getDocSubTypeSO() != null &&
										documentType.getDocSubTypeSO().equalsIgnoreCase(MDocType_BH.DOCSUBTYPESO_OnCreditOrder))
						.findFirst();
		if (onCreditOrderDocumentType.isEmpty()) {
			throw new AdempiereException("No on-credit document type found");
		}
		if (entity.getOrders() == null) {
			entity.setOrders(new ArrayList<>());
		}
		for (Order order : entity.getOrders()) {
			order.setVisitId(visit.get_ID());
			order.setDocumentTypeTargetId(onCreditOrderDocumentType.get().get_ID());

			// set patient
			if (entity.getPatient() != null && entity.getPatient().getUuid() != null) {
				MBPartner_BH patient = patientDBService.getEntityByUuidFromDB(entity.getPatient().getUuid());
				if (patient != null) {
					order.setBusinessPartner(new BusinessPartner(patient));
				}
			}

			order.setIsSalesOrderTransaction(true);
			order.setDateOrdered(entity.getVisitDate());
			order.setDateAccount(entity.getVisitDate());

			orderDBService.saveEntity(order);
		}

		// list of persisted payment line ids
		StringBuilder lineIds = new StringBuilder();
		List<Payment> payments = entity.getPayments();
		if (payments != null && !payments.isEmpty()) {
			int count = 0;
			// We only update incomplete payments
			Set<String> completePaymentUuids =
					paymentDBService.getByUuids(payments.stream().map(Payment::getUuid).collect(Collectors.toSet())).values()
							.stream().filter(MPayment_BH::isComplete).map(MPayment_BH::getC_Payment_UU).collect(Collectors.toSet());
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
					payment.setPatient(new Patient());
					payment.getPatient().setUuid(entity.getPatient().getUuid());
				}

				Payment response = paymentDBService.saveEntity(payment);
				lineIds.append("'").append(response.getUuid()).append("'");
				if (++count < payments.size()) {
					lineIds.append(",");
				}
			}
		}

		// delete payment lines not in request
		paymentDBService.deletePaymentLinesByVisit(visit.get_ID(), lineIds.toString());

		Visit model = createInstanceWithAllFields(visit);
		model.setOrders(orderDBService.transformData(
				orderDBService.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID,
						Collections.singleton(visit.get_ID())).get(visit.get_ID())));
		model.setPayments(paymentDBService.getPaymentsByVisitId(model.getId()));
		return model;
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

			// If this visit has any completed orders, shipments, invoices, or payments, we can't delete it
			List<MOrder_BH> visitsOrders =
					new Query(Env.getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_BH_Visit_ID + "=?",
							deleteVisitTransaction.getTrxName()).setParameters(visit.get_ID()).list();
			List<MInOut_BH> visitsInOuts =
					new Query(Env.getCtx(), MInOut_BH.Table_Name, MInOut_BH.COLUMNNAME_BH_Visit_ID + "=?",
							deleteVisitTransaction.getTrxName()).setParameters(visit.get_ID()).list();
			List<MInvoice_BH> visitsInvoices =
					new Query(Env.getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_BH_Visit_ID + "=?",
							deleteVisitTransaction.getTrxName()).setParameters(visit.get_ID()).list();
			List<MPayment_BH> visitsPayments =
					new Query(Env.getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?",
							deleteVisitTransaction.getTrxName()).setParameters(visit.get_ID()).list();

			Predicate<DocAction> isNotDrafted =
					(DocAction entity) -> !DocumentEngine.STATUS_Drafted.equals(entity.getDocStatus());
			if (visitsOrders.stream().anyMatch(isNotDrafted) || visitsInOuts.stream().anyMatch(isNotDrafted) ||
					visitsInvoices.stream().anyMatch(isNotDrafted) || visitsPayments.stream().anyMatch(isNotDrafted)) {
				throw new AdempiereException("Visit is already completed");
			}

			Predicate<PO> deleteEntity = (PO entity) -> entity.delete(true);
			if (!(visitsPayments.stream().allMatch(deleteEntity) && visitsInvoices.stream().allMatch(deleteEntity) &&
					visitsInOuts.stream().allMatch(deleteEntity) && visitsOrders.stream().allMatch(deleteEntity))) {
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
		try {
			MBPartner_BH patient = patientDBService.getPatientById(instance.getPatient_ID());
			if (patient == null) {
				log.severe("Missing patient");
				return null;
			}

			String patientType = instance.getBH_PatientType();

			Visit visit = new Visit();
			visit.setId(instance.get_ID());
			visit.setClientId(instance.getAD_Client_ID());
			visit.setOrgId(instance.getAD_Org_ID());
			visit.setUuid(instance.getBH_Visit_UU());
			visit.setIsActive(instance.isActive());
			visit.setCreated(DateUtil.parse(instance.getCreated()));
			visit.setCreatedTimestamp(instance.getCreated());
			visit.setCreatedBy(instance.getCreatedBy());
			visit.setPatient(new Patient(patient.getName(), patient.getC_BPartner_UU()));
			visit.setPatientType(new PatientType(
					entityMetadataDBService.getReferenceNameByValue(EntityMetadataDBService.PATIENT_TYPE, patientType)));
			visit.setVisitDate(instance.getBH_VisitDate());
			return visit;
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Visit createInstanceWithAllFields(MBHVisit instance) {
		Visit visit = new Visit(instance);
//		visit.setStatus(getOrderStatus(instance));

		// get patient
		MBPartner_BH businessPartner = patientDBService.getPatientById(instance.getPatient_ID());
		if (businessPartner == null) {
			throw new AdempiereException("Missing patient");
		}
		visit.setPatient(patientDBService.transformData(Collections.singletonList(businessPartner)).get(0));
		visit.setPayments(paymentDBService.getPaymentsByVisitId(instance.get_ID()));
		visit.setOrders(orderDBService.transformData(
				orderDBService.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID,
						Collections.singleton(visit.getId())).get(visit.getId())));
		Map<Integer, List<OrderLine>> orderLinesByOrderId = orderLineDBService.getOrderLinesByOrderIds(
				visit.getOrders().stream().map(Order::getId).collect(Collectors.toSet()));
		visit.getOrders()
				.forEach(order -> order.setOrderLines(orderLinesByOrderId.getOrDefault(order.getId(), new ArrayList<>())));

		// THIS NEEDS TO BE REVISED! The `createInstanceWithAllFields` call does not
		// happen in a loop, hence it makes no sense pre-fetching a list of all users
		// only to filter out one user. This logic will only make sense if the
		// `createInstanceWithAllFields` is called in a loop, and even so, we only need
		// to make sure the prefetchedList is retrieved once...
		if (instance.getBH_Clinician_User_ID() > 0) {
			userDBService.getClinicians(null).stream()
					.filter(user -> user.getAD_User_ID() == instance.getBH_Clinician_User_ID()).findFirst()
					.ifPresent(clinician -> visit.setClinician(new User(clinician)));
		}

		Set<Integer> codedDiagnosisIds = new HashSet<>();

		if (instance.getBH_PrimaryCodedDiagnosis_ID() > 0) {
			codedDiagnosisIds.add(instance.getBH_PrimaryCodedDiagnosis_ID());
		}

		if (instance.getbh_secondarycodeddiagnosis_ID() > 0) {
			codedDiagnosisIds.add(instance.getbh_secondarycodeddiagnosis_ID());
		}

		if (!codedDiagnosisIds.isEmpty()) {
			Map<Integer, MBHCodedDiagnosis> codedDiagnosesById = codedDiagnosisDBService.getByIds(codedDiagnosisIds);

			if (codedDiagnosesById.containsKey(instance.getBH_PrimaryCodedDiagnosis_ID())) {
				visit.setPrimaryCodedDiagnosis(
						new CodedDiagnosis(codedDiagnosesById.get(instance.getBH_PrimaryCodedDiagnosis_ID())));
			}
			if (codedDiagnosesById.containsKey(instance.getbh_secondarycodeddiagnosis_ID())) {
				visit.setSecondaryCodedDiagnosis(
						new CodedDiagnosis(codedDiagnosesById.get(instance.getbh_secondarycodeddiagnosis_ID())));
			}
		}

		return visit;
	}

	@Override
	protected Visit createInstanceWithSearchFields(MBHVisit instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MBHVisit getModelInstance() {
		return new MBHVisit(Env.getCtx(), 0, null);
	}

	public BaseListResponse<Visit> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		BaseListResponse<Visit> visits = super.getAll(pagingInfo, sortJson, filterJson);

		// Since non-patient payments are negative, they'll change order totals
		// Get updated order totals for these visits
		if (visits != null) {
			Map<Integer, List<MOrderLine_BH>> orderLinesByOrder =
					orderLineDBService.getGroupsByIds(MOrderLine_BH::getC_Order_ID, MOrderLine_BH.COLUMNNAME_C_Order_ID,
							visits.getResults().stream().flatMap(visit -> visit.getOrders().stream()).map(Order::getId)
									.collect(Collectors.toSet()));

			// Update the totals to exclude negative values in the lines
			visits.getResults().forEach(visit -> {
				visit.getOrders().forEach(
						order -> order.setGrandTotal(orderLinesByOrder.get(order.getId()).stream().map(MOrderLine_BH::getLineNetAmt)
								.filter(lineNetAmt -> lineNetAmt.compareTo(new BigDecimal(0)) >= 0)
								.reduce(new BigDecimal(0), BigDecimal::add)));
			});
		}

		return visits;
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
						MBPartner_BH patient = patientDBService.getPatientById(entity.getC_BPartner_ID());
						if (patient == null) {
							continue;
						}
						Visit visit = new Visit();
						visit.setCreated(DateUtil.parseQueueTime(entity.getCreated()));
						visit.setCreatedTimestamp(entity.getCreated());
						visit.setUuid(entity.getC_Order_UU());
						visit.setPatient(new Patient(patient.getName(), patient.getC_BPartner_UU()));
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
		StringBuilder sqlWhere = new StringBuilder("WHERE ")
				.append(buildOpenDraftsWhereClauseAndParameters(parameters));

		return SqlUtil.getCount(MOrder_BH.Table_Name, sqlWhere.toString(), parameters);
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
		StringBuilder sqlWhere = new StringBuilder().append(MOrder_BH.COLUMNNAME_AD_Client_ID).append(" =?")
				.append(AND_OPERATOR).append(MOrder_BH.COLUMNNAME_AD_Org_ID).append(" =?").append(AND_OPERATOR)
				.append(MOrder_BH.COLUMNNAME_IsActive).append(" =?").append(AND_OPERATOR)
				.append(MOrder_BH.COLUMNNAME_DocStatus).append(" =? ").append(AND_OPERATOR).append("to_char(")
				.append(MOrder_BH.COLUMNNAME_Created).append(", 'YYYY-MM-DD')").append(" < ? ").append(AND_OPERATOR)
				.append(MOrder_BH.COLUMNNAME_IsSOTrx).append(" = ?");

		if (parameters == null) {
			parameters = new ArrayList<>();
		}

		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));
		parameters.add("Y");
		parameters.add(MOrder_BH.DOCSTATUS_Drafted);
		parameters.add(DateUtil.parseDateOnly(new Timestamp(System.currentTimeMillis())));
		parameters.add("Y");

		return sqlWhere.toString();
	}

	@Override
	public List<Visit> transformData(List<MBHVisit> dbModels) {
		Set<Integer> visitIds = dbModels.stream().map(MBHVisit::get_ID).collect(Collectors.toSet());
		Map<Integer, List<Order>> orderIdsByVisitId = orderDBService.transformData(
						orderDBService.getGroupsByIds(MOrder_BH::getBH_Visit_ID, MOrder_BH.COLUMNNAME_BH_Visit_ID, visitIds).values()
								.stream().flatMap(Collection::stream).collect(Collectors.toList())).stream()
				.collect(Collectors.groupingBy(Order::getVisitId));
		return dbModels.stream().map(visit -> {
			Visit entity = createInstanceWithDefaultFields(visit);
			entity.setOrders(orderIdsByVisitId.getOrDefault(visit.get_ID(), new ArrayList<>()));
			return entity;
		}).collect(Collectors.toList());
	}
}
