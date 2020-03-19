package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.utils.DateUtil;

/**
 * Visit/billing functionality
 * 
 * @author andrew
 *
 */
public class VisitDBService extends BaseOrderDBService<Visit> {

	private final String COLUMNNAME_VISIT_NOTES = "bh_lab_notes"; // this column needs to be renamed accordingly in the
																	// db
	private final String COLUMNNAME_PATIENT_TYPE = "bh_patienttype";
	private final String COLUMNNAME_REFERRAL = "bh_referral";
	private PatientDBService patientDBService;

	public VisitDBService() {
		patientDBService = new PatientDBService();
	}

	@Override
	protected Visit createInstanceWithDefaultFields(MOrder_BH instance) {
		try {
			MBPartner_BH patient = patientDBService.getPatientById(instance.getC_BPartner_ID());
			if (patient == null) {
				return null;
			}

			return new Visit(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					instance.getC_BPartner_ID(), patient.getName(), patient.getTotalOpenBalance(),
					DateUtil.parse(instance.getDateOrdered()), instance.getGrandTotal());
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
				return null;
			}

			orderLineDBService = new OrderLineDBService(instance.get_ID());
			paymentDBService = new PaymentDBService(instance.get_ID(), instance.getC_BPartner_ID());

			// retrieve order lines
			List<OrderLine> orderLines = orderLineDBService.getOrderLinesByOrderId(instance.get_ID());

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

			Visit visit = new Visit(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Order_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					instance.getC_BPartner_ID(), patient.getName(), patient.getTotalOpenBalance(),
					DateUtil.parse(instance.getDateOrdered()), instance.getGrandTotal(), instance.isBH_NewVisit(),
					visitNotes, instance.getDescription(), patientType, referral, orderLines, payments);
			return visit;
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public BaseListResponse<Visit> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters, pagingInfo, sortColumn, sortOrder);
	}
}
