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
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInvoice_BH invoice;
		PO persistentObject = getPO(event);
		if (persistentObject instanceof MInvoice_BH) {
			invoice = (MInvoice_BH) persistentObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(invoice);
		}
	}

	private void beforeSaveRequest(MInvoice_BH invoice) {
		if (invoice.getDateAcct() == null) {
			// Update account date to be same as invoice date
			invoice.setDateAcct(invoice.getDateInvoiced());
		}
	}
}
