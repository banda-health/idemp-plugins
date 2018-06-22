package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MLocator;
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
		if (value != null) {

			Integer productId = (Integer) value;
			
			//ignore billed services
			MProduct product = new MProduct(ctx, productId,null);
			if(product.getProductType().equals("S")) {
				return errorMessage;
			}
			Integer warehouseId = Env.getContextAsInt(ctx, WindowNo+"|M_Warehouse_ID");
			
			MLocator locator = new MWarehouse(ctx, warehouseId, null).getDefaultLocator();
			Integer locatorId = locator.get_ID();
			
			String whereClause = MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND "
					+ MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?";
			Query availableQtyInStorage = new Query(Env.getCtx(), MStorageOnHand.Table_Name, whereClause, null);
			BigDecimal quantity = (BigDecimal)availableQtyInStorage.setParameters(Arrays.asList(productId, locatorId)).first()
					.get_Value("qtyonhand");
			mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable, quantity);
		} else {
			mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable,BigDecimal.ZERO);
		}

		return errorMessage;
	}
}
