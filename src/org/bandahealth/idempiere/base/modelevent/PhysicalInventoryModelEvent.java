package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.config.BHConfigLoader;
import org.compiere.model.MInventory;
import org.compiere.model.PO;
import org.osgi.service.event.Event;

public class PhysicalInventoryModelEvent extends AbstractEventHandler{
	private static final String TABLE_NAME = "M_Inventory";
	
	@Override
	protected void initialize() {

		registerTableEvent(IEventTopics.PO_BEFORE_NEW, TABLE_NAME);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, TABLE_NAME);

		// load bandahealth configs
		BHConfigLoader.getInstance();
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInventory inventory = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MInventory) {
			inventory = (MInventory) persistantObject;
		} else {
			return;
		}
		
		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			setDefaultData(inventory);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			createRelatedDataAfterSave(inventory);
		}		
	}
	
	private void setDefaultData(MInventory inventory) {
		
	}
	
	private void createRelatedDataAfterSave(MInventory inventory) {
		
	}
}
