package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.rest.model.*;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Retrieve All Metadata data i.e entity types (e.g nhif,patient,payment types)
 * 
 * @author andrew
 *
 */
public class EntityMetadataDBService {

	public final static String PATIENT_TYPE = "BH_PatientType";
	public final static String ORDER_PAYMENT_TYPE = "C_Payment Tender Type";
	public final static String INVOICE_PAYMENT_TYPE = "_Payment Rule";
	public final static String NHIF_TYPE = "BH_NHIFTypeRef";
	public final static String NHIF_RELATIONSHIP = "BH_NHIF_Relationship_Choices";
	public final static String REFERRAL_DROPDOWN = "BH_Referral_Dropdown";
	public final static String PAYMENT_TYPE_LIMIT = "C_Payment Tender Type Limit";
	public final static String DOCUMENT_STATUS = "_Document Status";
	public final static String PRODUCT_CATEGORY_TYPE = "BH Product Category Type";

	public EntityMetadata getAll() {
		EntityMetadata metadata = new EntityMetadata();

		// retrieve patient types
		for (MRefList instance : getTypes(PATIENT_TYPE)) {
			metadata.addPatientType(new PatientType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve payment types
		for (MRefList instance : getTypes(ORDER_PAYMENT_TYPE)) {
			metadata.addOrderPaymentType(new PaymentType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve invoice payment types
		List<MRefList> invoicePaymentTypes = getTypes(INVOICE_PAYMENT_TYPE);
		for (MRefList instance : invoicePaymentTypes) {
			metadata.addInvoicePaymentType(new PaymentType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve nhif types
		for (MRefList instance : getTypes(NHIF_TYPE)) {
			metadata.addNHIFType(new NHIFType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve nhif relationships
		for (MRefList instance : getTypes(NHIF_RELATIONSHIP)) {
			metadata.addNHIFRelationship(new NHIFRelationship(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve referrals
		for (MRefList instance : getTypes(REFERRAL_DROPDOWN)) {
			metadata.addReferral(new Referral(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve product category types
		for (MRefList instance : getTypes(PRODUCT_CATEGORY_TYPE)) {
			metadata.addProductCategoryType(new BaseEntity(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getDescription(), instance.getValue()));
		}

		return metadata;
	}

	/**
	 * Get Reference List from MRefList.Table_Name
	 * 
	 * @param referenceName
	 * @param referenceValue
	 * @return
	 */
	private List<MRefList> getTypes(String referenceName, String referenceValue) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(referenceName);

		String whereClause = MReference.Table_Name + "." + MReference.COLUMNNAME_Name + "=? ";

		if (referenceValue != null) {
			whereClause += " AND " + MRefList.COLUMNNAME_Value + "=?";
			parameters.add(referenceValue);
		}

		if (referenceName.equalsIgnoreCase(ORDER_PAYMENT_TYPE)) {
			// get payment type limits..
			MValRule valRule = new Query(Env.getCtx(), MValRule.Table_Name, MValRule.COLUMNNAME_Name + "=?", null)
					.setParameters(PAYMENT_TYPE_LIMIT).setOnlyActiveRecords(true).first();
			if (valRule != null) {
				whereClause += " AND " + valRule.getCode();
			}
		}

		return new Query(Env.getCtx(), MRefList.Table_Name, whereClause, null)
				.addJoinClause("JOIN " + MReference.Table_Name + " ON " + MReference.Table_Name + "."
						+ MReference.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "."
						+ MRefList.COLUMNNAME_AD_Reference_ID)
				.setParameters(parameters).setOnlyActiveRecords(true).list();
	}

	private List<MRefList> getTypes(String referenceName) {
		return getTypes(referenceName, null);
	}

	public String getReferenceNameByValue(String referenceName, String referenceValue) {
		List<MRefList> refList = getTypes(referenceName, referenceValue);

		if (refList != null && refList.size() > 0) {
			return refList.get(0).getName();
		}

		return null;
	}
}
