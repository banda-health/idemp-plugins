package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MDashboardContentAccess;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContent_AccessInput extends MDashboardContentAccess implements I_PA_DashboardContent_AccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mPA_DashboardContent;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_DashboardContent_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_DashboardContent_AccessInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDashboardContentAccess(null, (ResultSet) null, null),
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
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UUID " + AD_Role.getUUID());
			}
		} else {
			this.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (get_ID() != 0) {
			return;
		}
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_DashboardContent_Access_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_DashboardContent_Access_UU();
	}

	/**
	 * Set Dashboard Content.
	 *
	 * @param PA_DashboardContent Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public void setPA_DashboardContentInput(ForeignEntityInput PA_DashboardContent) {
		this.mPA_DashboardContent = PA_DashboardContent;
		if (get_ID() != 0) {
			return;
		}
		if (PA_DashboardContent != null) {
			// Since an entity was passed, make sure it's in the DB
			MDashboardContent foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_DashboardContent", "PA_DashboardContent_UU=?", get_TrxName())
							.setParameters(PA_DashboardContent.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_DashboardContent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_DashboardContent with UUID " + PA_DashboardContent.getUUID());
			}
		} else {
			this.setPA_DashboardContent_ID(0);
		}
	}

	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public ForeignEntityInput PA_DashboardContent() {
		return mPA_DashboardContent;
	}
}
