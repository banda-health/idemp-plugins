package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MMovement;

public class MMovement_BH extends MMovement {

	public static final String COLUMNNAME_BH_FROM_WAREHOUSE_ID = "BH_From_Warehouse_ID";
	public static final String COLUMNNAME_BH_TO_WAREHOUSE_ID = "BH_To_Warehouse_ID";

	public MMovement_BH(Properties context, int cOrderId, String transactionName) {
		super(context, cOrderId, transactionName);
	}

	public MMovement_BH(Properties contex, ResultSet resultSet, String transactionName) {
		super(contex, resultSet, transactionName);
	}

	public int getBH_FromWarehouseID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_FROM_WAREHOUSE_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public void setBH_FromWarehouseID(int BH_FromWarehouse_ID) {
		if (BH_FromWarehouse_ID < 1) {
			set_Value(COLUMNNAME_BH_FROM_WAREHOUSE_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_FROM_WAREHOUSE_ID, Integer.valueOf(BH_FromWarehouse_ID));
		}
	}
	
	public int getBH_ToWarehouseID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_TO_WAREHOUSE_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public void setBH_ToWarehouseID(int BH_ToWarehouse_ID) {
		if (BH_ToWarehouse_ID < 1) {
			set_Value(COLUMNNAME_BH_TO_WAREHOUSE_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_TO_WAREHOUSE_ID, Integer.valueOf(BH_ToWarehouse_ID));
		}
	}
}
