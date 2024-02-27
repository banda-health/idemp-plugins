package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHConcept extends X_BH_Concept {
	public MBHConcept(Properties ctx, int BH_Concept_ID, String trxName) {
		super(ctx, BH_Concept_ID, trxName);
	}

	public MBHConcept(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
