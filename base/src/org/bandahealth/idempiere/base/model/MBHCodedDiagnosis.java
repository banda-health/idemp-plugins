package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHCodedDiagnosis extends X_BH_Coded_Diagnosis {
	public MBHCodedDiagnosis(Properties ctx, int BH_Coded_Diagnosis_ID, String trxName) {
		super(ctx, BH_Coded_Diagnosis_ID, trxName);
	}

	public MBHCodedDiagnosis(Properties ctx, int BH_Coded_Diagnosis_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Coded_Diagnosis_ID, trxName, virtualColumns);
	}

	public MBHCodedDiagnosis(Properties ctx, String BH_Coded_Diagnosis_UU, String trxName) {
		super(ctx, BH_Coded_Diagnosis_UU, trxName);
	}

	public MBHCodedDiagnosis(Properties ctx, String BH_Coded_Diagnosis_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Coded_Diagnosis_UU, trxName, virtualColumns);
	}

	public MBHCodedDiagnosis(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
