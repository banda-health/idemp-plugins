package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Subscription_Delivery;

/**
 * Generated Interface for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_Subscription_DeliveryInput extends I_C_Subscription_Delivery {

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
