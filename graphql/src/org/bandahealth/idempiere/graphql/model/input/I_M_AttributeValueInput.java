package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeValue;

/**
 * Generated Interface for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_AttributeValueInput extends I_M_AttributeValue {

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
	 * Set M_Attribute.
	 *
	 * @param M_Attribute Product Attribute
	 */
	void setM_AttributeInput(ForeignEntityInput M_Attribute);

	/**
	 * Get M_Attribute.
	 *
	 * @return Product Attribute
	 */
	ForeignEntityInput M_Attribute();

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
