package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserDef_Field;

/**
 * Generated Interface for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_UserDef_FieldInput extends I_AD_UserDef_Field {

	/**
	 * Set AD_Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	void setAD_FieldInput(ForeignEntityInput AD_Field);

	/**
	 * Get AD_Field.
	 *
	 * @return Field on a database table
	 */
	ForeignEntityInput AD_Field();

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
	 * Set AD_UserDef_Tab.
	 *
	 * @param AD_UserDef_Tab AD_UserDef_Tab
	 */
	void setAD_UserDef_TabInput(ForeignEntityInput AD_UserDef_Tab);

	/**
	 * Get AD_UserDef_Tab.
	 *
	 * @return AD_UserDef_Tab
	 */
	ForeignEntityInput AD_UserDef_Tab();

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
	 * Set IsAlwaysUpdateable.
	 *
	 * @param IsAlwaysUpdateable The column is always updateable, even if the record is not active or processed
	 */
	void setIsAlwaysUpdateableInput(I_AD_Ref_ListInput IsAlwaysUpdateable);

	/**
	 * Get IsAlwaysUpdateable.
	 *
	 * @return The column is always updateable, even if the record is not active or processed
	 */
	I_AD_Ref_ListInput IsAlwaysUpdateable();

	/**
	 * Set IsAutocomplete.
	 *
	 * @param IsAutocomplete Automatic completion for textfields
	 */
	void setIsAutocompleteInput(I_AD_Ref_ListInput IsAutocomplete);

	/**
	 * Get IsAutocomplete.
	 *
	 * @return Automatic completion for textfields
	 */
	I_AD_Ref_ListInput IsAutocomplete();

	/**
	 * Set IsDisplayed.
	 *
	 * @param IsDisplayed Determines, if this field is displayed
	 */
	void setIsDisplayedInput(I_AD_Ref_ListInput IsDisplayed);

	/**
	 * Get IsDisplayed.
	 *
	 * @return Determines, if this field is displayed
	 */
	I_AD_Ref_ListInput IsDisplayed();

	/**
	 * Set IsMandatory.
	 *
	 * @param IsMandatory Data entry is required in this column
	 */
	void setIsMandatoryInput(I_AD_Ref_ListInput IsMandatory);

	/**
	 * Get IsMandatory.
	 *
	 * @return Data entry is required in this column
	 */
	I_AD_Ref_ListInput IsMandatory();

	/**
	 * Set IsReadOnly.
	 *
	 * @param IsReadOnly Field is read only
	 */
	void setIsReadOnlyInput(I_AD_Ref_ListInput IsReadOnly);

	/**
	 * Get IsReadOnly.
	 *
	 * @return Field is read only
	 */
	I_AD_Ref_ListInput IsReadOnly();

	/**
	 * Set IsSameLine.
	 *
	 * @param IsSameLine Displayed on same line as previous field
	 */
	void setIsSameLineInput(I_AD_Ref_ListInput IsSameLine);

	/**
	 * Get IsSameLine.
	 *
	 * @return Displayed on same line as previous field
	 */
	I_AD_Ref_ListInput IsSameLine();

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
	 * Set IsUpdateable.
	 *
	 * @param IsUpdateable Determines, if the field can be updated
	 */
	void setIsUpdateableInput(I_AD_Ref_ListInput IsUpdateable);

	/**
	 * Get IsUpdateable.
	 *
	 * @return Determines, if the field can be updated
	 */
	I_AD_Ref_ListInput IsUpdateable();

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
}
