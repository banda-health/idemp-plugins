package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Rule;

/**
 * Generated Interface for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_RuleInput extends I_AD_Rule {

	/**
	 * Set AccessLevel.
	 *
	 * @param AccessLevel Access Level required
	 */
	void setAccessLevelInput(I_AD_Ref_ListInput AccessLevel);

	/**
	 * Get AccessLevel.
	 *
	 * @return Access Level required
	 */
	I_AD_Ref_ListInput AccessLevel();

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
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set EventType.
	 *
	 * @param EventType Type of Event
	 */
	void setEventTypeInput(I_AD_Ref_ListInput EventType);

	/**
	 * Get EventType.
	 *
	 * @return Type of Event
	 */
	I_AD_Ref_ListInput EventType();

	/**
	 * Set RuleType.
	 *
	 * @param RuleType RuleType
	 */
	void setRuleTypeInput(I_AD_Ref_ListInput RuleType);

	/**
	 * Get RuleType.
	 *
	 * @return RuleType
	 */
	I_AD_Ref_ListInput RuleType();
}
