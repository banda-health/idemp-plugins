package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class ProductModelEvent extends AbstractEventHandler {

	private int clientId = -1;
	private int orgId = -1;
	private Properties context = null;

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
		if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)
				|| event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE)) {
			afterSaveRequest(product);
		}
	}

	@Override
	protected void initialize() {
		context = Env.getCtx();
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MProduct_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MProduct_BH.Table_Name);
	}

	/* Add prices to product in the pricelist */
	private void afterSaveRequest(MProduct_BH product) {
		if (product.get_ID() > 0) {
			// set selling price
			savePrice(product, true);
			// set buying price
			savePrice(product, false);
		} else {
			throw new AdempiereException("Some error occured while saving the product");
		}
	}

	/* Save a product price */
	private boolean savePrice(MProduct_BH product, boolean isSoPrice) {
		boolean isSaved = false;

		// setting the sales pricing for the product
		MPriceList priceList = null;
		MPriceListVersion plVersion = null;
		MProductPrice productPrice = null;
		char isSellingPrice = isSoPrice ? 'Y' : 'N';
		// get existing (default) sales price-list
		priceList = QueryUtil.getQueryByOrgAndClient(clientId, orgId, context, MPriceList.Table_Name,
						"isdefault='Y'" + " and issopricelist='" + isSellingPrice + "'", null).setOnlyActiveRecords(true)
				.setOrderBy("ORDER BY " + MPriceList.COLUMNNAME_Created).first();

		if (priceList != null) {
			int mProductId = product.getM_Product_ID();
			// get the price-list version for the price-list
			plVersion = QueryUtil.getQueryByOrgAndClient(clientId, orgId, context, MPriceListVersion.Table_Name,
							"m_pricelist_id=" + priceList.get_ID(), null).setOnlyActiveRecords(true)
					.setOrderBy("ORDER BY " + MPriceListVersion.COLUMNNAME_ValidFrom + " DESC").first();

			if (plVersion == null) {
				throw new AdempiereException("PriceList version not found. Please set in Idempiere!");
			}

			productPrice = MProductPrice.get(Env.getCtx(), plVersion.get_ID(), mProductId, null);

			BigDecimal price = isSellingPrice == 'Y' ? product.getBH_SellPrice() : product.getBH_BuyPrice();
			if (productPrice != null) {
				if (price == null) {
					// update product price
					if (isSoPrice) {
						product.setBH_SellPrice(productPrice.getPriceStd());
					} else {
						// update product buy price
						product.setBH_BuyPrice(productPrice.getPriceStd());
					}

					// calculate price margin
					if (product.getBH_SellPrice() != null && product.getBH_BuyPrice() != null) {
						product.setBH_PriceMargin(product.getBH_SellPrice().subtract(product.getBH_BuyPrice()));
					}

					product.save(product.get_TrxName());
				} else {
					productPrice.setPriceStd(price);
				}
			} else {
				if (price == null) {
					price = new BigDecimal(0);
				}

				productPrice = new MProductPrice(product.getCtx(), plVersion.get_ID(), product.get_ID(),
						new BigDecimal(0), price, new BigDecimal(0), product.get_TrxName());
				productPrice.setM_Product_ID(mProductId);
			}

			productPrice.save(product.get_TrxName());

		} else {
			throw new AdempiereException("Default PriceList not found. Please set in Idempiere!");
		}

		return isSaved;
	}
}
