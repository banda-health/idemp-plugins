package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaGL;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_GLInput extends MAcctSchemaGL implements I_C_AcctSchema_GLInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mCommitmentOffsetSales_A;
	private ForeignEntityInput mCommitmentOffset_A;
	private ForeignEntityInput mCurrencyBalancing_A;
	private ForeignEntityInput mIntercompanyDueFrom_A;
	private ForeignEntityInput mIntercompanyDueTo_A;
	private ForeignEntityInput mPPVOffset_A;
	private ForeignEntityInput mSuspenseBalancing_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_AcctSchema_GLInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAcctSchemaGL(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_AcctSchema_GL_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_AcctSchema_GL_UU();
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
	 * Set Commitment Offset.
	 *
	 * @param CommitmentOffset_A Budgetary Commitment Offset Account
	 */
	@JsonProperty("CommitmentOffset_A")
	public void setCommitmentOffset_AInput(ForeignEntityInput CommitmentOffset_A) {
		this.mCommitmentOffset_A = CommitmentOffset_A;
		MAccount foreignEntity;
		if (CommitmentOffset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(CommitmentOffset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCommitmentOffset_Acct(foreignEntity.get_ID());
		} else {
			super.setCommitmentOffset_Acct(0);
		}
	}

	/**
	 * Get Commitment Offset.
	 *
	 * @return Budgetary Commitment Offset Account
	 */
	@JsonProperty("CommitmentOffset_A")
	public ForeignEntityInput CommitmentOffset_A() {
		return mCommitmentOffset_A;
	}

	/**
	 * Set Commitment Offset Sales.
	 *
	 * @param CommitmentOffsetSales_A Budgetary Commitment Offset Account for Sales
	 */
	@JsonProperty("CommitmentOffsetSales_A")
	public void setCommitmentOffsetSales_AInput(ForeignEntityInput CommitmentOffsetSales_A) {
		this.mCommitmentOffsetSales_A = CommitmentOffsetSales_A;
		MAccount foreignEntity;
		if (CommitmentOffsetSales_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(CommitmentOffsetSales_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCommitmentOffsetSales_Acct(foreignEntity.get_ID());
		} else {
			super.setCommitmentOffsetSales_Acct(0);
		}
	}

	/**
	 * Get Commitment Offset Sales.
	 *
	 * @return Budgetary Commitment Offset Account for Sales
	 */
	@JsonProperty("CommitmentOffsetSales_A")
	public ForeignEntityInput CommitmentOffsetSales_A() {
		return mCommitmentOffsetSales_A;
	}

	/**
	 * Set Currency Balancing Acct.
	 *
	 * @param CurrencyBalancing_A Account used when a currency is out of balance
	 */
	@JsonProperty("CurrencyBalancing_A")
	public void setCurrencyBalancing_AInput(ForeignEntityInput CurrencyBalancing_A) {
		this.mCurrencyBalancing_A = CurrencyBalancing_A;
		MAccount foreignEntity;
		if (CurrencyBalancing_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(CurrencyBalancing_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCurrencyBalancing_Acct(foreignEntity.get_ID());
		} else {
			super.setCurrencyBalancing_Acct(0);
		}
	}

	/**
	 * Get Currency Balancing Acct.
	 *
	 * @return Account used when a currency is out of balance
	 */
	@JsonProperty("CurrencyBalancing_A")
	public ForeignEntityInput CurrencyBalancing_A() {
		return mCurrencyBalancing_A;
	}

	/**
	 * Set Intercompany Due From Acct.
	 *
	 * @param IntercompanyDueFrom_A Intercompany Due From / Receivables Account
	 */
	@JsonProperty("IntercompanyDueFrom_A")
	public void setIntercompanyDueFrom_AInput(ForeignEntityInput IntercompanyDueFrom_A) {
		this.mIntercompanyDueFrom_A = IntercompanyDueFrom_A;
		MAccount foreignEntity;
		if (IntercompanyDueFrom_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(IntercompanyDueFrom_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIntercompanyDueFrom_Acct(foreignEntity.get_ID());
		} else {
			super.setIntercompanyDueFrom_Acct(0);
		}
	}

	/**
	 * Get Intercompany Due From Acct.
	 *
	 * @return Intercompany Due From / Receivables Account
	 */
	@JsonProperty("IntercompanyDueFrom_A")
	public ForeignEntityInput IntercompanyDueFrom_A() {
		return mIntercompanyDueFrom_A;
	}

	/**
	 * Set Intercompany Due To Acct.
	 *
	 * @param IntercompanyDueTo_A Intercompany Due To / Payable Account
	 */
	@JsonProperty("IntercompanyDueTo_A")
	public void setIntercompanyDueTo_AInput(ForeignEntityInput IntercompanyDueTo_A) {
		this.mIntercompanyDueTo_A = IntercompanyDueTo_A;
		MAccount foreignEntity;
		if (IntercompanyDueTo_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(IntercompanyDueTo_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIntercompanyDueTo_Acct(foreignEntity.get_ID());
		} else {
			super.setIntercompanyDueTo_Acct(0);
		}
	}

	/**
	 * Get Intercompany Due To Acct.
	 *
	 * @return Intercompany Due To / Payable Account
	 */
	@JsonProperty("IntercompanyDueTo_A")
	public ForeignEntityInput IntercompanyDueTo_A() {
		return mIntercompanyDueTo_A;
	}

	/**
	 * Set PPV Offset.
	 *
	 * @param PPVOffset_A Purchase Price Variance Offset Account
	 */
	@JsonProperty("PPVOffset_A")
	public void setPPVOffset_AInput(ForeignEntityInput PPVOffset_A) {
		this.mPPVOffset_A = PPVOffset_A;
		MAccount foreignEntity;
		if (PPVOffset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(PPVOffset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPPVOffset_Acct(foreignEntity.get_ID());
		} else {
			super.setPPVOffset_Acct(0);
		}
	}

	/**
	 * Get PPV Offset.
	 *
	 * @return Purchase Price Variance Offset Account
	 */
	@JsonProperty("PPVOffset_A")
	public ForeignEntityInput PPVOffset_A() {
		return mPPVOffset_A;
	}

	/**
	 * Set Suspense Balancing Acct.
	 *
	 * @param SuspenseBalancing_A Suspense Balancing Acct
	 */
	@JsonProperty("SuspenseBalancing_A")
	public void setSuspenseBalancing_AInput(ForeignEntityInput SuspenseBalancing_A) {
		this.mSuspenseBalancing_A = SuspenseBalancing_A;
		MAccount foreignEntity;
		if (SuspenseBalancing_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(SuspenseBalancing_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSuspenseBalancing_Acct(foreignEntity.get_ID());
		} else {
			super.setSuspenseBalancing_Acct(0);
		}
	}

	/**
	 * Get Suspense Balancing Acct.
	 *
	 * @return Suspense Balancing Acct
	 */
	@JsonProperty("SuspenseBalancing_A")
	public ForeignEntityInput SuspenseBalancing_A() {
		return mSuspenseBalancing_A;
	}
}
