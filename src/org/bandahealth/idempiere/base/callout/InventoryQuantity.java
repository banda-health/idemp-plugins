package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MStorageOnHand;
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
//			logger.info("Product Id held in value: "+productId);
			Integer locatorId = Env.getContextAsInt(ctx, "1|1|M_Warehouse_ID");
			String whereClause = MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND "
					+ MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?";
//			logger.info("Selected Warehouse: " + locatorId);
			Query getAvailableQtyInStorage = new Query(Env.getCtx(), MStorageOnHand.Table_Name, whereClause, null);
//			logger.info(getAvailableQtyInStorage.setParameters(Arrays.asList(productId, locatorId)).getSQL());
			int quantity = getAvailableQtyInStorage.setParameters(Arrays.asList(productId, locatorId)).first()
					.get_ValueAsInt("qtyonhand");
			mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable, String.valueOf(quantity));
		} else {
			mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable, String.valueOf(BigDecimal.ZERO));
		}

		return errorMessage;
	}
}
