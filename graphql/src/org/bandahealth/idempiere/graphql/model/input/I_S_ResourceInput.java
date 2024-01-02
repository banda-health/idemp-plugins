package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_S_Resource;

/**
 * Generated Interface for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_S_ResourceInput extends I_S_Resource {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

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

	/**
	 * Set ManufacturingResourceType.
	 *
	 * @param ManufacturingResourceType ManufacturingResourceType
	 */
	void setManufacturingResourceTypeInput(I_AD_Ref_ListInput ManufacturingResourceType);

	/**
	 * Get ManufacturingResourceType.
	 *
	 * @return ManufacturingResourceType
	 */
	I_AD_Ref_ListInput ManufacturingResourceType();

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
	 * Set S_ResourceType.
	 *
	 * @param S_ResourceType S_ResourceType
	 */
	void setS_ResourceTypeInput(I_S_ResourceTypeInput S_ResourceType);

	/**
	 * Get S_ResourceType.
	 *
	 * @return S_ResourceType
	 */
	I_S_ResourceTypeInput S_ResourceType();
}
