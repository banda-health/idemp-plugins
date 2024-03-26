package org.bandahealth.idempiere.base.model;

import org.compiere.model.MMovement;

import java.sql.ResultSet;
import java.util.Properties;

public class MMovement_BH extends MMovement {

	/**
	 * Column name BH_From_Warehouse_ID
	 */
	public static final String COLUMNNAME_BH_From_Warehouse_ID = "BH_From_Warehouse_ID";

	/**
	 * Column name BH_To_Warehouse_ID
	 */
	public static final String COLUMNNAME_BH_To_Warehouse_ID = "BH_To_Warehouse_ID";

	public MMovement_BH(Properties ctx, String M_Movement_UU, String trxName) {
		super(ctx, M_Movement_UU, trxName);
	}

	public MMovement_BH(Properties ctx, int M_Movement_ID, String trxName) {
		super(ctx, M_Movement_ID, trxName);
	}

	public MMovement_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Set BH_From_Warehouse_ID.
	 *
	 * @param BH_From_Warehouse_ID BH_From_Warehouse_ID
	 */
	public void setBH_From_Warehouse_ID(int BH_From_Warehouse_ID) {
		if (BH_From_Warehouse_ID < 1)
			set_Value(COLUMNNAME_BH_From_Warehouse_ID, null);
		else
			set_Value(COLUMNNAME_BH_From_Warehouse_ID, Integer.valueOf(BH_From_Warehouse_ID));
	}

	/**
	 * Get BH_From_Warehouse_ID.
	 *
	 * @return BH_From_Warehouse_ID
	 */
	public int getBH_From_Warehouse_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_From_Warehouse_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set BH_To_Warehouse_ID.
	 *
	 * @param BH_To_Warehouse_ID BH_To_Warehouse_ID
	 */
	public void setBH_To_Warehouse_ID(int BH_To_Warehouse_ID) {
		if (BH_To_Warehouse_ID < 1)
			set_Value(COLUMNNAME_BH_To_Warehouse_ID, null);
		else
			set_Value(COLUMNNAME_BH_To_Warehouse_ID, Integer.valueOf(BH_To_Warehouse_ID));
	}

	/**
	 * Get BH_To_Warehouse_ID.
	 *
	 * @return BH_To_Warehouse_ID
	 */
	public int getBH_To_Warehouse_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_To_Warehouse_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}
