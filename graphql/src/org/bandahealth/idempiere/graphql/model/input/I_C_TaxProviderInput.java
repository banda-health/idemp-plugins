package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_TaxProvider;

/**
 * Generated Interface for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_TaxProviderInput extends I_C_TaxProvider {

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
	 * Set C_TaxProviderCfg.
	 *
	 * @param C_TaxProviderCfg C_TaxProviderCfg
	 */
	void setC_TaxProviderCfgInput(ForeignEntityInput C_TaxProviderCfg);

	/**
	 * Get C_TaxProviderCfg.
	 *
	 * @return C_TaxProviderCfg
	 */
	ForeignEntityInput C_TaxProviderCfg();
}
