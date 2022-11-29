package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MDocType;
import org.compiere.model.MInventory;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class PhysicalInventoryModelEvent extends AbstractEventHandler{
	
	private final static String DOC_TYPE = "Material Physical Inventory";
	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MInventory.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MInventory.Table_Name);
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
			beforeSaveRequest(inventory);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(inventory);
		}		
	}
	
	private void beforeSaveRequest(MInventory inventory) {
		// retrieve & set the document type
		Query query = new Query(Env.getCtx(), "C_DocType", "name = '" + DOC_TYPE + "'", null).setClient_ID();
		if (query.count() > 0) {
			MDocType docType = query.first();
			inventory.setC_DocType_ID(docType.get_ID());
		}
	}
	
	private void afterSaveRequest(MInventory inventory) {
	}
}
