package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AuthorizationCredential;

/**
 * Generated Interface for AD_AuthorizationCredential - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_AuthorizationCredentialInput extends I_AD_AuthorizationCredential {

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
	 * Set AD_AuthorizationProvider.
	 *
	 * @param AD_AuthorizationProvider AD_AuthorizationProvider
	 */
	void setAD_AuthorizationProviderInput(ForeignEntityInput AD_AuthorizationProvider);

	/**
	 * Get AD_AuthorizationProvider.
	 *
	 * @return AD_AuthorizationProvider
	 */
	ForeignEntityInput AD_AuthorizationProvider();

	/**
	 * Set AD_AuthorizationScopeList.
	 *
	 * @param AD_AuthorizationScopeList AD_AuthorizationScopeList
	 */
	void setAD_AuthorizationScopeListInput(ForeignEntityInput AD_AuthorizationScopeList);

	/**
	 * Get AD_AuthorizationScopeList.
	 *
	 * @return AD_AuthorizationScopeList
	 */
	ForeignEntityInput AD_AuthorizationScopeList();

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
}
