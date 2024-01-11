package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_CM_Chat;

/**
 * Generated Interface for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_CM_ChatInput extends I_CM_Chat {

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
	 * Set CM_ChatType.
	 *
	 * @param CM_ChatType Type of discussion / chat
	 */
	void setCM_ChatTypeInput(ForeignEntityInput CM_ChatType);

	/**
	 * Get CM_ChatType.
	 *
	 * @return Type of discussion / chat
	 */
	ForeignEntityInput CM_ChatType();

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
	 * Set ModerationType.
	 *
	 * @param ModerationType Type of moderation
	 */
	void setModerationTypeInput(I_AD_Ref_ListInput ModerationType);

	/**
	 * Get ModerationType.
	 *
	 * @return Type of moderation
	 */
	I_AD_Ref_ListInput ModerationType();
}
