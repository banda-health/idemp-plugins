package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;

import java.util.Collections;

import static org.bandahealth.idempiere.base.test.utils.AsyncUtil.waitFor;
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
		BandaCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void testProcessRequest() throws Exception {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		valueObject.getOrder().setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.getOrder().save();
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getOrder(), valueObject.getDocType().get_ID(), valueObject.getDate()));
		valueObject.setDocAction(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		BandaCreateEntity.createPayment(valueObject);
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
		BandaCreateEntity.runProcess(valueObject);

		waitFor(() -> {
			valueObject.refresh();
			assertTrue("Order is completed", valueObject.getOrder().isComplete());
			MInvoice_BH invoice =
					new Query(valueObject.getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
							valueObject.get_trxName()).setParameters(valueObject.getOrder().get_ID()).first();
			assertTrue("Invoice is completed", invoice.isComplete());
			assertTrue("Payment is completed", valueObject.getPayment().isComplete());
		});
	}
}
