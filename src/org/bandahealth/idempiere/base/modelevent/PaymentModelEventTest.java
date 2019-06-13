package org.bandahealth.idempiere.base.modelevent;

import org.bandahealth.idempiere.base.MOrderLineTemplate;
import org.bandahealth.idempiere.base.MOrderTemplate;
import org.bandahealth.idempiere.base.MPaymentTemplate;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.util.Env;

import test.AdempiereTestCase;

public class PaymentModelEventTest extends AdempiereTestCase {

	private MOrder_BH order;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());

		// create order
		order = new MOrderTemplate(getTrxName(), getCtx(), true, Env.getAD_Client_ID(getCtx())).getInstance();
		// set orderline
		new MOrderLineTemplate(getTrxName(), getCtx(), order).getInstance();
	}

	public void testSalesOrderPaymentBeforeSaveRequest() throws Exception {
		MPayment_BH payment = new MPaymentTemplate(getTrxName(), getCtx(), order).getInstance();

		assertNotNull("Payment should not be null", payment);
		assertNotNull("Should have an Order", payment.getBH_C_Order_ID());
		assertNotNull("Should have a DocType", payment.getC_DocType_ID());
		assertNotNull("Should be a receipt", payment.isReceipt());
		assertEquals("Should have the same business partner as the order", true,
				payment.getC_BPartner_ID() == order.getC_BPartner_ID());
		assertEquals("Should NOT have an invoice", true, payment.getC_Invoice_ID() == 0);

	}

	public void testCompletedSalesOrderPaymentBeforeSaveRequest() throws Exception {
		//boolean status = order.processIt(DocAction.ACTION_Complete);
		//order.completeIt();
		// assertEquals("Should process order successfully",
		// MOrder_BH.DOCACTION_Complete, status);
		//assertEquals("Should have completed status", MOrder_BH.DOCSTATUS_Completed, order.getDocStatus());

		//MPayment_BH payment = new MPaymentTemplate(getTrxName(), getCtx(), order).getInstance();

		//assertEquals("Should have an invoice since the order is complete", true, payment.getC_Invoice_ID() > 0);

	}
}
