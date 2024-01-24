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
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set MsgType.
	 *
	 * @param MsgType Type of message (Informational, Menu or Error)
	 */
	void setMsgTypeInput(I_AD_Ref_ListInput MsgType);

	/**
	 * Get MsgType.
	 *
	 * @return Type of message (Informational, Menu or Error)
	 */
	I_AD_Ref_ListInput MsgType();
}
