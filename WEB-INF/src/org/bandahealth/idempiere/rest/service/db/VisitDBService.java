package org.bandahealth.idempiere.rest.service.db;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.OrderStatus;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.model.PatientType;
import org.bandahealth.idempiere.rest.model.PatientVital;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.model.Referral;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MOrder;
import org.compiere.model.MScheduler;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Visit/billing functionality
 *
 * @author andrew
 */
public class VisitDBService extends BaseOrderDBService<Visit> {

	private final String COLUMNNAME_VISIT_NOTES = "bh_lab_notes"; // this column needs to be renamed accordingly in the
	// db
	private final String COLUMNNAME_PATIENT_TYPE = "bh_patienttype";
	private final String COLUMNNAME_REFERRAL = "bh_referral";
	private PatientDBService patientDBService;
	private ReportDBService reportDBService;
	private PaymentDBService paymentDBService;
	private MBPartner_BH mPatient;

	public VisitDBService() {
		patientDBService = new PatientDBService();
		paymentDBService = new PaymentDBService();
	}

	@Override
	protected void beforeSave(Visit entity, MOrder_BH mOrder) {
		if (StringUtil.isNotNullAndEmpty(entity.getVisitNotes())) {
			mOrder.set_ValueOfColumn(COLUMNNAME_VISIT_NOTES, entity.getVisitNotes());
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
			mPatient = patientDBService.getEntityByUuidFromDB(entity.getPatient().getUuid());
			if (mPatient != null) {
				mOrder.setC_BPartner_ID(mPatient.get_ID());
			}
		}

		if (entity.isNewVisit() != null) {
			mOrder.setBH_NewVisit(entity.isNewVisit());
		}
		
		if (entity.getPatientVital() != null) {
			mOrder.setBH_Chief_Complaint(entity.getPatientVital().getChiefComplaint());
			mOrder.setBH_Temperature(entity.getPatientVital().getTemperature());
			mOrder.setBH_Pulse(entity.getPatientVital().getPulse());
			mOrder.setBH_Respiratory_Rate(entity.getPatientVital().getRespiratoryRate());
			mOrder.setBH_Blood_Pressure(entity.getPatientVital().getBloodPressure());
			mOrder.setBH_Height(entity.getPatientVital().getHeight());
			mOrder.setBH_Weight(entity.getPatientVital().getWeight());
		}

		mOrder.setIsSOTrx(true);
	}

	@Override
	protected void afterSave(Visit entity, MOrder_BH mOrder) {
		// list of persisted payment line ids
		String lineIds = "";
		List<Payment> payments = entity.getPayments();
		if (payments != null && entity.isIsSalesOrderTransaction()) {
			int count = 0;
			for (Payment payment : entity.getPayments()) {
				payment.setOrderId(mOrder.get_ID());
				if (mPatient != null) {
					payment.setPatient(new Patient(mPatient.getName(), mPatient.getC_BPartner_UU()));
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
	public Boolean deleteEntity(String uuid) {
		try {
			MOrder order = new Query(Env.getCtx(), MOrder_BH.Table_Name, MOrder.COLUMNNAME_C_Order_UU + "=?", null)
					.setParameters(uuid).first();
			if (!order.isSOTrx()) {
				throw new AdempiereException("Document id not a Visit");
//				return order.delete(false);
			}
			if (order.isComplete()) {
				throw new AdempiereException("Visit is already completed");
			} else {
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
					DateUtil.parseDateOnly(instance.getDateOrdered()), instance.getGrandTotal(), entityMetadataDBService
							.getReferenceNameByValue(EntityMetadataDBService.DOCUMENT_STATUS, instance.getDocStatus()));
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Visit createInstanceWithAllFields(MOrder_BH instance) {
		try {
			// get patient
			MBPartner_BH patient = patientDBService.getPatientById(instance.getC_BPartner_ID());
			if (patient == null) {
				log.severe("Missing patient");
				return null;
			}

			// retrieve payments
			List<Payment> payments = paymentDBService.getPaymentsByOrderId(instance.get_ID());

			String visitNotes = instance.get_Value(COLUMNNAME_VISIT_NOTES) != null
					? (String) instance.get_Value(COLUMNNAME_VISIT_NOTES)
					: null;
			String patientType = instance.get_Value(COLUMNNAME_PATIENT_TYPE) != null
					? (String) instance.get_Value(COLUMNNAME_PATIENT_TYPE)
					: null;
			String referral = instance.get_Value(COLUMNNAME_REFERRAL) != null
					? (String) instance.get_Value(COLUMNNAME_REFERRAL)
					: null;

			return new Visit(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					new Patient(patient.getC_BPartner_UU(), patient.getName(), patient.getTotalOpenBalance()),
					DateUtil.parseDateOnly(instance.getDateOrdered()), instance.getGrandTotal(),
					instance.isBH_NewVisit(), visitNotes, instance.getDescription(), new PatientType(patientType),
					new Referral(referral), orderLineDBService.getOrderLinesByOrderId(instance.get_ID()), payments,
					instance.getDocStatus(), getOrderStatus(instance),
					new PatientVital(instance.getBH_Chief_Complaint(), instance.getBH_Temperature(),
							instance.getBH_Pulse(), instance.getBH_Respiratory_Rate(), instance.getBH_Blood_Pressure(),
							instance.getBH_Height(), instance.getBH_Weight()));
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

	public BaseListResponse<Visit> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters, pagingInfo, sortColumn, sortOrder);
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
					&& entity.get_Value(COLUMNNAME_VISIT_NOTES) == null) {
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
	 * Generates Thermal receipt
	 *
	 * @param uuid
	 * @return
	 */
	public File generateThermalReceipt(String uuid) {
		MOrder_BH visit = getEntityByUuidFromDB(uuid);
		if (visit != null) {
			reportDBService = new ReportDBService(MScheduler.REPORTOUTPUTTYPE_PDF);
			return reportDBService.generateThermalReceipt(new BigDecimal(visit.get_ID()));
		}

		return null;
	}

	public static int getVisitsCount(MBPartner_BH patient) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");
		parameters.add(patient.get_ID());
		int count = new Query(Env.getCtx(), MOrder_BH.Table_Name,
				MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " + MOrder_BH.COLUMNNAME_C_BPartner_ID + " = ?", null)
						.setParameters(parameters).setClient_ID().setOnlyActiveRecords(true).count();
		return count;
	}

	public static String getLastVisitDate(MBPartner_BH patient) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");
		parameters.add(patient.get_ID());

		List<MOrder_BH> results = new Query(Env.getCtx(), MOrder_BH.Table_Name,
				MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " + MOrder_BH.COLUMNNAME_C_BPartner_ID + " = ?", null)
						.setParameters(parameters).setClient_ID().setOnlyActiveRecords(true).list();
		if (results.isEmpty()) {
			return null;
		}
		List<Date> dates = new ArrayList<>();
		for (MOrder_BH mOrder_BH : results) {
			dates.add(mOrder_BH.getDateOrdered());
		}
		Timestamp ts = new Timestamp(Collections.max(dates).getTime());
		return DateUtil.parseDateOnly(ts);
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
	public BaseListResponse<Visit> getOpenVisitDrafts(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		String sqlWhere = buildOpenDraftsWhereClauseAndParameters(parameters);

		return super.getAll(sqlWhere, parameters, pagingInfo, sortColumn, sortOrder);
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
}
