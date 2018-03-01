package org.bandahealth.idempiere.base.modelevent;

import java.util.logging.Level;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class ProductModelEvent extends AbstractEventHandler {
	
	private CLogger logger = CLogger.getCLogger(ProductModelEvent.class);
	private MProduct product;
	private MPriceList priceList;
	private PO persistentObject;
	private int clientId;
	private int orgId;
	
	@Override
	protected void doHandleEvent(Event event) {
		logger.log(Level.ALL, "Event trigered");
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
			setAfterHeaderSaveDefaults();
		}
		
	}

	/*Register table model events to be handled */
	@Override
	protected void initialize() {
		logger.log(Level.ALL, "Initializing event listener");
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MProduct.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MProduct.Table_Name);
	}
	
	/*Set defaults to fields */
	private void setBeforeHeaderSaveDefaults() {

		logger.log(Level.INFO, "saving header defaults!");
		//set required check-boxes
		product.setIsSold(true);
		product.setIsPurchased(true);
		product.setIsStocked(true);
		
	}

	
	private void setAfterHeaderSaveDefaults() {
		//set the sales and purchase price-lists for this product
		Query query = new Query(Env.getCtx(),MPriceList.Table_Name,"isactive='Y' and isdefault='Y'",null);
		priceList = query.first();
		System.out.println("Query: " + query.getSQL());
		MPriceListVersion priceListVersion = new MPriceListVersion(priceList);
//		MProductPrice prodPrice =  new MProductPrice(priceListVersion,product.get_ID(),priceList(),new PriceList)
		
	}

}
