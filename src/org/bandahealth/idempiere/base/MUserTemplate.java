package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.Query;

public class MUserTemplate extends BaseTemplate<MUser_BH> {

	private String trxName;
	private Properties ctx;

	public MUserTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MUser_BH getInstance(int... args) {
		MUser_BH salesRep = new Query(getCtx(), MBPartner.Table_Name, "name = 'Test Sales Rep'", getTrxName()).first();
		if (salesRep == null) {
			salesRep = new MUser_BH(getCtx(), 0, getTrxName());
			salesRep.setName("Test Sales Rep");
			salesRep.setAD_Org_ID(args[0]);
			salesRep.saveEx();
		}

		return salesRep;
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
