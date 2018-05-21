package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MInventoryLine;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

public class InventoryQuantity implements IColumnCallout {

	CLogger logger = CLogger.getCLogger(this.getClass());
	
	
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		String errorMessage = null;
		Integer productId = (Integer) value;
		
		String whereClause = MOrderLine_BH.COLUMNNAME_M_Product_ID+"=?";
		Query inventoryAvailabeForProduct = new Query(Env.getCtx(),MInventoryLine.Table_Name,
				whereClause, null);
		Integer quantityCount = inventoryAvailabeForProduct.setParameters(productId).first().get_ValueAsInt("qtycount");
		mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyAvailable, BigDecimal.valueOf(quantityCount));
		
		return errorMessage;
	}

}
