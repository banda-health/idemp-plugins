package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.Query;

public class MBPartnerTemplate extends BaseTemplate<MBPartner_BH> {

	private String trxName;
	private Properties ctx;

	public MBPartnerTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MBPartner_BH getInstance(int... args) {
		MBPartner_BH bpartner = new Query(getCtx(), MBPartner_BH.Table_Name, "name = 'Test Business Partner'", trxName)
				.first();
		if (bpartner == null) {
			bpartner = newInstance(args);
			bpartner.saveEx();
		}

		return bpartner;
	}

	public MBPartner_BH newInstance(int... args) {
		MBPartner_BH bpartner = new MBPartner_BH(getCtx(), 0, getTrxName());
		bpartner.setName("Test Business Partner");
		bpartner.setAD_Org_ID(args[0]);

		return bpartner;
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
