package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHCodedDiagnosisMapping extends X_BH_CodedDiagnosisMapping {
	public MBHCodedDiagnosisMapping(Properties ctx, int BH_CodedDiagnosisMapping_ID, String trxName) {
		super(ctx, BH_CodedDiagnosisMapping_ID, trxName);
	}

	public MBHCodedDiagnosisMapping(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
