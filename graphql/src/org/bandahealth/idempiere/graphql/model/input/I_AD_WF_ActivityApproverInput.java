package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_ActivityApprover;

/**
 * Generated Interface for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WF_ActivityApproverInput extends I_AD_WF_ActivityApprover {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

	/**
	 * Set AD_WF_Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	void setAD_WF_Activity(I_AD_WF_ActivityInput AD_WF_Activity);

	/**
	 * Get AD_WF_Activity.
	 *
	 * @return Workflow Activity
	 */
	I_AD_WF_ActivityInput getAD_WF_Activity();

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
}
