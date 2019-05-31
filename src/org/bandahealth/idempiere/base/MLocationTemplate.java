package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MLocation;
import org.compiere.model.Query;

public class MLocationTemplate extends BaseTemplate<MLocation> {

	private String trxName;
	private Properties ctx;

	public MLocationTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MLocation getInstance(int... args) {
		MLocation location = new Query(getCtx(), MLocation.Table_Name, "address1 = 'Test Address 1'", getTrxName())
				.first();
		if (location == null) {
			location = new MLocation(getCtx(), 0, getTrxName());
			location.setAD_Org_ID(args[0]);
			location.setAddress1("Test Address 1");
			location.saveEx();
		}
		return location;
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