package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class OrderLineExpirationDateRequired implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		String errorMessage = null;

		if (value != null) {
			int productId = (int) value;
			String whereClause = MProduct_BH.COLUMNNAME_M_Product_ID + "=?";
			boolean requiresExpiration = ((MProduct_BH) new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause, null)
					.setParameters(productId)
					.first())
					.isBH_HasExpiration();
			mTab.setValue(MOrderLine_BH.COLUMNNAME_BH_RequiresExpiration, requiresExpiration);
		}

		return errorMessage;
	}
}
