package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperLabels;

/**
 * Generated Interface for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_ShipperLabelsInput extends I_M_ShipperLabels {

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
	 * Set M_ShipperLabelsCfg.
	 *
	 * @param M_ShipperLabelsCfg M_ShipperLabelsCfg
	 */
	void setM_ShipperLabelsCfgInput(ForeignEntityInput M_ShipperLabelsCfg);

	/**
	 * Get M_ShipperLabelsCfg.
	 *
	 * @return M_ShipperLabelsCfg
	 */
	ForeignEntityInput M_ShipperLabelsCfg();
}
