package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.I_M_Product;
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
	private PO persistentObject;
	private int clientId;
	private int orgId;
	
	@Override
	protected void doHandleEvent(Event event) {
		System.out.println("Event trigered: " + event.getTopic());
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
			System.out.println("Executing beforeSaveRequest()");
			beforeSaveRequest();
		}else if(event.getTopic().equals(IEventTopics.PO_AFTER_NEW)){
			//do this after save
			System.out.println("Executing afterSaveRequest()");
			afterSaveRequest();
		}
		
	}

	/*Register table model events to be handled */
	@Override
	protected void initialize() {
		logger.log(Level.ALL, "Initializing event listener");
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_M_Product.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_M_Product.Table_Name);
	}
	
	/*Set defaults to fields */
	private void beforeSaveRequest() {

		logger.log(Level.INFO, "saving header defaults!");
		//set required check-boxes
		product.setIsSold(true);
		product.setIsPurchased(true);
		product.setIsStocked(true);
		
	}

	
	private void afterSaveRequest() {
		
		//setting the sales pricing for the product
		Query query = null;
		MPriceList priceList = null;
		MPriceListVersion plVersion = null;
		
		//get existing sales price-list
		query = new Query(Env.getCtx(),MPriceList.Table_Name,"isactive='Y' and isdefault='Y'",null); 
		if (query.count() > 0) {
			priceList = query.first();
			System.out.println(priceList.toString());
		}
		
		// get a version of the price-list set as the default
		query = new Query(Env.getCtx(),MPriceListVersion.Table_Name,"m_pricelist_id="+priceList.get_ID(),null);
		if(query.count() > 0) {
			plVersion = query.first();
			System.out.println(plVersion.toString());
		}
		
		//create a product price and set default prices (list,standard and limit prices)
		MProductPrice prodPrice =  
				new MProductPrice(Env.getCtx(),
						plVersion.get_ID(), 
						product.get_ID(), 
						new BigDecimal(100), 
						new BigDecimal(100), 
						new BigDecimal(100), 
						null);
		prodPrice.setM_PriceList_Version_ID(plVersion.get_ID());
		plVersion.setM_PriceList_ID(priceList.get_ID());
		prodPrice.save();
//		product
		System.out.println(prodPrice.toString());
		
		//add the product price to the product
		
	}

}
