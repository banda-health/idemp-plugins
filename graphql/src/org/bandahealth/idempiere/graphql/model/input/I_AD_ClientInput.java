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
	 * Set AD_Language_L.
	 *
	 * @param AD_Language_L Language for this entity
	 */
	void setAD_Language_L(I_AD_LanguageInput AD_Language_L);

	/**
	 * Get AD_Language_L.
	 *
	 * @return Language for this entity
	 */
	I_AD_LanguageInput getAD_Language_L();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_PasswordRule.
	 *
	 * @param AD_PasswordRule AD_PasswordRule
	 */
	void setAD_PasswordRule(I_AD_PasswordRuleInput AD_PasswordRule);

	/**
	 * Get AD_PasswordRule.
	 *
	 * @return AD_PasswordRule
	 */
	I_AD_PasswordRuleInput getAD_PasswordRule();

	/**
	 * Set AD_ReplicationStrategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	void setAD_ReplicationStrategy(I_AD_ReplicationStrategyInput AD_ReplicationStrategy);

	/**
	 * Get AD_ReplicationStrategy.
	 *
	 * @return Data Replication Strategy
	 */
	I_AD_ReplicationStrategyInput getAD_ReplicationStrategy();

	/**
	 * Set AutoArchive_RL.
	 *
	 * @param AutoArchive_RL Enable and level of automatic Archive of documents
	 */
	void setAutoArchive_RL(I_AD_Ref_ListInput AutoArchive_RL);

	/**
	 * Get AutoArchive_RL.
	 *
	 * @return Enable and level of automatic Archive of documents
	 */
	I_AD_Ref_ListInput getAutoArchive_RL();

	/**
	 * Set MMPolicy_RL.
	 *
	 * @param MMPolicy_RL Material Movement Policy
	 */
	void setMMPolicy_RL(I_AD_Ref_ListInput MMPolicy_RL);

	/**
	 * Get MMPolicy_RL.
	 *
	 * @return Material Movement Policy
	 */
	I_AD_Ref_ListInput getMMPolicy_RL();
}
