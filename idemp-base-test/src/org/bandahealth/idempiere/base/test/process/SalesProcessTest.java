package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertTrue;

public class SalesProcessTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void testProcessRequest() throws Exception {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBP(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocAction(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPaymentBH().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPaymentBH().saveEx();
		commitEx();

		valueObject.setStepName("Run the sales order completion process");
		valueObject.setProcess_UU("c5f39620-b2dc-42ad-8626-7713c4f22e0c");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(
				Collections.singletonList(new ProcessInfoParameter("c_order_id", valueObject.getOrder().get_ID(), "", "",
						"")));
		ChuBoeCreateEntity.runProcess(valueObject);

		valueObject.setStepName("Confirm sales entities are completed");
		valueObject.refresh();
		assertTrue("Order is completed", valueObject.getOrder().isComplete());
		assertTrue("Invoice is completed", valueObject.getInvoice().isComplete());
		assertTrue("Payment is completed", valueObject.getPayment().isComplete());
	}
}
