package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;
import org.compiere.util.CLogger;

public class InventoryQuantity implements IColumnCallout {

	CLogger logger = CLogger.getCLogger(this.getClass());
	
	
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		
		logger.info("Inside "+this.getClass().getName()+" callout");
		logger.info("Column with callout is: "+mField.getColumnName()); //get the field the callout is attached to.
		mTab.setValue("Available Quantity", 5000);
		return null;
	}

}
