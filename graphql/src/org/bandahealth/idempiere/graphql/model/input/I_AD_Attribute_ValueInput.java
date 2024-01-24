package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Attribute_Value;

/**
 * Generated Interface for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_Attribute_ValueInput extends I_AD_Attribute_Value {

	/**
	 * Set AD_Attribute.
	 *
	 * @param AD_Attribute AD_Attribute
	 */
	void setAD_AttributeInput(ForeignEntityInput AD_Attribute);

	/**
	 * Get AD_Attribute.
	 *
	 * @return AD_Attribute
	 */
	ForeignEntityInput AD_Attribute();

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
}
