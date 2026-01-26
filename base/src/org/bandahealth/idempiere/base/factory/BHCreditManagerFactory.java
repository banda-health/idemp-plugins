package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.ICreditManager;
import org.adempiere.base.ICreditManagerFactory;
import org.bandahealth.idempiere.base.model.credit.CreditManagerInOut_BH;
import org.bandahealth.idempiere.base.model.credit.CreditManagerInvoice_BH;
import org.bandahealth.idempiere.base.model.credit.CreditManagerOrder_BH;
import org.compiere.model.MInOut;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.model.PO;

public class BHCreditManagerFactory implements ICreditManagerFactory {

	@Override
	public ICreditManager getCreditManager(PO po) {
		// Check the base entities so we can handle when iDempiere creates one internally
		if (po instanceof MOrder order) {
			return new CreditManagerOrder_BH(order);
		}
		if (po instanceof MInvoice invoice) {
			return new CreditManagerInvoice_BH(invoice);
		}
		if (po instanceof MInOut inOut) {
			return new CreditManagerInOut_BH(inOut);
		}

		return null;
	}
}
