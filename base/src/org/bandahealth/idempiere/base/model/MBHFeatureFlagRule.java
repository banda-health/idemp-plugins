package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHFeatureFlagRule extends X_BH_Feature_Flag_Rule {

	public MBHFeatureFlagRule(Properties ctx, int BH_Feature_Flag_Rule_ID, String trxName) {
		super(ctx, BH_Feature_Flag_Rule_ID, trxName);
	}

	public MBHFeatureFlagRule(Properties ctx, int BH_Feature_Flag_Rule_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Feature_Flag_Rule_ID, trxName, virtualColumns);
	}

	public MBHFeatureFlagRule(Properties ctx, String BH_Feature_Flag_Rule_UU, String trxName) {
		super(ctx, BH_Feature_Flag_Rule_UU, trxName);
	}

	public MBHFeatureFlagRule(Properties ctx, String BH_Feature_Flag_Rule_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Feature_Flag_Rule_UU, trxName, virtualColumns);
	}

	public MBHFeatureFlagRule(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
