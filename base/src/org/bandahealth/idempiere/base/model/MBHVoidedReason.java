package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHVoidedReason extends X_BH_Voided_Reason {
	public MBHVoidedReason(Properties ctx, int BH_VoidedReason_ID, String trxName) {
		super(ctx, BH_VoidedReason_ID, trxName);
	}

	public MBHVoidedReason(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
