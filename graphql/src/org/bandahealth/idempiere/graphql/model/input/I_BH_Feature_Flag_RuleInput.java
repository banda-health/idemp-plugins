package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Feature_Flag_Rule;

/**
 * Generated Interface for BH_Feature_Flag_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Feature_Flag_RuleInput extends I_BH_Feature_Flag_Rule {

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
	 * Set BH_Environment.
	 *
	 * @param BH_Environment BH_Environment
	 */
	void setBH_EnvironmentInput(ForeignEntityInput BH_Environment);

	/**
	 * Get BH_Environment.
	 *
	 * @return BH_Environment
	 */
	ForeignEntityInput BH_Environment();

	/**
	 * Set BH_Feature_Flag.
	 *
	 * @param BH_Feature_Flag BH_Feature_Flag
	 */
	void setBH_Feature_FlagInput(ForeignEntityInput BH_Feature_Flag);

	/**
	 * Get BH_Feature_Flag.
	 *
	 * @return BH_Feature_Flag
	 */
	ForeignEntityInput BH_Feature_Flag();

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
	 * Set BH_Rule_Client.
	 *
	 * @param BH_Rule_Client BH_Rule_Client
	 */
	void setBH_Rule_ClientInput(ForeignEntityInput BH_Rule_Client);

	/**
	 * Get BH_Rule_Client.
	 *
	 * @return BH_Rule_Client
	 */
	ForeignEntityInput BH_Rule_Client();

	/**
	 * Set BH_Rule_Role.
	 *
	 * @param BH_Rule_Role BH_Rule_Role
	 */
	void setBH_Rule_RoleInput(ForeignEntityInput BH_Rule_Role);

	/**
	 * Get BH_Rule_Role.
	 *
	 * @return BH_Rule_Role
	 */
	ForeignEntityInput BH_Rule_Role();

	/**
	 * Set BH_Rule_User.
	 *
	 * @param BH_Rule_User BH_Rule_User
	 */
	void setBH_Rule_UserInput(ForeignEntityInput BH_Rule_User);

	/**
	 * Get BH_Rule_User.
	 *
	 * @return BH_Rule_User
	 */
	ForeignEntityInput BH_Rule_User();
}
