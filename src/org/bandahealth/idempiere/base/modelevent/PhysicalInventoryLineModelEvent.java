package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.I_M_InventoryLine;
import org.compiere.model.PO;
import org.osgi.service.event.Event;

public class PhysicalInventoryLineModelEvent extends AbstractEventHandler {

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_M_InventoryLine.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, I_M_InventoryLine.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_M_InventoryLine.Table_Name);
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
		// if an expiration date is set, create an attribute set instance and attach to
		// the inventory line
		int attributeSetInstanceId = QueryUtil.createExpirationDateAttributeInstance(
				inventoryLine.getM_AttributeSetInstance_ID(), inventoryLine.getBH_Expiration(),
				inventoryLine.get_TrxName());
		if (attributeSetInstanceId > 0) {
			inventoryLine.setM_AttributeSetInstance_ID(attributeSetInstanceId);
		}
	}

	private void afterSaveRequest(MInventoryLine_BH inventory) {
	}
}
