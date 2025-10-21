package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.ICreditManager;
import org.adempiere.base.ICreditManagerFactory;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.credit.CreditManagerInOut_BH;
import org.bandahealth.idempiere.base.model.credit.CreditManagerInvoice_BH;
import org.bandahealth.idempiere.base.model.credit.CreditManagerOrder_BH;
import org.compiere.model.MInOut;
import org.compiere.model.PO;

public class BHCreditManagerFactory implements ICreditManagerFactory {

	@Override
	public ICreditManager getCreditManager(PO po) {
		if (po instanceof MOrder_BH order) {
			return new CreditManagerOrder_BH(order);
		}
		if (po instanceof MInvoice_BH invoice) {
			return new CreditManagerInvoice_BH(invoice);
		}
		if (po instanceof MInOut inout) {
			return new CreditManagerInOut_BH(inout);
		}

		return null;
	}
}
