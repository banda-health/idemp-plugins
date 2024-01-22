package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Role;

/**
 * Generated Interface for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_RoleInput extends I_AD_Role {

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
	void setAD_Tree_MenuInput(ForeignEntityInput AD_Tree_Menu);

	/**
	 * Get AD_Tree_Menu.
	 *
	 * @return Tree of the menu
	 */
	ForeignEntityInput AD_Tree_Menu();

	/**
	 * Set AD_Tree_Org.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	void setAD_Tree_OrgInput(ForeignEntityInput AD_Tree_Org);

	/**
	 * Get AD_Tree_Org.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	ForeignEntityInput AD_Tree_Org();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set PreferenceType.
	 *
	 * @param PreferenceType Determines what preferences the user can set
	 */
	void setPreferenceTypeInput(I_AD_Ref_ListInput PreferenceType);

	/**
	 * Get PreferenceType.
	 *
	 * @return Determines what preferences the user can set
	 */
	I_AD_Ref_ListInput PreferenceType();

	/**
	 * Set RoleType.
	 *
	 * @param RoleType RoleType
	 */
	void setRoleTypeInput(I_AD_Ref_ListInput RoleType);

	/**
	 * Get RoleType.
	 *
	 * @return RoleType
	 */
	I_AD_Ref_ListInput RoleType();

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisorInput(ForeignEntityInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	ForeignEntityInput Supervisor();

	/**
	 * Set UserLevel.
	 *
	 * @param UserLevel System Client Organization
	 */
	void setUserLevelInput(I_AD_Ref_ListInput UserLevel);

	/**
	 * Get UserLevel.
	 *
	 * @return System Client Organization
	 */
	I_AD_Ref_ListInput UserLevel();
}
