package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;

public class CalloutPayment implements IColumnCallout {

	private String errorMessage = null;

	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal remainingInvoiceAmount = (BigDecimal) mTab
				.getField(MPayment_BH.COLUMNNAME_BH_REMAINING_INVOICE_AMOUNT).getValue();
		if (remainingInvoiceAmount != null && remainingInvoiceAmount.compareTo(BigDecimal.ZERO) >= 0) {
			mTab.setValue(MPayment_BH.COLUMNNAME_PayAmt, remainingInvoiceAmount);
		}

		return errorMessage;
	}
}