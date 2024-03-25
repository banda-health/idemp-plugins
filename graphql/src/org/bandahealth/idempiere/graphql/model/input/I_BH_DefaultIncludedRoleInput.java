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
