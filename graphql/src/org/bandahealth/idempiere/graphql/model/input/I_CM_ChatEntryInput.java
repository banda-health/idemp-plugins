package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_CM_ChatEntry;

/**
 * Generated Interface for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_CM_ChatEntryInput extends I_CM_ChatEntry {

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
	 * Set ChatEntryType.
	 *
	 * @param ChatEntryType Type of Chat/Forum Entry
	 */
	void setChatEntryTypeInput(I_AD_Ref_ListInput ChatEntryType);

	/**
	 * Get ChatEntryType.
	 *
	 * @return Type of Chat/Forum Entry
	 */
	I_AD_Ref_ListInput ChatEntryType();

	/**
	 * Set CM_Chat.
	 *
	 * @param CM_Chat Chat or discussion thread
	 */
	void setCM_ChatInput(ForeignEntityInput CM_Chat);

	/**
	 * Get CM_Chat.
	 *
	 * @return Chat or discussion thread
	 */
	ForeignEntityInput CM_Chat();

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
	 * Set CM_ChatEntryGrandParent.
	 *
	 * @param CM_ChatEntryGrandParent Link to Grand Parent (root level)
	 */
	void setCM_ChatEntryGrandParentInput(ForeignEntityInput CM_ChatEntryGrandParent);

	/**
	 * Get CM_ChatEntryGrandParent.
	 *
	 * @return Link to Grand Parent (root level)
	 */
	ForeignEntityInput CM_ChatEntryGrandParent();

	/**
	 * Set CM_ChatEntryParent.
	 *
	 * @param CM_ChatEntryParent Link to direct Parent
	 */
	void setCM_ChatEntryParentInput(ForeignEntityInput CM_ChatEntryParent);

	/**
	 * Get CM_ChatEntryParent.
	 *
	 * @return Link to direct Parent
	 */
	ForeignEntityInput CM_ChatEntryParent();

	/**
	 * Set ConfidentialType.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType);

	/**
	 * Get ConfidentialType.
	 *
	 * @return Type of Confidentiality
	 */
	I_AD_Ref_ListInput ConfidentialType();

	/**
	 * Set ModeratorStatus.
	 *
	 * @param ModeratorStatus Status of Moderation
	 */
	void setModeratorStatusInput(I_AD_Ref_ListInput ModeratorStatus);

	/**
	 * Get ModeratorStatus.
	 *
	 * @return Status of Moderation
	 */
	I_AD_Ref_ListInput ModeratorStatus();
}
