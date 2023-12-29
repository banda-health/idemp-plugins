package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_TaxProvider;

/**
 * Generated Interface for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_TaxProviderInput extends I_C_TaxProvider {

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
	 * Set C_TaxProviderCfg.
	 *
	 * @param C_TaxProviderCfg C_TaxProviderCfg
	 */
	void setC_TaxProviderCfg(I_C_TaxProviderCfgInput C_TaxProviderCfg);

	/**
	 * Get C_TaxProviderCfg.
	 *
	 * @return C_TaxProviderCfg
	 */
	I_C_TaxProviderCfgInput getC_TaxProviderCfg();
}
