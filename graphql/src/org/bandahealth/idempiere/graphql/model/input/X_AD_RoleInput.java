package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
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

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mAD_Tree_Menu;
	 private ForeignEntityInput mAD_Tree_Org;
	 private ForeignEntityInput mC_Currency;
	 private ForeignEntityInput mSupervisor;
	 private I_AD_Ref_ListInput mPreferenceType;
	 private I_AD_Ref_ListInput mRoleType;
	 private I_AD_Ref_ListInput mUserLevel;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_RoleInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
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
	@JsonProperty("AD_Tree_Menu")
	public void setAD_Tree_MenuInput(ForeignEntityInput AD_Tree_Menu) {
		this.mAD_Tree_Menu = AD_Tree_Menu;
		MTree foreignEntity;
		if (AD_Tree_Menu != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Menu.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Menu_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Menu_ID(0);
		}
	}

	/**
	 * Get Menu Tree.
	 *
	 * @return Tree of the menu
	 */
	@JsonProperty("AD_Tree_Menu")
	public ForeignEntityInput AD_Tree_Menu() {
		return mAD_Tree_Menu;
	}

	/**
	 * Set Organization Tree.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	@JsonProperty("AD_Tree_Org")
	public void setAD_Tree_OrgInput(ForeignEntityInput AD_Tree_Org) {
		this.mAD_Tree_Org = AD_Tree_Org;
		MTree foreignEntity;
		if (AD_Tree_Org != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Org_ID(0);
		}
	}

	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	@JsonProperty("AD_Tree_Org")
	public ForeignEntityInput AD_Tree_Org() {
		return mAD_Tree_Org;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Preference Level.
	 *
	 * @param PreferenceType Determines what preferences the user can set
	 */
	@JsonProperty("PreferenceType")
	public void setPreferenceTypeInput(I_AD_Ref_ListInput PreferenceType) {
		this.mPreferenceType = PreferenceType;
		MRefList_BH foreignEntity;
		if (PreferenceType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PreferenceType.getID())
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
	@JsonProperty("PreferenceType")
	public I_AD_Ref_ListInput PreferenceType() {
		return mPreferenceType;
	}

	/**
	 * Set Role Type.
	 *
	 * @param RoleType Role Type
	 */
	@JsonProperty("RoleType")
	public void setRoleTypeInput(I_AD_Ref_ListInput RoleType) {
		this.mRoleType = RoleType;
		MRefList_BH foreignEntity;
		if (RoleType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RoleType.getID())
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
	@JsonProperty("RoleType")
	public I_AD_Ref_ListInput RoleType() {
		return mRoleType;
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public void setSupervisorInput(ForeignEntityInput Supervisor) {
		this.mSupervisor = Supervisor;
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(Supervisor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSupervisor_ID(foreignEntity.get_ID());
		} else {
			super.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public ForeignEntityInput Supervisor() {
		return mSupervisor;
	}

	/**
	 * Set User Level.
	 *
	 * @param UserLevel System Client Organization
	 */
	@JsonProperty("UserLevel")
	public void setUserLevelInput(I_AD_Ref_ListInput UserLevel) {
		this.mUserLevel = UserLevel;
		MRefList_BH foreignEntity;
		if (UserLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(UserLevel.getID())
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
	@JsonProperty("UserLevel")
	public I_AD_Ref_ListInput UserLevel() {
		return mUserLevel;
	}
}
