package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperPickupTypesCfg;

/**
 * Generated Interface for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_ShipperPickupTypesCfgInput extends I_M_ShipperPickupTypesCfg {

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
	 * Set M_ShipperCfg.
	 *
	 * @param M_ShipperCfg M_ShipperCfg
	 */
	void setM_ShipperCfgInput(ForeignEntityInput M_ShipperCfg);

	/**
	 * Get M_ShipperCfg.
	 *
	 * @return M_ShipperCfg
	 */
	ForeignEntityInput M_ShipperCfg();

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
}
