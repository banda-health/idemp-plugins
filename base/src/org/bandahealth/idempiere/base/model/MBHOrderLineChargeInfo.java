package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHOrderLineChargeInfo extends X_BH_OrderLine_Charge_Info {
	public MBHOrderLineChargeInfo(Properties ctx, int BH_OrderLine_Charge_Info_ID, String trxName) {
		super(ctx, BH_OrderLine_Charge_Info_ID, trxName);
	}

	public MBHOrderLineChargeInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
