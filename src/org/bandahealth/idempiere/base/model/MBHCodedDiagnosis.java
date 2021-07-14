package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHCodedDiagnosis extends X_BH_CodedDiagnosis {
	public MBHCodedDiagnosis(Properties ctx, int BH_CodedDiagnosis_ID, String trxName) {
		super(ctx, BH_CodedDiagnosis_ID, trxName);
	}

	public MBHCodedDiagnosis(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
