package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHBPSpecificPayerInfo extends X_BH_BP_Specific_Payer_Info {
	public MBHBPSpecificPayerInfo(Properties ctx, int BH_BP_Specific_Payer_Info_ID, String trxName) {
		super(ctx, BH_BP_Specific_Payer_Info_ID, trxName);
	}

	public MBHBPSpecificPayerInfo(Properties ctx, int BH_BP_Specific_Payer_Info_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_BP_Specific_Payer_Info_ID, trxName, virtualColumns);
	}

	public MBHBPSpecificPayerInfo(Properties ctx, String BH_BP_Specific_Payer_Info_UU, String trxName) {
		super(ctx, BH_BP_Specific_Payer_Info_UU, trxName);
	}

	public MBHBPSpecificPayerInfo(Properties ctx, String BH_BP_Specific_Payer_Info_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_BP_Specific_Payer_Info_UU, trxName, virtualColumns);
	}

	public MBHBPSpecificPayerInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
