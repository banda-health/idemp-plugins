package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHClientConcept extends X_BH_Client_Concept {
	public MBHClientConcept(Properties ctx, int BH_Client_Concept_ID, String trxName) {
		super(ctx, BH_Client_Concept_ID, trxName);
	}

	public MBHClientConcept(Properties ctx, int BH_Client_Concept_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Client_Concept_ID, trxName, virtualColumns);
	}

	public MBHClientConcept(Properties ctx, String BH_Client_Concept_UU, String trxName) {
		super(ctx, BH_Client_Concept_UU, trxName);
	}

	public MBHClientConcept(Properties ctx, String BH_Client_Concept_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Client_Concept_UU, trxName, virtualColumns);
	}

	public MBHClientConcept(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
