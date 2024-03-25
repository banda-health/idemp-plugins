package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Column;

/**
 * Generated Interface for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_ColumnInput extends I_AD_Column {

	/**
	 * Set AD_Chart.
	 *
	 * @param AD_Chart AD_Chart
	 */
	void setAD_ChartInput(ForeignEntityInput AD_Chart);

	/**
	 * Get AD_Chart.
	 *
	 * @return AD_Chart
	 */
	ForeignEntityInput AD_Chart();

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
	 * Set AD_Element.
	 *
	 * @param AD_Element System Element enables the central maintenance of column description and help.
	 */
	void setAD_ElementInput(ForeignEntityInput AD_Element);

	/**
	 * Get AD_Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	ForeignEntityInput AD_Element();

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
	 * Set AD_Reference_Value.
	 *
	 * @param AD_Reference_Value Required to specify, if data type is Table or List
	 */
	void setAD_Reference_ValueInput(ForeignEntityInput AD_Reference_Value);

	/**
	 * Get AD_Reference_Value.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	ForeignEntityInput AD_Reference_Value();

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
	 * Set AD_Val_Rule_Lookup.
	 *
	 * @param AD_Val_Rule_Lookup Override Dynamic Validation Rule for Lookup Window
	 */
	void setAD_Val_Rule_LookupInput(ForeignEntityInput AD_Val_Rule_Lookup);

	/**
	 * Get AD_Val_Rule_Lookup.
	 *
	 * @return Override Dynamic Validation Rule for Lookup Window
	 */
	ForeignEntityInput AD_Val_Rule_Lookup();

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
	 * Set FKConstraintMsg.
	 *
	 * @param FKConstraintMsg FKConstraintMsg
	 */
	void setFKConstraintMsgInput(ForeignEntityInput FKConstraintMsg);

	/**
	 * Get FKConstraintMsg.
	 *
	 * @return FKConstraintMsg
	 */
	ForeignEntityInput FKConstraintMsg();

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
	void setPA_DashboardContentInput(ForeignEntityInput PA_DashboardContent);

	/**
	 * Get PA_DashboardContent.
	 *
	 * @return PA_DashboardContent
	 */
	ForeignEntityInput PA_DashboardContent();

	/**
	 * Set PartitioningMethod.
	 *
	 * @param PartitioningMethod Indicates how the Table is partitioned
	 */
	void setPartitioningMethodInput(I_AD_Ref_ListInput PartitioningMethod);

	/**
	 * Get PartitioningMethod.
	 *
	 * @return Indicates how the Table is partitioned
	 */
	I_AD_Ref_ListInput PartitioningMethod();
}
