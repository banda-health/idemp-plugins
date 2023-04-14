package org.bandahealth.idempiere.base.process;

import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.process.call.ExpenseProcessAsyncCall;
import org.bandahealth.idempiere.base.utils.ErrorUtils;
import org.compiere.Adempiere;
import org.compiere.model.MClient;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ExpenseProcess extends SvrProcess {

	public static final String PARAMETERNAME_C_INVOICE_ID = "c_invoice_id";
	public static final String PARAMETERNAME_PROCESS_ACTION = "processaction";

	public static final String PROCESSACTION_Complete = "Complete";
	public static final String PROCESSACTION_Remove = "Remove";

	private int invoiceId;
	private String processAction;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();
		this.processAction = DocAction.ACTION_Complete;

		for (ProcessInfoParameter parameter : parameters) {

			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase(PARAMETERNAME_C_INVOICE_ID)) {
				invoiceId = parameter.getParameterAsInt();
			} else if (parameterName.equalsIgnoreCase(PARAMETERNAME_PROCESS_ACTION)) {
				String processAction = parameter.getParameterAsString();
				if (processAction.equalsIgnoreCase(PROCESSACTION_Remove)) {
					this.processAction = DocAction.ACTION_Reverse_Accrual;
				}
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		setBHProcessingStatus(true, null, null);
		// async call.
		Adempiere.getThreadPoolExecutor()
				.schedule(new ExpenseProcessAsyncCall(getCtx(), invoiceId, processAction, new ProcessCallback<String>() {

					@Override
					public void onSuccess(Properties context, String transactionName) {
						setBHProcessingStatus(false, context, transactionName);}

					@Override
					public void onError(String error, Properties context, String transactionName) {
						MClient client = MClient.get(getCtx(), getAD_Client_ID());
						client.sendEMail("implementer@bandahealth.org", "ERROR PROCESSING PATIENT BILL",
								ErrorUtils.createHtmlBody(error, client.getName()), null, true);
					}
				}), 0, TimeUnit.MILLISECONDS);

		return null;
	}

	private void setBHProcessingStatus(boolean processing, Properties context, String transactionName) {
		String where = MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?";
		MInvoice_BH expense = new Query(
				context == null ? getCtx() : context,
				MInvoice_BH.Table_Name,
				where,
				transactionName
		)
				.setParameters(invoiceId)
				.first();
		expense.setBH_Processing(processing);
		expense.saveEx();
	}
}
