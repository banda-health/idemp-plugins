package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_ActivityResult;

/**
 * Generated Interface for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_WF_ActivityResultInput extends I_AD_WF_ActivityResult {

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
}
