package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Role_WarehouseAccess;

/**
 * Generated Interface for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_Role_WarehouseAccessInput extends I_BH_Role_WarehouseAccess {

	/**
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set BH_Role_WarehouseAccess.
	 *
	 * @param BH_Role_WarehouseAccess BH_Role_WarehouseAccess
	 */
	void setBH_Role_WarehouseAccessInput(ForeignEntityInput BH_Role_WarehouseAccess);

	/**
	 * Get BH_Role_WarehouseAccess.
	 *
	 * @return BH_Role_WarehouseAccess
	 */
	ForeignEntityInput BH_Role_WarehouseAccess();

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
}
