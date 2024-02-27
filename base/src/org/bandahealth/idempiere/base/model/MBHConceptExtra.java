package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHConceptExtra extends X_BH_Concept_Extra {
	public MBHConceptExtra(Properties ctx, int BH_Concept_Extra_ID, String trxName) {
		super(ctx, BH_Concept_Extra_ID, trxName);
	}

	public MBHConceptExtra(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
