package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShippingProcessor;

/**
 * Generated Interface for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShippingProcessorInput extends I_M_ShippingProcessor {

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
	 * Set M_ShippingProcessorCfg.
	 *
	 * @param M_ShippingProcessorCfg M_ShippingProcessorCfg
	 */
	void setM_ShippingProcessorCfg(I_M_ShippingProcessorCfgInput M_ShippingProcessorCfg);

	/**
	 * Get M_ShippingProcessorCfg.
	 *
	 * @return M_ShippingProcessorCfg
	 */
	I_M_ShippingProcessorCfgInput getM_ShippingProcessorCfg();
}
