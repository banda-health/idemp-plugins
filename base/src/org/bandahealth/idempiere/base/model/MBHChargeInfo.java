package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeInfo extends X_BH_Charge_Info {
	public MBHChargeInfo(Properties ctx, int BH_Charge_Info_ID, String trxName) {
		super(ctx, BH_Charge_Info_ID, trxName);
	}

	public MBHChargeInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
