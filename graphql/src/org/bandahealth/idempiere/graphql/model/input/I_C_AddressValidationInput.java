package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AddressValidation;

/**
 * Generated Interface for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_AddressValidationInput extends I_C_AddressValidation {

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
	 * Set C_AddressValidationCfg.
	 *
	 * @param C_AddressValidationCfg C_AddressValidationCfg
	 */
	void setC_AddressValidationCfgInput(ForeignEntityInput C_AddressValidationCfg);

	/**
	 * Get C_AddressValidationCfg.
	 *
	 * @return C_AddressValidationCfg
	 */
	ForeignEntityInput C_AddressValidationCfg();
}
