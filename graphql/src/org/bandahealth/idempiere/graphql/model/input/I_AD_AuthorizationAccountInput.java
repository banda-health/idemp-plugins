package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AuthorizationAccount;

/**
 * Generated Interface for AD_AuthorizationAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_AuthorizationAccountInput extends I_AD_AuthorizationAccount {

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
	 * Set AD_AuthorizationCredential.
	 *
	 * @param AD_AuthorizationCredential AD_AuthorizationCredential
	 */
	void setAD_AuthorizationCredentialInput(ForeignEntityInput AD_AuthorizationCredential);

	/**
	 * Get AD_AuthorizationCredential.
	 *
	 * @return AD_AuthorizationCredential
	 */
	ForeignEntityInput AD_AuthorizationCredential();

	/**
	 * Set AD_AuthorizationScopes.
	 *
	 * @param AD_AuthorizationScopes AD_AuthorizationScopes
	 */
	void setAD_AuthorizationScopesInput(ForeignEntityInput AD_AuthorizationScopes);

	/**
	 * Get AD_AuthorizationScopes.
	 *
	 * @return AD_AuthorizationScopes
	 */
	ForeignEntityInput AD_AuthorizationScopes();

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();
}
