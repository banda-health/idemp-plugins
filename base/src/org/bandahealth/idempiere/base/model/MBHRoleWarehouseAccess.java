package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHRoleWarehouseAccess extends X_BH_Role_WarehouseAccess {
	public MBHRoleWarehouseAccess(Properties ctx, int BH_Role_WarehouseAccess_ID, String trxName) {
		super(ctx, BH_Role_WarehouseAccess_ID, trxName);
	}

	public MBHRoleWarehouseAccess(Properties ctx, int BH_Role_WarehouseAccess_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Role_WarehouseAccess_ID, trxName, virtualColumns);
	}

	public MBHRoleWarehouseAccess(Properties ctx, String BH_Role_WarehouseAccess_UU, String trxName) {
		super(ctx, BH_Role_WarehouseAccess_UU, trxName);
	}

	public MBHRoleWarehouseAccess(Properties ctx, String BH_Role_WarehouseAccess_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Role_WarehouseAccess_UU, trxName, virtualColumns);
	}

	public MBHRoleWarehouseAccess(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
