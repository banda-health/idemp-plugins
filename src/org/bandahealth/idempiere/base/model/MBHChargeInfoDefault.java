package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeInfoDefault extends X_BH_Charge_Info_Default {
	public MBHChargeInfoDefault(Properties ctx, int BH_Charge_Info_Default_ID, String trxName) {
		super(ctx, BH_Charge_Info_Default_ID, trxName);
	}

	public MBHChargeInfoDefault(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
