package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHConcept extends X_BH_Concept {
	public final static String TEST_CONCEPT_CLASS = "Test";

	public MBHConcept(Properties ctx, int BH_Concept_ID, String trxName) {
		super(ctx, BH_Concept_ID, trxName);
	}

	public MBHConcept(Properties ctx, int BH_Concept_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Concept_ID, trxName, virtualColumns);
	}

	public MBHConcept(Properties ctx, String BH_Concept_UU, String trxName) {
		super(ctx, BH_Concept_UU, trxName);
	}

	public MBHConcept(Properties ctx, String BH_Concept_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Concept_UU, trxName, virtualColumns);
	}

	public MBHConcept(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
