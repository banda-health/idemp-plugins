package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_DefaultIncludedRole;

/**
 * Generated Interface for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_BH_DefaultIncludedRoleInput extends I_BH_DefaultIncludedRole {

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

	/**
	 * Set Included_Role.
	 *
	 * @param Included_Role Included_Role
	 */
	void setIncluded_RoleInput(ForeignEntityInput Included_Role);

	/**
	 * Get Included_Role.
	 *
	 * @return Included_Role
	 */
	ForeignEntityInput Included_Role();
}
