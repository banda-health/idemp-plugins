package org.bandahealth.idempiere.base.process;

import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.process.call.ExpenseProcessAsyncCall;
import org.bandahealth.idempiere.base.utils.ErrorUtils;
import org.compiere.Adempiere;
import org.compiere.model.MClient;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ExpenseProcess extends SvrProcess {

	private int invoiceId;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();

		for (ProcessInfoParameter parameter : parameters) {

			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase("c_invoice_id")) {
				invoiceId = parameter.getParameterAsInt();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		// check receive goods/expenses
		MInvoice_BH invoice = new Query(
				getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?", get_TrxName())
				.setParameters(invoiceId)
				.first();
		
//		setPaymentStatus(true, null, null);

		// async call.
		Adempiere.getThreadPoolExecutor()
				.schedule(new ExpenseProcessAsyncCall(getCtx(), invoiceId, new ProcessCallback<String>() {

					@Override
					public void onSuccess(Properties context, String transactionName) {
//						setPaymentStatus(false, context, transactionName);
						// Add payments equalling the amount of this invoice, associate them, and complete them
					}

					@Override
					public void onError(String error, Properties context, String transactionName) {
						// setPaymentStatus(false, context, transactionName);

						MClient client = MClient.get(getCtx(), getAD_Client_ID());
						client.sendEMail("implementer@bandahealth.org", "ERROR PROCESSING PATIENT BILL",
								ErrorUtils.createHtmlBody(error, client.getName()), null, true);
					}
				}), 0, TimeUnit.MILLISECONDS);

		return null;
	}
}
