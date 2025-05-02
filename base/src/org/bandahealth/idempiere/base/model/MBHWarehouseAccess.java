package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHWarehouseAccess extends X_BH_Warehouse_Access {
	public MBHWarehouseAccess(Properties ctx, int BH_Warehouse_Access_ID, String trxName) {
		super(ctx, BH_Warehouse_Access_ID, trxName);
	}

	public MBHWarehouseAccess(Properties ctx, int BH_Warehouse_Access_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Warehouse_Access_ID, trxName, virtualColumns);
	}

	public MBHWarehouseAccess(Properties ctx, String BH_Warehouse_Access_UU, String trxName) {
		super(ctx, BH_Warehouse_Access_UU, trxName);
	}

	public MBHWarehouseAccess(Properties ctx, String BH_Warehouse_Access_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Warehouse_Access_UU, trxName, virtualColumns);
	}

	public MBHWarehouseAccess(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
