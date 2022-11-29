package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeTypeDefault extends X_BH_ChargeTypeDefault {
	public MBHChargeTypeDefault(Properties ctx, int BH_ChargeTypeDefault_ID, String trxName) {
		super(ctx, BH_ChargeTypeDefault_ID, trxName);
	}

	public MBHChargeTypeDefault(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
