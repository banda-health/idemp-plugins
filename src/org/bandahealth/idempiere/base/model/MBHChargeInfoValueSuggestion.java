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

	@Override
	/**
	 * Get the UUID column name for this entity. The base class truncates this due to some past constraints in the DB,
	 * but we've removed that limitation. So, we're overriding the method here.
	 */
	public String getUUIDColumnName() {
		return get_TableName() + "_UU";
	}
}
