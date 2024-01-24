package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Default_DocAction_Access;

/**
 * Generated Interface for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_Default_DocAction_AccessInput extends I_BH_Default_DocAction_Access {

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
	 * Set AD_Ref_List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List);

	/**
	 * Get AD_Ref_List.
	 *
	 * @return Reference List based on Table
	 */
	ForeignEntityInput AD_Ref_List();

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
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(ForeignEntityInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	ForeignEntityInput C_DocType();

	/**
	 * Set DB_UserType.
	 *
	 * @param DB_UserType The User Type when a new client is created
	 */
	void setDB_UserTypeInput(I_AD_Ref_ListInput DB_UserType);

	/**
	 * Get DB_UserType.
	 *
	 * @return The User Type when a new client is created
	 */
	I_AD_Ref_ListInput DB_UserType();
}
