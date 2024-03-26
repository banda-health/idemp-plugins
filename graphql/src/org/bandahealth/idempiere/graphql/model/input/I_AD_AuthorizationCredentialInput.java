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
	void setAD_AuthorizationScopeListInput(I_AD_Ref_ListInput AD_AuthorizationScopeList);

	/**
	 * Get AD_AuthorizationScopeList.
	 *
	 * @return AD_AuthorizationScopeList
	 */
	I_AD_Ref_ListInput AD_AuthorizationScopeList();

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
