package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHConceptDescription extends X_BH_Concept_Description {
	public MBHConceptDescription(Properties ctx, int BH_Concept_Description_ID, String trxName) {
		super(ctx, BH_Concept_Description_ID, trxName);
	}

	public MBHConceptDescription(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
