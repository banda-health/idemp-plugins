package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.logging.Level;

import javax.sql.rowset.spi.TransactionalWriter;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.I_M_Product;
import org.compiere.model.MAttributeSet;
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
	private Properties properties = null;

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
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {}
	}

	@Override
	protected void initialize() {
		logger.info("Initializing ProductModelEvent");
		properties = Env.getCtx();
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MProduct.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MProduct.Table_Name);
	}

	private void beforeSaveRequest(MProduct product) {
		Integer attributeSetId = findProductAttributeSet("Expires On").get_ID();
		logger.info("Attribute Set Id received:" + attributeSetId);
		product.setM_AttributeSet_ID(attributeSetId);
	}

	/*Adds a default price to this product in the pricelist*/
	private void afterSaveRequest(MProduct product) {
		if (product.get_ID() > 0) {
			// setting the sales pricing for the product
			MPriceList priceList = null;
			MPriceListVersion plVersion = null;
			MProductPrice productPricing = null;

			// get existing (default) sales price-list
			priceList = QueryUtil.queryTableByOrgAndClient(clientId, orgId, 
					properties, 
					MPriceList.Table_Name, 
					"isactive='Y' and isdefault='Y'", 
					null);

			// get the price-list version for the price-list
			plVersion = QueryUtil.queryTableByOrgAndClient(clientId, orgId, 
					properties,
					MPriceListVersion.Table_Name,
					"m_pricelist_id=" + priceList.get_ID(),
					null);

				// get the prices attached to this version
			productPricing = QueryUtil.queryTableByOrgAndClient(clientId, orgId, 
					properties, 
					MProductPrice.Table_Name,
					"m_pricelist_version_id=" + plVersion.get_ID(),
					null);
			
			Trx.get(product.get_TrxName(), false).commit();
			productPricing.setM_Product_ID(product.get_ID());
			productPricing.save();
			
			}else {
			throw new AdempiereException("Some error occured while saving the product");
		}
	}
	
	private MAttributeSet findProductAttributeSet(String productAttribSetName) {
		logger.info("INSIDER: ["+this.getClass().getName()+"]");
		MAttributeSet pSet = QueryUtil.queryTableByOrgAndClient(clientId, orgId, Env.getCtx(),
				MAttributeSet.Table_Name,
				"name='"+productAttribSetName+"'", null);
		logger.info("INSIDER: ["+this.getClass().getName()+"]" + pSet.toString());
		return pSet;
	}
}
