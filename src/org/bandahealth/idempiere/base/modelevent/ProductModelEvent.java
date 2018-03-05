package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
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
	
	private int clientId;
	private int orgId;
	
	@Override
	protected void doHandleEvent(Event event) {
		MProduct product = null;
		System.out.println("Event trigered: " + event.getTopic());
		PO persistentObject = getPO(event);
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
			beforeSaveRequest(product);
		}else if(event.getTopic().equals(IEventTopics.PO_AFTER_NEW)){
			//do this after save
			System.out.println("Executing afterSaveRequest()");
			afterSaveRequest(product);
		}
		
	}

	/*Register table model events to be handled */
	@Override
	protected void initialize() {
		System.out.println("Initializing event listener");
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_M_Product.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_M_Product.Table_Name);
	}
	
	/*Set defaults to fields */
	private void beforeSaveRequest(MProduct product) {

		System.out.println("Inside beforeSave");
		//set required check-boxes
		product.setIsSold(true);
		product.setIsPurchased(true);
		product.setIsStocked(true);
		System.out.println(product.toString());
	}

	
	private void afterSaveRequest(MProduct product) {
		
		if(product.get_ID() > 0) {
			
			System.out.println("Product id: " + product.get_ID());
			System.out.println("Product id: " + product.getName());
			System.out.println(product.toString());
		
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
			System.out.println("price list version selected: " + plVersion.toString());
		}
		
		
		//create a product price and set default prices (list,standard and limit prices)
		MProductPrice prodPrice =  
				new MProductPrice(Env.getCtx(),
						plVersion.get_ID(), 
						product.get_ID(), 
						new BigDecimal(0.00), 
						new BigDecimal(0.00), 
						new BigDecimal(0.00), 
						null);
		prodPrice.setM_PriceList_Version_ID(plVersion.get_ID());
		plVersion.setM_PriceList_ID(priceList.get_ID());
		prodPrice.save();
		}else {
			System.out.println("Failed in saving product");
			throw new AdempiereException("Product was not saved");
		}
	}

}
