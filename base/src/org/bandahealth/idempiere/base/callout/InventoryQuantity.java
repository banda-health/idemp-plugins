package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MLocator;
import org.compiere.model.MOrder;
import org.compiere.model.MProduct;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;


public class InventoryQuantity implements IColumnCallout {

	CLogger logger = CLogger.getCLogger(this.getClass());

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		String errorMessage = null;
		Integer warehouseId = Env.getContextAsInt(ctx, WindowNo + "|M_Warehouse_ID");
		Integer orderId = Env.getContextAsInt(ctx, WindowNo + "|C_Order_ID");
		Integer attributeSetId = Env.getContextAsInt(ctx, WindowNo + "|M_AttributeSetInstance_ID");
		Integer productId = null;

		if (value != null) {

			// ignore PO
			MOrder order = new MOrder(ctx, orderId, null);
			if (!order.isSOTrx()) {
				return errorMessage;
			}

			if (attributeSetId > 0) {
				productId = Env.getContextAsInt(ctx, WindowNo + "|M_Product_ID");
			} else {
				productId = (Integer) value;
			}

			// ignore billed services
			MProduct product = new MProduct(ctx, productId, null);
			if (product.getProductType().equals("S")) {
				return errorMessage;
			}

			mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable,
					getQtyAvailable(ctx, warehouseId, productId, attributeSetId));
		} else {
			mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable, BigDecimal.ZERO); // reset qty field
			productId = Env.getContextAsInt(ctx, WindowNo + "|M_Product_ID");
			if (productId != null) {
				mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable,
						getQtyAvailable(ctx, warehouseId, productId, attributeSetId));
			}
		}

		return errorMessage;

	}

	private BigDecimal getQtyAvailable(Properties ctx, Integer warehouseId, Integer productId, Integer attributeSetId) {
		Query queryQtyInStorage = null;
		BigDecimal quantity = BigDecimal.ZERO;

		MWarehouse store = new MWarehouse(ctx, warehouseId, null);
		MLocator locator = store.getDefaultLocator();
		if (locator != null) {
			Integer locatorId = locator.get_ID();
			String whereClause = MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND "
					+ MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?";
			ArrayList<Object> parameters = new ArrayList<>();
			parameters.add(productId);
			parameters.add(locatorId);
			if (attributeSetId > 0) {
				whereClause += " AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "=?";
				parameters.add(attributeSetId);
			}
			queryQtyInStorage = new Query(Env.getCtx(), MStorageOnHand.Table_Name, whereClause, null);
			queryQtyInStorage.setParameters(parameters);
			quantity = queryQtyInStorage.aggregate("qtyonhand", Query.AGGREGATE_SUM);
		}else {
			logger.severe("No locator found for store: " + store.getName());
		}
		return quantity;
	}

}
