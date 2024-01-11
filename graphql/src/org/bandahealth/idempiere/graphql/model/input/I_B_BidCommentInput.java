package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_B_BidComment;

/**
 * Generated Interface for B_BidComment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_B_BidCommentInput extends I_B_BidComment {

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
