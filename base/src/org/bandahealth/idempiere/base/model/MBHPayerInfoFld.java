package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFld extends X_BH_Payer_Info_Fld {
	public MBHPayerInfoFld(Properties ctx, int BH_Charge_Info_ID, String trxName) {
		super(ctx, BH_Charge_Info_ID, trxName);
	}

	public MBHPayerInfoFld(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
