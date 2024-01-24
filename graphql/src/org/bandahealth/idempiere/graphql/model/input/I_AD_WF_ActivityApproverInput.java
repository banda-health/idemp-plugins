package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_ActivityApprover;

/**
 * Generated Interface for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_WF_ActivityApproverInput extends I_AD_WF_ActivityApprover {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
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
	 * Set AD_WF_Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	void setAD_WF_ActivityInput(ForeignEntityInput AD_WF_Activity);

	/**
	 * Get AD_WF_Activity.
	 *
	 * @return Workflow Activity
	 */
	ForeignEntityInput AD_WF_Activity();

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
}
