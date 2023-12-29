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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	 * Set FrequencyType_RL.
	 *
	 * @param FrequencyType_RL Frequency of event
	 */
	void setFrequencyType_RL(I_AD_Ref_ListInput FrequencyType_RL);

	/**
	 * Get FrequencyType_RL.
	 *
	 * @return Frequency of event
	 */
	I_AD_Ref_ListInput getFrequencyType_RL();
}
