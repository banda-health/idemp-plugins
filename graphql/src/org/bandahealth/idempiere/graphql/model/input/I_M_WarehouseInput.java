package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Warehouse;

/**
 * Generated Interface for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_WarehouseInput extends I_M_Warehouse {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput C_Location();

	/**
	 * Set M_ReserveLocator.
	 *
	 * @param M_ReserveLocator Reservation Locator (just for reporting purposes)
	 */
	void setM_ReserveLocatorInput(I_M_LocatorInput M_ReserveLocator);

	/**
	 * Get M_ReserveLocator.
	 *
	 * @return Reservation Locator (just for reporting purposes)
	 */
	I_M_LocatorInput M_ReserveLocator();

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
	 * Set M_WarehouseSource.
	 *
	 * @param M_WarehouseSource Optional Warehouse to replenish from
	 */
	void setM_WarehouseSourceInput(I_M_WarehouseInput M_WarehouseSource);

	/**
	 * Get M_WarehouseSource.
	 *
	 * @return Optional Warehouse to replenish from
	 */
	I_M_WarehouseInput M_WarehouseSource();
}
