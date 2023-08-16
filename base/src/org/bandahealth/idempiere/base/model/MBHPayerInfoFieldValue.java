package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFieldValue extends X_BH_Payer_Info_Field_Value {
	public MBHPayerInfoFieldValue(Properties ctx, int BH_Charge_Info_Values_ID, String trxName) {
		super(ctx, BH_Charge_Info_Values_ID, trxName);
	}

	public MBHPayerInfoFieldValue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
