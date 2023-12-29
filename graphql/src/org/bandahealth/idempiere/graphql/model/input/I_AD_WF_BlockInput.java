package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WF_Block;

/**
 * Generated Interface for AD_WF_Block - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WF_BlockInput extends I_AD_WF_Block {

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
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_Workflow(I_AD_WorkflowInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	I_AD_WorkflowInput getAD_Workflow();
}
