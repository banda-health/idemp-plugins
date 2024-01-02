package org.bandahealth.idempiere.base.model;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MOrderLine_BH extends MOrderLine {

	/**
	 * Column name BH_Expiration
	 */
	public static final String COLUMNNAME_BH_Expiration = "BH_Expiration";

	/**
	 * Column name BH_RequiresExpiration
	 */
	public static final String COLUMNNAME_BH_RequiresExpiration = "BH_RequiresExpiration";

	/**
	 * Column name QtyAvailable
	 */
	public static final String COLUMNNAME_QtyAvailable = "QtyAvailable";

	public static final String COLUMNNAME_BH_Instructions = "BH_Instructions";

	/**
	 * Column name BH_NavButtons
	 */
	public static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";

	/**
	 * Column name BH_NumOrderLines
	 */
	public static final String COLUMNNAME_BH_NumOrderLines = "BH_NumOrderLines";

	/**
	 * Column name BH_OrderDocStatus
	 */
	public static final String COLUMNNAME_BH_OrderDocStatus = "BH_OrderDocStatus";

	public MOrderLine_BH(MOrder order) {
		super(order);
	}

	public MOrderLine_BH(Properties ctx, int C_OrderLine_ID, String trxName) {
		super(ctx, C_OrderLine_ID, trxName);
	}

	public MOrderLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Get Expire On.
	 *
	 * @return Expire On
	 */
	public Timestamp getBH_Expiration() {
		return (Timestamp) get_Value(COLUMNNAME_BH_Expiration);
	}

	/**
	 * Set Expire On.
	 *
	 * @param BH_Expiration Expire On
	 */
	public void setBH_Expiration(Timestamp BH_Expiration) {
		set_Value(COLUMNNAME_BH_Expiration, BH_Expiration);
	}

	/**
	 * Get Requires Expiration.
	 *
	 * @return Requires Expiration
	 */
	public boolean isBH_RequiresExpiration() {
		Object oo = get_Value(COLUMNNAME_BH_RequiresExpiration);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set Requires Expiration.
	 *
	 * @param BH_RequiresExpiration Requires Expiration
	 */
	public void setBH_RequiresExpiration(boolean BH_RequiresExpiration) {
		throw new IllegalArgumentException("BH_RequiresExpiration is virtual column");
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

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons) {
		set_Value(COLUMNNAME_BH_NavButtons, BH_NavButtons);
	}

	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons() {
		return get_Value(COLUMNNAME_BH_NavButtons);
	}

	/**
	 * Set Number of Order Lines.
	 *
	 * @param BH_NumOrderLines The number of order lines on an order
	 */
	public void setBH_NumOrderLines(int BH_NumOrderLines) {
		throw new IllegalArgumentException("BH_NumOrderLines is virtual column");
	}

	/**
	 * Get Number of Order Lines.
	 *
	 * @return The number of order lines on an order
	 */
	public int getBH_NumOrderLines() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_NumOrderLines);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set Document Status.
	 *
	 * @param BH_OrderDocStatus The current status of the document
	 */
	public void setBH_OrderDocStatus(String BH_OrderDocStatus) {
		throw new IllegalArgumentException("BH_OrderDocStatus is virtual column");
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	public String getBH_OrderDocStatus() {
		return (String) get_Value(COLUMNNAME_BH_OrderDocStatus);
	}
}
