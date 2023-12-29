package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Shipper;

/**
 * Generated Interface for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShipperInput extends I_M_Shipper {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

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
	 * Set M_ShipperCfg.
	 *
	 * @param M_ShipperCfg M_ShipperCfg
	 */
	void setM_ShipperCfg(I_M_ShipperCfgInput M_ShipperCfg);

	/**
	 * Get M_ShipperCfg.
	 *
	 * @return M_ShipperCfg
	 */
	I_M_ShipperCfgInput getM_ShipperCfg();

	/**
	 * Set M_ShippingProcessor.
	 *
	 * @param M_ShippingProcessor M_ShippingProcessor
	 */
	void setM_ShippingProcessor(I_M_ShippingProcessorInput M_ShippingProcessor);

	/**
	 * Get M_ShippingProcessor.
	 *
	 * @return M_ShippingProcessor
	 */
	I_M_ShippingProcessorInput getM_ShippingProcessor();
}
