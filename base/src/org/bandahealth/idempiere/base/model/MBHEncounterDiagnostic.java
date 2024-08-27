package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHEncounterDiagnostic extends X_BH_Encounter_Diagnostic {
	public MBHEncounterDiagnostic(Properties ctx, int BH_Encounter_Diagnostic_ID, String trxName) {
		super(ctx, BH_Encounter_Diagnostic_ID, trxName);
	}

	public MBHEncounterDiagnostic(Properties ctx, int BH_Encounter_Diagnostic_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Encounter_Diagnostic_ID, trxName, virtualColumns);
	}

	public MBHEncounterDiagnostic(Properties ctx, String BH_Encounter_Diagnostic_UU, String trxName) {
		super(ctx, BH_Encounter_Diagnostic_UU, trxName);
	}

	public MBHEncounterDiagnostic(Properties ctx, String BH_Encounter_Diagnostic_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Encounter_Diagnostic_UU, trxName, virtualColumns);
	}

	public MBHEncounterDiagnostic(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
