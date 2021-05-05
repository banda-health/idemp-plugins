package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHOrderLineInfo extends X_BH_OrderLine_Info {
	public MBHOrderLineInfo(Properties ctx, int BH_OrderLine_Info_ID, String trxName) {
		super(ctx, BH_OrderLine_Info_ID, trxName);
	}

	public MBHOrderLineInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
