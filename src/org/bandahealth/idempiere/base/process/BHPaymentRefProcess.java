package org.bandahealth.idempiere.base.process;

import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.modelevent.BHPaymentRefModelEvent;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereSystemError;
import org.compiere.util.Env;

import java.util.logging.Level;

public class BHPaymentRefProcess extends SvrProcess {

	private int mbhPaymentRefId;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();

		for (ProcessInfoParameter parameter : parameters) {
			String parameterName = parameter.getParameterName();
			if (parameterName.equalsIgnoreCase("bh_paymentref_id")) {
				mbhPaymentRefId = parameter.getParameterAsInt();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		MBHPaymentRef paymentRef = new Query(
				Env.getCtx(),
				MBHPaymentRef.Table_Name,
				MBHPaymentRef.COLUMNNAME_BH_PaymentRef_ID + "=?",
				get_TrxName()
		)
				.setParameters(mbhPaymentRefId)
				.first();
		if (paymentRef == null) {
			throw new AdempiereSystemError("Payment Ref not found!");
		}
		BHPaymentRefModelEvent.synchronizeReferenceListValues(paymentRef);

		return "Synchronized!";
	}
}
