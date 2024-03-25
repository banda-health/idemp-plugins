package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserDef_Info_Column;

/**
 * Generated Interface for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_UserDef_Info_ColumnInput extends I_AD_UserDef_Info_Column {

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
	 * Set AD_InfoColumn.
	 *
	 * @param AD_InfoColumn Info Window Column
	 */
	void setAD_InfoColumnInput(ForeignEntityInput AD_InfoColumn);

	/**
	 * Get AD_InfoColumn.
	 *
	 * @return Info Window Column
	 */
	ForeignEntityInput AD_InfoColumn();

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
	 * Set AD_UserDef_Info.
	 *
	 * @param AD_UserDef_Info AD_UserDef_Info
	 */
	void setAD_UserDef_InfoInput(ForeignEntityInput AD_UserDef_Info);

	/**
	 * Get AD_UserDef_Info.
	 *
	 * @return AD_UserDef_Info
	 */
	ForeignEntityInput AD_UserDef_Info();

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
	 * Set IsAutocomplete.
	 *
	 * @param IsAutocomplete Automatic completion for text fields
	 */
	void setIsAutocompleteInput(I_AD_Ref_ListInput IsAutocomplete);

	/**
	 * Get IsAutocomplete.
	 *
	 * @return Automatic completion for text fields
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
	 * Set IsQueryAfterChange.
	 *
	 * @param IsQueryAfterChange Issues a query request after the user has made changes to the field
	 */
	void setIsQueryAfterChangeInput(I_AD_Ref_ListInput IsQueryAfterChange);

	/**
	 * Get IsQueryAfterChange.
	 *
	 * @return Issues a query request after the user has made changes to the field
	 */
	I_AD_Ref_ListInput IsQueryAfterChange();

	/**
	 * Set IsQueryCriteria.
	 *
	 * @param IsQueryCriteria The column is also used as a query criteria
	 */
	void setIsQueryCriteriaInput(I_AD_Ref_ListInput IsQueryCriteria);

	/**
	 * Get IsQueryCriteria.
	 *
	 * @return The column is also used as a query criteria
	 */
	I_AD_Ref_ListInput IsQueryCriteria();

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
	 * Set QueryOperator.
	 *
	 * @param QueryOperator Operator for database query
	 */
	void setQueryOperatorInput(I_AD_Ref_ListInput QueryOperator);

	/**
	 * Get QueryOperator.
	 *
	 * @return Operator for database query
	 */
	I_AD_Ref_ListInput QueryOperator();
}
