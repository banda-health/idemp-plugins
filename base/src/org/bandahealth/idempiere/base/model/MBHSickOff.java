package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHSickOff extends X_BH_SickOff {

	public MBHSickOff(Properties ctx, int BH_SickOff_ID, String trxName) {
		super(ctx, BH_SickOff_ID, trxName);
	}

	public MBHSickOff(Properties ctx, int BH_SickOff_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_SickOff_ID, trxName, virtualColumns);
	}

	public MBHSickOff(Properties ctx, String BH_SickOff_UU, String trxName) {
		super(ctx, BH_SickOff_UU, trxName);
	}

	public MBHSickOff(Properties ctx, String BH_SickOff_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_SickOff_UU, trxName, virtualColumns);
	}

	public MBHSickOff(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
