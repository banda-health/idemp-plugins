package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHDefaultDocActionAccess extends X_BH_Default_DocAction_Access {
	public MBHDefaultDocActionAccess(Properties ctx, int BH_Default_DocAction_Access_ID, String trxName) {
		super(ctx, BH_Default_DocAction_Access_ID, trxName);
	}

	public MBHDefaultDocActionAccess(Properties ctx, int BH_Default_DocAction_Access_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Default_DocAction_Access_ID, trxName, virtualColumns);
	}

	public MBHDefaultDocActionAccess(Properties ctx, String BH_Default_DocAction_Access_UU, String trxName) {
		super(ctx, BH_Default_DocAction_Access_UU, trxName);
	}

	public MBHDefaultDocActionAccess(Properties ctx, String BH_Default_DocAction_Access_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Default_DocAction_Access_UU, trxName, virtualColumns);
	}

	public MBHDefaultDocActionAccess(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
