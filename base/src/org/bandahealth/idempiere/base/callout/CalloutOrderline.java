package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.Env;

public class CalloutOrderline extends CalloutEngine {

	private String errorMessage = null;
	private BigDecimal productQuantity, totalLineAmount, unitPrice;

	public String validate(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// don't touch SO line items.
		String isSoTrx = Env.getContext(ctx, WindowNo, 0, "IsSOTrx");
		
		if (value != null) {
			if (mField.getColumnName().equals(MOrderLine_BH.COLUMNNAME_PriceEntered)){
				unitPrice = (BigDecimal) mField.getValue();
				mTab.setValue(MOrderLine_BH.COLUMNNAME_PriceActual, unitPrice);
				
				productQuantity = (BigDecimal) mTab.getField(MOrderLine_BH.COLUMNNAME_QtyEntered).getValue();
			} else if (mField.getColumnName().equals(MOrderLine_BH.COLUMNNAME_QtyEntered)){
				productQuantity = (BigDecimal) mField.getValue();
				
				if (isSoTrx != null && isSoTrx.equalsIgnoreCase("Y")) {
					unitPrice = (BigDecimal)mTab.getField(MOrderLine_BH.COLUMNNAME_PriceActual).getValue();
				} else {
					totalLineAmount = (BigDecimal) mTab.getField(MOrderLine_BH.COLUMNNAME_LineNetAmt).getValue();	
				}
				
			} else {
				totalLineAmount = (BigDecimal) mField.getValue();
				
				productQuantity = (BigDecimal) mTab.getField(MOrderLine_BH.COLUMNNAME_QtyEntered).getValue();
			}
			
			if (unitPrice == null) {
				unitPrice = totalLineAmount.divide(productQuantity, 2, RoundingMode.CEILING);
			}
			
			if (totalLineAmount == null) {
				totalLineAmount = productQuantity.multiply(unitPrice);
			}
			
			// save qty, unitprice, totallineamount
			mTab.setValue(MOrderLine_BH.COLUMNNAME_LineNetAmt, totalLineAmount);
			
			mTab.setValue(MOrderLine_BH.COLUMNNAME_QtyEntered, productQuantity);
			
			mTab.setValue(MOrderLine_BH.COLUMNNAME_PriceEntered, unitPrice);
			mTab.setValue(MOrderLine_BH.COLUMNNAME_PriceActual, unitPrice);
		}

		return errorMessage;
	}

}
