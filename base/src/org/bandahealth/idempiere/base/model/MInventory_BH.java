package org.bandahealth.idempiere.base.model;

import org.compiere.model.MInventory;
import org.compiere.model.MWarehouse;

import java.sql.ResultSet;
import java.util.Properties;

public class MInventory_BH extends MInventory {

	/**
	 * Column name bh_update_reason
	 */
	public static final String COLUMNNAME_bh_update_reason = "bh_update_reason";

	private static final long serialVersionUID = -7140493467408459522L;

	public MInventory_BH(Properties ctx, String M_Inventory_UU, String trxName) {
		super(ctx, M_Inventory_UU, trxName);
	}

	public MInventory_BH(Properties ctx, int M_Inventory_ID, String trxName) {
		super(ctx, M_Inventory_ID, trxName);
	}

	public MInventory_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MInventory_BH(MWarehouse wh, String trxName) {
		super(wh, trxName);
	}

	public MInventory_BH(MInventory copy) {
		super(copy);
	}

	public MInventory_BH(Properties ctx, MInventory copy) {
		super(ctx, copy);
	}

	public MInventory_BH(Properties ctx, MInventory copy, String trxName) {
		super(ctx, copy, trxName);
	}

	/**
	 * Damaged products = p_dmg
	 */
	public static final String BH_UPDATE_REASON_DamagedProducts = "p_dmg";
	/**
	 * Product expired = p_exp
	 */
	public static final String BH_UPDATE_REASON_ProductExpired = "p_exp";
	/**
	 * Products used but not charged = p_unc
	 */
	public static final String BH_UPDATE_REASON_ProductsUsedButNotCharged = "p_unc";
	/**
	 * Lost or stolen products = p_los
	 */
	public static final String BH_UPDATE_REASON_LostOrStolenProducts = "p_los";
	/**
	 * System unavailable at sale = p_sna
	 */
	public static final String BH_UPDATE_REASON_SystemUnavailableAtSale = "p_sna";
	/**
	 * Wrong quantity received = p_bqt
	 */
	public static final String BH_UPDATE_REASON_WrongQuantityReceived = "p_bqt";
	/**
	 * Wrong expiration received = p_wer
	 */
	public static final String BH_UPDATE_REASON_WrongExpirationReceived = "p_wer";

	/**
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason bh_update_reason
	 */
	public void setbh_update_reason(String bh_update_reason) {

		set_Value(COLUMNNAME_bh_update_reason, bh_update_reason);
	}

	/**
	 * Get bh_update_reason.
	 *
	 * @return bh_update_reason
	 */
	public String getbh_update_reason() {
		return (String) get_Value(COLUMNNAME_bh_update_reason);
	}
}
