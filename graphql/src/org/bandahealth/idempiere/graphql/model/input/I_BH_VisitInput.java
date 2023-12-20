package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Visit;

/**
 * Generated Interface for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_VisitInput extends I_BH_Visit {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set BH_PatientType_RL.
	 *
	 * @param BH_PatientType_RL BH_PatientType_RL
	 */
	void setBH_PatientType_RL(I_AD_Ref_ListInput BH_PatientType_RL);

	/**
	 * Get BH_PatientType_RL.
	 *
	 * @return BH_PatientType_RL
	 */
	I_AD_Ref_ListInput getBH_PatientType_RL();

	/**
	 * Set BH_Process_Stage_RL.
	 *
	 * @param BH_Process_Stage_RL Drop down field in visits for users to define the process stage
	 */
	void setBH_Process_Stage_RL(I_AD_Ref_ListInput BH_Process_Stage_RL);

	/**
	 * Get BH_Process_Stage_RL.
	 *
	 * @return Drop down field in visits for users to define the process stage
	 */
	I_AD_Ref_ListInput getBH_Process_Stage_RL();

	/**
	 * Set bh_referral_RL.
	 *
	 * @param bh_referral_RL bh_referral_RL
	 */
	void setbh_referral_RL(I_AD_Ref_ListInput bh_referral_RL);

	/**
	 * Get bh_referral_RL.
	 *
	 * @return bh_referral_RL
	 */
	I_AD_Ref_ListInput getbh_referral_RL();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set BH_Voided_Reason.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason
	 */
	void setBH_Voided_Reason(I_BH_Voided_ReasonInput BH_Voided_Reason);

	/**
	 * Get BH_Voided_Reason.
	 *
	 * @return BH_Voided_Reason
	 */
	I_BH_Voided_ReasonInput getBH_Voided_Reason();

	/**
	 * Set Patient.
	 *
	 * @param Patient The Patient must be a valid business partner.
	 */
	void setPatient(I_C_BPartnerInput Patient);

	/**
	 * Get Patient.
	 *
	 * @return The Patient must be a valid business partner.
	 */
	I_C_BPartnerInput getPatient();
}
