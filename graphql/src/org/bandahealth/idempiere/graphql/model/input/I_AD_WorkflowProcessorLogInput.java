package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_WorkflowProcessorLog;

/**
 * Generated Interface for AD_WorkflowProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_WorkflowProcessorLogInput extends I_AD_WorkflowProcessorLog {

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
	 * Set AD_WorkflowProcessor.
	 *
	 * @param AD_WorkflowProcessor Workflow Processor Server
	 */
	void setAD_WorkflowProcessorInput(ForeignEntityInput AD_WorkflowProcessor);

	/**
	 * Get AD_WorkflowProcessor.
	 *
	 * @return Workflow Processor Server
	 */
	ForeignEntityInput AD_WorkflowProcessor();

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
