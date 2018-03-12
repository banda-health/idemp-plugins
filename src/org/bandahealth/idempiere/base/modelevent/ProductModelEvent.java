package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;
import java.util.logging.Level;

import javax.sql.rowset.spi.TransactionalWriter;

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
import org.compiere.util.Trx;
import org.osgi.service.event.Event;

public class ProductModelEvent extends AbstractEventHandler {

	private CLogger logger = CLogger.getCLogger(ProductModelEvent.class);
	private int clientId = -1;
	private int orgId = -1;

	@Override
	protected void doHandleEvent(Event event) {
		MProduct product = null;

		PO persistentObject = getPO(event);
		clientId = persistentObject.getAD_Client_ID();
		orgId = persistentObject.getAD_Org_ID();
		
		if (persistentObject instanceof MProduct) {
			product = (MProduct) persistentObject;
		} else {
			return;
		}
		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(product);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(product);
		}
	}

	/* Register table model events to be handled */
	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MProduct.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MProduct.Table_Name);
	}

	private void beforeSaveRequest(MProduct product) {}

	private void afterSaveRequest(MProduct product) {
		if (product.get_ID() > 0) {
			// setting the sales pricing for the product
			Query query = null;
			MPriceList priceList = null;
			MPriceListVersion plVersion = null;

			// get existing (default) sales price-list
			query = new Query(Env.getCtx(), 
					MPriceList.Table_Name, "isactive='Y' and isdefault='Y'", 
					null);
			if (query.count() > 0) {
				priceList = query.first();
			}

			// get the price-list version for the price-list
			query = new Query(Env.getCtx(), 
					MPriceListVersion.Table_Name, "m_pricelist_id=" + priceList.get_ID(), 
					null);
			if (query.count() > 0) {
				plVersion = query.first();
				MProductPrice productPricing = null;

				// get the prices attached to this version
				Query pricingQuery = new Query(Env.getCtx(), 
						MProductPrice.Table_Name,
						"m_pricelist_version_id=" + plVersion.get_ID(), 
						null);
				if (pricingQuery.count() > 0) {
					productPricing = pricingQuery.first();
					Trx.get(product.get_TrxName(), false).commit();
					productPricing.save();
				}
			}
		} else {
			throw new AdempiereException("Some error occured while saving the product");
		}
	}
}
