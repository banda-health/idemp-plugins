package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Visit;

public interface I_BH_VisitInput extends I_BH_Visit {
	String getID();

	void setID(String ID);

	I_AD_OrgInput getAD_Org();

	void setAD_Org(I_AD_OrgInput AD_Org);

	I_AD_Ref_ListInput getBH_PatientType_RL();

	void setBH_PatientType_RL(I_AD_Ref_ListInput BH_PatientType_RL);

	I_AD_Ref_ListInput getBH_Process_Stage_RL();

	void setBH_Process_Stage_RL(I_AD_Ref_ListInput BH_Process_Stage_RL);

	I_AD_Ref_ListInput getBh_referral_RL();

	void setBh_referral_RL(I_AD_Ref_ListInput bh_referral_RL);

	I_BH_Voided_ReasonInput getBH_Voided_Reason();

	void setBH_Voided_Reason(I_BH_Voided_ReasonInput BH_VoidedReason);

	@Override
	I_C_BPartnerInput getPatient();

	void setPatient(I_C_BPartnerInput patient);
}
