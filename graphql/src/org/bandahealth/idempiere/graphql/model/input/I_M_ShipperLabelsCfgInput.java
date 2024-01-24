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
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

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
