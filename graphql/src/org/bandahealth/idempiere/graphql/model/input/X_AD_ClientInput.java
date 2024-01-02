package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.MPasswordRule;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientInput extends MClient_BH implements I_AD_ClientInput {

	 private I_AD_LanguageInput mAD_Language;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_PasswordRuleInput mAD_PasswordRule;
	 private I_AD_Ref_ListInput mAutoArchive;
	 private I_AD_Ref_ListInput mMMPolicy;
	 private I_AD_ReplicationStrategyInput mAD_ReplicationStrategy;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ClientInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Client_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Client_UU();
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	@JsonProperty("AD_Language")
	public void setAD_LanguageInput(I_AD_LanguageInput AD_Language) {
		this.mAD_Language = AD_Language;
		MLanguage foreignEntity;
		if (AD_Language != null &&
				(foreignEntity = new Query(getCtx(), MLanguage.Table_Name, MLanguage.COLUMNNAME_AD_Language_UU + "=?", get_TrxName())
						.setParameters(AD_Language.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Language(foreignEntity.getAD_Language());
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
	public I_AD_LanguageInput AD_Language() {
		return mAD_Language;
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
	 * Set Password Policies.
	 *
	 * @param AD_PasswordRule Password Policies
	 */
	@JsonProperty("AD_PasswordRule")
	public void setAD_PasswordRuleInput(I_AD_PasswordRuleInput AD_PasswordRule) {
		this.mAD_PasswordRule = AD_PasswordRule;
		MPasswordRule foreignEntity;
		if (AD_PasswordRule != null &&
				(foreignEntity = new Query(getCtx(), MPasswordRule.Table_Name, MPasswordRule.COLUMNNAME_AD_PasswordRule_UU + "=?", get_TrxName())
						.setParameters(AD_PasswordRule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PasswordRule_ID(foreignEntity.get_ID());
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
	public I_AD_PasswordRuleInput AD_PasswordRule() {
		return mAD_PasswordRule;
	}

	/**
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public void setAD_ReplicationStrategyInput(I_AD_ReplicationStrategyInput AD_ReplicationStrategy) {
		this.mAD_ReplicationStrategy = AD_ReplicationStrategy;
		MReplicationStrategy foreignEntity;
		if (AD_ReplicationStrategy != null &&
				(foreignEntity = new Query(getCtx(), MReplicationStrategy.Table_Name, MReplicationStrategy.COLUMNNAME_AD_ReplicationStrategy_UU + "=?", get_TrxName())
						.setParameters(AD_ReplicationStrategy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
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
	public I_AD_ReplicationStrategyInput AD_ReplicationStrategy() {
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
		if (AutoArchive != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AutoArchive.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAutoArchive(foreignEntity.getValue());
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
		if (MMPolicy != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MMPolicy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMMPolicy(foreignEntity.getValue());
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
