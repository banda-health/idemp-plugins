package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_ClientResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.MPasswordRule;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ClientInput extends MClient_BH implements I_AD_ClientInput {

	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PasswordRule;
	private ForeignEntityInput mAD_ReplicationStrategy;
	private ForeignEntityInput mAuthenticationType;
	private ForeignEntityInput mAutoArchive;
	private ForeignEntityInput mMMPolicy;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Client_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ClientInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Client_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Client_UU();
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	@JsonProperty("AD_Language")
	public void setAD_LanguageInput(ForeignEntityInput AD_Language) {
		this.mAD_Language = AD_Language;
		if (AD_Language != null) {
			// Since an entity was passed, make sure it's in the DB
			MLanguage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
							.setParameters(AD_Language.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Language(foreignEntity.getAD_Language());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Language with UU " + AD_Language.getUU());
			}
		} else {
			this.setAD_Language(null);
		}
	}

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	@JsonProperty("AD_Language")
	public ForeignEntityInput AD_Language() {
		return mAD_Language;
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
	 * Set Password Policies.
	 *
	 * @param AD_PasswordRule Password Policies
	 */
	@JsonProperty("AD_PasswordRule")
	public void setAD_PasswordRuleInput(ForeignEntityInput AD_PasswordRule) {
		this.mAD_PasswordRule = AD_PasswordRule;
		if (AD_PasswordRule != null) {
			// Since an entity was passed, make sure it's in the DB
			MPasswordRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PasswordRule", "AD_PasswordRule_UU=?", get_TrxName())
							.setParameters(AD_PasswordRule.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PasswordRule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PasswordRule with UU " + AD_PasswordRule.getUU());
			}
		} else {
			this.setAD_PasswordRule_ID(0);
		}
	}

	/**
	 * Get Password Policies.
	 *
	 * @return Password Policies
	 */
	@JsonProperty("AD_PasswordRule")
	public ForeignEntityInput AD_PasswordRule() {
		return mAD_PasswordRule;
	}

	/**
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public void setAD_ReplicationStrategyInput(ForeignEntityInput AD_ReplicationStrategy) {
		this.mAD_ReplicationStrategy = AD_ReplicationStrategy;
		if (AD_ReplicationStrategy != null) {
			// Since an entity was passed, make sure it's in the DB
			MReplicationStrategy foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReplicationStrategy", "AD_ReplicationStrategy_UU=?", get_TrxName())
							.setParameters(AD_ReplicationStrategy.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReplicationStrategy with UU " + AD_ReplicationStrategy.getUU());
			}
		} else {
			this.setAD_ReplicationStrategy_ID(0);
		}
	}

	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public ForeignEntityInput AD_ReplicationStrategy() {
		return mAD_ReplicationStrategy;
	}

	/**
	 * Set Authentication Type.
	 *
	 * @param AuthenticationType Authentication Type
	 */
	@JsonProperty("AuthenticationType")
	public void setAuthenticationTypeInput(ForeignEntityInput AuthenticationType) {
		this.mAuthenticationType = AuthenticationType;
		if (AuthenticationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ClientResolver.AUTHENTICATIONTYPE_UUIDS_BY_VALUE.containsValue(AuthenticationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + AuthenticationType.getUU() +
						" is not in the list defined for the AuthenticationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AuthenticationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAuthenticationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AuthenticationType.getUU());
			}
		} else {
			this.setAuthenticationType(null);
		}
	}

	/**
	 * Get Authentication Type.
	 *
	 * @return Authentication Type
	 */
	@JsonProperty("AuthenticationType")
	public ForeignEntityInput AuthenticationType() {
		return mAuthenticationType;
	}

	/**
	 * Set Auto Archive.
	 *
	 * @param AutoArchive Enable and level of automatic Archive of documents
	 */
	@JsonProperty("AutoArchive")
	public void setAutoArchiveInput(ForeignEntityInput AutoArchive) {
		this.mAutoArchive = AutoArchive;
		if (AutoArchive != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ClientResolver.AUTOARCHIVE_UUIDS_BY_VALUE.containsValue(AutoArchive.getUU())) {
				throw new AdempiereException("The reference list UU of " + AutoArchive.getUU() +
						" is not in the list defined for the AutoArchive column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AutoArchive.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAutoArchive(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AutoArchive.getUU());
			}
		} else {
			this.setAutoArchive(null);
		}
	}

	/**
	 * Get Auto Archive.
	 *
	 * @return Enable and level of automatic Archive of documents
	 */
	@JsonProperty("AutoArchive")
	public ForeignEntityInput AutoArchive() {
		return mAutoArchive;
	}

	/**
	 * Set Material Policy.
	 *
	 * @param MMPolicy Material Movement Policy
	 */
	@JsonProperty("MMPolicy")
	public void setMMPolicyInput(ForeignEntityInput MMPolicy) {
		this.mMMPolicy = MMPolicy;
		if (MMPolicy != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ClientResolver.MMPOLICY_UUIDS_BY_VALUE.containsValue(MMPolicy.getUU())) {
				throw new AdempiereException("The reference list UU of " + MMPolicy.getUU() +
						" is not in the list defined for the MMPolicy column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MMPolicy.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setMMPolicy(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + MMPolicy.getUU());
			}
		} else {
			this.setMMPolicy(null);
		}
	}

	/**
	 * Get Material Policy.
	 *
	 * @return Material Movement Policy
	 */
	@JsonProperty("MMPolicy")
	public ForeignEntityInput MMPolicy() {
		return mMMPolicy;
	}
}
