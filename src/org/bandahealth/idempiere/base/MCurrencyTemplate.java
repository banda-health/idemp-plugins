package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MCurrency;
import org.compiere.model.Query;

public class MCurrencyTemplate extends BaseTemplate<MCurrency> {

	private String trxName;
	private Properties ctx;

	public MCurrencyTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MCurrency getInstance(int... args) {
		MCurrency currency = new Query(ctx, MCurrency.Table_Name, "iso_code = 'KE'", trxName).first();
		if (currency == null) {
			currency = new MCurrency(ctx, 0, trxName);
			currency.setISO_Code("KE");
			currency.setDescription("KE");
			currency.setAD_Org_ID(args[0]);
			currency.saveEx();
		}
		return currency;
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
