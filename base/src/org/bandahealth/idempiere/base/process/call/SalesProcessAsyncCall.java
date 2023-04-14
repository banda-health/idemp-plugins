package org.bandahealth.idempiere.base.process.call;

import java.util.Properties;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Trx;

public class SalesProcessAsyncCall implements Runnable {
	private CLogger log = CLogger.getCLogger(getClass());
	private Properties context;
	private Trx transaction;
	private MOrder_BH salesOrder;
	private String transactionName = getClass().getName() + "_startThread";
	private ProcessCallback<String> callback;

	public SalesProcessAsyncCall(Properties ctx, int orderId, ProcessCallback<String> callback) {
		super();

		context = new Properties();

		Env.setContext(context, "#AD_Client_ID", ctx.getProperty("#AD_Client_ID"));
		Env.setContext(context, "#AD_Org_ID", ctx.getProperty("#AD_Org_ID"));
		Env.setContext(context, "#AD_Role_ID", ctx.getProperty("#AD_Role_ID"));
		Env.setContext(context, "#M_Warehouse_ID", ctx.getProperty("#M_Warehouse_ID"));
		Env.setContext(context, "#AD_Language", ctx.getProperty("#AD_Language"));
		Env.setContext(context, "#AD_User_ID", ctx.getProperty("#AD_User_ID"));
		Env.setContext(context, "#Date", ctx.getProperty("#Date"));

		transaction = Trx.get(transactionName, true);

		salesOrder = new Query(context, MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?", transactionName)
				.setParameters(orderId).first();

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
		if (salesOrder == null) {
			return;
		}

		if (salesOrder.isSOTrx()) {
			new ProcessSalesOrder(salesOrder, context, transactionName, callback).processIt();
		}
	}
}