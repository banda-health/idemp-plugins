package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Field;

/**
 * Generated Interface for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_FieldInput extends I_AD_Field {

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
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

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
	 * Set AD_FieldGroup.
	 *
	 * @param AD_FieldGroup Logical grouping of fields
	 */
	void setAD_FieldGroupInput(ForeignEntityInput AD_FieldGroup);

	/**
	 * Get AD_FieldGroup.
	 *
	 * @return Logical grouping of fields
	 */
	ForeignEntityInput AD_FieldGroup();

	/**
	 * Set AD_FieldStyle.
	 *
	 * @param AD_FieldStyle Field CSS Style 
	 */
	void setAD_FieldStyleInput(ForeignEntityInput AD_FieldStyle);

	/**
	 * Get AD_FieldStyle.
	 *
	 * @return Field CSS Style 
	 */
	ForeignEntityInput AD_FieldStyle();

	/**
	 * Set AD_LabelStyle.
	 *
	 * @param AD_LabelStyle Label CSS Style
	 */
	void setAD_LabelStyleInput(ForeignEntityInput AD_LabelStyle);

	/**
	 * Get AD_LabelStyle.
	 *
	 * @return Label CSS Style
	 */
	ForeignEntityInput AD_LabelStyle();

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
	 * Set AD_Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	void setAD_TabInput(ForeignEntityInput AD_Tab);

	/**
	 * Get AD_Tab.
	 *
	 * @return Tab within a Window
	 */
	ForeignEntityInput AD_Tab();

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
	 * Column name BH_Abbreviation
	 */
	static final String COLUMNNAME_BH_Abbreviation = "BH_Abbreviation";

	/**
	 * Set BH_Abbreviation.
	 *
	 * @param BH_Abbreviation An abbreviation for a given name
	 */
	void setBH_Abbreviation(String BH_Abbreviation);

	/**
	 * Get BH_Abbreviation.
	 *
	 * @return An abbreviation for a given name
	 */
	String getBH_Abbreviation();

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
	 * Set Included_Tab.
	 *
	 * @param Included_Tab Included Tab in this Tab (Master Detail)
	 */
	void setIncluded_TabInput(ForeignEntityInput Included_Tab);

	/**
	 * Get Included_Tab.
	 *
	 * @return Included Tab in this Tab (Master Detail)
	 */
	ForeignEntityInput Included_Tab();

	/**
	 * Set IsAllowCopy.
	 *
	 * @param IsAllowCopy Determine if a column must be copied when pushing the button to copy record
	 */
	void setIsAllowCopyInput(ForeignEntityInput IsAllowCopy);

	/**
	 * Get IsAllowCopy.
	 *
	 * @return Determine if a column must be copied when pushing the button to copy record
	 */
	ForeignEntityInput IsAllowCopy();

	/**
	 * Set IsAlwaysUpdateable.
	 *
	 * @param IsAlwaysUpdateable The column is always updateable, even if the record is not active or processed
	 */
	void setIsAlwaysUpdateableInput(ForeignEntityInput IsAlwaysUpdateable);

	/**
	 * Get IsAlwaysUpdateable.
	 *
	 * @return The column is always updateable, even if the record is not active or processed
	 */
	ForeignEntityInput IsAlwaysUpdateable();

	/**
	 * Set IsHtml.
	 *
	 * @param IsHtml Text has HTML tags
	 */
	void setIsHtmlInput(ForeignEntityInput IsHtml);

	/**
	 * Get IsHtml.
	 *
	 * @return Text has HTML tags
	 */
	ForeignEntityInput IsHtml();

	/**
	 * Set IsMandatory.
	 *
	 * @param IsMandatory Data entry is required in this column
	 */
	void setIsMandatoryInput(ForeignEntityInput IsMandatory);

	/**
	 * Get IsMandatory.
	 *
	 * @return Data entry is required in this column
	 */
	ForeignEntityInput IsMandatory();

	/**
	 * Set IsSelectionColumn.
	 *
	 * @param IsSelectionColumn Is this column used for finding rows in windows
	 */
	void setIsSelectionColumnInput(ForeignEntityInput IsSelectionColumn);

	/**
	 * Get IsSelectionColumn.
	 *
	 * @return Is this column used for finding rows in windows
	 */
	ForeignEntityInput IsSelectionColumn();

	/**
	 * Set IsToolbarButton.
	 *
	 * @param IsToolbarButton Show the button on the toolbar, the window, or both
	 */
	void setIsToolbarButtonInput(ForeignEntityInput IsToolbarButton);

	/**
	 * Get IsToolbarButton.
	 *
	 * @return Show the button on the toolbar, the window, or both
	 */
	ForeignEntityInput IsToolbarButton();

	/**
	 * Set IsUpdateable.
	 *
	 * @param IsUpdateable Determines, if the field can be updated
	 */
	void setIsUpdateableInput(ForeignEntityInput IsUpdateable);

	/**
	 * Get IsUpdateable.
	 *
	 * @return Determines, if the field can be updated
	 */
	ForeignEntityInput IsUpdateable();

	/**
	 * Set ObscureType.
	 *
	 * @param ObscureType Type of obscuring the data (limiting the display)
	 */
	void setObscureTypeInput(ForeignEntityInput ObscureType);

	/**
	 * Get ObscureType.
	 *
	 * @return Type of obscuring the data (limiting the display)
	 */
	ForeignEntityInput ObscureType();
}
