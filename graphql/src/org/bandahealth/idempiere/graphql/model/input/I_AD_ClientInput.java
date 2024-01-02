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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(I_AD_LanguageInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	I_AD_LanguageInput AD_Language();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_PasswordRule.
	 *
	 * @param AD_PasswordRule AD_PasswordRule
	 */
	void setAD_PasswordRuleInput(I_AD_PasswordRuleInput AD_PasswordRule);

	/**
	 * Get AD_PasswordRule.
	 *
	 * @return AD_PasswordRule
	 */
	I_AD_PasswordRuleInput AD_PasswordRule();

	/**
	 * Set AD_ReplicationStrategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	void setAD_ReplicationStrategyInput(I_AD_ReplicationStrategyInput AD_ReplicationStrategy);

	/**
	 * Get AD_ReplicationStrategy.
	 *
	 * @return Data Replication Strategy
	 */
	I_AD_ReplicationStrategyInput AD_ReplicationStrategy();

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
