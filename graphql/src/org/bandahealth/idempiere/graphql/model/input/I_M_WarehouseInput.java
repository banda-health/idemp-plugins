package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Warehouse;

/**
 * Generated Interface for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_WarehouseInput extends I_M_Warehouse {

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
	 * Column name BH_DefaultWarehouse
	 */
	static final String COLUMNNAME_BH_DefaultWarehouse = "BH_DefaultWarehouse";

	/**
	 * Set Default Warehouse.
	 *
	 * @param BH_DefaultWarehouse Default Warehouse
	 */
	void setBH_DefaultWarehouse(boolean BH_DefaultWarehouse);

	/**
	 * Get Default Warehouse.
	 *
	 * @return Default Warehouse
	 */
	boolean isBH_DefaultWarehouse();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(ForeignEntityInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	ForeignEntityInput C_Location();

	/**
	 * Set M_ReserveLocator.
	 *
	 * @param M_ReserveLocator Reservation Locator (just for reporting purposes)
	 */
	void setM_ReserveLocatorInput(ForeignEntityInput M_ReserveLocator);

	/**
	 * Get M_ReserveLocator.
	 *
	 * @return Reservation Locator (just for reporting purposes)
	 */
	ForeignEntityInput M_ReserveLocator();

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
}
