package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_ActivityResult;

/**
 * Generated Interface for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WF_ActivityResultInput extends I_AD_WF_ActivityResult {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_WF_Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	void setAD_WF_ActivityInput(I_AD_WF_ActivityInput AD_WF_Activity);

	/**
	 * Get AD_WF_Activity.
	 *
	 * @return Workflow Activity
	 */
	I_AD_WF_ActivityInput AD_WF_Activity();

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
