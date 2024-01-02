package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperPackaging;

/**
 * Generated Interface for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShipperPackagingInput extends I_M_ShipperPackaging {

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
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_ShipperInput(I_M_ShipperInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	I_M_ShipperInput M_Shipper();

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
	 * Set M_ShipperPackagingCfg.
	 *
	 * @param M_ShipperPackagingCfg M_ShipperPackagingCfg
	 */
	void setM_ShipperPackagingCfgInput(I_M_ShipperPackagingCfgInput M_ShipperPackagingCfg);

	/**
	 * Get M_ShipperPackagingCfg.
	 *
	 * @return M_ShipperPackagingCfg
	 */
	I_M_ShipperPackagingCfgInput M_ShipperPackagingCfg();
}
