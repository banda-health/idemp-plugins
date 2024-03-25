package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Locator;

/**
 * Generated Interface for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_LocatorInput extends I_M_Locator {

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
	 * Set M_LocatorType.
	 *
	 * @param M_LocatorType M_LocatorType
	 */
	void setM_LocatorTypeInput(ForeignEntityInput M_LocatorType);

	/**
	 * Get M_LocatorType.
	 *
	 * @return M_LocatorType
	 */
	ForeignEntityInput M_LocatorType();

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
}
