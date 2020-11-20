package org.bandahealth.idempiere.base.process.call;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.utils.EnvConstant;
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
	private String processAction;

	public ExpenseProcessAsyncCall(
			Properties context, int invoiceId, String processAction, ProcessCallback<String> callback) {
		super();

		this.context = new Properties();

		Env.setContext(this.context, Env.AD_CLIENT_ID, context.getProperty(Env.AD_CLIENT_ID));
		Env.setContext(this.context, Env.AD_ORG_ID, context.getProperty(Env.AD_ORG_ID));
		Env.setContext(this.context, Env.AD_ROLE_ID, context.getProperty(Env.AD_ROLE_ID));
		Env.setContext(this.context, Env.AD_USER_ID, context.getProperty(Env.AD_USER_ID));
		Env.setContext(this.context, Env.LANGUAGE, context.getProperty(Env.LANGUAGE));
		Env.setContext(this.context, EnvConstant.DATE, context.getProperty(EnvConstant.DATE));

		transaction = Trx.get(transactionName, true);

		expense = new Query(
				this.context, MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?", transactionName)
				.setParameters(invoiceId)
				.first();

		this.callback = callback;
		this.processAction = processAction;
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
			transaction.close();
			transaction = null;
			ServerContext.dispose();
		}
	}

	private void doRun() throws Exception {
		if (expense == null) {
			return;
		}
		new ProcessExpense(expense, context, transactionName, processAction, callback).processIt();
	}
}