package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;

import java.util.Collections;

import static org.bandahealth.idempiere.base.test.utils.AsyncUtil.waitFor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalesProcessTest extends ChuBoePopulateFactoryVO {
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
	public void testProcessRequest() throws Exception {
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
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrder().setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.getOrder().save();
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getOrder(), valueObject.getDocumentType().get_ID(), valueObject.getDate()));
		valueObject.setDocumentAction(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Run the sales order completion process");
		valueObject.setProcessUuid("c5f39620-b2dc-42ad-8626-7713c4f22e0c");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Collections.singletonList(new ProcessInfoParameter("c_order_id", valueObject.getOrder().get_ID(), "", "",
						"")));
		ChuBoeCreateEntity.runProcess(valueObject);

		waitFor(() -> {
			valueObject.refresh();
			assertTrue(valueObject.getOrder().isComplete(), "Order is completed");
			MInvoice_BH invoice =
					new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
							valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
			assertTrue(invoice.isComplete(), "Invoice is completed");
			assertTrue(valueObject.getPayment().isComplete(), "Payment is completed");
		});
	}
}
