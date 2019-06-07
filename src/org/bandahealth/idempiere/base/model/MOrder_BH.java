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

	/**
	 * Column name bh_isexpense
	 */
	public static final String COLUMNNAME_BH_IsExpense = "BH_isexpense";

	public static final String COLUMNNAME_BH_NEWVISIT = "bh_newvisit";

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

	public Object getBH_Isexpense() {
		return get_Value(COLUMNNAME_BH_IsExpense);
	}

	public void setBH_Isexpense(Object bh_isexpense) {
		set_Value(COLUMNNAME_BH_IsExpense, bh_isexpense);
	}
	
	public boolean isBH_NewVisit() {
		Object oo = get_Value(COLUMNNAME_BH_NEWVISIT);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}
	
	public void setBH_NewVisit(boolean newVisit) {
		set_Value(COLUMNNAME_BH_NEWVISIT, newVisit);
	}
}
