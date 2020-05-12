package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.osgi.service.event.Event;

public class InvoiceModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(InvoiceModelEvent.class);

	@Override
	protected void initialize() {

		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MInvoice_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MInvoice_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MInvoice_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MInvoice_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MInvoice_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInvoice_BH charge = null;
		PO persistentObject = getPO(event);
		if (persistentObject instanceof MInvoice_BH) {
			charge = (MInvoice_BH) persistentObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			beforeChangeRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE)) {
			afterChangeRequest(charge);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_DELETE)) {
			beforeDeleteRequest(charge);
		}
	}

	private void beforeChangeRequest(MInvoice_BH invoice) {
	}

	private void afterChangeRequest(MInvoice_BH invoice) {
	}

	private void beforeSaveRequest(MInvoice_BH invoice) {
		// Update account date to be same as invoice date
		invoice.setDateAcct(invoice.getDateInvoiced());
	}

	private void afterSaveRequest(MInvoice_BH invoice) {
	}

	private void beforeDeleteRequest(MInvoice_BH invoice) {
	}
}
