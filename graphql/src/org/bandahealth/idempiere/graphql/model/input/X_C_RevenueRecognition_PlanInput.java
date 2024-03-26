package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.MRevenueRecognitionPlan;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_RevenueRecognition_Plan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecognition_PlanInput extends MRevenueRecognitionPlan implements I_C_RevenueRecognition_PlanInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mC_RevenueRecognition;
	private ForeignEntityInput mP_Revenue_A;
	private ForeignEntityInput mUnEarnedRevenue_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RevenueRecognition_Plan_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RevenueRecognition_PlanInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (get_ID() != 0) {
			return;
		}
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		if (get_ID() != 0) {
			return;
		}
		if (C_InvoiceLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoiceLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UUID " + C_InvoiceLine.getUUID());
			}
		} else {
			this.setC_InvoiceLine_ID(0);
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public ForeignEntityInput C_InvoiceLine() {
		return mC_InvoiceLine;
	}

	/**
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public void setC_RevenueRecognitionInput(ForeignEntityInput C_RevenueRecognition) {
		this.mC_RevenueRecognition = C_RevenueRecognition;
		if (get_ID() != 0) {
			return;
		}
		if (C_RevenueRecognition != null) {
			// Since an entity was passed, make sure it's in the DB
			MRevenueRecognition foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecognition", "C_RevenueRecognition_UU=?", get_TrxName())
							.setParameters(C_RevenueRecognition.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_RevenueRecognition_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecognition with UUID " + C_RevenueRecognition.getUUID());
			}
		} else {
			this.setC_RevenueRecognition_ID(0);
		}
	}

	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public ForeignEntityInput C_RevenueRecognition() {
		return mC_RevenueRecognition;
	}
	/**
	 * Set Revenue Recognition Plan.
	 *
	 * @param C_RevenueRecognition_Plan_ID Plan for recognizing or recording revenue
	 */

	public void setC_RevenueRecognition_Plan_ID(int C_RevenueRecognition_Plan_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecognition_Plan_ID(C_RevenueRecognition_Plan_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_RevenueRecognition_Plan_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_RevenueRecognition_Plan_UU();
	}

	/**
	 * Set Product Revenue.
	 *
	 * @param P_Revenue_A Account for Product Revenue (Sales Account)
	 */
	@JsonProperty("P_Revenue_A")
	public void setP_Revenue_AInput(ForeignEntityInput P_Revenue_A) {
		this.mP_Revenue_A = P_Revenue_A;
		if (get_ID() != 0) {
			return;
		}
		if (P_Revenue_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(P_Revenue_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setP_Revenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + P_Revenue_A.getUUID());
			}
		} else {
			this.setP_Revenue_Acct(0);
		}
	}

	/**
	 * Get Product Revenue.
	 *
	 * @return Account for Product Revenue (Sales Account)
	 */
	@JsonProperty("P_Revenue_A")
	public ForeignEntityInput P_Revenue_A() {
		return mP_Revenue_A;
	}
	/**
	 * Set Recognized Amount.
	 *
	 * @param RecognizedAmt Recognized Amount
	 */

	public void setRecognizedAmt(BigDecimal RecognizedAmt) {
		if (get_ID() == 0) {
			super.setRecognizedAmt(RecognizedAmt);
		}
	}
	/**
	 * Set Total Amount.
	 *
	 * @param TotalAmt Total Amount
	 */

	public void setTotalAmt(BigDecimal TotalAmt) {
		if (get_ID() == 0) {
			super.setTotalAmt(TotalAmt);
		}
	}

	/**
	 * Set Unearned Revenue.
	 *
	 * @param UnEarnedRevenue_A Account for unearned revenue
	 */
	@JsonProperty("UnEarnedRevenue_A")
	public void setUnEarnedRevenue_AInput(ForeignEntityInput UnEarnedRevenue_A) {
		this.mUnEarnedRevenue_A = UnEarnedRevenue_A;
		if (get_ID() != 0) {
			return;
		}
		if (UnEarnedRevenue_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(UnEarnedRevenue_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUnEarnedRevenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + UnEarnedRevenue_A.getUUID());
			}
		} else {
			this.setUnEarnedRevenue_Acct(0);
		}
	}

	/**
	 * Get Unearned Revenue.
	 *
	 * @return Account for unearned revenue
	 */
	@JsonProperty("UnEarnedRevenue_A")
	public ForeignEntityInput UnEarnedRevenue_A() {
		return mUnEarnedRevenue_A;
	}
}
