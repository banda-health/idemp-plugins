package org.bandahealth.idempiere.base.process.call;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MMessage;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;

public class ProcessSalesOrder {

	private CLogger log = CLogger.getCLogger(getClass());

	private Properties context;
	private String transactionName;
	private MOrder_BH salesOrder;
	private ProcessCallback<String> callback;

	public ProcessSalesOrder(MOrder_BH salesOrder, Properties context, String transactionName,
			ProcessCallback<String> callback) {
		this.salesOrder = salesOrder;
		this.context = context;
		this.transactionName = transactionName;
		this.callback = callback;
	}

	public void processIt() {
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
			MMessage message = new Query(context, MMessage.Table_Name, MMessage.COLUMNNAME_AD_Message_UU + "=?", null)
					.setParameters(noLineItemsEnteredErrorMsgUUID).first();
			if (message != null) {
				throw new AdempiereUserError(message.getMsgText());
			} else {
				throw new AdempiereUserError("Unable to process bill " + salesOrder.get_ID());
			}
		}

		try {
			boolean salesOrderIsComplete = salesOrder.processIt(DocAction.ACTION_Complete);
			if (!salesOrderIsComplete) {
				callback.onError("Error trying to complete order " + salesOrder.getC_Order_ID(), context,
						transactionName);
			} else {
				callback.onSuccess(context, transactionName);
			}
		} catch (AdempiereException ex) {
			callback.onError("Could not complete order " + salesOrder.getC_Order_ID() + ". Error: " + ex.getMessage(),
					context, transactionName);
		} finally {
			log.warning("Time spent processing SO (secs): " + (System.currentTimeMillis() - start) / 1000);
		}
	}
}
