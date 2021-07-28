package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHBPartnerChargeInfo extends X_BH_BPartner_Charge_Info {
	public MBHBPartnerChargeInfo(Properties ctx, int BH_BPartner_Info_ID, String trxName) {
		super(ctx, BH_BPartner_Info_ID, trxName);
	}

	public MBHBPartnerChargeInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
