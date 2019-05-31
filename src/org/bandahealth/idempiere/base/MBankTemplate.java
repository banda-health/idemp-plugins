package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MBank;
import org.compiere.model.Query;

public class MBankTemplate extends BaseTemplate<MBank> {

	private String trxName;
	private Properties ctx;

	public MBankTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MBank getInstance(int... args) {
		MBank bank = new Query(getCtx(), MBank.Table_Name, "name = 'Test Bank'", getTrxName()).first();
		if (bank == null) {
			bank = new MBank(getCtx(), 0, getTrxName());
			bank.setName("Test Bank");
			bank.setRoutingNo("12345");
			bank.saveEx();
		}

		return bank;
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
