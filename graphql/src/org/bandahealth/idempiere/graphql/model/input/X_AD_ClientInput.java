package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 7.1 - $Id$
 */
public class X_AD_ClientInput extends MClient_BH implements I_AD_ClientInput {

	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PasswordRule;
	private ForeignEntityInput mAD_ReplicationStrategy;
	private I_AD_Ref_ListInput mAutoArchive;
	private I_AD_Ref_ListInput mMMPolicy;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Client_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ClientInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MClient_BH(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Client_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		MLanguage foreignEntity;
		if (AD_Language != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
							.setParameters(AD_Language.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Language(foreignEntity.getAD_Language());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Language with UUID " + AD_Language.getUUID());
			}
		} else {
			super.setAD_Language(null);
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
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Password Policies.
	 *
	 * @param AD_PasswordRule Password Policies
	 */
	@JsonProperty("AD_PasswordRule")
	public void setAD_PasswordRuleInput(ForeignEntityInput AD_PasswordRule) {
		this.mAD_PasswordRule = AD_PasswordRule;
		MPasswordRule foreignEntity;
		if (AD_PasswordRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PasswordRule", "AD_PasswordRule_UU=?", get_TrxName())
							.setParameters(AD_PasswordRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PasswordRule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PasswordRule with UUID " + AD_PasswordRule.getUUID());
			}
		} else {
			super.setAD_PasswordRule_ID(0);
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
		MReplicationStrategy foreignEntity;
		if (AD_ReplicationStrategy != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReplicationStrategy", "AD_ReplicationStrategy_UU=?", get_TrxName())
							.setParameters(AD_ReplicationStrategy.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReplicationStrategy with UUID " + AD_ReplicationStrategy.getUUID());
			}
		} else {
			super.setAD_ReplicationStrategy_ID(0);
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
	 * Set Auto Archive.
	 *
	 * @param AutoArchive Enable and level of automatic Archive of documents
	 */
	@JsonProperty("AutoArchive")
	public void setAutoArchiveInput(I_AD_Ref_ListInput AutoArchive) {
		this.mAutoArchive = AutoArchive;
		MRefList_BH foreignEntity;
		if (AutoArchive != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AutoArchive.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAutoArchive(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AutoArchive.getUUID());
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
	public I_AD_Ref_ListInput AutoArchive() {
		return mAutoArchive;
	}

	/**
	 * Set Material Policy.
	 *
	 * @param MMPolicy Material Movement Policy
	 */
	@JsonProperty("MMPolicy")
	public void setMMPolicyInput(I_AD_Ref_ListInput MMPolicy) {
		this.mMMPolicy = MMPolicy;
		MRefList_BH foreignEntity;
		if (MMPolicy != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MMPolicy.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setMMPolicy(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + MMPolicy.getUUID());
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
	public I_AD_Ref_ListInput MMPolicy() {
		return mMMPolicy;
	}
}
