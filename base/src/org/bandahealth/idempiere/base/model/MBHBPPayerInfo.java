package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHBPPayerInfo extends X_BH_BP_Payer_Info {
	public MBHBPPayerInfo(Properties ctx, int BH_BP_Payer_Info_ID, String trxName) {
		super(ctx, BH_BP_Payer_Info_ID, trxName);
	}

	public MBHBPPayerInfo(Properties ctx, int BH_BP_Payer_Info_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_BP_Payer_Info_ID, trxName, virtualColumns);
	}

	public MBHBPPayerInfo(Properties ctx, String BH_BP_Payer_Info_UU, String trxName) {
		super(ctx, BH_BP_Payer_Info_UU, trxName);
	}

	public MBHBPPayerInfo(Properties ctx, String BH_BP_Payer_Info_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_BP_Payer_Info_UU, trxName, virtualColumns);
	}

	public MBHBPPayerInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
