package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MBPartnerLocation;
import org.compiere.model.Query;

public class MBPartnerLocationTemplate extends BaseTemplate<MBPartnerLocation> {

	private String trxName;
	private Properties ctx;

	public MBPartnerLocationTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MBPartnerLocation getInstance(int... args) {
		MBPartnerLocation location = new Query(getCtx(), MBPartnerLocation.Table_Name, "name = 'Test Shipping Address'",
				getTrxName()).first();
		if (location == null) {
			location = new MBPartnerLocation(getCtx(), 0, getTrxName());
			location.setName("Test Shipping Address");
			location.setC_BPartner_ID(args[0]);
			location.setC_Location_ID(args[1]);
			location.setAD_Org_ID(args[2]);
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
