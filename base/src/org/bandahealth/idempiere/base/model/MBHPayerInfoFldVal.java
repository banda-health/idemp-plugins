package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFldVal extends X_BH_Payer_Info_Fld_Val {
	public MBHPayerInfoFldVal(Properties ctx, int BH_Charge_Info_Values_ID, String trxName) {
		super(ctx, BH_Charge_Info_Values_ID, trxName);
	}

	public MBHPayerInfoFldVal(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
