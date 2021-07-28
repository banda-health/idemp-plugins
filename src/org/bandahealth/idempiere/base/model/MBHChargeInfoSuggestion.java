package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHChargeInfoSuggestion extends X_BH_Charge_Info_Suggestion {
	public MBHChargeInfoSuggestion(Properties ctx, int BH_Charge_Info_Suggestion_ID, String trxName) {
		super(ctx, BH_Charge_Info_Suggestion_ID, trxName);
	}

	public MBHChargeInfoSuggestion(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
