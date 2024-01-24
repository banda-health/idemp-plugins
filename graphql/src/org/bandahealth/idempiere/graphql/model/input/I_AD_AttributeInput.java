package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Attribute;

/**
 * Generated Interface for AD_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_AttributeInput extends I_AD_Attribute {

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
}
