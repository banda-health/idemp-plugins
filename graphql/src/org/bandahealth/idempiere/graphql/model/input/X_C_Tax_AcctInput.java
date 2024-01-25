package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.model.X_C_Tax_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Tax_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_Tax_AcctInput extends X_C_Tax_Acct implements I_C_Tax_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Tax;
	private ForeignEntityInput mT_Credit_A;
	private ForeignEntityInput mT_Due_A;
	private ForeignEntityInput mT_Expense_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Tax_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_Tax_AcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_Tax_Acct(null, (ResultSet) null, null),
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
		setC_Tax_Acct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Tax_Acct_UU();
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		if (get_ID() != 0) {
			return;
		}
		if (C_Tax != null) {
			// Since an entity was passed, make sure it's in the DB
			MTax foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(C_Tax.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UUID " + C_Tax.getUUID());
			}
		} else {
			this.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public ForeignEntityInput C_Tax() {
		return mC_Tax;
	}

	/**
	 * Set Tax Credit.
	 *
	 * @param T_Credit_A Account for Tax you can reclaim
	 */
	@JsonProperty("T_Credit_A")
	public void setT_Credit_AInput(ForeignEntityInput T_Credit_A) {
		this.mT_Credit_A = T_Credit_A;
		if (T_Credit_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(T_Credit_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setT_Credit_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + T_Credit_A.getUUID());
			}
		} else {
			this.setT_Credit_Acct(0);
		}
	}

	/**
	 * Get Tax Credit.
	 *
	 * @return Account for Tax you can reclaim
	 */
	@JsonProperty("T_Credit_A")
	public ForeignEntityInput T_Credit_A() {
		return mT_Credit_A;
	}

	/**
	 * Set Tax Due.
	 *
	 * @param T_Due_A Account for Tax you have to pay
	 */
	@JsonProperty("T_Due_A")
	public void setT_Due_AInput(ForeignEntityInput T_Due_A) {
		this.mT_Due_A = T_Due_A;
		if (T_Due_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(T_Due_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setT_Due_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + T_Due_A.getUUID());
			}
		} else {
			this.setT_Due_Acct(0);
		}
	}

	/**
	 * Get Tax Due.
	 *
	 * @return Account for Tax you have to pay
	 */
	@JsonProperty("T_Due_A")
	public ForeignEntityInput T_Due_A() {
		return mT_Due_A;
	}

	/**
	 * Set Tax Expense.
	 *
	 * @param T_Expense_A Account for paid tax you cannot reclaim
	 */
	@JsonProperty("T_Expense_A")
	public void setT_Expense_AInput(ForeignEntityInput T_Expense_A) {
		this.mT_Expense_A = T_Expense_A;
		if (T_Expense_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(T_Expense_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setT_Expense_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + T_Expense_A.getUUID());
			}
		} else {
			this.setT_Expense_Acct(0);
		}
	}

	/**
	 * Get Tax Expense.
	 *
	 * @return Account for paid tax you cannot reclaim
	 */
	@JsonProperty("T_Expense_A")
	public ForeignEntityInput T_Expense_A() {
		return mT_Expense_A;
	}
}
