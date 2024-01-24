package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;

import java.sql.ResultSet;

/**
 * Generated Model for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_DefaultIncludedRoleInput extends MBHDefaultIncludedRole implements I_BH_DefaultIncludedRoleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mIncluded_Role;
	private I_AD_Ref_ListInput mDB_UserType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_DefaultIncludedRoleInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHDefaultIncludedRole(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	 * Set Default Included Roles.
	 *
	 * @param BH_DefaultIncludedRole_ID Default Included Roles
	 */

	public void setBH_DefaultIncludedRole_ID(int BH_DefaultIncludedRole_ID) {
		if (get_ID() == 0) {
			super.setBH_DefaultIncludedRole_ID(BH_DefaultIncludedRole_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_DefaultIncludedRole_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_DefaultIncludedRole_UU();
	}

	/**
	 * Set UserType.
	 *
	 * @param DB_UserType The User Type when a new client is created
	 */
	@JsonProperty("DB_UserType")
	public void setDB_UserTypeInput(I_AD_Ref_ListInput DB_UserType) {
		this.mDB_UserType = DB_UserType;
		MRefList_BH foreignEntity;
		if (DB_UserType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DB_UserType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDB_UserType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput DB_UserType() {
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
		X_AD_Role foreignEntity;
		if (Included_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(Included_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIncluded_Role_ID(foreignEntity.get_ID());
		} else {
			super.setIncluded_Role_ID(0);
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
