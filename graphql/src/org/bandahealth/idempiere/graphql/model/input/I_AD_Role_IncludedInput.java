package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Role_Included;

/**
 * Generated Interface for AD_Role_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Role_IncludedInput extends I_AD_Role_Included {

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
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

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
