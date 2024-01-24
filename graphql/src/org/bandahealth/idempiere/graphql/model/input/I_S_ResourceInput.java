package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_S_Resource;

/**
 * Generated Interface for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_S_ResourceInput extends I_S_Resource {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

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
	 * Set S_ResourceType.
	 *
	 * @param S_ResourceType S_ResourceType
	 */
	void setS_ResourceTypeInput(ForeignEntityInput S_ResourceType);

	/**
	 * Get S_ResourceType.
	 *
	 * @return S_ResourceType
	 */
	ForeignEntityInput S_ResourceType();
}
