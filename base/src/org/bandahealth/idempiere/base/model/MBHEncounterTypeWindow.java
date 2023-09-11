package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHEncounterTypeWindow extends X_BH_Encounter_Type_Window {

	public MBHEncounterTypeWindow(Properties ctx, int BH_Encounter_ID, String trxName) {
		super(ctx, BH_Encounter_ID, trxName);
	}

	public MBHEncounterTypeWindow(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
