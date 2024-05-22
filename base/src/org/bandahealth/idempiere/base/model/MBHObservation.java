package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHObservation extends X_BH_Observation {
	public MBHObservation(Properties ctx, int BH_Observation_ID, String trxName) {
		super(ctx, BH_Observation_ID, trxName);
	}

	public MBHObservation(Properties ctx, int BH_Observation_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Observation_ID, trxName, virtualColumns);
	}

	public MBHObservation(Properties ctx, String BH_Observation_UU, String trxName) {
		super(ctx, BH_Observation_UU, trxName);
	}

	public MBHObservation(Properties ctx, String BH_Observation_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Observation_UU, trxName, virtualColumns);
	}

	public MBHObservation(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
