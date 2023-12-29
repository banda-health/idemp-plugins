package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Role;

/**
 * Generated Interface for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_RoleInput extends I_AD_Role {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	 * Set AD_Tree_Menu.
	 *
	 * @param AD_Tree_Menu Tree of the menu
	 */
	void setAD_Tree_Menu(I_AD_TreeInput AD_Tree_Menu);

	/**
	 * Get AD_Tree_Menu.
	 *
	 * @return Tree of the menu
	 */
	I_AD_TreeInput getAD_Tree_Menu();

	/**
	 * Set AD_Tree_Org.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	void setAD_Tree_Org(I_AD_TreeInput AD_Tree_Org);

	/**
	 * Get AD_Tree_Org.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	I_AD_TreeInput getAD_Tree_Org();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set PreferenceType_RL.
	 *
	 * @param PreferenceType_RL Determines what preferences the user can set
	 */
	void setPreferenceType_RL(I_AD_Ref_ListInput PreferenceType_RL);

	/**
	 * Get PreferenceType_RL.
	 *
	 * @return Determines what preferences the user can set
	 */
	I_AD_Ref_ListInput getPreferenceType_RL();

	/**
	 * Set RoleType_RL.
	 *
	 * @param RoleType_RL RoleType_RL
	 */
	void setRoleType_RL(I_AD_Ref_ListInput RoleType_RL);

	/**
	 * Get RoleType_RL.
	 *
	 * @return RoleType_RL
	 */
	I_AD_Ref_ListInput getRoleType_RL();

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisor(I_AD_UserInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	I_AD_UserInput getSupervisor();

	/**
	 * Set UserLevel_RL.
	 *
	 * @param UserLevel_RL System Client Organization
	 */
	void setUserLevel_RL(I_AD_Ref_ListInput UserLevel_RL);

	/**
	 * Get UserLevel_RL.
	 *
	 * @return System Client Organization
	 */
	I_AD_Ref_ListInput getUserLevel_RL();
}
