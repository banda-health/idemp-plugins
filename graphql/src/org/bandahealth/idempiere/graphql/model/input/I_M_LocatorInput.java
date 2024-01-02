package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Locator;

/**
 * Generated Interface for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_LocatorInput extends I_M_Locator {

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
	 * Set M_LocatorType.
	 *
	 * @param M_LocatorType M_LocatorType
	 */
	void setM_LocatorTypeInput(I_M_LocatorTypeInput M_LocatorType);

	/**
	 * Get M_LocatorType.
	 *
	 * @return M_LocatorType
	 */
	I_M_LocatorTypeInput M_LocatorType();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput M_Warehouse();
}
