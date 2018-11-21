package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MOrderLine;
import org.compiere.util.CLogger;

public class UnitPriceCalculator implements IColumnCallout {

	CLogger log = CLogger.getCLogger(ProductTypeCheck.class);
	private String errorMessage = null;
	BigDecimal productQuantity, totalLineAmount, persistedUnitPrice, calculatedUnitPrice;

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if (value != null) {
			productQuantity = (BigDecimal) mTab.getField(MOrderLine.COLUMNNAME_QtyEntered).getValue();
			totalLineAmount = (BigDecimal) mField.getValue();
			persistedUnitPrice = (BigDecimal)mTab.getField(MOrderLine.COLUMNNAME_PriceActual).getValue();
			calculatedUnitPrice = totalLineAmount.divide(productQuantity, 2, RoundingMode.HALF_UP);
			
			//since lineTotal is calculated from table values (priceActual * Qty)...
			//set the calculated unit price as actual price
			if (persistedUnitPrice != calculatedUnitPrice) {
				mTab.setValue(MOrderLine.COLUMNNAME_PriceActual, calculatedUnitPrice);
			}
			mTab.setValue(MOrderLine_BH.COLUMNNAME_PriceEntered, calculatedUnitPrice);
		}
		return errorMessage;
	}

}
