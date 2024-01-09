package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperPackagingCfg;

/**
 * Generated Interface for M_ShipperPackagingCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShipperPackagingCfgInput extends I_M_ShipperPackagingCfg {

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
}
