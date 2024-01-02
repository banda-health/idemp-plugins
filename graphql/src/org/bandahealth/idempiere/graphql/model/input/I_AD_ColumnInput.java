package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Column;

/**
 * Generated Interface for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ColumnInput extends I_AD_Column {

	/**
	 * Set AD_Chart.
	 *
	 * @param AD_Chart AD_Chart
	 */
	void setAD_ChartInput(I_AD_ChartInput AD_Chart);

	/**
	 * Get AD_Chart.
	 *
	 * @return AD_Chart
	 */
	I_AD_ChartInput AD_Chart();

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
	 * Set AD_Element.
	 *
	 * @param AD_Element System Element enables the central maintenance of column description and help.
	 */
	void setAD_ElementInput(I_AD_ElementInput AD_Element);

	/**
	 * Get AD_Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	I_AD_ElementInput AD_Element();

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
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(I_AD_ProcessInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	I_AD_ProcessInput AD_Process();

	/**
	 * Set AD_Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	void setAD_ReferenceInput(I_AD_ReferenceInput AD_Reference);

	/**
	 * Get AD_Reference.
	 *
	 * @return System Reference and Validation
	 */
	I_AD_ReferenceInput AD_Reference();

	/**
	 * Set AD_Reference_Value.
	 *
	 * @param AD_Reference_Value Required to specify, if data type is Table or List
	 */
	void setAD_Reference_ValueInput(I_AD_ReferenceInput AD_Reference_Value);

	/**
	 * Get AD_Reference_Value.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	I_AD_ReferenceInput AD_Reference_Value();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput AD_Table();

	/**
	 * Set AD_Val_Rule.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	void setAD_Val_RuleInput(I_AD_Val_RuleInput AD_Val_Rule);

	/**
	 * Get AD_Val_Rule.
	 *
	 * @return Dynamic Validation Rule
	 */
	I_AD_Val_RuleInput AD_Val_Rule();

	/**
	 * Set AD_Val_Rule_Lookup.
	 *
	 * @param AD_Val_Rule_Lookup Override Dynamic Validation Rule for Lookup Window
	 */
	void setAD_Val_Rule_LookupInput(I_AD_Val_RuleInput AD_Val_Rule_Lookup);

	/**
	 * Get AD_Val_Rule_Lookup.
	 *
	 * @return Override Dynamic Validation Rule for Lookup Window
	 */
	I_AD_Val_RuleInput AD_Val_Rule_Lookup();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput AD_EntityType();

	/**
	 * Set FKConstraintType.
	 *
	 * @param FKConstraintType FKConstraintType
	 */
	void setFKConstraintTypeInput(I_AD_Ref_ListInput FKConstraintType);

	/**
	 * Get FKConstraintType.
	 *
	 * @return FKConstraintType
	 */
	I_AD_Ref_ListInput FKConstraintType();

	/**
	 * Set IsEncrypted.
	 *
	 * @param IsEncrypted Display or Storage is encrypted
	 */
	void setIsEncryptedInput(I_AD_Ref_ListInput IsEncrypted);

	/**
	 * Get IsEncrypted.
	 *
	 * @return Display or Storage is encrypted
	 */
	I_AD_Ref_ListInput IsEncrypted();

	/**
	 * Set IsToolbarButton.
	 *
	 * @param IsToolbarButton Show the button on the toolbar, the window, or both
	 */
	void setIsToolbarButtonInput(I_AD_Ref_ListInput IsToolbarButton);

	/**
	 * Get IsToolbarButton.
	 *
	 * @return Show the button on the toolbar, the window, or both
	 */
	I_AD_Ref_ListInput IsToolbarButton();

	/**
	 * Set PA_DashboardContent.
	 *
	 * @param PA_DashboardContent PA_DashboardContent
	 */
	void setPA_DashboardContentInput(I_PA_DashboardContentInput PA_DashboardContent);

	/**
	 * Get PA_DashboardContent.
	 *
	 * @return PA_DashboardContent
	 */
	I_PA_DashboardContentInput PA_DashboardContent();
}
