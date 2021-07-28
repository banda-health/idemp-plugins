package org.bandahealth.idempiere.base.modelevent;

import java.math.BigDecimal;

import org.bandahealth.idempiere.base.AdempiereTestCase;
import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.MOrderLineTemplate;
import org.bandahealth.idempiere.base.MOrderTemplate;
import org.bandahealth.idempiere.base.MPaymentTemplate;
import org.bandahealth.idempiere.base.MPriceListTemplate;
import org.bandahealth.idempiere.base.MProductTemplate;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MPriceList;
import org.compiere.util.Env;

public class PaymentModelEventTest extends AdempiereTestCase {

	private MOrder_BH order;
	private String PRODUCT_NAME = "Test Payment Product";

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());

		MPriceList soPriceList = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), true, "Test Payment Sales Price List").getInstance();

		MPriceList poPriceList = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), false, "Test Payment Buy Price List").getInstance();

		int bPartnerId = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), null, false,
				"Test Payment Patient 1", true, 0, soPriceList.get_ID(), poPriceList.get_ID(), false).getInstance().get_ID();

		// create order
		order = new MOrderTemplate(getTrxName(), getCtx(), true, Env.getAD_Client_ID(getCtx()), soPriceList.get_ID(),
				bPartnerId).getInstance();

		MProduct_BH product = new MProductTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), PRODUCT_NAME,
				soPriceList, poPriceList).getInstance();

		// set orderline
		new MOrderLineTemplate(getTrxName(), getCtx(), order, product.get_ID()).getInstance();
	}

	public void testSalesOrderPaymentBeforeSaveRequest() throws Exception {
		MPayment_BH payment = new MPaymentTemplate(getTrxName(), getCtx(), order, new BigDecimal(10)).getInstance();

		assertNotNull("Payment should not be null", payment);
		assertNotNull("Should have an Order", payment.getBH_C_Order_ID());
		assertNotNull("Should have a DocType", payment.getC_DocType_ID());
		assertNotNull("Should be a receipt", payment.isReceipt());
		assertEquals("Should have the same business partner as the order", true,
				payment.getC_BPartner_ID() == order.getC_BPartner_ID());
		assertEquals("Should NOT have an invoice", true, payment.getC_Invoice_ID() == 0);
	}
}
