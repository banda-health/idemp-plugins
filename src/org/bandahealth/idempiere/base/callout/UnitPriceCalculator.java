package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MField;
import org.compiere.model.MOrderLine;
import org.compiere.util.CLogger;

public class UnitPriceCalculator implements IColumnCallout{

	CLogger log = CLogger.getCLogger(ProductTypeCheck.class);
	private String errorMessage = null;
	
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		log.info("Inside callout");
		//get the qty field q
		GridField qtyField = mTab.getField(MOrderLine.COLUMNNAME_QtyEntered);
		BigDecimal productQuantity = (BigDecimal) qtyField.getValue();
		//get the product total field T
		BigDecimal totalLineAmount = (BigDecimal)mField.getValue();
		//check if any are null/zero
		if(productQuantity == null || totalLineAmount == null ) {
			errorMessage = "Fields are null";
			return errorMessage;
		}
		//calculate the unit price p by T/q
		BigDecimal unitPrice = totalLineAmount.divide(productQuantity,2,RoundingMode.HALF_UP);
		//add p to price field
		GridField unitPriceField = mTab.getField(MOrderLine.COLUMNNAME_PriceEntered);
		unitPriceField.setValue(unitPrice, true);
		return errorMessage;
	}

	
}
