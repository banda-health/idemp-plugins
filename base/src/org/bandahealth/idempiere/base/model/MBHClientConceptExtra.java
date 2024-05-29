package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHClientConceptExtra extends X_BH_Client_Concept_Extra {
	
	public MBHClientConceptExtra(Properties ctx, int BH_Client_Concept_Extra_ID, String trxName) {
		super(ctx, BH_Client_Concept_Extra_ID, trxName);
	}

	public MBHClientConceptExtra(Properties ctx, int BH_Client_Concept_Extra_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Client_Concept_Extra_ID, trxName, virtualColumns);
	}

	public MBHClientConceptExtra(Properties ctx, String BH_Client_Concept_Extra_UU, String trxName) {
		super(ctx, BH_Client_Concept_Extra_UU, trxName);
	}

	public MBHClientConceptExtra(Properties ctx, String BH_Client_Concept_Extra_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Client_Concept_Extra_UU, trxName, virtualColumns);
	}

	public MBHClientConceptExtra(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
