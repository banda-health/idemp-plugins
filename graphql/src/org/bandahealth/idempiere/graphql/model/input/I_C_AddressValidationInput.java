package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AddressValidation;

/**
 * Generated Interface for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_AddressValidationInput extends I_C_AddressValidation {

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
