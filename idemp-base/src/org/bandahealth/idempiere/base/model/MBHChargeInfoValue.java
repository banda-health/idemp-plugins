package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeInfoValue extends X_BH_Charge_Info_Values {
	public MBHChargeInfoValue(Properties ctx, int BH_Charge_Info_Values_ID, String trxName) {
		super(ctx, BH_Charge_Info_Values_ID, trxName);
	}

	public MBHChargeInfoValue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
