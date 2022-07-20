package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.compiere.process.DocumentEngine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentModelEventTest extends ChuBoePopulateFactoryVO {
	private ChuBoePopulateVO valueObject;

	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRunBefore
	public void createSalesOrders() throws Exception {
		this.valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Initialize business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();
		valueObject.setDocumentAction(null);
	}

	@IPopulateAnnotation.CanRunAfter
	public void after() throws Exception {
		this.valueObject = null;
	}

	@IPopulateAnnotation.CanRun
	public void paymentInformationSetCorrectlyWhenSavedOnASalesOrder() throws Exception {
		valueObject.setStepName("Create payment");
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getOrder(), valueObject.getDocumentType().get_ID(), valueObject.getDate()));
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.refresh();
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.refresh();

		assertNotNull(valueObject.getPayment(), "Payment should not be null");
		assertTrue(valueObject.getPayment().getBH_C_Order_ID() > 0, "Should have an Order");
		assertTrue(valueObject.getPayment().getC_DocType_ID() > 0, "Should have a DocType");
		assertTrue(valueObject.getPayment().isReceipt(), "Should be a receipt");
		assertEquals(valueObject.getPayment().getC_BPartner_ID(), valueObject.getOrder().getC_BPartner_ID(),
				"Should have the same business partner as the order");
		assertEquals(0, valueObject.getPayment().getC_Invoice_ID(), "Should NOT have an invoice");
	}
}
