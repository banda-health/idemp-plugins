package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Role_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_RoleInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_Role(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Role_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
							.setParameters(AD_Tree_Menu.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Menu_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Menu.getUUID());
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
							.setParameters(AD_Tree_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Org.getUUID());
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
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
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
	public void setPreferenceTypeInput(I_AD_Ref_ListInput PreferenceType) {
		this.mPreferenceType = PreferenceType;
		if (PreferenceType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PreferenceType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPreferenceType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PreferenceType.getUUID());
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
		if (RoleType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RoleType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRoleType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + RoleType.getUUID());
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
		if (Supervisor != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Supervisor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSupervisor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + Supervisor.getUUID());
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
	 * @param UserLevel System Client Organization
	 */
	@JsonProperty("UserLevel")
	public void setUserLevelInput(I_AD_Ref_ListInput UserLevel) {
		this.mUserLevel = UserLevel;
		if (UserLevel != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(UserLevel.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setUserLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + UserLevel.getUUID());
			}
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
