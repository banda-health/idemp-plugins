package org.bandahealth.idempiere.base.process.call;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import java.util.Properties;

public class ExpenseProcessAsyncCall implements Runnable {
	private CLogger log = CLogger.getCLogger(getClass());
	private Properties context;
	private Trx transaction;
	private MInvoice_BH expense;
	private String transactionName = getClass().getName() + "_startThread";
	private ProcessCallback<String> callback;

	public ExpenseProcessAsyncCall(Properties ctx, int invoiceId, ProcessCallback<String> callback) {
		super();

		context = new Properties();

		Env.setContext(context, "#AD_Client_ID", ctx.getProperty("#AD_Client_ID"));
		Env.setContext(context, "#AD_Org_ID", ctx.getProperty("#AD_Org_ID"));
		Env.setContext(context, "#AD_Role_ID", ctx.getProperty("#AD_Role_ID"));
		Env.setContext(context, "#AD_Language", ctx.getProperty("#AD_Language"));
		Env.setContext(context, "#AD_User_ID", ctx.getProperty("#AD_User_ID"));
		Env.setContext(context, "#Date", ctx.getProperty("#Date"));

		transaction = Trx.get(transactionName, true);

		expense = new Query(
				context, MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?", transactionName)
				.setParameters(invoiceId)
				.first();

		this.callback = callback;
	}

	@Override
	public void run() {
		try {
			ServerContext.setCurrentInstance(context);
			doRun();
			transaction.commit(true);
		} catch (Exception e) {
			log.severe(e.getMessage());
			transaction.rollback();
		} finally {
			ServerContext.dispose();
			transaction.close();
			transaction = null;
		}
	}

	private void doRun() throws Exception {
		if (expense == null) {
			return;
		}
		new CompleteExpense(expense, context, transactionName, callback).processIt();
	}
}