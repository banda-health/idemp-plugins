package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Attribute;

/**
 * Generated Interface for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_AttributeInput extends I_M_Attribute {

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
	 * Set AttributeValueType.
	 *
	 * @param AttributeValueType Type of Attribute Value
	 */
	void setAttributeValueTypeInput(I_AD_Ref_ListInput AttributeValueType);

	/**
	 * Get AttributeValueType.
	 *
	 * @return Type of Attribute Value
	 */
	I_AD_Ref_ListInput AttributeValueType();

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
	 * Set M_AttributeSearch.
	 *
	 * @param M_AttributeSearch Common Search Attribute 
	 */
	void setM_AttributeSearchInput(ForeignEntityInput M_AttributeSearch);

	/**
	 * Get M_AttributeSearch.
	 *
	 * @return Common Search Attribute 
	 */
	ForeignEntityInput M_AttributeSearch();
}
