package org.bandahealth.idempiere.base.model;

import org.compiere.model.MOrder;
import org.compiere.model.MProject;
import org.compiere.model.MTable;

import java.sql.ResultSet;
import java.util.Properties;

public class MOrder_BH extends MOrder {
	/**
	 * Column name BH_Visit_ID
	 */
	public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";
	/**
	 * Column name BH_Voided_Reason_ID
	 */
	public static final String COLUMNNAME_BH_Voided_Reason_ID = "BH_Voided_Reason_ID";

	public MOrder_BH(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
	}

	public MOrder_BH(MProject project, boolean IsSOTrx, String DocSubTypeSO) {
		super(project, IsSOTrx, DocSubTypeSO);
	}

	public MOrder_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public I_BH_Visit getBH_Visit() throws RuntimeException {
		return (I_BH_Visit) MTable.get(getCtx(), I_BH_Visit.Table_Name)
				.getPO(getBH_Visit_ID(), get_TrxName());
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */
	public void setBH_Visit_ID(int BH_Visit_ID) {
		if (BH_Visit_ID < 1)
			set_Value(COLUMNNAME_BH_Visit_ID, null);
		else
			set_Value(COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public int getBH_Visit_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public I_BH_Voided_Reason getBH_Voided_Reason() throws RuntimeException {
		return (I_BH_Voided_Reason) MTable.get(getCtx(), I_BH_Voided_Reason.Table_Name)
				.getPO(getBH_Voided_Reason_ID(), get_TrxName());
	}

	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason_ID BH_Voided_Reason_ID
	 */
	public void setBH_Voided_Reason_ID(int BH_Voided_Reason_ID) {
		if (BH_Voided_Reason_ID < 1)
			set_Value(COLUMNNAME_BH_Voided_Reason_ID, null);
		else
			set_Value(COLUMNNAME_BH_Voided_Reason_ID, Integer.valueOf(BH_Voided_Reason_ID));
	}

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public int getBH_Voided_Reason_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Voided_Reason_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}
