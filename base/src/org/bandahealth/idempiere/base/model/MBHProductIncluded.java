package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHProductIncluded extends X_BH_Product_Included {
	public MBHProductIncluded(Properties ctx, int BH_Product_Included_ID, String trxName) {
		super(ctx, BH_Product_Included_ID, trxName);
	}

	public MBHProductIncluded(Properties ctx, int BH_Product_Included_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Product_Included_ID, trxName, virtualColumns);
	}

	public MBHProductIncluded(Properties ctx, String BH_Product_Included_UU, String trxName) {
		super(ctx, BH_Product_Included_UU, trxName);
	}

	public MBHProductIncluded(Properties ctx, String BH_Product_Included_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Product_Included_UU, trxName, virtualColumns);
	}

	public MBHProductIncluded(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
