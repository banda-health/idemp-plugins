package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_InventoryLine;

/**
 * Generated Interface for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_InventoryLineInput extends I_M_InventoryLine {

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

	/**
	 * Set InventoryType.
	 *
	 * @param InventoryType Type of inventory difference
	 */
	void setInventoryTypeInput(ForeignEntityInput InventoryType);

	/**
	 * Get InventoryType.
	 *
	 * @return Type of inventory difference
	 */
	ForeignEntityInput InventoryType();

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
	 * Set M_Inventory.
	 *
	 * @param M_Inventory Parameters for a Physical Inventory
	 */
	void setM_InventoryInput(ForeignEntityInput M_Inventory);

	/**
	 * Get M_Inventory.
	 *
	 * @return Parameters for a Physical Inventory
	 */
	ForeignEntityInput M_Inventory();

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
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_LocatorInput(ForeignEntityInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	ForeignEntityInput M_Locator();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set ReversalLine.
	 *
	 * @param ReversalLine Use to keep the reversal line ID for reversing costing purpose
	 */
	void setReversalLineInput(ForeignEntityInput ReversalLine);

	/**
	 * Get ReversalLine.
	 *
	 * @return Use to keep the reversal line ID for reversing costing purpose
	 */
	ForeignEntityInput ReversalLine();
}
