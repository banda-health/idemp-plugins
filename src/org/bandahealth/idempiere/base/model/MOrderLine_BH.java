package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;

public class MOrderLine_BH extends MOrderLine {

	public static String COLUMNNAME_BH_Expiration = "Expiration";

	public MOrderLine_BH(MOrder order) {
		super(order);
		// TODO Auto-generated constructor stub
	}

	public MOrderLine_BH(Properties ctx, int C_OrderLine_ID, String trxName) {
		super(ctx, C_OrderLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MOrderLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public void setBH_Expiration(Object BH_Expiration) {
		set_Value(COLUMNNAME_BH_Expiration, BH_Expiration);
	}

	public Object getBH_Expiration() {
		return get_Value(COLUMNNAME_BH_Expiration);
	}
}
