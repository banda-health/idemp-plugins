package org.bandahealth.idempiere.base.model;

import org.compiere.model.Query;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MBHPaymentRef extends X_BH_PaymentRef {
	public MBHPaymentRef(Properties ctx, int BH_PaymentRef_ID, String trxName) {
		super(ctx, BH_PaymentRef_ID, trxName);
	}

	public MBHPaymentRef(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public List<MBHPaymentRefBankAccount> getBH_PaymentRef_BankAccounts() {
		List<MBHPaymentRefBankAccount> paymentRefBankAccounts = new Query(
				getCtx(),
				MBHPaymentRefBankAccount.Table_Name,
				MBHPaymentRefBankAccount.COLUMNNAME_BH_PaymentRef_ID + "=?",
				get_TrxName()
		)
				.setParameters(getBH_PaymentRef_ID())
				.setOrderBy(MBHPaymentRefBankAccount.COLUMNNAME_Created + " DESC")
				.list();
		return paymentRefBankAccounts == null ? new ArrayList<MBHPaymentRefBankAccount>() : paymentRefBankAccounts;
	}
}
