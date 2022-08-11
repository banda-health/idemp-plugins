package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteOrdersProcessTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void processCompletesPaymentsThatErrored() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setInvoice(new MInvoice_BH(valueObject.getOrder().getInvoices()[0]));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getPayment().processIt(MOrder_BH.DOCACTION_Complete);
		commitEx();

		valueObject.setStepName("Re-activate order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate);
		valueObject.getOrder().saveEx();

		valueObject.setStepName("Re-complete order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Set payment as errored");
		MPayment_BH reversedPayment =
				new Query(valueObject.getContext(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID())
						.setOrderBy(MPayment_BH.COLUMNNAME_C_Payment_ID + " ASC").first();
		MPayment_BH newPayment = reversedPayment.copy();
		newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
		newPayment.setBH_C_Order_ID(valueObject.getOrder().get_ID());
		newPayment.setBH_Processing(true);
		newPayment.saveEx();
		commitEx();

		valueObject.setStepName("Run the order completion process");
		valueObject.setProcessUuid("1d5191dd-4792-464f-94c5-5b4d652e5fe5");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		ChuBoeCreateEntity.runProcess(valueObject);

		newPayment =
				new Query(valueObject.getContext(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID())
						.setOrderBy(MPayment_BH.COLUMNNAME_C_Payment_ID + " DESC").first();
		assertNotNull(newPayment, "Order payment still exists");
		assertTrue(newPayment.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Completed), "Payment was completed");
		assertTrue(newPayment.isAllocated(), "Payment was allocated");
	}
}
