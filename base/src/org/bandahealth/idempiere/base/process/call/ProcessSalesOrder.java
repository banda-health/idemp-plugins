package org.bandahealth.idempiere.base.process.call;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MInvoice;
import org.compiere.model.MMessage;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
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
		if (!salesOrder.getDocStatus().equals(MOrder_BH.DOCSTATUS_Drafted) &&
				!MOrder_BH.DOCSTATUS_InProgress.equalsIgnoreCase(salesOrder.getDocStatus())) {
			callback.onError("DocStatus MUST be DRAFTED " + salesOrder.get_ID(), context, transactionName);
			return;
		}
		Date date = new Date();
		if (salesOrder.getDateAcct() != null && salesOrder.getDateAcct().before(date)) {
			salesOrder.setDateAcct(new Timestamp(date.getTime()));
			log.info("Setting accounting date to: " + salesOrder.getDateAcct());
		}

		// check if the order has any orderline items.
		int lineItemsCount = new Query(context, MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_Order_ID + " = ?",
				transactionName).setParameters(salesOrder.getC_Order_ID()).count();

		if (lineItemsCount == 0) {
			MMessage message = new Query(context, MMessage.Table_Name, MMessage.COLUMNNAME_AD_Message_UU + "=?", null)
					.setParameters(noLineItemsEnteredErrorMsgUUID).first();
			if (message != null) {
				callback.onError(message.getMsgText(), context, transactionName);
			} else {
				callback.onError("Order MUST have at least one line item: orderId = " + salesOrder.get_ID(), context,
						transactionName);
			}

			salesOrder.setDocStatus(MOrder_BH.DOCSTATUS_Invalid);
			salesOrder.saveEx();
			return;
		}

		try {
			boolean salesOrderIsComplete = salesOrder.processIt(DocAction.ACTION_Complete);
			if (!salesOrderIsComplete) {
				callback.onError("Error trying to complete order " + salesOrder.getC_Order_ID(), context,
						transactionName);
				return;
			}
			salesOrder.saveEx();
			Optional<MInvoice> invoice = Arrays.stream(salesOrder.getInvoices()).filter(MInvoice::isComplete).findFirst();
			if (invoice.isEmpty()) {
				callback.onError("Error trying to complete order " + salesOrder.getC_Order_ID() + " - invoice wasn't created",
						context, transactionName);
				return;
			}
			// Get the payments associated with this order and complete them
			List<MPayment_BH> orderPayments = new Query(context, MPayment_BH.Table_Name,
					MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + " NOT IN (?)",
					transactionName).setParameters(salesOrder.get_ID(), MPayment_BH.DOCSTATUS_Reversed).list();
			AtomicBoolean successfullyCompletedPayments = new AtomicBoolean(true);
			AtomicBoolean successfullyAllocatedPayments = new AtomicBoolean(true);
			orderPayments.forEach(payment -> {
				if (!payment.isComplete()) {
					payment.setC_Invoice_ID(invoice.get().get_ID());
					payment.setDocAction(MPayment_BH.DOCACTION_Complete);
					if (!payment.processIt(MPayment_BH.DOCACTION_Complete)) {
						successfullyCompletedPayments.set(false);
						return;
					}
				} else if (!payment.isAllocated()) {
					if (!payment.allocateIt()) {
						successfullyAllocatedPayments.set(false);
						return;
					}
				}
				payment.saveEx();
			});
			if (!successfullyCompletedPayments.get()) {
				callback.onError("Error trying to complete order payments " + salesOrder.getC_Order_ID(), context,
						transactionName);
				return;
			}
			if (!successfullyAllocatedPayments.get()) {
				callback.onError("Error trying to allocate order payments " + salesOrder.getC_Order_ID(), context,
						transactionName);
				return;
			}
			callback.onSuccess(context, transactionName);
		} catch (AdempiereException ex) {
			callback.onError("Could not complete order " + salesOrder.getC_Order_ID() + ". Error: " + ex.getMessage(),
					context, transactionName);

			// handle wrong allocation date error.
			if (ex.getMessage().contains("Failed when processing document - Wrong allocation date")) {
				// date ordered must be greater than the created date.
				if (salesOrder.getCreated().before(salesOrder.getDateOrdered())) {
					salesOrder.setDateOrdered(salesOrder.getCreated());
					salesOrder.saveEx();
				}
			}
		} finally {
			log.warning("Time spent processing SO (secs): " + (System.currentTimeMillis() - start) / 1000);
		}
	}
}
