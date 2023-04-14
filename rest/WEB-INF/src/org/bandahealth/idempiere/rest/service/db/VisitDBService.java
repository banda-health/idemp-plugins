package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.CodedDiagnosis;
import org.bandahealth.idempiere.rest.model.OrderStatus;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Patient;
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
import org.compiere.model.MClient;
import org.compiere.model.MDocType;
import org.compiere.model.MOrder;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Visit/billing functionality
 *
 * @author andrew
 */
@Component
public class VisitDBService extends BaseOrderDBService<Visit> {

	private final String COLUMNNAME_PATIENT_TYPE = "bh_patienttype";
	private final String COLUMNNAME_REFERRAL = "bh_referral";
	@Autowired
	private CodedDiagnosisDBService codedDiagnosisDBService;
	@Autowired
	private PatientDBService patientDBService;
	@Autowired
	private PaymentDBService paymentDBService;
	@Autowired
	private UserDBService userDBService;

	private Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(MBPartner_BH.Table_Name,
					"LEFT JOIN " + MBPartner_BH.Table_Name + " ON " + MOrder_BH.Table_Name + "."
							+ MOrder_BH.COLUMNNAME_C_BPartner_ID + " = " + MBPartner_BH.Table_Name + "."
							+ MBPartner_BH.COLUMNNAME_C_BPartner_ID);
			put(MUser.Table_Name,
					"LEFT JOIN " + MUser.Table_Name + " ON " + MOrder_BH.Table_Name + "."
							+ MOrder_BH.COLUMMNAME_BH_CLINICIAN_USER_ID + " = " + MUser.Table_Name + "."
							+ MUser.COLUMNNAME_AD_User_ID);
		}
	};

	public static int getVisitsCount(Integer patientId) {
		return getVisitCountsByPatients(Collections.singleton(patientId)).getOrDefault(patientId, 0);
	}

	public static Map<Integer, Integer> getVisitCountsByPatients(Set<Integer> patientIds) {
		StringBuilder sqlWhere = new StringBuilder("WHERE ").append(MOrder_BH.COLUMNNAME_IsSOTrx).append(" = ? AND ")
				.append(MOrder_BH.COLUMNNAME_IsActive).append(" = ? AND ").append(MOrder_BH.COLUMNNAME_DocStatus)
				.append("!=? AND ").append(MOrder_BH.COLUMNNAME_C_BPartner_ID).append(" IN (");

		List<Object> parameters = new ArrayList<>();

		parameters.add("Y");
		parameters.add("Y");
		parameters.add(MOrder_BH.DOCSTATUS_Voided);

		String patientIdInWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters);
		sqlWhere.append(patientIdInWhereClause).append(")");

		return SqlUtil.getGroupCount(MOrder_BH.Table_Name, sqlWhere.toString(), MOrder_BH.COLUMNNAME_C_BPartner_ID,
				parameters, (resultSet -> {
					try {
						return resultSet.getInt(1);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return 0;
				}));
	}

	public static String getLastVisitDate(MBPartner_BH patient) {
		return getLastVisitDateByPatients(Collections.singleton(patient.get_ID())).get(patient.get_ID());
	}

	public static Map<Integer, String> getLastVisitDateByPatients(Set<Integer> patientIds) {
		if (patientIds.isEmpty()) {
			return new HashMap<>();
		}
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");
		String whereClause =
				"WHERE " + MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " + MOrder_BH.COLUMNNAME_C_BPartner_ID + " IN (" +
						QueryUtil.getWhereClauseAndSetParametersForSet(patientIds, parameters) + ") AND " +
						MOrder_BH.COLUMNNAME_AD_Client_ID + "=?";
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));

		String sql =
				"SELECT " + MOrder_BH.COLUMNNAME_C_BPartner_ID + ", MAX(" + MOrder_BH.COLUMNNAME_BH_VisitDate + ") FROM " +
						MOrder_BH.Table_Name + " " + whereClause + " GROUP BY " + MOrder_BH.COLUMNNAME_C_BPartner_ID;

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

	@Override
	public Visit processEntity(String uuid, String docAction) throws Exception {
		MClient client =
				new Query(Env.getCtx(), MClient.Table_Name, MClient.COLUMNNAME_AD_Client_ID + " =?", null).setParameters(
						Env.getAD_Client_ID(Env.getCtx())).first();

		String clientUuidsForSynchronousProcessingString =
				MSysConfig_BH.getValue(MSysConfig_BH.CLIENT_IDS_FOR_SYNCHRONOUS_SALES_ORDER_PROCESSING, "");
		List<String> clientIdsForSynchronousProcessing = new ArrayList<>();
		try {
			if (!StringUtil.isNullOrEmpty(clientUuidsForSynchronousProcessingString)) {
				clientIdsForSynchronousProcessing = Arrays.stream(clientUuidsForSynchronousProcessingString.split(","))
						.map(stringClientId -> stringClientId.trim()).collect(Collectors.toList());
			}
		} catch (Exception exception) {
			log.severe(exception.getMessage());
		}
		// We need to do something special for completing a sales order - do it asynchronously (except for the clients we
		// want to do it synchronously for)
		if (StringUtil.isNullOrEmpty(docAction) || !docAction.equalsIgnoreCase(DocAction.ACTION_Complete) ||
				clientIdsForSynchronousProcessing.contains(client.getAD_Client_UU())) {
			Visit visit = super.processEntity(uuid, docAction);
			Collection<MPayment_BH> existingPayments = paymentDBService.getByUuids(
					visit.getPayments().stream().map(Payment::getUuid).collect(Collectors.toSet())).values();
			// If this is a reversal, we also need to take care of the payments
			if (docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Accrual) ||
					docAction.equalsIgnoreCase(DocAction.ACTION_Reverse_Correct) ||
					docAction.equalsIgnoreCase(DocAction.ACTION_ReActivate)) {

				Collection<MPayment_BH> existingCompletedPayments =
						paymentDBService.getByUuids(visit.getPayments().stream().map(Payment::getUuid).collect(Collectors.toSet()))
								.values().stream().filter(
										payment -> !payment.isComplete() || payment.getDocStatus().equals(MPayment_BH.DOCSTATUS_Completed))
								.collect(Collectors.toList());
				for (MPayment_BH payment : existingCompletedPayments) {
					MPayment_BH newPayment = payment.copy();
					payment.setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
					payment.processIt(MPayment_BH.DOCACTION_Reverse_Accrual);
					payment.saveEx();

					newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
					newPayment.setBH_C_Order_ID(visit.getId());
					newPayment.saveEx();
				}

			} else {
				for (MPayment_BH payment : existingPayments) {
					payment.setDocAction(docAction);
					payment.processIt(docAction);
					payment.saveEx();
				}
			}
			visit.setPayments(paymentDBService.getPaymentsByOrderId(visit.getId()));
			return visit;
		}

		if (!isDocActionValidForUser(docAction)) {
			return null;
		}

		MOrder_BH order = getEntityByUuidFromDB(uuid);
		if (order == null) {
			log.severe("No entity with uuid = " + uuid);
			return null;
		}
		processDBService.runOrderProcess(order.get_ID());

		// Since the async process will take some time, assume it completed successfully
		// and return the appropriate status
		Visit visit = createInstanceWithAllFields(getEntityByUuidFromDB(uuid));
		visit.setDocStatus(DocAction.STATUS_Completed);
		return visit;
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	protected void beforeSave(Visit entity, MOrder_BH mOrder) {
		if (mOrder.getC_DocType_ID() == 0) {
			Optional<MDocType> onCreditOrderDocumentType =
					Arrays.stream(MDocType_BH.getOfDocBaseType(mOrder.getCtx(), MDocType_BH.DOCBASETYPE_SalesOrder)).filter(
							documentType -> documentType.getDocSubTypeSO() != null &&
									documentType.getDocSubTypeSO().equalsIgnoreCase(MDocType_BH.DOCSUBTYPESO_OnCreditOrder)).findFirst();
			if (onCreditOrderDocumentType.isEmpty()) {
				throw new AdempiereException("No on-credit document type found");
			}
			mOrder.setC_DocTypeTarget_ID(onCreditOrderDocumentType.get().get_ID());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getClinicalNotes())) {
			mOrder.setBH_ClinicalNotes(entity.getClinicalNotes());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getLabNotes())) {
			mOrder.setBH_LabNotes(entity.getLabNotes());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getDiagnosis())) {
			mOrder.setDescription(entity.getDiagnosis());
		}

		if (entity.getPatientType() != null && entity.getPatientType().getValue() != null) {
			mOrder.set_ValueOfColumn(COLUMNNAME_PATIENT_TYPE, entity.getPatientType().getValue());
		}

		if (entity.getReferral() != null && entity.getReferral().getValue() != null) {
			mOrder.set_ValueOfColumn(COLUMNNAME_REFERRAL, entity.getReferral().getValue());
		}

		// set patient
		if (entity.getPatient() != null && entity.getPatient().getUuid() != null) {
			MBPartner_BH patient = patientDBService.getEntityByUuidFromDB(entity.getPatient().getUuid());
			if (patient != null) {
				// Reset the patient info in the entity so it can be passed for saving (used for
				// payments below)
				entity.setPatient(new Patient(patient.getName(), patient.getC_BPartner_UU()));
				mOrder.setC_BPartner_ID(patient.get_ID());
			}
		}

		if (entity.isNewVisit() != null) {
			mOrder.setBH_NewVisit(entity.isNewVisit());
		}

		if (entity.getChiefComplaint() != null) {
			mOrder.setBH_Chief_Complaint(entity.getChiefComplaint());
		}

		if (entity.getTemperature() != null) {
			mOrder.setBH_Temperature(entity.getTemperature());
		}

		if (entity.getPulse() != null) {
			mOrder.setBH_Pulse(entity.getPulse());
		}

		if (entity.getRespiratoryRate() != null) {
			mOrder.setBH_Respiratory_Rate(entity.getRespiratoryRate());
		}

		if (entity.getSystolicBloodPressure() != null) {
			mOrder.setbh_systolic_blood_pressure(entity.getSystolicBloodPressure());
		}

		if (entity.getDiastolicBloodPressure() != null) {
			mOrder.setbh_diastolic_blood_pressure(entity.getDiastolicBloodPressure());
		}

		if (entity.getHeight() != null) {
			mOrder.setBH_Height(entity.getHeight());
		}

		if (entity.getWeight() != null) {
			mOrder.setBH_Weight(entity.getWeight());
		}

		if (entity.getPrimaryCodedDiagnosis() != null || entity.getSecondaryCodedDiagnosis() != null) {
			List<String> uuids = new ArrayList<>();

			if (entity.getPrimaryCodedDiagnosis() != null) {
				uuids.add(entity.getPrimaryCodedDiagnosis().getUuid());
			}
			if (entity.getSecondaryCodedDiagnosis() != null) {
				uuids.add(entity.getSecondaryCodedDiagnosis().getUuid());
			}
			// prefetch coded diagnosis list
			List<MBHCodedDiagnosis> prefetchedCodedDiagnosisList = codedDiagnosisDBService
					.getCodedDiagnosesByUuids(uuids);

			if (entity.getPrimaryCodedDiagnosis() != null) {
				MBHCodedDiagnosis primaryCodedDiagnosis = searchPrefetchCodedDiagnosisListByUuid(
						entity.getPrimaryCodedDiagnosis().getUuid(), prefetchedCodedDiagnosisList);
				if (primaryCodedDiagnosis != null) {
					mOrder.setBH_PrimaryCodedDiagnosisID(primaryCodedDiagnosis.get_ID());
				}
			}

			if (entity.getSecondaryCodedDiagnosis() != null) {
				MBHCodedDiagnosis secondaryCodedDiagnosis = searchPrefetchCodedDiagnosisListByUuid(
						entity.getSecondaryCodedDiagnosis().getUuid(), prefetchedCodedDiagnosisList);
				if (secondaryCodedDiagnosis != null) {
					mOrder.setBH_SecondaryCodedDiagnosisID(secondaryCodedDiagnosis.get_ID());
				}
			}
		}

		if (entity.getPrimaryUnCodedDiagnosis() != null) {
			mOrder.setBH_PrimaryUnCodedDiagnosis(entity.getPrimaryUnCodedDiagnosis());
		}

		if (entity.getSecondaryUnCodedDiagnosis() != null) {
			mOrder.setBH_SecondaryUnCodedDiagnosis(entity.getSecondaryUnCodedDiagnosis());
		}

		if (entity.getClinician() != null && entity.getClinician().getUuid() != null) {
			// get user id
			MUser user = new Query(Env.getCtx(), MUser.Table_Name, MUser.COLUMNNAME_AD_User_UU + " =?", null)
					.setParameters(entity.getClinician().getUuid()).first();
			if (user != null) {
				mOrder.setBH_ClinicianUserID(user.get_ID());
			}
		}

		if (entity.getProcessStage() != null && entity.getProcessStage().getValue() != null) {
			mOrder.setBH_ProcessStage(entity.getProcessStage().getValue());
		}

		mOrder.setIsSOTrx(true);

		ModelUtil.setPropertyIfPresent(entity.getReferredFromTo(), mOrder::setBH_ReferredFromTo);
		ModelUtil.setPropertyIfPresent(entity.getVisitDate(), mOrder::setDateOrdered);
		ModelUtil.setPropertyIfPresent(entity.getVisitDate(), mOrder::setBH_VisitDate);
		mOrder.setBH_OxygenSaturation(entity.getOxygenSaturation());
	}

	@Override
	protected void afterSave(Visit entity, MOrder_BH mOrder) {
		// list of persisted payment line ids
		String lineIds = "";
		List<Payment> payments = entity.getPayments();
		if (payments != null && !payments.isEmpty() && entity.isIsSalesOrderTransaction()) {
			int count = 0;
			// We only update incomplete payments
			Set<String> completePaymentUuids =
					paymentDBService.getByUuids(payments.stream().map(Payment::getUuid).collect(Collectors.toSet())).values()
							.stream().filter(MPayment_BH::isComplete).map(MPayment_BH::getC_Payment_UU).collect(Collectors.toSet());
			payments = payments.stream().filter(payment -> !completePaymentUuids.contains(payment.getUuid()))
					.collect(Collectors.toList());
			for (Payment payment : payments) {
				payment.setOrderId(mOrder.get_ID());
				// Read the patient assigned to the entity
				// NOTE: DO NOT use the mPatient property because this class is a singleton and
				// there exists the possibility
				// that the property has been overridden by another save request between when it
				// was set for this order and now
				if (entity.getPatient() != null) {
					payment.setPatient(entity.getPatient());
				}

				Payment response = paymentDBService.saveEntity(payment);
				lineIds += "'" + response.getUuid() + "'";
				if (++count < payments.size()) {
					lineIds += ",";
				}
			}
		}

		// delete payment lines not in request
		paymentDBService.deletePaymentLinesByOrder(mOrder.get_ID(), lineIds);
	}

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_BILLS;
	}

	@Override
	public Boolean deleteEntity(String uuid) {
		try {
			MOrder order = new Query(Env.getCtx(), MOrder_BH.Table_Name, MOrder.COLUMNNAME_C_Order_UU + "=?", null)
					.setParameters(uuid).first();
			if (!order.isSOTrx()) {
				throw new AdempiereException("Document id not a Visit");
//				return order.delete(false);
			}
			// We also want to ensure that a visit that has been re-opened (doc status = In Progress) doesn't get deleted
			if (order.isComplete() || MOrder_BH.DOCSTATUS_InProgress.equalsIgnoreCase(order.getDocStatus())) {
				throw new AdempiereException("Visit is already completed");
			} else {
				// Make sure to delete any payments that might've been saved
				paymentDBService.deletePaymentLinesByOrder(order.get_ID(), null);
				// Delete the order
				return order.delete(false);
			}
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Visit createInstanceWithDefaultFields(MOrder_BH instance) {
		try {
			MBPartner_BH patient = patientDBService.getPatientById(instance.getC_BPartner_ID());
			if (patient == null) {
				log.severe("Missing patient");
				return null;
			}

			String patientType = instance.get_Value(COLUMNNAME_PATIENT_TYPE) != null
					? (String) instance.get_Value(COLUMNNAME_PATIENT_TYPE)
					: null;

			return new Visit(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					new Patient(patient.getName(), patient.getC_BPartner_UU()),
					new PatientType(entityMetadataDBService
							.getReferenceNameByValue(EntityMetadataDBService.PATIENT_TYPE, patientType)),
					DateUtil.parseDateOnly(instance.getDateOrdered()), instance.getGrandTotal(),
					instance.getDocStatus(), instance);
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Visit createInstanceWithAllFields(MOrder_BH instance) {
		try {
			// get patient
			// TODO: This needs to be fetched from a preloaded list
			MBPartner_BH patient = patientDBService.getPatientById(instance.getC_BPartner_ID());
			if (patient == null) {
				log.severe("Missing patient");
				return null;
			}

			// retrieve payments
			List<Payment> payments = paymentDBService.getPaymentsByOrderId(instance.get_ID());

			String clinicalNotes = instance.getBH_ClinicalNotes();
			String labNotes = instance.getBH_LabNotes();
			String patientType = instance.get_Value(COLUMNNAME_PATIENT_TYPE) != null
					? (String) instance.get_Value(COLUMNNAME_PATIENT_TYPE)
					: null;
			String referral = instance.get_Value(COLUMNNAME_REFERRAL) != null
					? (String) instance.get_Value(COLUMNNAME_REFERRAL)
					: null;

			// THIS NEEDS TO BE REVISED! The `createInstanceWithAllFields` call does not
			// happen in a loop, hence it makes no sense pre-fetching a list of all users
			// only to filter out one user. This logic will only make sense if the
			// `createInstanceWithAllFields` is called in a loop, and even so, we only need
			// to make sure the prefetchedList is retrieved once..
			MUser_BH user = searchUserInPrefetchedList(instance.getBH_ClinicianUserID());

			List<Integer> codedDiagnosisIds = new ArrayList<>();

			MBHCodedDiagnosis primaryCodedDiagnosis = null;
			MBHCodedDiagnosis secondaryCodedDiagnosis = null;
			if (instance.getBH_PrimaryCodedDiagnosisID() > 0) {
				codedDiagnosisIds.add(instance.getBH_PrimaryCodedDiagnosisID());
			}

			if (instance.getBH_SecondaryCodedDiagnosisID() > 0) {
				codedDiagnosisIds.add(instance.getBH_SecondaryCodedDiagnosisID());
			}

			if (!codedDiagnosisIds.isEmpty()) {
				List<MBHCodedDiagnosis> prefetchCodedDiagnosisList = codedDiagnosisDBService
						.getCodedDiagnosesByIds(codedDiagnosisIds);

				primaryCodedDiagnosis = searchPrefetchCodedDiagnosisListById(instance.getBH_PrimaryCodedDiagnosisID(),
						prefetchCodedDiagnosisList);
				secondaryCodedDiagnosis = searchPrefetchCodedDiagnosisListById(
						instance.getBH_SecondaryCodedDiagnosisID(), prefetchCodedDiagnosisList);

			}

			return new Visit(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					new Patient(patient.getC_BPartner_UU(), patient.getName(), patient.getTotalOpenBalance(),
							patient.getBH_PatientID(), DateUtil.parseDateOnly(patient.getBH_Birthday()),
							patient.getBH_Phone(), patient.getBH_EMail(), DateUtil.parse(patient.getCreated()),
							patient.getbh_gender(), patient.isActive(), patient.getBH_Local_PatientID(),
							getVisitsCount(patient.get_ID()), getLastVisitDate(patient)),
					DateUtil.parseDateOnly(instance.getDateOrdered()), instance.getGrandTotal(),
					instance.isBH_NewVisit(), clinicalNotes, instance.getDescription(), new PatientType(patientType),
					new Referral(referral), orderLineDBService.getOrderLinesByOrderId(instance.get_ID()), payments,
					instance.getDocStatus(), getOrderStatus(instance), instance.getBH_Chief_Complaint(),
					instance.getBH_Temperature(), instance.getBH_Pulse(), instance.getBH_Respiratory_Rate(),
					instance.getBH_Height(), instance.getBH_Weight(),
					secondaryCodedDiagnosis != null
							? new CodedDiagnosis(secondaryCodedDiagnosis.getBH_CodedDiagnosis_UU(),
							secondaryCodedDiagnosis.getBH_CielName())
							: null,
					primaryCodedDiagnosis != null
							? new CodedDiagnosis(primaryCodedDiagnosis.getBH_CodedDiagnosis_UU(),
							primaryCodedDiagnosis.getBH_CielName())
							: null,
					user != null ? new User(user.getAD_User_UU()) : null,
					new ProcessStage(instance.getBH_ProcessStage()), instance);
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Visit createInstanceWithSearchFields(MOrder_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	public BaseListResponse<Visit> search(String value, Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.search(value, pagingInfo, sortColumn, sortOrder, MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters);
	}

	public BaseListResponse<Visit> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		BaseListResponse<Visit> visits = super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters, pagingInfo,
				sortJson, filterJson, null);

		// Since non-patient payments are negative, they'll change order totals
		// Get updated order totals for these visits
		if (visits != null) {
			Map<Integer, List<MOrderLine_BH>> orderLinesByOrder = orderLineDBService.getGroupsByIds(
					MOrderLine_BH::getC_Order_ID, MOrderLine_BH.COLUMNNAME_C_Order_ID,
					visits.getResults().stream().map(Visit::getId).collect(Collectors.toSet()));

			// Update the totals to exclude negative values in the lines
			visits.getResults().forEach(visit -> {
				visit.setGrandTotal(orderLinesByOrder.get(visit.getId()).stream().map(MOrderLine_BH::getLineNetAmt)
						.filter(lineNetAmt -> lineNetAmt.compareTo(new BigDecimal(0)) >= 0)
						.reduce(new BigDecimal(0), BigDecimal::add));
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

			if (parameters != null) {
				query = query.setParameters(parameters);
			}

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

						results.add(new Visit().getVisitQueue(DateUtil.parseQueueTime(entity.getCreated()),
								entity.getC_Order_UU(), new Patient(patient.getName(), patient.getC_BPartner_UU()),
								getOrderStatus(entity)));
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
	 * WAITING - visit with no clinical, no line items, no payments DISPENSING -
	 * visit with clinical information, no line items, no payments PENDING - visit
	 * with clinical information, line items, no payments, PENDING_COMPLETION -
	 * visit yet to be processed, COMPLETED - completed visit
	 *
	 * @param entity
	 */
	private OrderStatus getOrderStatus(MOrder_BH entity) {
		// check payments
		boolean paymentsExist = paymentDBService.checkPaymentExists(entity.get_ID());

		// check orderlines
		boolean orderlinesExist = orderLineDBService.checkOrderLinesExist(entity.get_ID());

		if (!orderlinesExist && !paymentsExist) {
			// check visit information
			if (entity.get_Value(COLUMNNAME_REFERRAL) == null && entity.getDescription() == null
					&& entity.getBH_ClinicalNotes() == null) {
				return OrderStatus.WAITING;
			} else {
				return OrderStatus.DISPENSING;
			}
		} else if (orderlinesExist && !paymentsExist) {
			return OrderStatus.PENDING;
		} else {
			if (MOrder_BH.DOCSTATUS_Completed.equalsIgnoreCase(entity.getDocStatus())) {
				return OrderStatus.COMPLETED;
			} else {
				return OrderStatus.PENDING_COMPLETION;
			}
		}
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
	 * @param sortColumn
	 * @param sortOrder
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

	private MUser_BH searchUserInPrefetchedList(Integer userId) {
		if (userId == null) {
			return null;
		}

		return userDBService.getClinicians(null).stream().filter(user -> user.getAD_User_ID() == userId).findFirst()
				.orElse(null);
	}

	private MBHCodedDiagnosis searchPrefetchCodedDiagnosisListById(int codedDiagnosisId,
			List<MBHCodedDiagnosis> prefetchedList) {
		return prefetchedList.stream()
				.filter(codedDiagnosis -> codedDiagnosis.getBH_CodedDiagnosis_ID() == codedDiagnosisId).findFirst()
				.orElse(null);
	}

	private MBHCodedDiagnosis searchPrefetchCodedDiagnosisListByUuid(String uuid,
			List<MBHCodedDiagnosis> prefetchedList) {
		return prefetchedList.stream().filter(codedDiagnosis -> codedDiagnosis.getBH_CodedDiagnosis_UU().equals(uuid))
				.findFirst().orElse(null);
	}

}
