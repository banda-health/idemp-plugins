package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_ProcessData;

/**
 * Generated Interface for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_WF_ProcessDataInput extends I_AD_WF_ProcessData {

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
	 * Set AD_WF_Process.
	 *
	 * @param AD_WF_Process Actual Workflow Process Instance
	 */
	void setAD_WF_ProcessInput(ForeignEntityInput AD_WF_Process);

	/**
	 * Get AD_WF_Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	ForeignEntityInput AD_WF_Process();

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
