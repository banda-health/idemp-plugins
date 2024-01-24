package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Note;

/**
 * Generated Interface for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_NoteInput extends I_AD_Note {

	/**
	 * Set AD_BroadcastMessage.
	 *
	 * @param AD_BroadcastMessage Broadcast Message
	 */
	void setAD_BroadcastMessageInput(ForeignEntityInput AD_BroadcastMessage);

	/**
	 * Get AD_BroadcastMessage.
	 *
	 * @return Broadcast Message
	 */
	ForeignEntityInput AD_BroadcastMessage();

	/**
	 * Set AD_Message.
	 *
	 * @param AD_Message System Message
	 */
	void setAD_MessageInput(ForeignEntityInput AD_Message);

	/**
	 * Get AD_Message.
	 *
	 * @return System Message
	 */
	ForeignEntityInput AD_Message();

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

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
	 * Set AD_WF_Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	void setAD_WF_ActivityInput(ForeignEntityInput AD_WF_Activity);

	/**
	 * Get AD_WF_Activity.
	 *
	 * @return Workflow Activity
	 */
	ForeignEntityInput AD_WF_Activity();
}
