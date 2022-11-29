package org.bandahealth.idempiere.base.modelevent;

import java.util.Date;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.PO;
import org.osgi.service.event.Event;

public class PhysicalInventoryLineModelEvent extends AbstractEventHandler {

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MInventoryLine_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MInventoryLine_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MInventoryLine_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInventoryLine_BH inventoryLine = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MInventoryLine_BH) {
			inventoryLine = (MInventoryLine_BH) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)
				|| event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			beforeSaveRequest(inventoryLine);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(inventoryLine);
		}
	}

	private void beforeSaveRequest(MInventoryLine_BH inventoryLine) {
		if (inventoryLine.getBH_Expiration() != null && inventoryLine.getBH_Expiration().before(new Date())) {
			throw new RuntimeException("Expiration should be a future date");
		}
	}

	private void afterSaveRequest(MInventoryLine_BH inventory) {
	}
}
