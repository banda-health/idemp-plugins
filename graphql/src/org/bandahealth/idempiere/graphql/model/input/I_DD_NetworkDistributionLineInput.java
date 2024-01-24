package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_DD_NetworkDistributionLine;

/**
 * Generated Interface for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_DD_NetworkDistributionLineInput extends I_DD_NetworkDistributionLine {

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
	 * Set DD_NetworkDistribution.
	 *
	 * @param DD_NetworkDistribution DD_NetworkDistribution
	 */
	void setDD_NetworkDistributionInput(ForeignEntityInput DD_NetworkDistribution);

	/**
	 * Get DD_NetworkDistribution.
	 *
	 * @return DD_NetworkDistribution
	 */
	ForeignEntityInput DD_NetworkDistribution();

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
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_ShipperInput(ForeignEntityInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	ForeignEntityInput M_Shipper();

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
}
