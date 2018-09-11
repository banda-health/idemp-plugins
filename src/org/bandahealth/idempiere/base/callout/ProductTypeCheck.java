package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MMessage;
import org.compiere.model.MProduct;

public class ProductTypeCheck implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		Integer productId = (Integer) value;

		MProduct product = new MProduct(ctx, productId, null);
		if (product != null) {

			if (product.getProductType().equals("S") || product.getProductType().equals("E")) {
				mTab.fireDataStatusEEvent(
						MMessage.get(ctx, 240).getMsgText(), "Cannot add "
								+ (product.getProductType().equals("S") ? "service" : "expense") + " to inventory",
						true);
			}
		}
		return null;
	}

}
