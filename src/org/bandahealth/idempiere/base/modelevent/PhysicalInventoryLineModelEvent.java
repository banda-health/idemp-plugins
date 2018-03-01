package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.I_M_InventoryLine;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class PhysicalInventoryLineModelEvent extends AbstractEventHandler {

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_M_InventoryLine.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_M_InventoryLine.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInventoryLine inventoryLine = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MInventoryLine) {
			inventoryLine = (MInventoryLine) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(inventoryLine);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(inventoryLine);
		}
	}

	private void beforeSaveRequest(MInventoryLine inventoryLine) {
		// check locator
		if (inventoryLine.getM_Locator() == null) {
			MWarehouse wh = MWarehouse.get(Env.getCtx(), inventoryLine.getM_Inventory().getM_Warehouse_ID());
			inventoryLine.setM_Locator_ID(wh.getDefaultLocator().get_ID());
		}
	}

	private void afterSaveRequest(MInventoryLine inventory) {
	}
}
