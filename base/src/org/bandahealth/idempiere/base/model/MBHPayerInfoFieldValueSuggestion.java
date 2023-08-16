package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFieldValueSuggestion extends X_BH_Payer_Info_Field_Value_Suggestion {
	public MBHPayerInfoFieldValueSuggestion(Properties ctx, int BH_Charge_Info_Values_Suggestion_ID,
			String trxName) {
		super(ctx, BH_Charge_Info_Values_Suggestion_ID, trxName);
	}

	public MBHPayerInfoFieldValueSuggestion(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
