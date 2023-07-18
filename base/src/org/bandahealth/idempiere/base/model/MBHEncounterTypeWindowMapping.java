package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHEncounterTypeWindowMapping extends X_BH_Encounter_Type_Window_Mapping {

	public MBHEncounterTypeWindowMapping(Properties ctx, int BH_Encounter_Type_Window_Mapping_ID, String trxName) {
		super(ctx, BH_Encounter_Type_Window_Mapping_ID, trxName);
	}

	public MBHEncounterTypeWindowMapping(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
