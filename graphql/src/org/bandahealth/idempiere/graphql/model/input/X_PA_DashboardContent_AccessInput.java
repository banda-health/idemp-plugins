package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_PA_DashboardContent_Access;
import org.compiere.util.Env;

/**
 * Generated Model for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContent_AccessInput extends X_PA_DashboardContent_Access implements I_PA_DashboardContent_AccessInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_RoleInput AD_Role;
	 private I_AD_UserInput AD_User;
	 private I_PA_DashboardContentInput PA_DashboardContent;

	/**
	 * Standard constructor
	 */
	public X_PA_DashboardContent_AccessInput(String ID) {
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
	 * @param AD_Role Responsibility Role
	 */
	public void setAD_Role(I_AD_RoleInput AD_Role) {
		this.AD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (get_ID() == 0 &&AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Role_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public I_AD_RoleInput getAD_Role() {
		return AD_Role;
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 &&AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}
	/**
	 * Set User/Contact.
	 *
	 * @param AD_User_ID User within the system - Internal or Business Partner Contact
	 */

	public void setAD_User_ID(int AD_User_ID) {
		if (get_ID() == 0) {
			super.setAD_User_ID(AD_User_ID);
		}
	}
	/**
	 * Set PA_DashboardContent_Access_ID.
	 *
	 * @param PA_DashboardContent_Access_ID PA_DashboardContent_Access_ID
	 */

	public void setPA_DashboardContent_Access_ID(int PA_DashboardContent_Access_ID) {
		if (get_ID() == 0) {
			super.setPA_DashboardContent_Access_ID(PA_DashboardContent_Access_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_DashboardContent_Access_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_DashboardContent_Access_UU();
	}

	/**
	 * Set Dashboard Content.
	 *
	 * @param PA_DashboardContent Dashboard Content
	 */
	public void setPA_DashboardContent(I_PA_DashboardContentInput PA_DashboardContent) {
		this.PA_DashboardContent = PA_DashboardContent;
		MDashboardContent foreignEntity;
		if (get_ID() == 0 &&PA_DashboardContent != null &&
				(foreignEntity = new Query(getCtx(), MDashboardContent.Table_Name, MDashboardContent.COLUMNNAME_PA_DashboardContent_UU + "=?", get_TrxName())
						.setParameters(PA_DashboardContent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_DashboardContent_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	public I_PA_DashboardContentInput getPA_DashboardContent() {
		return PA_DashboardContent;
	}
	/**
	 * Set Dashboard Content.
	 *
	 * @param PA_DashboardContent_ID Dashboard Content
	 */

	public void setPA_DashboardContent_ID(int PA_DashboardContent_ID) {
		if (get_ID() == 0) {
			super.setPA_DashboardContent_ID(PA_DashboardContent_ID);
		}
	}
}
