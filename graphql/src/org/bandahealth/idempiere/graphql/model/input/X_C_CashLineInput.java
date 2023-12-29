package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCash;
import org.compiere.model.MCashLine;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashLineInput extends MCashLine implements I_C_CashLineInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CashType_RL;
	 private I_C_BankAccountInput C_BankAccount;
	 private I_C_CashInput C_Cash;
	 private I_C_ChargeInput C_Charge;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_InvoiceInput C_Invoice;
	 private I_C_PaymentInput C_Payment;

	/**
	 * Standard constructor
	 */
	public X_C_CashLineInput(String ID) {
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
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	public void setC_BankAccount(I_C_BankAccountInput C_BankAccount) {
		this.C_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (C_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), MBankAccount_BH.Table_Name, MBankAccount_BH.COLUMNNAME_C_BankAccount_UU + "=?", get_TrxName())
						.setParameters(C_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BankAccount_ID(foreignEntity.get_ID());
		} else {
			this.setC_BankAccount_ID(0);
		}
	}

	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public I_C_BankAccountInput getC_BankAccount() {
		return C_BankAccount;
	}

	/**
	 * Set Cash Journal.
	 *
	 * @param C_Cash Cash Journal
	 */
	public void setC_Cash(I_C_CashInput C_Cash) {
		this.C_Cash = C_Cash;
		MCash foreignEntity;
		if (get_ID() == 0 &&C_Cash != null &&
				(foreignEntity = new Query(getCtx(), MCash.Table_Name, MCash.COLUMNNAME_C_Cash_UU + "=?", get_TrxName())
						.setParameters(C_Cash.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Cash_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Cash Journal.
	 *
	 * @return Cash Journal
	 */
	public I_C_CashInput getC_Cash() {
		return C_Cash;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CashLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_CashLine_UU();
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			this.setC_Charge_ID(0);
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
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (get_ID() == 0 &&C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
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

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	public void setC_Invoice(I_C_InvoiceInput C_Invoice) {
		this.C_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 &&C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Invoice_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public I_C_InvoiceInput getC_Invoice() {
		return C_Invoice;
	}

	/**
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	public void setC_Payment(I_C_PaymentInput C_Payment) {
		this.C_Payment = C_Payment;
		MPayment_BH foreignEntity;
		if (C_Payment != null &&
				(foreignEntity = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", get_TrxName())
						.setParameters(C_Payment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Payment_ID(foreignEntity.get_ID());
		} else {
			this.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public I_C_PaymentInput getC_Payment() {
		return C_Payment;
	}

	/**
	 * Set Cash Type.
	 *
	 * @param CashType_RL Source of Cash
	 */
	public void setCashType_RL(I_AD_Ref_ListInput CashType_RL) {
		this.CashType_RL = CashType_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&CashType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CashType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCashType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Cash Type.
	 *
	 * @return Source of Cash
	 */
	public I_AD_Ref_ListInput getCashType_RL() {
		return CashType_RL;
	}
	/**
	 * Set Generated.
	 *
	 * @param IsGenerated This Line is generated
	 */
	public void setIsGenerated(boolean IsGenerated) {
		if (get_ID() == 0) {
			super.setIsGenerated(IsGenerated);
		}
	}
}
