package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Client;

/**
 * Generated Interface for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_ClientInput extends I_AD_Client {

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
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(ForeignEntityInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	ForeignEntityInput AD_Language();

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
	 * Set AD_PasswordRule.
	 *
	 * @param AD_PasswordRule AD_PasswordRule
	 */
	void setAD_PasswordRuleInput(ForeignEntityInput AD_PasswordRule);

	/**
	 * Get AD_PasswordRule.
	 *
	 * @return AD_PasswordRule
	 */
	ForeignEntityInput AD_PasswordRule();

	/**
	 * Set AD_ReplicationStrategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	void setAD_ReplicationStrategyInput(ForeignEntityInput AD_ReplicationStrategy);

	/**
	 * Get AD_ReplicationStrategy.
	 *
	 * @return Data Replication Strategy
	 */
	ForeignEntityInput AD_ReplicationStrategy();

	/**
	 * Set AuthenticationType.
	 *
	 * @param AuthenticationType AuthenticationType
	 */
	void setAuthenticationTypeInput(ForeignEntityInput AuthenticationType);

	/**
	 * Get AuthenticationType.
	 *
	 * @return AuthenticationType
	 */
	ForeignEntityInput AuthenticationType();

	/**
	 * Set AutoArchive.
	 *
	 * @param AutoArchive Enable and level of automatic Archive of documents
	 */
	void setAutoArchiveInput(ForeignEntityInput AutoArchive);

	/**
	 * Get AutoArchive.
	 *
	 * @return Enable and level of automatic Archive of documents
	 */
	ForeignEntityInput AutoArchive();

	/**
	 * Set MMPolicy.
	 *
	 * @param MMPolicy Material Movement Policy
	 */
	void setMMPolicyInput(ForeignEntityInput MMPolicy);

	/**
	 * Get MMPolicy.
	 *
	 * @return Material Movement Policy
	 */
	ForeignEntityInput MMPolicy();
}
