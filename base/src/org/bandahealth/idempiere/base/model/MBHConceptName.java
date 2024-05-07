package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHConceptName extends X_BH_Concept_Name {
	public MBHConceptName(Properties ctx, int BH_Concept_Name_ID, String trxName) {
		super(ctx, BH_Concept_Name_ID, trxName);
	}

	public MBHConceptName(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
