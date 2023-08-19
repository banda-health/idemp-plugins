package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFldSug extends X_BH_Payer_Info_Fld_Sug {
	public MBHPayerInfoFldSug(Properties ctx, int BH_Charge_Info_Suggestion_ID, String trxName) {
		super(ctx, BH_Charge_Info_Suggestion_ID, trxName);
	}

	public MBHPayerInfoFldSug(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
