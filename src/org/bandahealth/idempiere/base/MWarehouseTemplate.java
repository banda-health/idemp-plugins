package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MWarehouse;
import org.compiere.model.Query;

public class MWarehouseTemplate extends BaseTemplate<MWarehouse> {

	private String trxName;
	private Properties ctx;

	public MWarehouseTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MWarehouse getInstance(int... args) {
		MWarehouse storeRoom = new Query(getCtx(), MWarehouse.Table_Name, "name = 'Test Store room'", getTrxName())
				.first();
		if (storeRoom == null) {
			storeRoom = new MWarehouse(getCtx(), 0, getTrxName());
			storeRoom.setName("Test Store room");
			storeRoom.setAD_Org_ID(args[0]);
			storeRoom.setC_Location_ID(args[1]);
			storeRoom.saveEx();
		}

		return storeRoom;
	}

	@Override
	protected String getTrxName() {
		return trxName;
	}

	@Override
	protected Properties getCtx() {
		return ctx;
	}
}
