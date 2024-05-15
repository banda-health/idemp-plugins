package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHProductCategoryDefault extends X_BH_Product_CategoryDefault {
	public MBHProductCategoryDefault(Properties ctx, int BH_Product_CategoryDefault_ID, String trxName) {
		super(ctx, BH_Product_CategoryDefault_ID, trxName);
	}

	public MBHProductCategoryDefault(Properties ctx, int BH_Product_CategoryDefault_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Product_CategoryDefault_ID, trxName, virtualColumns);
	}

	public MBHProductCategoryDefault(Properties ctx, String BH_Product_CategoryDefault_UU, String trxName) {
		super(ctx, BH_Product_CategoryDefault_UU, trxName);
	}

	public MBHProductCategoryDefault(Properties ctx, String BH_Product_CategoryDefault_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Product_CategoryDefault_UU, trxName, virtualColumns);
	}

	public MBHProductCategoryDefault(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
