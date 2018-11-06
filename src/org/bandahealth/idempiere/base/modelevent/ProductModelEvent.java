package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.config.InternalSetupConfig;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.osgi.service.event.Event;

public class ProductModelEvent extends AbstractEventHandler {

	private int clientId = -1;
	private int orgId = -1;
	private Properties context = null;
	private MAttributeSet attributeSet;

	@Override
	protected void doHandleEvent(Event event) {
		MProduct_BH product = null;

		PO persistentObject = getPO(event);
		clientId = persistentObject.getAD_Client_ID();
		orgId = persistentObject.getAD_Org_ID();

		if (persistentObject instanceof MProduct_BH) {
			product = (MProduct_BH) persistentObject;
		} else {
			return;
		}
		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(product);
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			afterSaveRequest(product);
		}
	}

	@Override
	protected void initialize() {
		context = Env.getCtx();
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MProduct_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MProduct_BH.Table_Name);
	}

	private void beforeSaveRequest(MProduct_BH product) {
		if (product.isBH_HasExpiration()) {
			attributeSet = findProductAttributeSet(QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET);
			if (attributeSet != null) {
				Integer attributeSetId = attributeSet.get_ID();
				product.setM_AttributeSet_ID(attributeSetId);
			} else {
				// failed to find or create product attribute set
				throw new AdempiereException(
						"Attribute Set '" + QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET + "' not found!");
			}
		}
	}

	/* Add prices to product in the pricelist */
	private void afterSaveRequest(MProduct_BH product) {
		if (product.get_ID() > 0) {
			BigDecimal buyPrice = product.getBH_BuyPrice();
			BigDecimal sellPrice = product.getBH_SellPrice();
			System.out.println("Buying Price: " + buyPrice + " Selling Price: " + sellPrice);
			savePrice(product, true);
			savePrice(product, false);
		} else {
			throw new AdempiereException("Some error occured while saving the product");
		}
	}

	/* Find an attribute set with specified name, create if not found */
	private MAttributeSet findProductAttributeSet(String productAttribSetName) {
		MAttributeSet attributeSet = QueryUtil.queryTableByOrgAndClient(clientId, orgId, context,
				MAttributeSet.Table_Name, "name='" + productAttribSetName + "'", null);

		if (attributeSet == null) {
			InternalSetupConfig.configureNewProductAttribSet(context);
			attributeSet = QueryUtil.queryTableByOrgAndClient(clientId, orgId, context, MAttributeSet.Table_Name,
					"name='" + productAttribSetName + "'", null);
		}
		// update for existing clients with this AS
		if (!(boolean) attributeSet.get_Value(MAttributeSet.COLUMNNAME_UseGuaranteeDateForMPolicy)) {
			attributeSet.setUseGuaranteeDateForMPolicy(true);
			attributeSet.saveEx();
		}
		return attributeSet;
	}

	/* Save a product price */
	private boolean savePrice(MProduct_BH product, boolean isSoPrice) {
		boolean isSaved = false;

		// setting the sales pricing for the product
		MPriceList priceList = null;
		MPriceListVersion plVersion = null;
		MProductPrice productPrice = null;
		char s = isSoPrice == true ? 'Y' : 'N';
		// get existing (default) sales price-list
		priceList = QueryUtil.queryTableByOrgAndClient(clientId, orgId, context, MPriceList.Table_Name,
				"isactive='Y' and isdefault='Y'" + " and issopricelist='" + s + "'", null);

		// get the price-list version for the price-list
		plVersion = QueryUtil.queryTableByOrgAndClient(clientId, orgId, context, MPriceListVersion.Table_Name,
				"m_pricelist_id=" + priceList.get_ID(), null);

		productPrice = new MProductPrice(plVersion, product.get_ID(), new BigDecimal(0),
				(s == 'Y' ? product.getBH_SellPrice() : product.getBH_SellPrice()), new BigDecimal(0));
		productPrice.save();
		productPrice.setM_Product_ID(product.get_ID());
		Trx.get(productPrice.get_TrxName(), false).commit();

		return isSaved;
	}
}
