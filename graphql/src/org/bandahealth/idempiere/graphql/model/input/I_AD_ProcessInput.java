package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Process;

/**
 * Generated Interface for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_ProcessInput extends I_AD_Process {

	/**
	 * Set AccessLevel.
	 *
	 * @param AccessLevel Access Level required
	 */
	void setAccessLevelInput(I_AD_Ref_ListInput AccessLevel);

	/**
	 * Get AccessLevel.
	 *
	 * @return Access Level required
	 */
	I_AD_Ref_ListInput AccessLevel();

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelpInput(ForeignEntityInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	ForeignEntityInput AD_CtxHelp();

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_FormInput(ForeignEntityInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	ForeignEntityInput AD_Form();

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

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

	/**
	 * Set AD_ReportView.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	void setAD_ReportViewInput(ForeignEntityInput AD_ReportView);

	/**
	 * Get AD_ReportView.
	 *
	 * @return View used to generate this report
	 */
	ForeignEntityInput AD_ReportView();

	/**
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(ForeignEntityInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	ForeignEntityInput AD_Workflow();

	/**
	 * Set AllowMultipleExecution.
	 *
	 * @param AllowMultipleExecution Allow or disallow executing a process/report multiple times.
	 */
	void setAllowMultipleExecutionInput(I_AD_Ref_ListInput AllowMultipleExecution);

	/**
	 * Get AllowMultipleExecution.
	 *
	 * @return Allow or disallow executing a process/report multiple times.
	 */
	I_AD_Ref_ListInput AllowMultipleExecution();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set ExecutionType.
	 *
	 * @param ExecutionType Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	void setExecutionTypeInput(I_AD_Ref_ListInput ExecutionType);

	/**
	 * Get ExecutionType.
	 *
	 * @return Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	I_AD_Ref_ListInput ExecutionType();

	/**
	 * Set ShowHelp.
	 *
	 * @param ShowHelp ShowHelp
	 */
	void setShowHelpInput(I_AD_Ref_ListInput ShowHelp);

	/**
	 * Get ShowHelp.
	 *
	 * @return ShowHelp
	 */
	I_AD_Ref_ListInput ShowHelp();
}
