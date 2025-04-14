package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_TaxProvider;

/**
 * Generated Interface for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_TaxProviderInput extends I_C_TaxProvider {

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
