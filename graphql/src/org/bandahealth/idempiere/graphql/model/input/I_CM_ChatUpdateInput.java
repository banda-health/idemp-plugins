package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_CM_ChatUpdate;

/**
 * Generated Interface for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_CM_ChatUpdateInput extends I_CM_ChatUpdate {

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
}
