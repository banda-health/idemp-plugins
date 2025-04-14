package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Process;

/**
 * Generated Interface for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_ProcessInput extends I_AD_Process {

	/**
	 * Set AccessLevel.
	 *
	 * @param AccessLevel Access Level required
	 */
	void setAccessLevelInput(ForeignEntityInput AccessLevel);

	/**
	 * Get AccessLevel.
	 *
	 * @return Access Level required
	 */
	ForeignEntityInput AccessLevel();

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
	 * @param AllowMultipleExecution Allow or disallow executing a process/report multiple times concurrently
	 */
	void setAllowMultipleExecutionInput(ForeignEntityInput AllowMultipleExecution);

	/**
	 * Get AllowMultipleExecution.
	 *
	 * @return Allow or disallow executing a process/report multiple times concurrently
	 */
	ForeignEntityInput AllowMultipleExecution();

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
	void setExecutionTypeInput(ForeignEntityInput ExecutionType);

	/**
	 * Get ExecutionType.
	 *
	 * @return Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	ForeignEntityInput ExecutionType();

	/**
	 * Set ShowHelp.
	 *
	 * @param ShowHelp ShowHelp
	 */
	void setShowHelpInput(ForeignEntityInput ShowHelp);

	/**
	 * Get ShowHelp.
	 *
	 * @return ShowHelp
	 */
	ForeignEntityInput ShowHelp();
}
