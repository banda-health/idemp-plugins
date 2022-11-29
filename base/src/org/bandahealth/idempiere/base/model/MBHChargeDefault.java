package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeDefault extends X_BH_ChargeDefault {
	public MBHChargeDefault(Properties ctx, int BH_ChargeDefault_ID, String trxName) {
		super(ctx, BH_ChargeDefault_ID, trxName);
	}

	public MBHChargeDefault(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
