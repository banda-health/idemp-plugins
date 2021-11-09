package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MWarehouse;
import org.compiere.model.PO;

public class MWarehouse_BH extends MWarehouse {

	public static final String COLUMNNAME_BH_DEFAULTWAREHOUSE = "BH_DefaultWarehouse";

	public MWarehouse_BH(Properties ctx, int M_Warehouse_ID, String trxName) {
		super(ctx, M_Warehouse_ID, trxName);
	}

	public MWarehouse_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * This won't copy keys (ids and uuids) to the new MWarehouse_BH object.
	 * 
	 * @param warehouse
	 */
	public MWarehouse_BH(MWarehouse warehouse) {
		super(warehouse.getCtx(), 0, warehouse.get_TrxName());

		PO.copyValues(warehouse, this, warehouse.getAD_Client_ID(), warehouse.getAD_Org_ID());
	}

	public boolean isBH_IsDefaultWarehouse() {
		Object oo = get_Value(COLUMNNAME_BH_DEFAULTWAREHOUSE);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	public void setBH_IsDefaultWarehouse(boolean BH_IsDefaultWarehouse) {
		set_Value(COLUMNNAME_BH_DEFAULTWAREHOUSE, Boolean.valueOf(BH_IsDefaultWarehouse));
	}
}
