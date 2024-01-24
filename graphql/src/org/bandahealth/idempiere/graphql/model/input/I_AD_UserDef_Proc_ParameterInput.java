package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserDef_Proc_Parameter;

/**
 * Generated Interface for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_UserDef_Proc_ParameterInput extends I_AD_UserDef_Proc_Parameter {

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
	 * Set AD_Process_Para.
	 *
	 * @param AD_Process_Para AD_Process_Para
	 */
	void setAD_Process_ParaInput(ForeignEntityInput AD_Process_Para);

	/**
	 * Get AD_Process_Para.
	 *
	 * @return AD_Process_Para
	 */
	ForeignEntityInput AD_Process_Para();

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
	 * Set AD_UserDef_Proc.
	 *
	 * @param AD_UserDef_Proc Primary Key : User defined Process
	 */
	void setAD_UserDef_ProcInput(ForeignEntityInput AD_UserDef_Proc);

	/**
	 * Get AD_UserDef_Proc.
	 *
	 * @return Primary Key : User defined Process
	 */
	ForeignEntityInput AD_UserDef_Proc();

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
}
