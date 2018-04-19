package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MProject;

public class MOrder_BH extends MOrder {

	/**
	 * Column name BH_Payments
	 */
	public static final String COLUMNNAME_BH_Payments = "BH_Payments";

	public MOrder_BH(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
	}

	public MOrder_BH(MProject project, boolean IsSOTrx, String DocSubTypeSO) {
		super(project, IsSOTrx, DocSubTypeSO);
	}

	public MOrder_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Get Payments.
	 *
	 * @return Payments
	 */
	public Object getBH_Payments() {
		return get_Value(COLUMNNAME_BH_Payments);
	}

	/**
	 * Set Payments.
	 *
	 * @param BH_Payments Payments
	 */
	public void setBH_Payments(Object BH_Payments) {
		set_Value(COLUMNNAME_BH_Payments, BH_Payments);
	}
}
