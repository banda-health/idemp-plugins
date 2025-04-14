package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_DefaultIncludedRoleResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_DefaultIncludedRoleInput extends MBHDefaultIncludedRole implements I_BH_DefaultIncludedRoleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mDB_UserType;
	private ForeignEntityInput mIncluded_Role;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_DefaultIncludedRole_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_DefaultIncludedRoleInput(@JsonProperty("UU") String UU) {
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
	 * Set Default Included Roles.
	 *
	 * @param BH_DefaultIncludedRole_ID Default Included Roles
	 */
	@JsonProperty("BH_DefaultIncludedRole_ID")
	public void setBH_DefaultIncludedRole_IDFromJson(int BH_DefaultIncludedRole_ID) {
		if (get_ID() == 0) {
			super.setBH_DefaultIncludedRole_ID(BH_DefaultIncludedRole_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_DefaultIncludedRole_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_DefaultIncludedRole_UU();
	}

	/**
	 * Set UserType.
	 *
	 * @param DB_UserType The User Type when a new client is created
	 */
	@JsonProperty("DB_UserType")
	public void setDB_UserTypeInput(ForeignEntityInput DB_UserType) {
		this.mDB_UserType = DB_UserType;
		if (DB_UserType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_DefaultIncludedRoleResolver.DB_USERTYPE_UUIDS_BY_VALUE.containsValue(DB_UserType.getUU())) {
				throw new AdempiereException("The reference list UU of " + DB_UserType.getUU() +
						" is not in the list defined for the DB_UserType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DB_UserType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDB_UserType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DB_UserType.getUU());
			}
		} else {
			this.setDB_UserType(null);
		}
	}

	/**
	 * Get UserType.
	 *
	 * @return The User Type when a new client is created
	 */
	@JsonProperty("DB_UserType")
	public ForeignEntityInput DB_UserType() {
		return mDB_UserType;
	}

	/**
	 * Set Included Role.
	 *
	 * @param Included_Role Included Role
	 */
	@JsonProperty("Included_Role")
	public void setIncluded_RoleInput(ForeignEntityInput Included_Role) {
		this.mIncluded_Role = Included_Role;
		if (Included_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(Included_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setIncluded_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UU " + Included_Role.getUU());
			}
		} else {
			this.setIncluded_Role_ID(0);
		}
	}

	/**
	 * Get Included Role.
	 *
	 * @return Included Role
	 */
	@JsonProperty("Included_Role")
	public ForeignEntityInput Included_Role() {
		return mIncluded_Role;
	}
}
