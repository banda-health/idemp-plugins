package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_MovementLine;

/**
 * Generated Interface for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_MovementLineInput extends I_M_MovementLine {

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
	 * Set DD_OrderLine.
	 *
	 * @param DD_OrderLine DD_OrderLine
	 */
	void setDD_OrderLineInput(ForeignEntityInput DD_OrderLine);

	/**
	 * Get DD_OrderLine.
	 *
	 * @return DD_OrderLine
	 */
	ForeignEntityInput DD_OrderLine();

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
	 * Set M_AttributeSetInstanceTo.
	 *
	 * @param M_AttributeSetInstanceTo Target Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceToInput(ForeignEntityInput M_AttributeSetInstanceTo);

	/**
	 * Get M_AttributeSetInstanceTo.
	 *
	 * @return Target Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstanceTo();

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
	 * Set M_LocatorTo.
	 *
	 * @param M_LocatorTo Location inventory is moved to
	 */
	void setM_LocatorToInput(ForeignEntityInput M_LocatorTo);

	/**
	 * Get M_LocatorTo.
	 *
	 * @return Location inventory is moved to
	 */
	ForeignEntityInput M_LocatorTo();

	/**
	 * Set M_Movement.
	 *
	 * @param M_Movement Movement of Inventory
	 */
	void setM_MovementInput(ForeignEntityInput M_Movement);

	/**
	 * Get M_Movement.
	 *
	 * @return Movement of Inventory
	 */
	ForeignEntityInput M_Movement();

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
