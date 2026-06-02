package org.bandahealth.idempiere.base.model;

import org.bandahealth.idempiere.base.utils.FeatureFlagContext;
import org.bandahealth.idempiere.base.utils.FeatureFlagUtil;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHFeatureFlag extends X_BH_Feature_Flag {

	public MBHFeatureFlag(Properties ctx, int BH_Feature_Flag_ID, String trxName) {
		super(ctx, BH_Feature_Flag_ID, trxName);
	}

	public MBHFeatureFlag(Properties ctx, int BH_Feature_Flag_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Feature_Flag_ID, trxName, virtualColumns);
	}

	public MBHFeatureFlag(Properties ctx, String BH_Feature_Flag_UU, String trxName) {
		super(ctx, BH_Feature_Flag_UU, trxName);
	}

	public MBHFeatureFlag(Properties ctx, String BH_Feature_Flag_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Feature_Flag_UU, trxName, virtualColumns);
	}

	public MBHFeatureFlag(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public static MBHFeatureFlag getByKey(Properties ctx, String flagKey, String trxName) {
		return new Query(ctx, Table_Name,
				COLUMNNAME_IsActive + "=? AND " + COLUMNNAME_Name + "=? AND " + COLUMNNAME_AD_Client_ID + " IN (0,?)",
				trxName).setParameters(true, flagKey, Env.getAD_Client_ID(ctx)).first();
	}

	public boolean isEnabled(Properties ctx, FeatureFlagContext context, String trxName) {
		return FeatureFlagUtil.isEnabled(ctx, this, context, trxName);
	}
}
