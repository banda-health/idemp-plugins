package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Process;

/**
 * Generated Interface for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ProcessInput extends I_AD_Process {

	/**
	 * Set AccessLevel_RL.
	 *
	 * @param AccessLevel_RL Access Level required
	 */
	void setAccessLevel_RL(I_AD_Ref_ListInput AccessLevel_RL);

	/**
	 * Get AccessLevel_RL.
	 *
	 * @return Access Level required
	 */
	I_AD_Ref_ListInput getAccessLevel_RL();

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelp(I_AD_CtxHelpInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	I_AD_CtxHelpInput getAD_CtxHelp();

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_Form(I_AD_FormInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	I_AD_FormInput getAD_Form();

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormat(I_AD_PrintFormatInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	I_AD_PrintFormatInput getAD_PrintFormat();

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
	 * Set AD_ReportView.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	void setAD_ReportView(I_AD_ReportViewInput AD_ReportView);

	/**
	 * Get AD_ReportView.
	 *
	 * @return View used to generate this report
	 */
	I_AD_ReportViewInput getAD_ReportView();

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

	/**
	 * Set AllowMultipleExecution_RL.
	 *
	 * @param AllowMultipleExecution_RL Allow or disallow executing a process/report multiple times.
	 */
	void setAllowMultipleExecution_RL(I_AD_Ref_ListInput AllowMultipleExecution_RL);

	/**
	 * Get AllowMultipleExecution_RL.
	 *
	 * @return Allow or disallow executing a process/report multiple times.
	 */
	I_AD_Ref_ListInput getAllowMultipleExecution_RL();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set ExecutionType_RL.
	 *
	 * @param ExecutionType_RL Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	void setExecutionType_RL(I_AD_Ref_ListInput ExecutionType_RL);

	/**
	 * Get ExecutionType_RL.
	 *
	 * @return Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	I_AD_Ref_ListInput getExecutionType_RL();

	/**
	 * Set ShowHelp_RL.
	 *
	 * @param ShowHelp_RL ShowHelp_RL
	 */
	void setShowHelp_RL(I_AD_Ref_ListInput ShowHelp_RL);

	/**
	 * Get ShowHelp_RL.
	 *
	 * @return ShowHelp_RL
	 */
	I_AD_Ref_ListInput getShowHelp_RL();
}
