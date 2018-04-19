package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;

public class MInventoryLine_BH extends MInventoryLine {

	public static final String COLUMNNAME_BH_Expiration = "BH_Expiration";
	private static final long serialVersionUID = 1L;

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

}
