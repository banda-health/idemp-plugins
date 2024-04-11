package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Exp_Detail;

/**
 * Generated Interface for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Package_Exp_DetailInput extends I_AD_Package_Exp_Detail {

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType System Entity Type
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return System Entity Type
	 */
	ForeignEntityInput AD_EntityType();

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
	 * Set AD_ImpFormat.
	 *
	 * @param AD_ImpFormat AD_ImpFormat
	 */
	void setAD_ImpFormatInput(ForeignEntityInput AD_ImpFormat);

	/**
	 * Get AD_ImpFormat.
	 *
	 * @return AD_ImpFormat
	 */
	ForeignEntityInput AD_ImpFormat();

	/**
	 * Set AD_InfoWindow.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow);

	/**
	 * Get AD_InfoWindow.
	 *
	 * @return Info and search/select Window
	 */
	ForeignEntityInput AD_InfoWindow();

	/**
	 * Set AD_Menu.
	 *
	 * @param AD_Menu Identifies a Menu
	 */
	void setAD_MenuInput(ForeignEntityInput AD_Menu);

	/**
	 * Get AD_Menu.
	 *
	 * @return Identifies a Menu
	 */
	ForeignEntityInput AD_Menu();

	/**
	 * Set AD_Message.
	 *
	 * @param AD_Message System Message
	 */
	void setAD_MessageInput(ForeignEntityInput AD_Message);

	/**
	 * Get AD_Message.
	 *
	 * @return System Message
	 */
	ForeignEntityInput AD_Message();

	/**
	 * Set AD_ModelValidator.
	 *
	 * @param AD_ModelValidator AD_ModelValidator
	 */
	void setAD_ModelValidatorInput(ForeignEntityInput AD_ModelValidator);

	/**
	 * Get AD_ModelValidator.
	 *
	 * @return AD_ModelValidator
	 */
	ForeignEntityInput AD_ModelValidator();

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
	 * Set AD_Package_Exp.
	 *
	 * @param AD_Package_Exp AD_Package_Exp
	 */
	void setAD_Package_ExpInput(ForeignEntityInput AD_Package_Exp);

	/**
	 * Get AD_Package_Exp.
	 *
	 * @return AD_Package_Exp
	 */
	ForeignEntityInput AD_Package_Exp();

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
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(ForeignEntityInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	ForeignEntityInput AD_Process();

	/**
	 * Set AD_Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	void setAD_ReferenceInput(ForeignEntityInput AD_Reference);

	/**
	 * Get AD_Reference.
	 *
	 * @return System Reference and Validation
	 */
	ForeignEntityInput AD_Reference();

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
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

	/**
	 * Set AD_Val_Rule.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	void setAD_Val_RuleInput(ForeignEntityInput AD_Val_Rule);

	/**
	 * Get AD_Val_Rule.
	 *
	 * @return Dynamic Validation Rule
	 */
	ForeignEntityInput AD_Val_Rule();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

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
	 * Set DBType.
	 *
	 * @param DBType DBType
	 */
	void setDBTypeInput(ForeignEntityInput DBType);

	/**
	 * Get DBType.
	 *
	 * @return DBType
	 */
	ForeignEntityInput DBType();

	/**
	 * Set ReleaseNo.
	 *
	 * @param ReleaseNo Internal Release Number
	 */
	void setReleaseNoInput(ForeignEntityInput ReleaseNo);

	/**
	 * Get ReleaseNo.
	 *
	 * @return Internal Release Number
	 */
	ForeignEntityInput ReleaseNo();

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	void setTypeInput(ForeignEntityInput Type);

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	ForeignEntityInput Type();
}
