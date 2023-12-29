package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Message;

/**
 * Generated Interface for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_MessageInput extends I_AD_Message {

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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set MsgType_RL.
	 *
	 * @param MsgType_RL Type of message (Informational, Menu or Error)
	 */
	void setMsgType_RL(I_AD_Ref_ListInput MsgType_RL);

	/**
	 * Get MsgType_RL.
	 *
	 * @return Type of message (Informational, Menu or Error)
	 */
	I_AD_Ref_ListInput getMsgType_RL();
}
