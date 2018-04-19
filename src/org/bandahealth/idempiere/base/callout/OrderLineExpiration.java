package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.Env;

public class OrderLineExpiration implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// show 'has expiration' field when the product has that field set.
		if (mField.getColumnName().equalsIgnoreCase(MProduct_BH.COLUMNNAME_M_Product_ID)) {
			if (value != null) {
				Integer productId = (Integer) value;
				MProduct_BH product = new MProduct_BH(Env.getCtx(), productId, null);
				if (!product.hasExpiration()) {
					mTab.getField(MOrderLine_BH.COLUMNNAME_BH_Expiration).setDisplayed(false);
				} else {
					mTab.getField(MOrderLine_BH.COLUMNNAME_BH_Expiration).setDisplayed(true);
				}
			}
		}

		return null;
	}
}
