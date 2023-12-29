package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperPickupTypes;

/**
 * Generated Interface for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShipperPickupTypesInput extends I_M_ShipperPickupTypes {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_Shipper(I_M_ShipperInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	I_M_ShipperInput getM_Shipper();

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
	 * Set M_ShipperPickupTypesCfg.
	 *
	 * @param M_ShipperPickupTypesCfg M_ShipperPickupTypesCfg
	 */
	void setM_ShipperPickupTypesCfg(I_M_ShipperPickupTypesCfgInput M_ShipperPickupTypesCfg);

	/**
	 * Get M_ShipperPickupTypesCfg.
	 *
	 * @return M_ShipperPickupTypesCfg
	 */
	I_M_ShipperPickupTypesCfgInput getM_ShipperPickupTypesCfg();
}
