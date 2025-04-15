package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Message;

/**
 * Generated Interface for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_MessageInput extends I_AD_Message {

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
	void setMsgTypeInput(ForeignEntityInput MsgType);

	/**
	 * Get MsgType.
	 *
	 * @return Type of message (Informational, Menu or Error)
	 */
	ForeignEntityInput MsgType();
}
