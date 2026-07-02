package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHSickOffPrintLog extends X_BH_SickOff_Print_Log {

	public MBHSickOffPrintLog(Properties ctx, int BH_SickOff_Print_Log_ID, String trxName) {
		super(ctx, BH_SickOff_Print_Log_ID, trxName);
	}

	public MBHSickOffPrintLog(Properties ctx, int BH_SickOff_Print_Log_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_SickOff_Print_Log_ID, trxName, virtualColumns);
	}

	public MBHSickOffPrintLog(Properties ctx, String BH_SickOff_Print_Log_UU, String trxName) {
		super(ctx, BH_SickOff_Print_Log_UU, trxName);
	}

	public MBHSickOffPrintLog(Properties ctx, String BH_SickOff_Print_Log_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_SickOff_Print_Log_UU, trxName, virtualColumns);
	}

	public MBHSickOffPrintLog(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
