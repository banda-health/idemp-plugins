package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentModelEventTest extends ChuBoePopulateFactoryVO {
	private ChuBoePopulateVO valueObject;

	@IPopulateAnnotation.CanRunBefore
	protected void before() throws Exception {
		this.valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Initialize business partner");
		ChuBoeCreateEntity.createBP(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, null, true, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRunAfter
	protected void after() throws Exception {
		this.valueObject = null;
	}

	@IPopulateAnnotation.CanRun
	public void paymentInformationSetCorrectlyWhenSavedOnASalesOrder() throws Exception {
		valueObject.setStepName("Create payment");
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		MPayment_BH payment =
				new Query(valueObject.getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_ID + "=?",
						valueObject.get_trxName()).setParameters(valueObject.getPayment().get_ID()).first();

		assertNotNull("Payment should not be null", payment);
		assertTrue("Should have an Order", payment.getBH_C_Order_ID() > 0);
		assertTrue("Should have a DocType", payment.getC_DocType_ID() > 0);
		assertTrue("Should be a receipt", payment.isReceipt());
		assertTrue("Should have the same business partner as the order",
				payment.getC_BPartner_ID() == valueObject.getOrder().getC_BPartner_ID());
		assertTrue("Should NOT have an invoice", payment.getC_Invoice_ID() == 0);
	}
}
