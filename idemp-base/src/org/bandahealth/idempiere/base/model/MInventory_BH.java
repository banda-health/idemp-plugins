package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MWarehouse;

public class MInventory_BH extends org.compiere.model.MInventory {

	/**
	 * Column name bh_update_reason
	 */
	public static final String COLUMNNAME_bh_update_reason = "bh_update_reason";

	private static final long serialVersionUID = -7140493467408459522L;

	public MInventory_BH(Properties ctx, int M_Inventory_ID, String trxName) {
		super(ctx, M_Inventory_ID, trxName);
	}

	public MInventory_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MInventory_BH(MWarehouse wh, String trxName) {
		super(wh, trxName);
	}

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
