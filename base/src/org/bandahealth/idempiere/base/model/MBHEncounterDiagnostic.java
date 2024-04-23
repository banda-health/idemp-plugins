package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHEncounterDiagnostic extends X_BH_Encounter_Diagnostic {
	public MBHEncounterDiagnostic(Properties ctx, int BH_EncounterDiagnostic_ID, String trxName) {
		super(ctx, BH_EncounterDiagnostic_ID, trxName);
	}

	public MBHEncounterDiagnostic(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
