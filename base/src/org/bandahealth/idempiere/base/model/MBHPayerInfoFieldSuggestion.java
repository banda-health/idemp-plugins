package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFieldSuggestion extends X_BH_Payer_Info_Field_Suggestion {
	public MBHPayerInfoFieldSuggestion(Properties ctx, int BH_Charge_Info_Suggestion_ID, String trxName) {
		super(ctx, BH_Charge_Info_Suggestion_ID, trxName);
	}

	public MBHPayerInfoFieldSuggestion(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
