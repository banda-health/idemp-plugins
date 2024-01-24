package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperPickupTypes;

/**
 * Generated Interface for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_ShipperPickupTypesInput extends I_M_ShipperPickupTypes {

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
	 * Set M_ShipperPickupTypesCfg.
	 *
	 * @param M_ShipperPickupTypesCfg M_ShipperPickupTypesCfg
	 */
	void setM_ShipperPickupTypesCfgInput(ForeignEntityInput M_ShipperPickupTypesCfg);

	/**
	 * Get M_ShipperPickupTypesCfg.
	 *
	 * @return M_ShipperPickupTypesCfg
	 */
	ForeignEntityInput M_ShipperPickupTypesCfg();
}
