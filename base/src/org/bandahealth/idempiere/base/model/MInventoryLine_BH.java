package org.bandahealth.idempiere.base.model;

import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MInventoryLine_BH extends MInventoryLine {

	public static final String COLUMNNAME_BH_Expiration = "BH_Expiration";
	/**
	 * Column name BH_RequiresExpiration
	 */
	public static final String COLUMNNAME_BH_RequiresExpiration = "BH_RequiresExpiration";

	/**
	 * Column name BH_OrderDocStatus
	 */
	public static final String COLUMNNAME_BH_OrderDocStatus = "BH_OrderDocStatus";
	private static final long serialVersionUID = 1L;

	/**
	 * Column name BH_NumOrderLines
	 */
	public static final String COLUMNNAME_BH_NumOrderLines = "BH_NumOrderLines";

	public MInventoryLine_BH(MInventory inventory, int M_Locator_ID, int M_Product_ID, int M_AttributeSetInstance_ID,
			BigDecimal QtyBook, BigDecimal QtyCount, BigDecimal QtyInternalUse) {
		super(inventory, M_Locator_ID, M_Product_ID, M_AttributeSetInstance_ID, QtyBook, QtyCount, QtyInternalUse);
	}

	public MInventoryLine_BH(MInventory inventory, int M_Locator_ID, int M_Product_ID, int M_AttributeSetInstance_ID,
			BigDecimal QtyBook, BigDecimal QtyCount) {
		super(inventory, M_Locator_ID, M_Product_ID, M_AttributeSetInstance_ID, QtyBook, QtyCount);
	}

	public MInventoryLine_BH(Properties ctx, int M_InventoryLine_ID, String trxName) {
		super(ctx, M_InventoryLine_ID, trxName);
	}

	public MInventoryLine_BH(Properties ctx, ResultSet rs, String trxName) {
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
