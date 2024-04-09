package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Table_Access;

/**
 * Generated Interface for AD_Table_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Table_AccessInput extends I_AD_Table_Access {

	/**
	 * Set AccessTypeRule.
	 *
	 * @param AccessTypeRule The type of access for this rule
	 */
	void setAccessTypeRuleInput(I_AD_Ref_ListInput AccessTypeRule);

	/**
	 * Get AccessTypeRule.
	 *
	 * @return The type of access for this rule
	 */
	I_AD_Ref_ListInput AccessTypeRule();

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
}
