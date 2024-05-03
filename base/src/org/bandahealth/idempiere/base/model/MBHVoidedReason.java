package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHVoidedReason extends X_BH_Voided_Reason {
	public MBHVoidedReason(Properties ctx, int BH_Voided_Reason_ID, String trxName) {
		super(ctx, BH_Voided_Reason_ID, trxName);
	}

	public MBHVoidedReason(Properties ctx, int BH_Voided_Reason_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Voided_Reason_ID, trxName, virtualColumns);
	}

	public MBHVoidedReason(Properties ctx, String BH_Voided_Reason_UU, String trxName) {
		super(ctx, BH_Voided_Reason_UU, trxName);
	}

	public MBHVoidedReason(Properties ctx, String BH_Voided_Reason_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Voided_Reason_UU, trxName, virtualColumns);
	}

	public MBHVoidedReason(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
