package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MTree;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RoleInput extends X_AD_Role implements I_AD_RoleInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput PreferenceType_RL;
	 private I_AD_Ref_ListInput RoleType_RL;
	 private I_AD_Ref_ListInput UserLevel_RL;
	 private I_AD_TreeInput AD_Tree_Menu;
	 private I_AD_TreeInput AD_Tree_Org;
	 private I_AD_UserInput Supervisor;
	 private I_C_CurrencyInput C_Currency;

	/**
	 * Standard constructor
	 */
	public X_AD_RoleInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}
	/**
	 * Set Role.
	 *
	 * @param AD_Role_ID Responsibility Role
	 */

	public void setAD_Role_ID(int AD_Role_ID) {
		if (get_ID() == 0) {
			super.setAD_Role_ID(AD_Role_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Role_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Role_UU();
	}

	/**
	 * Set Menu Tree.
	 *
	 * @param AD_Tree_Menu Tree of the menu
	 */
	public void setAD_Tree_Menu(I_AD_TreeInput AD_Tree_Menu) {
		this.AD_Tree_Menu = AD_Tree_Menu;
		MTree foreignEntity;
		if (AD_Tree_Menu != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Menu.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Menu_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Menu_ID(0);
		}
	}

	/**
	 * Get Menu Tree.
	 *
	 * @return Tree of the menu
	 */
	public I_AD_TreeInput getAD_Tree_Menu() {
		return AD_Tree_Menu;
	}
	/**
	 * Set Menu Tree.
	 *
	 * @param AD_Tree_Menu_ID Tree of the menu
	 */

	public void setAD_Tree_Menu_ID(int AD_Tree_Menu_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Menu_ID(AD_Tree_Menu_ID);
		}
	}

	/**
	 * Set Organization Tree.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	public void setAD_Tree_Org(I_AD_TreeInput AD_Tree_Org) {
		this.AD_Tree_Org = AD_Tree_Org;
		MTree foreignEntity;
		if (AD_Tree_Org != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Org_ID(0);
		}
	}

	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	public I_AD_TreeInput getAD_Tree_Org() {
		return AD_Tree_Org;
	}
	/**
	 * Set Organization Tree.
	 *
	 * @param AD_Tree_Org_ID Trees are used for (financial) reporting and security access (via role)
	 */

	public void setAD_Tree_Org_ID(int AD_Tree_Org_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Org_ID(AD_Tree_Org_ID);
		}
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Preference Level.
	 *
	 * @param PreferenceType_RL Determines what preferences the user can set
	 */
	public void setPreferenceType_RL(I_AD_Ref_ListInput PreferenceType_RL) {
		this.PreferenceType_RL = PreferenceType_RL;
		MRefList foreignEntity;
		if (PreferenceType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PreferenceType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPreferenceType(foreignEntity.getValue());
		} else {
			this.setPreferenceType(null);
		}
	}

	/**
	 * Get Preference Level.
	 *
	 * @return Determines what preferences the user can set
	 */
	public I_AD_Ref_ListInput getPreferenceType_RL() {
		return PreferenceType_RL;
	}

	/**
	 * Set Role Type.
	 *
	 * @param RoleType_RL Role Type
	 */
	public void setRoleType_RL(I_AD_Ref_ListInput RoleType_RL) {
		this.RoleType_RL = RoleType_RL;
		MRefList foreignEntity;
		if (RoleType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RoleType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRoleType(foreignEntity.getValue());
		} else {
			this.setRoleType(null);
		}
	}

	/**
	 * Get Role Type.
	 *
	 * @return Role Type
	 */
	public I_AD_Ref_ListInput getRoleType_RL() {
		return RoleType_RL;
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	public void setSupervisor(I_AD_UserInput Supervisor) {
		this.Supervisor = Supervisor;
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(Supervisor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSupervisor_ID(foreignEntity.get_ID());
		} else {
			this.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public I_AD_UserInput getSupervisor() {
		return Supervisor;
	}
	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor_ID Supervisor for this user/organization - used for escalation and approval
	 */

	public void setSupervisor_ID(int Supervisor_ID) {
		if (get_ID() == 0) {
			super.setSupervisor_ID(Supervisor_ID);
		}
	}

	/**
	 * Set User Level.
	 *
	 * @param UserLevel_RL System Client Organization
	 */
	public void setUserLevel_RL(I_AD_Ref_ListInput UserLevel_RL) {
		this.UserLevel_RL = UserLevel_RL;
		MRefList foreignEntity;
		if (UserLevel_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(UserLevel_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUserLevel(foreignEntity.getValue());
		} else {
			this.setUserLevel(null);
		}
	}

	/**
	 * Get User Level.
	 *
	 * @return System Client Organization
	 */
	public I_AD_Ref_ListInput getUserLevel_RL() {
		return UserLevel_RL;
	}
}
