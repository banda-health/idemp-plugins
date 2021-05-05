package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeInfoValueDefault extends X_BH_Charge_Info_Values_Default {
	public MBHChargeInfoValueDefault(Properties ctx, int BH_Charge_Info_Values_Default_ID,
			String trxName) {
		super(ctx, BH_Charge_Info_Values_Default_ID, trxName);
	}

	public MBHChargeInfoValueDefault(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
