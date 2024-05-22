package org.bandahealth.idempiere.base.model;

import org.compiere.model.MInOut;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.model.MTable;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MInOut_BH extends MInOut {

	/**
	 * Column name BH_Visit_ID
	 */
	public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";

	public MInOut_BH(Properties ctx, String M_InOut_UU, String trxName) {
		super(ctx, M_InOut_UU, trxName);
	}

	public MInOut_BH(Properties ctx, int M_InOut_ID, String trxName) {
		super(ctx, M_InOut_ID, trxName);
	}

	public MInOut_BH(Properties ctx, int M_InOut_ID, String trxName, String... virtualColumns) {
		super(ctx, M_InOut_ID, trxName, virtualColumns);
	}

	public MInOut_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MInOut_BH(MOrder order, int C_DocTypeShipment_ID, Timestamp movementDate) {
		super(order, C_DocTypeShipment_ID, movementDate);
	}

	public MInOut_BH(MInvoice invoice, int C_DocTypeShipment_ID, Timestamp movementDate,
			int M_Warehouse_ID) {
		super(invoice, C_DocTypeShipment_ID, movementDate, M_Warehouse_ID);
	}

	public MInOut_BH(MInOut original, int C_DocTypeShipment_ID, Timestamp movementDate) {
		super(original, C_DocTypeShipment_ID, movementDate);
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
}
