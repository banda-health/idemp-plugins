package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MProduct;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.osgi.service.event.Event;

public class ProductModelEvent extends AbstractEventHandler {
	
	private CLogger logger = CLogger.getCLogger(ProductModelEvent.class);
	private MProduct product;
	private PO persistentObject;
	private int clientId;
	private int orgId;
	
	@Override
	protected void doHandleEvent(Event event) {
		persistentObject = getPO(event);
		if(persistentObject instanceof MProduct) {
			product = (MProduct)persistentObject;
			clientId = product.getAD_Client_ID();
			orgId = product.getAD_Org_ID();
		}else {
			return;
		}
		
		if(event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			//stuff to do before save
			setBeforeHeaderSaveDefaults();
		}else if(event.getTopic().equals(IEventTopics.PO_AFTER_NEW)){
			//do this after save
		}
		
	}

	/*Register table model events to be handled */
	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MProduct.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MProduct.Table_Name);
	}
	
	/*Set defaults to fields */
	private void setBeforeHeaderSaveDefaults() {

		product.setIsSold(true);
		product.setIsPurchased(true);
		product.setIsStocked(true);
	}

	
	private void setAfterHeaderSaveDefaults() {
		
	}

}
