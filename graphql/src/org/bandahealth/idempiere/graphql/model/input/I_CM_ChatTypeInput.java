package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_CM_ChatType;

/**
 * Generated Interface for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_CM_ChatTypeInput extends I_CM_ChatType {

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
