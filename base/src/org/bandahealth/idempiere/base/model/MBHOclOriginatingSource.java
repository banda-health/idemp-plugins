package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHOclOriginatingSource extends X_BH_Ocl_Originating_Source {
	public MBHOclOriginatingSource(Properties ctx, int BH_Ocl_Originating_Source_ID, String trxName) {
		super(ctx, BH_Ocl_Originating_Source_ID, trxName);
	}

	public MBHOclOriginatingSource(Properties ctx, int BH_Ocl_Originating_Source_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Ocl_Originating_Source_ID, trxName, virtualColumns);
	}

	public MBHOclOriginatingSource(Properties ctx, String BH_Ocl_Originating_Source_UU, String trxName) {
		super(ctx, BH_Ocl_Originating_Source_UU, trxName);
	}

	public MBHOclOriginatingSource(Properties ctx, String BH_Ocl_Originating_Source_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Ocl_Originating_Source_UU, trxName, virtualColumns);
	}

	public MBHOclOriginatingSource(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
