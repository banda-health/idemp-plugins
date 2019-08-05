package org.bandahealth.idempiere.base.process;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MMessage;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Trx;

public class SalesProcessJob implements Runnable {
	private CLogger log = CLogger.getCLogger(getClass());
	private Properties m_ctx;
	private Trx m_trx;
	private MOrder_BH salesOrder;
	private String trxName = getClass().getName() + "_startThread";
	private ProcessCallback<String> callback;

	public SalesProcessJob(Properties ctx, int orderId, ProcessCallback<String> callback) {
		super();

		m_ctx = new Properties();

		Env.setContext(m_ctx, "#AD_Client_ID", ctx.getProperty("#AD_Client_ID"));
		Env.setContext(m_ctx, "#AD_Org_ID", ctx.getProperty("#AD_Org_ID"));
		Env.setContext(m_ctx, "#AD_Role_ID", ctx.getProperty("#AD_Role_ID"));
		Env.setContext(m_ctx, "#M_Warehouse_ID", ctx.getProperty("#M_Warehouse_ID"));
		Env.setContext(m_ctx, "#AD_Language", ctx.getProperty("#AD_Language"));
		Env.setContext(m_ctx, "#AD_User_ID", ctx.getProperty("#AD_User_ID"));
		Env.setContext(m_ctx, "#Date", ctx.getProperty("#Date"));

		m_trx = Trx.get(trxName, true);

		salesOrder = new Query(m_ctx, MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?", trxName)
				.setParameters(orderId).first();

		this.callback = callback;
	}

	@Override
	public void run() {
		try {
			ServerContext.setCurrentInstance(m_ctx);
			doRun();
			m_trx.commit(true);
		} catch (Exception e) {
			log.severe(e.getMessage());
			m_trx.rollback();
		} finally {
			ServerContext.dispose();
			m_trx.close();
			m_trx = null;
		}
	}

	private void doRun() throws Exception {
		if (salesOrder == null) {
			return;
		}

		if (salesOrder.isSOTrx()) {
			processSalesOrder();
		} else {
			salesOrder.setBH_Isexpense(true);
			salesOrder.processIt(DocAction.ACTION_Complete);
		}
	}

	private void processSalesOrder() {
		long start = System.currentTimeMillis();
		/* Packed out from BH_SysConfig */
		String noLineItemsEnteredErrorMsgUUID = "03cb65e5-104c-4dd6-bec0-4bfe244ae804";
		if (!salesOrder.getDocStatus().equals(MOrder_BH.DOCSTATUS_Drafted)) {
			return;
		}
		Date date = new Date();
		if (salesOrder.getDateAcct() != null && salesOrder.getDateAcct().before(date)) {
			salesOrder.setDateAcct(new Timestamp(date.getTime()));
			log.info("Setting accounting date to: " + salesOrder.getDateAcct());
		}
		if ((salesOrder.getTotalLines().intValue() == 0)) {
			MMessage message = new Query(m_ctx, MMessage.Table_Name, MMessage.COLUMNNAME_AD_Message_UU + "=?", null)
					.setParameters(noLineItemsEnteredErrorMsgUUID).first();
			throw new AdempiereUserError(message.getMsgText());
		}

		try {
			boolean salesOrderIsComplete = salesOrder.processIt(DocAction.ACTION_Complete);
			if (!salesOrderIsComplete) {
				callback.onError("Error trying to complete order " + salesOrder.getC_Order_ID(), m_ctx, trxName);
			} else {
				callback.onSuccess(m_ctx, trxName);
			}
		} catch (AdempiereException ex) {
			callback.onError("Could not complete order " + salesOrder.getC_Order_ID() + ". Error: " + ex.getMessage(),
					m_ctx, trxName);
		} finally {
			log.warning("Time spent processing SO (secs): " + (System.currentTimeMillis() - start) / 1000);
		}
	}
}