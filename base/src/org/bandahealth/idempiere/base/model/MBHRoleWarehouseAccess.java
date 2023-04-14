package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHRoleWarehouseAccess extends X_BH_RoleWarehouseAccess {
	public MBHRoleWarehouseAccess(Properties ctx, int BH_RoleWarehouseAccess_ID, String trxName) {
		super(ctx, BH_RoleWarehouseAccess_ID, trxName);
	}

	public MBHRoleWarehouseAccess(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
