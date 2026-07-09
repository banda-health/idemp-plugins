package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHEmployeeComponent extends X_BH_Employee_Component {

	public MBHEmployeeComponent(Properties ctx, int BH_Employee_Component_ID, String trxName) {
		super(ctx, BH_Employee_Component_ID, trxName);
	}

	public MBHEmployeeComponent(Properties ctx, int BH_Employee_Component_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Employee_Component_ID, trxName, virtualColumns);
	}

	public MBHEmployeeComponent(Properties ctx, String BH_Employee_Component_UU, String trxName) {
		super(ctx, BH_Employee_Component_UU, trxName);
	}

	public MBHEmployeeComponent(Properties ctx, String BH_Employee_Component_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Employee_Component_UU, trxName, virtualColumns);
	}

	public MBHEmployeeComponent(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
