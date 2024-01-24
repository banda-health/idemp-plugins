package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_SubscriptionType;

/**
 * Generated Interface for C_SubscriptionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_SubscriptionTypeInput extends I_C_SubscriptionType {

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
	 * Set FrequencyType.
	 *
	 * @param FrequencyType Frequency of event
	 */
	void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType);

	/**
	 * Get FrequencyType.
	 *
	 * @return Frequency of event
	 */
	I_AD_Ref_ListInput FrequencyType();
}
