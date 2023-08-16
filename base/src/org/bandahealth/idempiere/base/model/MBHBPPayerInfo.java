package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHBPPayerInfo extends X_BH_BP_Payer_Info {
	public MBHBPPayerInfo(Properties ctx, int BH_BPartner_Charge_ID, String trxName) {
		super(ctx, BH_BPartner_Charge_ID, trxName);
	}

	public MBHBPPayerInfo(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
