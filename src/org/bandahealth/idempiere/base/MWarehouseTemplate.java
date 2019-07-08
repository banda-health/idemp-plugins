package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MLocator;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;

public class MWarehouseTemplate extends BaseModelTemplate<MWarehouse> {

	private int orgId;
	private int locationId;

	public MWarehouseTemplate(String transactionName, Properties context, int orgId, int locationId) {
		super(transactionName, context);

		this.orgId = orgId;
		this.locationId = locationId;
	}

	@Override
	protected MWarehouse createInstance() {
		MWarehouse storeRoom = new MWarehouse(getContext(), 0, getTransactionName());
		storeRoom.setName("Test Store room");
		storeRoom.setAD_Org_ID(orgId);
		storeRoom.setC_Location_ID(locationId);
		storeRoom.saveEx();
		
		MLocator loc = new MLocator (storeRoom, "Test Locator");
		loc.setIsDefault(true);
		loc.saveEx();

		commit();

		return storeRoom;
	}

	@Override
	protected MWarehouse findInstance() {
		return new Query(getContext(), MWarehouse.Table_Name, "name = 'Test Store room'", getTransactionName()).first();
	}
}