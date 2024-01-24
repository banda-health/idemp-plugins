package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Subscription_Delivery;

/**
 * Generated Interface for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_Subscription_DeliveryInput extends I_C_Subscription_Delivery {

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
	 * Set C_Subscription.
	 *
	 * @param C_Subscription Subscription of a Business Partner of a Product to renew
	 */
	void setC_SubscriptionInput(ForeignEntityInput C_Subscription);

	/**
	 * Get C_Subscription.
	 *
	 * @return Subscription of a Business Partner of a Product to renew
	 */
	ForeignEntityInput C_Subscription();
}
