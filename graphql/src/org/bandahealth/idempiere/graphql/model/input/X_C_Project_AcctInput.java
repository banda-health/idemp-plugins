package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.Query;
import org.compiere.model.X_C_Project_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for C_Project_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_Project_AcctInput extends X_C_Project_Acct implements I_C_Project_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mPJ_Asset_A;
	private ForeignEntityInput mPJ_WIP_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_Project_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_Project_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Project_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MProject foreignEntity;
		if (get_ID() == 0 && C_Project != null &&
				(foreignEntity = new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
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
		MAccount foreignEntity;
		if (PJ_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(PJ_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPJ_Asset_Acct(foreignEntity.get_ID());
		} else {
			super.setPJ_Asset_Acct(0);
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
		MAccount foreignEntity;
		if (PJ_WIP_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(PJ_WIP_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPJ_WIP_Acct(foreignEntity.get_ID());
		} else {
			super.setPJ_WIP_Acct(0);
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
