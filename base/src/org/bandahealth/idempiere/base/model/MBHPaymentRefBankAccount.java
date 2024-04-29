package org.bandahealth.idempiere.base.model;

import org.compiere.model.MBankAccount;
import org.compiere.model.MRefList;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPaymentRefBankAccount extends X_BH_PaymentRef_BankAcct {
	public MBHPaymentRefBankAccount(Properties ctx, int BH_PaymentRef_BankAcct_ID, String trxName) {
		super(ctx, BH_PaymentRef_BankAcct_ID, trxName);
	}

	public MBHPaymentRefBankAccount(Properties ctx, int BH_PaymentRef_BankAcct_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_PaymentRef_BankAcct_ID, trxName, virtualColumns);
	}

	public MBHPaymentRefBankAccount(Properties ctx, String BH_PaymentRef_BankAcct_UU, String trxName) {
		super(ctx, BH_PaymentRef_BankAcct_UU, trxName);
	}

	public MBHPaymentRefBankAccount(Properties ctx, String BH_PaymentRef_BankAcct_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_PaymentRef_BankAcct_UU, trxName, virtualColumns);
	}

	public MBHPaymentRefBankAccount(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MBHPaymentRefBankAccount(MRefList refList) {
		super(refList.getCtx(), 0, refList.get_TrxName());

		setAD_Ref_List_ID(refList.getAD_Ref_List_ID());
		setName(refList.getName());
		setBH_PaymentRefList_Value(refList.getValue());
	}

	public MBHPaymentRefBankAccount(MRefList refList, MBankAccount bankAccount) {
		this(refList);

		setC_BankAccount_ID(bankAccount.getC_BankAccount_ID());
		setAD_Client_ID(bankAccount.getAD_Client_ID());
		setAD_Org_ID(bankAccount.getAD_Org_ID());
	}
}
