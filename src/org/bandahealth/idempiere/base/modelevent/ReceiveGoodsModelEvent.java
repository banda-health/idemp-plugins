package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MInOut;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.osgi.service.event.Event;

public class ReceiveGoodsModelEvent extends AbstractEventHandler {

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MOrder.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MOrder.Table_Name);
		
		registerEvent(IEventTopics.DOC_AFTER_COMPLETE);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MOrder order = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MOrder) {
			order = (MOrder) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.DOC_AFTER_COMPLETE)) {
			createMaterialReceiptFromOrder(order);
		}
	}

	private void createMaterialReceiptFromOrder(MOrder order) {
		if (order.isSOTrx()) {
			return;
		}

		MInOut mReceipt = MInOut.createFrom(order, order.getDateOrdered(), false, false, null, true, order.get_TrxName());
		System.out.println("ID = " + mReceipt.get_ID());
	}
}