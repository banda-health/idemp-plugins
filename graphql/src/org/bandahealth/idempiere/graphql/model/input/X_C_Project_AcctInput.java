package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.Query;
import org.compiere.model.X_C_Project_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Project_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Project_AcctInput extends X_C_Project_Acct implements I_C_Project_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mPJ_Asset_A;
	private ForeignEntityInput mPJ_WIP_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Project_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_Project_AcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_Project_Acct(null, (ResultSet) null, null),
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Project_Acct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Project_Acct_UU();
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		if (get_ID() != 0) {
			return;
		}
		if (C_Project != null) {
			// Since an entity was passed, make sure it's in the DB
			MProject foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
			}
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Project Asset.
	 *
	 * @param PJ_Asset_A Project Asset Account
	 */
	@JsonProperty("PJ_Asset_A")
	public void setPJ_Asset_AInput(ForeignEntityInput PJ_Asset_A) {
		this.mPJ_Asset_A = PJ_Asset_A;
		if (PJ_Asset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(PJ_Asset_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPJ_Asset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + PJ_Asset_A.getUUID());
			}
		} else {
			this.setPJ_Asset_Acct(0);
		}
	}

	/**
	 * Get Project Asset.
	 *
	 * @return Project Asset Account
	 */
	@JsonProperty("PJ_Asset_A")
	public ForeignEntityInput PJ_Asset_A() {
		return mPJ_Asset_A;
	}

	/**
	 * Set Work In Progress.
	 *
	 * @param PJ_WIP_A Account for Work in Progress
	 */
	@JsonProperty("PJ_WIP_A")
	public void setPJ_WIP_AInput(ForeignEntityInput PJ_WIP_A) {
		this.mPJ_WIP_A = PJ_WIP_A;
		if (PJ_WIP_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(PJ_WIP_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPJ_WIP_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + PJ_WIP_A.getUUID());
			}
		} else {
			this.setPJ_WIP_Acct(0);
		}
	}

	/**
	 * Get Work In Progress.
	 *
	 * @return Account for Work in Progress
	 */
	@JsonProperty("PJ_WIP_A")
	public ForeignEntityInput PJ_WIP_A() {
		return mPJ_WIP_A;
	}
}
