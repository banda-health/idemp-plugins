package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_CM_ChatTypeUpdate;

/**
 * Generated Interface for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_CM_ChatTypeUpdateInput extends I_CM_ChatTypeUpdate {

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
}
