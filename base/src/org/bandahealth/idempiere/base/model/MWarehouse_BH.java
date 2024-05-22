package org.bandahealth.idempiere.base.model;

import org.compiere.model.MOrg;
import org.compiere.model.MWarehouse;

import java.sql.ResultSet;
import java.util.Properties;

public class MWarehouse_BH extends MWarehouse {

	/**
	 * Column name BH_DefaultWarehouse
	 */
	public static final String COLUMNNAME_BH_DefaultWarehouse = "BH_DefaultWarehouse";

	public MWarehouse_BH(Properties ctx, String M_Warehouse_UU, String trxName) {
		super(ctx, M_Warehouse_UU, trxName);
	}

	public MWarehouse_BH(Properties ctx, int M_Warehouse_ID, String trxName) {
		super(ctx, M_Warehouse_ID, trxName);
	}

	public MWarehouse_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MWarehouse_BH(MOrg org) {
		super(org);
	}

	public MWarehouse_BH(MWarehouse copy) {
		super(copy);
	}

	public MWarehouse_BH(Properties ctx, MWarehouse copy) {
		super(ctx, copy);
	}

	public MWarehouse_BH(Properties ctx, MWarehouse copy, String trxName) {
		super(ctx, copy, trxName);
	}

	/**
	 * Set Default Warehouse.
	 *
	 * @param BH_DefaultWarehouse Default Warehouse
	 */
	public void setBH_DefaultWarehouse(boolean BH_DefaultWarehouse) {
		set_Value(COLUMNNAME_BH_DefaultWarehouse, Boolean.valueOf(BH_DefaultWarehouse));
	}

	/**
	 * Get Default Warehouse.
	 *
	 * @return Default Warehouse
	 */
	public boolean isBH_DefaultWarehouse() {
		Object oo = get_Value(COLUMNNAME_BH_DefaultWarehouse);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
}
