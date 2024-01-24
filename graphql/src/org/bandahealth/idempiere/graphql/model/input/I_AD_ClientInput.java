package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Client;

/**
 * Generated Interface for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ClientInput extends I_AD_Client {

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
	 * Set AutoArchive.
	 *
	 * @param AutoArchive Enable and level of automatic Archive of documents
	 */
	void setAutoArchiveInput(I_AD_Ref_ListInput AutoArchive);

	/**
	 * Get AutoArchive.
	 *
	 * @return Enable and level of automatic Archive of documents
	 */
	I_AD_Ref_ListInput AutoArchive();

	/**
	 * Set MMPolicy.
	 *
	 * @param MMPolicy Material Movement Policy
	 */
	void setMMPolicyInput(I_AD_Ref_ListInput MMPolicy);

	/**
	 * Get MMPolicy.
	 *
	 * @return Material Movement Policy
	 */
	I_AD_Ref_ListInput MMPolicy();
}
