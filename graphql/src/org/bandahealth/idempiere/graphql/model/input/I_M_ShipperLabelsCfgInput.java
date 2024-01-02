package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperLabelsCfg;

/**
 * Generated Interface for M_ShipperLabelsCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShipperLabelsCfgInput extends I_M_ShipperLabelsCfg {

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
	 * Set LabelPrintMethod.
	 *
	 * @param LabelPrintMethod LabelPrintMethod
	 */
	void setLabelPrintMethodInput(I_AD_Ref_ListInput LabelPrintMethod);

	/**
	 * Get LabelPrintMethod.
	 *
	 * @return LabelPrintMethod
	 */
	I_AD_Ref_ListInput LabelPrintMethod();

	/**
	 * Set M_ShipperCfg.
	 *
	 * @param M_ShipperCfg M_ShipperCfg
	 */
	void setM_ShipperCfgInput(I_M_ShipperCfgInput M_ShipperCfg);

	/**
	 * Get M_ShipperCfg.
	 *
	 * @return M_ShipperCfg
	 */
	I_M_ShipperCfgInput M_ShipperCfg();

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
