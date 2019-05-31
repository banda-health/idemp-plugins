package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MBankAccount;
import org.compiere.model.Query;

public class MBankAccountTemplate extends BaseTemplate<MBankAccount> {

	private String trxName;
	private Properties ctx;

	public MBankAccountTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MBankAccount getInstance(int... args) {
		String whereClause = "AD_Org_ID=? AND C_Currency_ID=?";
		int currencyId = new MCurrencyTemplate(trxName, ctx).getInstance(args[0]).get_ID();
		MBankAccount bankAccount = new Query(getCtx(), MBankAccount.Table_Name, whereClause, getTrxName())
				.setParameters(args[0], currencyId).setOnlyActiveRecords(true).setOrderBy("IsDefault DESC").first();
		if (bankAccount == null) {
			bankAccount = new MBankAccount(getCtx(), 0, getTrxName());
			bankAccount.setName("Test Bank Account");
			bankAccount.setAD_Org_ID(args[0]);
			bankAccount.setC_Currency_ID(currencyId);
			bankAccount.setAccountNo("12345");
			bankAccount.setBankAccountType("C");
			bankAccount.setC_Bank_ID(new MBankTemplate(whereClause, ctx).getInstance().get_ID());
			bankAccount.saveEx();
		}

		return bankAccount;
	}

	@Override
	protected String getTrxName() {
		return trxName;
	}

	@Override
	protected Properties getCtx() {
		return ctx;
	}
}
