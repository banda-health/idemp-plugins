package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MProduct;
import org.compiere.util.CLogger;
import org.osgi.service.event.Event;

public class ProductModelEvent extends AbstractEventHandler {
	
	private CLogger logger = CLogger.getCLogger(ProductModelEvent.class);
	
	
	
	@Override
	protected void doHandleEvent(Event event) {
		setAutoDefaults();
	}

	/*Register table model events to be handled */
	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MProduct.Table_Name);
	}
	
	/*Set defaults to fields */
	private void setAutoDefaults() {
		
	}

}
