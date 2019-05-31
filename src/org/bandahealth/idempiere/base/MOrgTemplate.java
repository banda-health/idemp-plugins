package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MOrg;
import org.compiere.model.Query;

public class MOrgTemplate extends BaseTemplate<MOrg> {

	private String trxName;
	private Properties ctx;

	public MOrgTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MOrg getInstance(int... args) {
		MOrg organization = new Query(getCtx(), MOrg.Table_Name, "name = 'Test Organization'", getTrxName()).first();
		if (organization == null) {
			organization = new MOrg(getCtx(), 0, getTrxName());
			organization.setName("Test Organization");
			organization.saveEx();
		}

		return organization;
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
