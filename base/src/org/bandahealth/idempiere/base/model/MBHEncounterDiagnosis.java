package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHEncounterDiagnosis extends X_BH_Encounter_Diagnosis {
	public MBHEncounterDiagnosis(Properties ctx, int BH_Encounter_Diagnosis_ID, String trxName) {
		super(ctx, BH_Encounter_Diagnosis_ID, trxName);
	}

	public MBHEncounterDiagnosis(Properties ctx, int BH_Encounter_Diagnosis_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Encounter_Diagnosis_ID, trxName, virtualColumns);
	}

	public MBHEncounterDiagnosis(Properties ctx, String BH_Encounter_Diagnosis_UU, String trxName) {
		super(ctx, BH_Encounter_Diagnosis_UU, trxName);
	}

	public MBHEncounterDiagnosis(Properties ctx, String BH_Encounter_Diagnosis_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Encounter_Diagnosis_UU, trxName, virtualColumns);
	}

	public MBHEncounterDiagnosis(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
