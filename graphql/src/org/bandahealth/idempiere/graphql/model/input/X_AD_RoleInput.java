package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_RoleResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RoleInput extends X_AD_Role implements I_AD_RoleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tree_Menu;
	private ForeignEntityInput mAD_Tree_Org;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mPreferenceType;
	private ForeignEntityInput mRoleType;
	private ForeignEntityInput mSupervisor;
	private ForeignEntityInput mUserLevel;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Role_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_RoleInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Role.
	 *
	 * @param AD_Role_ID Responsibility Role
	 */
	@JsonProperty("AD_Role_ID")
	public void setAD_Role_IDFromJson(int AD_Role_ID) {
		if (get_ID() == 0) {
			super.setAD_Role_ID(AD_Role_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Role_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (AD_Tree_Menu != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Menu.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Tree_Menu_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UU " + AD_Tree_Menu.getUU());
			}
		} else {
			this.setAD_Tree_Menu_ID(0);
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
		if (AD_Tree_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Tree_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UU " + AD_Tree_Org.getUU());
			}
		} else {
			this.setAD_Tree_Org_ID(0);
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
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + C_Currency.getUU());
			}
		} else {
			this.setC_Currency_ID(0);
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
	public void setPreferenceTypeInput(ForeignEntityInput PreferenceType) {
		this.mPreferenceType = PreferenceType;
		if (PreferenceType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RoleResolver.PREFERENCETYPE_UUIDS_BY_VALUE.containsValue(PreferenceType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PreferenceType.getUU() +
						" is not in the list defined for the PreferenceType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PreferenceType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPreferenceType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PreferenceType.getUU());
			}
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
	public ForeignEntityInput PreferenceType() {
		return mPreferenceType;
	}

	/**
	 * Set Role Type.
	 *
	 * @param RoleType Role Type
	 */
	@JsonProperty("RoleType")
	public void setRoleTypeInput(ForeignEntityInput RoleType) {
		this.mRoleType = RoleType;
		if (RoleType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RoleResolver.ROLETYPE_UUIDS_BY_VALUE.containsValue(RoleType.getUU())) {
				throw new AdempiereException("The reference list UU of " + RoleType.getUU() +
						" is not in the list defined for the RoleType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RoleType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRoleType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + RoleType.getUU());
			}
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
	public ForeignEntityInput RoleType() {
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
		if (Supervisor != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Supervisor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSupervisor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + Supervisor.getUU());
			}
		} else {
			this.setSupervisor_ID(0);
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
	 * @param UserLevel System Tenant Organization
	 */
	@JsonProperty("UserLevel")
	public void setUserLevelInput(ForeignEntityInput UserLevel) {
		this.mUserLevel = UserLevel;
		if (UserLevel != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_RoleResolver.USERLEVEL_UUIDS_BY_VALUE.containsValue(UserLevel.getUU())) {
				throw new AdempiereException("The reference list UU of " + UserLevel.getUU() +
						" is not in the list defined for the UserLevel column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(UserLevel.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUserLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + UserLevel.getUU());
			}
		} else {
			this.setUserLevel(null);
		}
	}

	/**
	 * Get User Level.
	 *
	 * @return System Tenant Organization
	 */
	@JsonProperty("UserLevel")
	public ForeignEntityInput UserLevel() {
		return mUserLevel;
	}
}
