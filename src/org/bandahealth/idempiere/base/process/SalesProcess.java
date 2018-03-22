package org.bandahealth.idempiere.base.process;

import java.util.logging.Level;

import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.model.MPayment;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

public class SalesProcess extends SvrProcess {

	private int orderId;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();

		for (ProcessInfoParameter parameter : parameters) {

			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase("")) {
				orderId = parameter.getParameterAsInt();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	@Override
	protected String doIt() throws Exception {

		// First, complete the sales order, which generates a shipment and an invoice
		MOrder salesOrder = new MOrder(getCtx(), orderId, get_TrxName());
		boolean salesOrderIsComplete = salesOrder.processIt(DocAction.ACTION_Complete);
		if (!salesOrderIsComplete) {
			// Error occurred
			return null;
		}

		// If the payment amount equals the invoice amount, we're finished
//		if (salesOrder.)
		if (true) {
			return null;
		}

		// On the invoice, the payment will have been added automatically, so reverse it
		MInvoice invoice = salesOrder.getInvoices()[0];
		MPayment payment = new Query(getCtx(), MPayment.Table_Name, MPayment.COLUMNNAME_C_Invoice_ID + " = ?", get_TrxName())
				.setParameters(invoice.getC_Invoice_ID())
				.first();

		boolean paymentReversalStatus = payment.processIt(DocAction.ACTION_Reverse_Correct);
		if (!paymentReversalStatus) {
			// Error occrred
			return null;
		}

		// Now go through and add the payment with the amount specified on the order

		return null;
	}
}
