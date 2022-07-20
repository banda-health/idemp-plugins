package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MInOut;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderLineModelEventTest extends ChuBoePopulateFactoryVO {
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
	public void createOrder() throws Exception {
		valueObject = new ChuBoePopulateVO();
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
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.refresh();
	}

	@IPopulateAnnotation.CanRun
	public void materialReceiptIsCreatedWhenReceiveAnOrder() throws Exception {
		MOrderLine_BH orderLine = valueObject.getOrderLine();

		assertNotNull(orderLine, "Receive Product Order Line should not be null");

		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete));
		valueObject.getOrder().saveEx();
		commitEx();
		valueObject.refresh();

		MInOut inOut = new Query(valueObject.getContext(), MInOut.Table_Name, MInOut.COLUMNNAME_C_Order_ID + "=?",
				valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		assertNotNull(inOut, "MInOut should not be null");

		assertEquals(MInOut.MOVEMENTTYPE_VendorReceipts, inOut.getMovementType());
		assertEquals(DocumentEngine.STATUS_Completed, inOut.getDocStatus());
	}
}