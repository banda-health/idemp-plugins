package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_B_Offer;

/**
 * Generated Interface for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_B_OfferInput extends I_B_Offer {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

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
	 * Set B_SellerFunds.
	 *
	 * @param B_SellerFunds Seller Funds from Offers on Topics
	 */
	void setB_SellerFundsInput(ForeignEntityInput B_SellerFunds);

	/**
	 * Get B_SellerFunds.
	 *
	 * @return Seller Funds from Offers on Topics
	 */
	ForeignEntityInput B_SellerFunds();

	/**
	 * Set B_Topic.
	 *
	 * @param B_Topic Auction Topic
	 */
	void setB_TopicInput(ForeignEntityInput B_Topic);

	/**
	 * Get B_Topic.
	 *
	 * @return Auction Topic
	 */
	ForeignEntityInput B_Topic();
}
