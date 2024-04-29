package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShippingProcessor;

/**
 * Generated Interface for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_ShippingProcessorInput extends I_M_ShippingProcessor {

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
	 * Set M_ShippingProcessorCfg.
	 *
	 * @param M_ShippingProcessorCfg M_ShippingProcessorCfg
	 */
	void setM_ShippingProcessorCfgInput(ForeignEntityInput M_ShippingProcessorCfg);

	/**
	 * Get M_ShippingProcessorCfg.
	 *
	 * @return M_ShippingProcessorCfg
	 */
	ForeignEntityInput M_ShippingProcessorCfg();
}
