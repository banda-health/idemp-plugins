package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_InventoryLineMA;

/**
 * Generated Interface for M_InventoryLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_InventoryLineMAInput extends I_M_InventoryLineMA {

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
	 * Set M_InventoryLine.
	 *
	 * @param M_InventoryLine Unique line in an Inventory document
	 */
	void setM_InventoryLineInput(ForeignEntityInput M_InventoryLine);

	/**
	 * Get M_InventoryLine.
	 *
	 * @return Unique line in an Inventory document
	 */
	ForeignEntityInput M_InventoryLine();

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
