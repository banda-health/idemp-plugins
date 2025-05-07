package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHTags extends X_BH_Tags {

	public MBHTags(Properties ctx, int BH_Tags_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Tags_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MBHTags(Properties ctx, int BH_Tags_ID, String trxName) {
		super(ctx, BH_Tags_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBHTags(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBHTags(Properties ctx, String BH_Tags_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Tags_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MBHTags(Properties ctx, String BH_Tags_UU, String trxName) {
		super(ctx, BH_Tags_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
