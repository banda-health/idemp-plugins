package org.bandahealth.idempiere.graphql.model.input;

import java.sql.Timestamp;
import org.compiere.model.I_M_InventoryLine;

/**
 * Generated Interface for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_InventoryLineInput extends I_M_InventoryLine {

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
	 * Column name BH_Expiration
	 */
	static final String COLUMNNAME_BH_Expiration = "BH_Expiration";

	/**
	 * Set Expire On.
	 *
	 * @param BH_Expiration Expire On
	 */
	void setBH_Expiration(Timestamp BH_Expiration);

	/**
	 * Get Expire On.
	 *
	 * @return Expire On
	 */
	Timestamp getBH_Expiration();

	/**
	 * Column name BH_NavButtons
	 */
	static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	void setBH_NavButtons(Object BH_NavButtons);

	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	Object getBH_NavButtons();

	/**
	 * Column name BH_NumOrderLines
	 */
	static final String COLUMNNAME_BH_NumOrderLines = "BH_NumOrderLines";

	/**
	 * Set Number of Order Lines.
	 *
	 * @param BH_NumOrderLines The number of order lines on an order
	 */
	void setBH_NumOrderLines(int BH_NumOrderLines);

	/**
	 * Get Number of Order Lines.
	 *
	 * @return The number of order lines on an order
	 */
	int getBH_NumOrderLines();

	/**
	 * Column name BH_OrderDocStatus
	 */
	static final String COLUMNNAME_BH_OrderDocStatus = "BH_OrderDocStatus";

	/**
	 * Set Document Status.
	 *
	 * @param BH_OrderDocStatus The current status of the document
	 */
	void setBH_OrderDocStatus(String BH_OrderDocStatus);

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	String getBH_OrderDocStatus();

	/**
	 * Column name BH_RequiresExpiration
	 */
	static final String COLUMNNAME_BH_RequiresExpiration = "BH_RequiresExpiration";

	/**
	 * Set Requires Expiration.
	 *
	 * @param BH_RequiresExpiration Requires Expiration
	 */
	void setBH_RequiresExpiration(boolean BH_RequiresExpiration);

	/**
	 * Get Requires Expiration.
	 *
	 * @return Requires Expiration
	 */
	boolean isBH_RequiresExpiration();

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
	void setInventoryTypeInput(I_AD_Ref_ListInput InventoryType);

	/**
	 * Get InventoryType.
	 *
	 * @return Type of inventory difference
	 */
	I_AD_Ref_ListInput InventoryType();

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
