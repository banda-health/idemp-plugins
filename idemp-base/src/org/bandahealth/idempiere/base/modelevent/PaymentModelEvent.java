package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoice;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class PaymentModelEvent extends AbstractEventHandler {

	CLogger log = CLogger.getCLogger(PaymentModelEvent.class);

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MPayment_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MPayment_BH payment = null;
		PO persistentObject = getPO(event);
		if (persistentObject instanceof MPayment_BH) {
			payment = (MPayment_BH) persistentObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(payment);
		}
	}

	private void beforeSaveRequest(MPayment_BH payment) {
		if (payment.getBH_C_Order_ID() > 0) {
			String where = MOrder_BH.COLUMNNAME_C_Order_ID + "=?";
			MOrder_BH order = new Query(Env.getCtx(), MOrder_BH.Table_Name, where, payment.get_TrxName())
					.setParameters(payment.getBH_C_Order_ID())
					.first();

			// Set bank account to default potentially
			boolean isReceipt = true;
			payment.setC_DocType_ID(isReceipt);
			payment.setIsReceipt(isReceipt);

			payment.setC_BPartner_ID(order.getC_BPartner_ID());

			// If the order is already complete, assign this payment to the order's invoice
			if (order.getDocStatus().equalsIgnoreCase(MOrder_BH.DOCSTATUS_Completed)) {
				MInvoice invoice = order.getInvoices()[0];
				payment.setC_Invoice_ID(invoice.getC_Invoice_ID());
			}
		} else {
			payment.setDefaultBH_C_Order_ID();
			
			if (payment.getC_Invoice_ID() > 0) {
				return;
			}
	
			// Issue go-1219: Need to make sure the service debt/pay outstanding balance window does not result to negative open balances.
			
			// get bpartner's total open balance
			MBPartner bPartner = MBPartner.get(Env.getCtx(), payment.getC_BPartner_ID());
			if (bPartner == null) {
				throw new AdempiereException("Payment must have a business partner");
			}
			
			BigDecimal totalOpenBalance = bPartner.getTotalOpenBalance();
			
			// set the payment amount to tender amount
			payment.setBH_TenderAmount(payment.getPayAmt());
			
			if (totalOpenBalance.compareTo(BigDecimal.ZERO) <= 0) {
				payment.setPayAmt(BigDecimal.ZERO);
			} else if (payment.getPayAmt().compareTo(totalOpenBalance) > 0) {
				payment.setPayAmt(totalOpenBalance);
			}
		}
	}
}
