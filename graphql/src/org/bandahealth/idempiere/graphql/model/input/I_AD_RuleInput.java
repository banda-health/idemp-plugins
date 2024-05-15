package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Rule;

/**
 * Generated Interface for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_RuleInput extends I_AD_Rule {

	/**
	 * Set AccessLevel.
	 *
	 * @param AccessLevel Access Level required
	 */
	void setAccessLevelInput(ForeignEntityInput AccessLevel);

	/**
	 * Get AccessLevel.
	 *
	 * @return Access Level required
	 */
	ForeignEntityInput AccessLevel();

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
	void setEventTypeInput(ForeignEntityInput EventType);

	/**
	 * Get EventType.
	 *
	 * @return Type of Event
	 */
	ForeignEntityInput EventType();

	/**
	 * Set RuleType.
	 *
	 * @param RuleType RuleType
	 */
	void setRuleTypeInput(ForeignEntityInput RuleType);

	/**
	 * Get RuleType.
	 *
	 * @return RuleType
	 */
	ForeignEntityInput RuleType();
}
