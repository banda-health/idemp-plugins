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

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal productQuantity = (BigDecimal) mTab.getField(MOrderLine.COLUMNNAME_QtyEntered).getValue();
		BigDecimal totalLineAmount = (BigDecimal) mField.getValue();
		if (productQuantity == null || totalLineAmount == null) {
			errorMessage = "product Qty or total line aamount is empty";
			return errorMessage;
		}
		BigDecimal unitPrice = totalLineAmount.divide(productQuantity, 2, RoundingMode.HALF_UP);
		mTab.setValue(MOrderLine_BH.COLUMNNAME_PriceEntered, unitPrice);
		return errorMessage;
	}

}
