package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFldSug extends X_BH_Payer_Info_Fld_Sug {
	public MBHPayerInfoFldSug(Properties ctx, int BH_Payer_Info_Fld_Sug_ID, String trxName) {
		super(ctx, BH_Payer_Info_Fld_Sug_ID, trxName);
	}

	public MBHPayerInfoFldSug(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
