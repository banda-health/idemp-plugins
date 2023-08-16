package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoField extends X_BH_Payer_Info_Field {
	public MBHPayerInfoField(Properties ctx, int BH_Charge_Info_ID, String trxName) {
		super(ctx, BH_Charge_Info_ID, trxName);
	}

	public MBHPayerInfoField(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
