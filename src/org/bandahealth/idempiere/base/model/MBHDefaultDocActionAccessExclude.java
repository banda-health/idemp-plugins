package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHDefaultDocActionAccessExclude extends X_BH_Default_DocAction_Access_Exclude {
	public MBHDefaultDocActionAccessExclude(Properties ctx, int BH_Default_DocAction_Access_Exclude_ID,
			String trxName) {
		super(ctx, BH_Default_DocAction_Access_Exclude_ID, trxName);
	}

	public MBHDefaultDocActionAccessExclude(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
