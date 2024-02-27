package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHConceptMapping extends X_BH_Concept_Mapping {
	public MBHConceptMapping(Properties ctx, int BH_Concept_Mapping_ID, String trxName) {
		super(ctx, BH_Concept_Mapping_ID, trxName);
	}

	public MBHConceptMapping(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
