package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MMessage;
import org.compiere.model.MProduct;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

public class ProductTypeCheck implements IColumnCallout {

	CLogger log = CLogger.getCLogger(ProductTypeCheck.class);
	private final String WINDOW_BH_ORDER = "BH Sales Order";
	private String errorMessage = null;

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		if (value != null) {
			// ignore callout while on the Sale Order window
			String windowName = Env.getContext(ctx, WindowNo + "|_WinInfo_WindowName"); 
			if (windowName.equalsIgnoreCase(WINDOW_BH_ORDER)) {
				return null;
			}
			Integer productId = (Integer) value;

			MProduct product = new MProduct(ctx, productId, null);

			if (product != null) {

				String isSoTrx = Env.getContext(ctx, WindowNo, 0, "IsSOTrx");
				if (product.getProductType().equals("E") || 
						(isSoTrx != null && isSoTrx.equalsIgnoreCase("N") && product.getProductType().equals("S"))) {
					mTab.fireDataStatusEEvent(
							MMessage.get(ctx, 240).getMsgText(), "Cannot add "
									+ (product.getProductType().equals("S") ? "service" : "expense") + " to inventory",
							true);
				}
			}
		}
		return errorMessage;
	}

}
