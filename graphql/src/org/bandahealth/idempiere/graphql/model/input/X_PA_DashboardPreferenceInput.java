package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MDashboardPreference;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

/**
 * Generated Model for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardPreferenceInput extends MDashboardPreference implements I_PA_DashboardPreferenceInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_RoleInput mAD_Role;
	 private I_AD_UserInput mAD_User;
	 private I_PA_DashboardContentInput mPA_DashboardContent;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_DashboardPreferenceInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(I_AD_RoleInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public I_AD_RoleInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public I_AD_UserInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Dashboard Content.
	 *
	 * @param PA_DashboardContent Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public void setPA_DashboardContentInput(I_PA_DashboardContentInput PA_DashboardContent) {
		this.mPA_DashboardContent = PA_DashboardContent;
		MDashboardContent foreignEntity;
		if (PA_DashboardContent != null &&
				(foreignEntity = new Query(getCtx(), MDashboardContent.Table_Name, MDashboardContent.COLUMNNAME_PA_DashboardContent_UU + "=?", get_TrxName())
						.setParameters(PA_DashboardContent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_DashboardContent_ID(foreignEntity.get_ID());
		} else {
			super.setPA_DashboardContent_ID(0);
		}
	}

	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public I_PA_DashboardContentInput PA_DashboardContent() {
		return mPA_DashboardContent;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_DashboardPreference_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_DashboardPreference_UU();
	}
}
