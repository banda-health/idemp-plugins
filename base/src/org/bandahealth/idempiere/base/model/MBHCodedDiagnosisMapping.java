package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHCodedDiagnosisMapping extends X_BH_Coded_Diagnosis_Mapping {
	public MBHCodedDiagnosisMapping(Properties ctx, int BH_Coded_Diagnosis_Mapping_ID, String trxName) {
		super(ctx, BH_Coded_Diagnosis_Mapping_ID, trxName);
	}

	public MBHCodedDiagnosisMapping(Properties ctx, int BH_Coded_Diagnosis_Mapping_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Coded_Diagnosis_Mapping_ID, trxName, virtualColumns);
	}

	public MBHCodedDiagnosisMapping(Properties ctx, String BH_Coded_Diagnosis_Mapping_UU, String trxName) {
		super(ctx, BH_Coded_Diagnosis_Mapping_UU, trxName);
	}

	public MBHCodedDiagnosisMapping(Properties ctx, String BH_Coded_Diagnosis_Mapping_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Coded_Diagnosis_Mapping_UU, trxName, virtualColumns);
	}

	public MBHCodedDiagnosisMapping(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
