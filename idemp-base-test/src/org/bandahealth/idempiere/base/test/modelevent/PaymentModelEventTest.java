package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.compiere.process.DocumentEngine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentModelEventTest extends ChuBoePopulateFactoryVO {
	private BandaValueObjectWrapper valueObject;

	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Open needed periods");
		BandaCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRunBefore
	public void createSalesOrders() throws Exception {
		this.valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Initialize business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		commitEx();
		valueObject.setDocAction(null);
	}

	@IPopulateAnnotation.CanRunAfter
	public void after() throws Exception {
		this.valueObject = null;
	}

	@IPopulateAnnotation.CanRun
	public void paymentInformationSetCorrectlyWhenSavedOnASalesOrder() throws Exception {
		valueObject.setStepName("Create payment");
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getOrder(), valueObject.getDocType().get_ID(), valueObject.getDate()));
		BandaCreateEntity.createPayment(valueObject);
		valueObject.refresh();
		valueObject.getPaymentBH().setBH_C_Order_ID(valueObject.getOrderBH().get_ID());
		valueObject.getPaymentBH().saveEx();
		commitEx();

		valueObject.refresh();

		assertNotNull(valueObject.getPaymentBH(), "Payment should not be null");
		assertTrue(valueObject.getPaymentBH().getBH_C_Order_ID() > 0, "Should have an Order");
		assertTrue(valueObject.getPaymentBH().getC_DocType_ID() > 0, "Should have a DocType");
		assertTrue(valueObject.getPaymentBH().isReceipt(), "Should be a receipt");
		assertEquals(valueObject.getPaymentBH().getC_BPartner_ID(), valueObject.getOrder().getC_BPartner_ID(),
				"Should have the same business partner as the order");
		assertEquals(0, valueObject.getPaymentBH().getC_Invoice_ID(), "Should NOT have an invoice");
	}
}
