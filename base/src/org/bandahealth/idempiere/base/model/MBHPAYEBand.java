package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPAYEBand extends X_BH_PAYE_Band {

	public MBHPAYEBand(Properties ctx, int BH_PAYE_Band_ID, String trxName) {
		super(ctx, BH_PAYE_Band_ID, trxName);
	}

	public MBHPAYEBand(Properties ctx, int BH_PAYE_Band_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_PAYE_Band_ID, trxName, virtualColumns);
	}

	public MBHPAYEBand(Properties ctx, String BH_PAYE_Band_UU, String trxName) {
		super(ctx, BH_PAYE_Band_UU, trxName);
	}

	public MBHPAYEBand(Properties ctx, String BH_PAYE_Band_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_PAYE_Band_UU, trxName, virtualColumns);
	}

	public MBHPAYEBand(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
