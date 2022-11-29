package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHDefaultDocActionAccess extends X_BH_Default_DocAction_Access {
	public MBHDefaultDocActionAccess(Properties ctx, int BH_Default_DocAction_Access_ID, String trxName) {
		super(ctx, BH_Default_DocAction_Access_ID, trxName);
	}

	public MBHDefaultDocActionAccess(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
