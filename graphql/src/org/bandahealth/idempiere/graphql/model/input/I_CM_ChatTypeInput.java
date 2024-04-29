package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_CM_ChatType;

/**
 * Generated Interface for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_CM_ChatTypeInput extends I_CM_ChatType {

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
	 * Set ModerationType.
	 *
	 * @param ModerationType Type of moderation
	 */
	void setModerationTypeInput(ForeignEntityInput ModerationType);

	/**
	 * Get ModerationType.
	 *
	 * @return Type of moderation
	 */
	ForeignEntityInput ModerationType();
}
