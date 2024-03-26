package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaGL;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AcctSchema_GL_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_AcctSchema_GLInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_AcctSchema_GL_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Commitment Offset.
	 *
	 * @param CommitmentOffset_A Budgetary Commitment Offset Account
	 */
	@JsonProperty("CommitmentOffset_A")
	public void setCommitmentOffset_AInput(ForeignEntityInput CommitmentOffset_A) {
		this.mCommitmentOffset_A = CommitmentOffset_A;
		if (CommitmentOffset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CommitmentOffset_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCommitmentOffset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CommitmentOffset_A.getUUID());
			}
		} else {
			this.setCommitmentOffset_Acct(0);
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
		if (CommitmentOffsetSales_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CommitmentOffsetSales_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCommitmentOffsetSales_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CommitmentOffsetSales_A.getUUID());
			}
		} else {
			this.setCommitmentOffsetSales_Acct(0);
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
		if (CurrencyBalancing_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(CurrencyBalancing_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCurrencyBalancing_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + CurrencyBalancing_A.getUUID());
			}
		} else {
			this.setCurrencyBalancing_Acct(0);
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
		if (IntercompanyDueFrom_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(IntercompanyDueFrom_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIntercompanyDueFrom_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + IntercompanyDueFrom_A.getUUID());
			}
		} else {
			this.setIntercompanyDueFrom_Acct(0);
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
		if (IntercompanyDueTo_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(IntercompanyDueTo_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIntercompanyDueTo_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + IntercompanyDueTo_A.getUUID());
			}
		} else {
			this.setIntercompanyDueTo_Acct(0);
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
		if (PPVOffset_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(PPVOffset_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPPVOffset_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + PPVOffset_A.getUUID());
			}
		} else {
			this.setPPVOffset_Acct(0);
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
		if (SuspenseBalancing_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(SuspenseBalancing_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSuspenseBalancing_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + SuspenseBalancing_A.getUUID());
			}
		} else {
			this.setSuspenseBalancing_Acct(0);
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
