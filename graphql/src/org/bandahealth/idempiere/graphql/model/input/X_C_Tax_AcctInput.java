package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.model.X_C_Tax_Acct;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_Tax_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_Tax_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
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
		setC_Tax_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MTax foreignEntity;
		if (get_ID() == 0 && C_Tax != null &&
				(foreignEntity = new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
						.setParameters(C_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Tax_ID(foreignEntity.get_ID());
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
		MAccount foreignEntity;
		if (T_Credit_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(T_Credit_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setT_Credit_Acct(foreignEntity.get_ID());
		} else {
			super.setT_Credit_Acct(0);
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
		MAccount foreignEntity;
		if (T_Due_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(T_Due_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setT_Due_Acct(foreignEntity.get_ID());
		} else {
			super.setT_Due_Acct(0);
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
		MAccount foreignEntity;
		if (T_Expense_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(T_Expense_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setT_Expense_Acct(foreignEntity.get_ID());
		} else {
			super.setT_Expense_Acct(0);
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
