package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_JobAssignment;

/**
 * Generated Interface for C_JobAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_JobAssignmentInput extends I_C_JobAssignment {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

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
	 * Set C_Job.
	 *
	 * @param C_Job Job Position
	 */
	void setC_JobInput(ForeignEntityInput C_Job);

	/**
	 * Get C_Job.
	 *
	 * @return Job Position
	 */
	ForeignEntityInput C_Job();
}
