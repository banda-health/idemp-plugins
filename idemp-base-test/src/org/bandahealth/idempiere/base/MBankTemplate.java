package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MBank;
import org.compiere.model.Query;

public class MBankTemplate extends BaseModelTemplate<MBank> {

	public MBankTemplate(String transactionName, Properties context) {
		super(transactionName, context);
	}

	@Override
	protected MBank createInstance() {
		MBank bank = new MBank(getContext(), 0, getTransactionName());
		bank.setName("Test Bank");
		bank.setRoutingNo("12345");
		bank.saveEx();

		commit();

		return bank;
	}

	@Override
	protected MBank findInstance() {
		return new Query(getContext(), MBank.Table_Name, "name = 'Test Bank'", getTransactionName()).first();
	}

	@Override
	protected void setFields(MBank instance) {
	}
}