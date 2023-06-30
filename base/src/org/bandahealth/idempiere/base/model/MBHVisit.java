package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHVisit extends X_BH_Visit {

	public MBHVisit(Properties ctx, int BH_Visit_ID, String trxName) {
		super(ctx, BH_Visit_ID, trxName);
	}

	public MBHVisit(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
