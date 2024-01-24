package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_RMATax;

/**
 * Generated Interface for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_RMATaxInput extends I_M_RMATax {

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
	 * Set C_Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	void setC_TaxInput(ForeignEntityInput C_Tax);

	/**
	 * Get C_Tax.
	 *
	 * @return Tax identifier
	 */
	ForeignEntityInput C_Tax();

	/**
	 * Set C_TaxProvider.
	 *
	 * @param C_TaxProvider C_TaxProvider
	 */
	void setC_TaxProviderInput(ForeignEntityInput C_TaxProvider);

	/**
	 * Get C_TaxProvider.
	 *
	 * @return C_TaxProvider
	 */
	ForeignEntityInput C_TaxProvider();

	/**
	 * Set M_RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	void setM_RMAInput(ForeignEntityInput M_RMA);

	/**
	 * Get M_RMA.
	 *
	 * @return Return Material Authorization
	 */
	ForeignEntityInput M_RMA();

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
}
