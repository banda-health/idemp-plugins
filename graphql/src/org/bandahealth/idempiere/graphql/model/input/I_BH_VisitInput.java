package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Visit;

/**
 * Generated Interface for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_BH_VisitInput extends I_BH_Visit {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set BH_PatientType.
	 *
	 * @param BH_PatientType BH_PatientType
	 */
	void setBH_PatientTypeInput(I_AD_Ref_ListInput BH_PatientType);

	/**
	 * Get BH_PatientType.
	 *
	 * @return BH_PatientType
	 */
	I_AD_Ref_ListInput BH_PatientType();

	/**
	 * Set BH_Process_Stage.
	 *
	 * @param BH_Process_Stage Drop down field in visits for users to define the process stage
	 */
	void setBH_Process_StageInput(I_AD_Ref_ListInput BH_Process_Stage);

	/**
	 * Get BH_Process_Stage.
	 *
	 * @return Drop down field in visits for users to define the process stage
	 */
	I_AD_Ref_ListInput BH_Process_Stage();

	/**
	 * Set bh_referral.
	 *
	 * @param bh_referral bh_referral
	 */
	void setbh_referralInput(I_AD_Ref_ListInput bh_referral);

	/**
	 * Get bh_referral.
	 *
	 * @return bh_referral
	 */
	I_AD_Ref_ListInput bh_referral();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set BH_Voided_Reason.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason
	 */
	void setBH_Voided_ReasonInput(ForeignEntityInput BH_Voided_Reason);

	/**
	 * Get BH_Voided_Reason.
	 *
	 * @return BH_Voided_Reason
	 */
	ForeignEntityInput BH_Voided_Reason();

	/**
	 * Set Patient.
	 *
	 * @param Patient The Patient must be a valid business partner.
	 */
	void setPatientInput(ForeignEntityInput Patient);

	/**
	 * Get Patient.
	 *
	 * @return The Patient must be a valid business partner.
	 */
	ForeignEntityInput Patient();
}
