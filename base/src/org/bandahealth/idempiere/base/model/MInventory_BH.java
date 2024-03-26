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

}
