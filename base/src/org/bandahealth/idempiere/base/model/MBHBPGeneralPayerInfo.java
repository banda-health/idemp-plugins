package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHBPGeneralPayerInfo extends X_BH_BP_General_Payer_Info {
	public MBHBPGeneralPayerInfo(Properties ctx, int BH_BP_General_Payer_Info_ID, String trxName) {
		super(ctx, BH_BP_General_Payer_Info_ID, trxName);
	}

	public MBHBPGeneralPayerInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
