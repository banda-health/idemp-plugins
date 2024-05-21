package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHEncounter extends X_BH_Encounter {
	public MBHEncounter(Properties ctx, int BH_Encounter_ID, String trxName) {
		super(ctx, BH_Encounter_ID, trxName);
	}

	public MBHEncounter(Properties ctx, int BH_Encounter_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Encounter_ID, trxName, virtualColumns);
	}

	public MBHEncounter(Properties ctx, String BH_Encounter_UU, String trxName) {
		super(ctx, BH_Encounter_UU, trxName);
	}

	public MBHEncounter(Properties ctx, String BH_Encounter_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Encounter_UU, trxName, virtualColumns);
	}

	public MBHEncounter(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
