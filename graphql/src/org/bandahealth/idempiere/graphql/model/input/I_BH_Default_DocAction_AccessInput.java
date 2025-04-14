package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Default_DocAction_Access;

/**
 * Generated Interface for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_BH_Default_DocAction_AccessInput extends I_BH_Default_DocAction_Access {

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
	void setDB_UserTypeInput(ForeignEntityInput DB_UserType);

	/**
	 * Get DB_UserType.
	 *
	 * @return The User Type when a new client is created
	 */
	ForeignEntityInput DB_UserType();
}
