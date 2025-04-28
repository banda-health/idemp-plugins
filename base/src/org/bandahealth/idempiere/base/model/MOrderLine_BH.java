package org.bandahealth.idempiere.base.model;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MTable;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

public class MOrderLine_BH extends MOrderLine {

	/**
	 * Column name QtyAvailable
	 */
	public static final String COLUMNNAME_QtyAvailable = "QtyAvailable";

	public static final String COLUMNNAME_BH_Instructions = "BH_Instructions";

	/**
	 * Column name Included_OrderLine_ID
	 */
	public static final String COLUMNNAME_Included_OrderLine_ID = "Included_OrderLine_ID";

	public MOrderLine_BH(Properties ctx, String C_OrderLine_UU, String trxName) {
		super(ctx, C_OrderLine_UU, trxName);
	}

	public MOrderLine_BH(Properties ctx, int C_OrderLine_ID, String trxName) {
		super(ctx, C_OrderLine_ID, trxName);
	}

	public MOrderLine_BH(Properties ctx, int C_OrderLine_ID, String trxName, String... virtualColumns) {
		super(ctx, C_OrderLine_ID, trxName, virtualColumns);
	}

	public MOrderLine_BH(MOrder order) {
		super(order);
	}

	public MOrderLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public org.compiere.model.I_C_OrderLine getIncluded_OrderLine() throws RuntimeException {
		return (org.compiere.model.I_C_OrderLine) MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_ID)
				.getPO(getIncluded_OrderLine_ID(), get_TrxName());
	}

	/**
	 * Set Included OrdeLine ID.
	 *
	 * @param Included_OrderLine_ID Included OrdeLine ID
	 */
	public void setIncluded_OrderLine_ID(int Included_OrderLine_ID) {
		if (Included_OrderLine_ID < 1)
			set_Value(COLUMNNAME_Included_OrderLine_ID, null);
		else
			set_Value(COLUMNNAME_Included_OrderLine_ID, Integer.valueOf(Included_OrderLine_ID));
	}

	/**
	 * Get Included OrdeLine ID.
	 *
	 * @return Included OrdeLine ID
	 */
	public int getIncluded_OrderLine_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_Included_OrderLine_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set BH_AvailableQuantity.
	 *
	 * @param QtyAvailable Available Quantity (On Hand - Reserved)
	 */
	public void setQtyAvailable(BigDecimal QtyAvailable) {
		set_ValueNoCheck(COLUMNNAME_QtyAvailable, QtyAvailable);
	}

	/**
	 * Get BH_AvailableQuantity.
	 *
	 * @return Available Quantity (On Hand - Reserved)
	 */
	public BigDecimal getQtyAvailable() {
		BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_QtyAvailable);
		if (bd == null)
			return Env.ZERO;
		return bd;
	}

	public void setBH_Instructions(String BH_Instructions) {
		set_Value(COLUMNNAME_BH_Instructions, BH_Instructions);
	}

	public String getBH_Instructions() {
		return (String) get_Value(COLUMNNAME_BH_Instructions);
	}
}
