package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHFeatureFlag;
import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Feature_Flag_RuleResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.model.X_AD_AllUsers_V;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Feature_Flag_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_Flag_RuleInput extends MBHFeatureFlagRule implements I_BH_Feature_Flag_RuleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Environment;
	private ForeignEntityInput mBH_Feature_Flag;
	private ForeignEntityInput mBH_Rule_Client;
	private ForeignEntityInput mBH_Rule_Role;
	private ForeignEntityInput mBH_Rule_User;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Feature_Flag_Rule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Feature_Flag_RuleInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Environment.
	 *
	 * @param BH_Environment Environment
	 */
	@JsonProperty("BH_Environment")
	public void setBH_EnvironmentInput(ForeignEntityInput BH_Environment) {
		this.mBH_Environment = BH_Environment;
		if (BH_Environment != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Feature_Flag_RuleResolver.BH_ENVIRONMENT_UUIDS_BY_VALUE.containsValue(BH_Environment.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Environment.getUU() +
						" is not in the list defined for the BH_Environment column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Environment.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Environment(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Environment.getUU());
			}
		} else {
			this.setBH_Environment(null);
		}
	}

	/**
	 * Get Environment.
	 *
	 * @return Environment
	 */
	@JsonProperty("BH_Environment")
	public ForeignEntityInput BH_Environment() {
		return mBH_Environment;
	}

	/**
	 * Set Feature Flag.
	 *
	 * @param BH_Feature_Flag Feature Flag
	 */
	@JsonProperty("BH_Feature_Flag")
	public void setBH_Feature_FlagInput(ForeignEntityInput BH_Feature_Flag) {
		this.mBH_Feature_Flag = BH_Feature_Flag;
		if (!is_new()) {
			return;
		}
		if (BH_Feature_Flag != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHFeatureFlag foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Feature_Flag", "BH_Feature_Flag_UU=?", get_TrxName())
							.setParameters(BH_Feature_Flag.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Feature_Flag_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Feature_Flag with UU " + BH_Feature_Flag.getUU());
			}
		} else {
			this.setBH_Feature_Flag_ID(0);
		}
	}

	/**
	 * Get Feature Flag.
	 *
	 * @return Feature Flag
	 */
	@JsonProperty("BH_Feature_Flag")
	public ForeignEntityInput BH_Feature_Flag() {
		return mBH_Feature_Flag;
	}
	/**
	 * Set Feature Flag Rule.
	 *
	 * @param BH_Feature_Flag_Rule_ID Feature Flag Rule
	 */
	@JsonProperty("BH_Feature_Flag_Rule_ID")
	public void setBH_Feature_Flag_Rule_IDFromJson(int BH_Feature_Flag_Rule_ID) {
		if (get_ID() == 0) {
			super.setBH_Feature_Flag_Rule_ID(BH_Feature_Flag_Rule_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Feature_Flag_Rule_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Feature_Flag_Rule_UU();
	}

	/**
	 * Set Client.
	 *
	 * @param BH_Rule_Client Client
	 */
	@JsonProperty("BH_Rule_Client")
	public void setBH_Rule_ClientInput(ForeignEntityInput BH_Rule_Client) {
		this.mBH_Rule_Client = BH_Rule_Client;
		if (BH_Rule_Client != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_AllClients_V foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllClients_V", "AD_AllClients_V_UU=?", get_TrxName())
							.setParameters(BH_Rule_Client.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Rule_Client_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllClients_V with UU " + BH_Rule_Client.getUU());
			}
		} else {
			this.setBH_Rule_Client_ID(0);
		}
	}

	/**
	 * Get Client.
	 *
	 * @return Client
	 */
	@JsonProperty("BH_Rule_Client")
	public ForeignEntityInput BH_Rule_Client() {
		return mBH_Rule_Client;
	}

	/**
	 * Set Role.
	 *
	 * @param BH_Rule_Role Role
	 */
	@JsonProperty("BH_Rule_Role")
	public void setBH_Rule_RoleInput(ForeignEntityInput BH_Rule_Role) {
		this.mBH_Rule_Role = BH_Rule_Role;
		if (BH_Rule_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(BH_Rule_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Rule_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UU " + BH_Rule_Role.getUU());
			}
		} else {
			this.setBH_Rule_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Role
	 */
	@JsonProperty("BH_Rule_Role")
	public ForeignEntityInput BH_Rule_Role() {
		return mBH_Rule_Role;
	}

	/**
	 * Set User.
	 *
	 * @param BH_Rule_User User
	 */
	@JsonProperty("BH_Rule_User")
	public void setBH_Rule_UserInput(ForeignEntityInput BH_Rule_User) {
		this.mBH_Rule_User = BH_Rule_User;
		if (BH_Rule_User != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_AllUsers_V foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllUsers_V", "AD_AllUsers_V_UU=?", get_TrxName())
							.setParameters(BH_Rule_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Rule_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllUsers_V with UU " + BH_Rule_User.getUU());
			}
		} else {
			this.setBH_Rule_User_ID(0);
		}
	}

	/**
	 * Get User.
	 *
	 * @return User
	 */
	@JsonProperty("BH_Rule_User")
	public ForeignEntityInput BH_Rule_User() {
		return mBH_Rule_User;
	}
}
