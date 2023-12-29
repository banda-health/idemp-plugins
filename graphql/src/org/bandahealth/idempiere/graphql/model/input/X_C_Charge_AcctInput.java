package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.Env;

/**
 * Generated Model for C_Charge_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Charge_AcctInput extends X_C_Charge_Acct implements I_C_Charge_AcctInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_ChargeInput C_Charge;
	 private I_C_ValidCombinationInput Ch_Expense_A;

	/**
	 * Standard constructor
	 */
	public X_C_Charge_AcctInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 &&C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
	}
	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema_ID Rules for accounting
	 */

	public void setC_AcctSchema_ID(int C_AcctSchema_ID) {
		if (get_ID() == 0) {
			super.setC_AcctSchema_ID(C_AcctSchema_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Charge_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Charge_Acct_UU();
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (get_ID() == 0 &&C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public I_C_ChargeInput getC_Charge() {
		return C_Charge;
	}
	/**
	 * Set Charge.
	 *
	 * @param C_Charge_ID Additional document charges
	 */

	public void setC_Charge_ID(int C_Charge_ID) {
		if (get_ID() == 0) {
			super.setC_Charge_ID(C_Charge_ID);
		}
	}

	/**
	 * Set Charge Account.
	 *
	 * @param Ch_Expense_A Charge Account
	 */
	public void setCh_Expense_A(I_C_ValidCombinationInput Ch_Expense_A) {
		this.Ch_Expense_A = Ch_Expense_A;
		MAccount foreignEntity;
		if (Ch_Expense_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(Ch_Expense_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCh_Expense_Acct(foreignEntity.get_ID());
		} else {
			this.setCh_Expense_Acct(0);
		}
	}

	/**
	 * Get Charge Account.
	 *
	 * @return Charge Account
	 */
	public I_C_ValidCombinationInput getCh_Expense_A() {
		return Ch_Expense_A;
	}
}
