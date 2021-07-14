package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHDefaultIncludedRole extends X_BH_DefaultIncludedRole {
	public MBHDefaultIncludedRole(Properties ctx, int BH_DefaultIncludedRole_ID, String trxName) {
		super(ctx, BH_DefaultIncludedRole_ID, trxName);
	}

	public MBHDefaultIncludedRole(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
