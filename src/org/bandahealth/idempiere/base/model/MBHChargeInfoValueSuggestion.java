package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeInfoValueSuggestion extends X_BH_Charge_Info_Values_Suggestion {
	public MBHChargeInfoValueSuggestion(Properties ctx, int BH_Charge_Info_Values_Suggestion_ID,
			String trxName) {
		super(ctx, BH_Charge_Info_Values_Suggestion_ID, trxName);
	}

	public MBHChargeInfoValueSuggestion(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
