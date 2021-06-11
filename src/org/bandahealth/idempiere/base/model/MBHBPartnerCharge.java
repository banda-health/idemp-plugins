package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHBPartnerCharge extends X_BH_BPartner_Charge {
	public MBHBPartnerCharge(Properties ctx, int BH_BPartner_Charge_ID, String trxName) {
		super(ctx, BH_BPartner_Charge_ID, trxName);
	}

	public MBHBPartnerCharge(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
