package org.bandahealth.idempiere.base.test;

import java.util.Properties;

import org.compiere.model.MBankAccount;
import org.compiere.model.Query;

public class MBankAccountTemplate extends BaseModelTemplate<MBankAccount> {

	private int orgId;
	private int currencyId;
	private int clientId;
	private static String WHERE_CLAUSE = "AD_Org_ID=? AND C_Currency_ID=?";

	public MBankAccountTemplate(String transactionName, Properties context, int orgId, int clientId) {
		super(transactionName, context);

		this.orgId = orgId;
		this.clientId = clientId;
		this.currencyId = getCurrencyId();
	}

	@Override
	protected MBankAccount createInstance() {
		MBankAccount bankAccount = new MBankAccount(getContext(), 0, getTransactionName());
		bankAccount.setName("Test Bank Account");
		bankAccount.setAD_Org_ID(orgId);
		bankAccount.setC_Currency_ID(currencyId);
		bankAccount.setAccountNo("12345");
		bankAccount.setBankAccountType("C");
		bankAccount.setC_Bank_ID(new MBankTemplate(WHERE_CLAUSE, getContext()).getInstance().get_ID());
		bankAccount.saveEx();

		commit();

		return bankAccount;
	}

	@Override
	protected MBankAccount findInstance() {
		MBankAccount bankAccount = new Query(getContext(), MBankAccount.Table_Name, WHERE_CLAUSE, getTransactionName())
				.setParameters(orgId, currencyId).setOnlyActiveRecords(true).setOrderBy("IsDefault DESC").first();
		return bankAccount;
	}

	@Override
	protected void setFields(MBankAccount instance) {
	}

	private int getCurrencyId() {
		return new MCurrencyTemplate(getTransactionName(), getContext(), orgId, clientId).getInstance().get_ID();
	}
}
