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
	 * Set BH_Clinician_User.
	 *
	 * @param BH_Clinician_User BH_Clinician_User_ID
	 */
	void setBH_Clinician_UserInput(ForeignEntityInput BH_Clinician_User);

	/**
	 * Get BH_Clinician_User.
	 *
	 * @return BH_Clinician_User_ID
	 */
	ForeignEntityInput BH_Clinician_User();

	/**
	 * Set BH_PatientType.
	 *
	 * @param BH_PatientType BH_PatientType
	 */
	void setBH_PatientTypeInput(ForeignEntityInput BH_PatientType);

	/**
	 * Get BH_PatientType.
	 *
	 * @return BH_PatientType
	 */
	ForeignEntityInput BH_PatientType();

	/**
	 * Set BH_Process_Stage.
	 *
	 * @param BH_Process_Stage Drop down field in visits for users to define the process stage
	 */
	void setBH_Process_StageInput(ForeignEntityInput BH_Process_Stage);

	/**
	 * Get BH_Process_Stage.
	 *
	 * @return Drop down field in visits for users to define the process stage
	 */
	ForeignEntityInput BH_Process_Stage();

	/**
	 * Set bh_referral.
	 *
	 * @param bh_referral bh_referral
	 */
	void setbh_referralInput(ForeignEntityInput bh_referral);

	/**
	 * Get bh_referral.
	 *
	 * @return bh_referral
	 */
	ForeignEntityInput bh_referral();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

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
