package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.MPasswordRule;
import org.compiere.model.MRefList;
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

	 private I_AD_LanguageInput AD_Language_L;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_PasswordRuleInput AD_PasswordRule;
	 private I_AD_Ref_ListInput AutoArchive_RL;
	 private I_AD_Ref_ListInput MMPolicy_RL;
	 private I_AD_ReplicationStrategyInput AD_ReplicationStrategy;

	/**
	 * Standard constructor
	 */
	public X_AD_ClientInput(String ID) {
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
	 * @param AD_Language_L Language for this entity
	 */
	public void setAD_Language_L(I_AD_LanguageInput AD_Language_L) {
		this.AD_Language_L = AD_Language_L;
		MLanguage foreignEntity;
		if (AD_Language_L != null &&
				(foreignEntity = new Query(getCtx(), MLanguage.Table_Name, MLanguage.COLUMNNAME_AD_Language_UU + "=?", get_TrxName())
						.setParameters(AD_Language_L.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Language(foreignEntity.getAD_Language());
		} else {
			this.setAD_Language(null);
		}
	}

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	public I_AD_LanguageInput getAD_Language_L() {
		return AD_Language_L;
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
	 * Set Password Policies.
	 *
	 * @param AD_PasswordRule Password Policies
	 */
	public void setAD_PasswordRule(I_AD_PasswordRuleInput AD_PasswordRule) {
		this.AD_PasswordRule = AD_PasswordRule;
		MPasswordRule foreignEntity;
		if (AD_PasswordRule != null &&
				(foreignEntity = new Query(getCtx(), MPasswordRule.Table_Name, MPasswordRule.COLUMNNAME_AD_PasswordRule_UU + "=?", get_TrxName())
						.setParameters(AD_PasswordRule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PasswordRule_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PasswordRule_ID(0);
		}
	}

	/**
	 * Get Password Policies.
	 *
	 * @return Password Policies
	 */
	public I_AD_PasswordRuleInput getAD_PasswordRule() {
		return AD_PasswordRule;
	}

	/**
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	public void setAD_ReplicationStrategy(I_AD_ReplicationStrategyInput AD_ReplicationStrategy) {
		this.AD_ReplicationStrategy = AD_ReplicationStrategy;
		MReplicationStrategy foreignEntity;
		if (AD_ReplicationStrategy != null &&
				(foreignEntity = new Query(getCtx(), MReplicationStrategy.Table_Name, MReplicationStrategy.COLUMNNAME_AD_ReplicationStrategy_UU + "=?", get_TrxName())
						.setParameters(AD_ReplicationStrategy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
		} else {
			this.setAD_ReplicationStrategy_ID(0);
		}
	}

	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	public I_AD_ReplicationStrategyInput getAD_ReplicationStrategy() {
		return AD_ReplicationStrategy;
	}

	/**
	 * Set Auto Archive.
	 *
	 * @param AutoArchive_RL Enable and level of automatic Archive of documents
	 */
	public void setAutoArchive_RL(I_AD_Ref_ListInput AutoArchive_RL) {
		this.AutoArchive_RL = AutoArchive_RL;
		MRefList foreignEntity;
		if (AutoArchive_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AutoArchive_RL.getID())
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
	public I_AD_Ref_ListInput getAutoArchive_RL() {
		return AutoArchive_RL;
	}

	/**
	 * Set Material Policy.
	 *
	 * @param MMPolicy_RL Material Movement Policy
	 */
	public void setMMPolicy_RL(I_AD_Ref_ListInput MMPolicy_RL) {
		this.MMPolicy_RL = MMPolicy_RL;
		MRefList foreignEntity;
		if (MMPolicy_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MMPolicy_RL.getID())
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
	public I_AD_Ref_ListInput getMMPolicy_RL() {
		return MMPolicy_RL;
	}
}
