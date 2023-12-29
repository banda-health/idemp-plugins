package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBank;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccountInput extends MBankAccount_BH implements I_C_BankAccountInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BankAccountType_RL;
	 private I_C_BankInput C_Bank;
	 private I_C_CurrencyInput C_Currency;

	/**
	 * Standard constructor
	 */
	public X_C_BankAccountInput(String ID) {
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
	 * Set Bank Account Type.
	 *
	 * @param BankAccountType_RL Bank Account Type
	 */
	public void setBankAccountType_RL(I_AD_Ref_ListInput BankAccountType_RL) {
		this.BankAccountType_RL = BankAccountType_RL;
		MRefList foreignEntity;
		if (BankAccountType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BankAccountType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBankAccountType(foreignEntity.getValue());
		} else {
			this.setBankAccountType(null);
		}
	}

	/**
	 * Get Bank Account Type.
	 *
	 * @return Bank Account Type
	 */
	public I_AD_Ref_ListInput getBankAccountType_RL() {
		return BankAccountType_RL;
	}

	/**
	 * Set Bank.
	 *
	 * @param C_Bank Bank
	 */
	public void setC_Bank(I_C_BankInput C_Bank) {
		this.C_Bank = C_Bank;
		MBank foreignEntity;
		if (get_ID() == 0 &&C_Bank != null &&
				(foreignEntity = new Query(getCtx(), MBank.Table_Name, MBank.COLUMNNAME_C_Bank_UU + "=?", get_TrxName())
						.setParameters(C_Bank.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Bank_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	public I_C_BankInput getC_Bank() {
		return C_Bank;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BankAccount_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BankAccount_UU();
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}
}
