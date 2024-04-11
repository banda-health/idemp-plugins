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
	void setLabelPrintMethodInput(ForeignEntityInput LabelPrintMethod);

	/**
	 * Get LabelPrintMethod.
	 *
	 * @return LabelPrintMethod
	 */
	ForeignEntityInput LabelPrintMethod();

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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

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
