package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_AttributeInstance;

/**
 * Generated Interface for M_AttributeInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_AttributeInstanceInput extends I_M_AttributeInstance {

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

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();

	/**
	 * Set M_AttributeValue.
	 *
	 * @param M_AttributeValue Product Attribute Value
	 */
	void setM_AttributeValueInput(ForeignEntityInput M_AttributeValue);

	/**
	 * Get M_AttributeValue.
	 *
	 * @return Product Attribute Value
	 */
	ForeignEntityInput M_AttributeValue();
}
