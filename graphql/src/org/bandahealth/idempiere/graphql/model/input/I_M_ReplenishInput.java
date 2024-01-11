package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Replenish;

/**
 * Generated Interface for M_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ReplenishInput extends I_M_Replenish {

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
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(ForeignEntityInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_Warehouse();

	/**
	 * Set M_WarehouseSource.
	 *
	 * @param M_WarehouseSource Optional Warehouse to replenish from
	 */
	void setM_WarehouseSourceInput(ForeignEntityInput M_WarehouseSource);

	/**
	 * Get M_WarehouseSource.
	 *
	 * @return Optional Warehouse to replenish from
	 */
	ForeignEntityInput M_WarehouseSource();

	/**
	 * Set ReplenishType.
	 *
	 * @param ReplenishType Method for re-ordering a product
	 */
	void setReplenishTypeInput(I_AD_Ref_ListInput ReplenishType);

	/**
	 * Get ReplenishType.
	 *
	 * @return Method for re-ordering a product
	 */
	I_AD_Ref_ListInput ReplenishType();
}
