package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHClientConcept extends X_BH_Client_Concept {
	public MBHClientConcept(Properties ctx, int BH_CodedDiagnosis_ID, String trxName) {
		super(ctx, BH_CodedDiagnosis_ID, trxName);
	}

	public MBHClientConcept(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
