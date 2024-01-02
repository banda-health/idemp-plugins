package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShipperLabels;

/**
 * Generated Interface for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShipperLabelsInput extends I_M_ShipperLabels {

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
	 * Set M_ShipperLabelsCfg.
	 *
	 * @param M_ShipperLabelsCfg M_ShipperLabelsCfg
	 */
	void setM_ShipperLabelsCfgInput(I_M_ShipperLabelsCfgInput M_ShipperLabelsCfg);

	/**
	 * Get M_ShipperLabelsCfg.
	 *
	 * @return M_ShipperLabelsCfg
	 */
	I_M_ShipperLabelsCfgInput M_ShipperLabelsCfg();
}
