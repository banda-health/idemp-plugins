package org.bandahealth.idempiere.rest.service.db;

import java.util.List;

import org.bandahealth.idempiere.rest.model.EntityMetadata;
import org.bandahealth.idempiere.rest.model.NHIFRelationship;
import org.bandahealth.idempiere.rest.model.NHIFType;
import org.bandahealth.idempiere.rest.model.PatientType;
import org.bandahealth.idempiere.rest.model.PaymentType;
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

	private final String PATIENT_TYPE = "BH_PatientType";
	private final String PAYMENT_TYPE = "C_Payment Tender Type";
	private final String NHIF_TYPE = "BH_NHIFTypeRef";
	private final String NHIF_RELATIONSHIP = "BH_NHIF_Relationship_Choices";
	private final String PAYMENT_TYPE_LIMIT = "C_Payment Tender Type Limit";

	public EntityMetadata getAll() {
		EntityMetadata metadata = new EntityMetadata();

		// retrieve patient types
		for (MRefList instance : getTypes(PATIENT_TYPE)) {
			metadata.addPatientType(new PatientType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve payment types
		for (MRefList instance : getTypes(PAYMENT_TYPE)) {
			metadata.addPaymentType(new PaymentType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
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

		return metadata;
	}

	private List<MRefList> getTypes(String value) {
		String whereClause = MReference.Table_Name + "." + MReference.COLUMNNAME_Name + "=? ";
		if (value.equalsIgnoreCase(PAYMENT_TYPE)) {
			// get payment type limits..
			MValRule valRule = new Query(Env.getCtx(), MValRule.Table_Name, MValRule.COLUMNNAME_Name + "=?", null)
					.setParameters(PAYMENT_TYPE_LIMIT).setOnlyActiveRecords(true).first();
			if (valRule != null) {
				whereClause += "AND " + valRule.getCode();
			}
		}

		return new Query(Env.getCtx(), MRefList.Table_Name, whereClause, null).addJoinClause("JOIN "
				+ MReference.Table_Name + " ON " + MReference.Table_Name + "." + MReference.COLUMNNAME_AD_Reference_ID
				+ "=" + MRefList.Table_Name + "." + MRefList.COLUMNNAME_AD_Reference_ID).setParameters(value)
				.setOnlyActiveRecords(true).list();
	}
}
