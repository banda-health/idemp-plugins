package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
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
	public void createOrder() throws Exception {
		valueObject = new BandaValueObjectWrapper();
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
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.refresh();
	}

	@IPopulateAnnotation.CanRun
	public void materialReceiptIsCreatedWhenReceiveAnOrder() throws Exception {
		MOrderLine_BH orderLine = valueObject.getOrderLineBH();

		assertNotNull(orderLine, "Receive Product Order Line should not be null");

		valueObject.getOrderBH().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrderBH().processIt(MOrder_BH.DOCACTION_Complete));
		valueObject.getOrderBH().saveEx();
		commitEx();
		valueObject.refresh();

		MInOut inOut = new Query(valueObject.getCtx(), MInOut.Table_Name, MInOut.COLUMNNAME_C_Order_ID + "=?",
				valueObject.get_trxName()).setParameters(valueObject.getOrderBH().get_ID()).first();
		assertNotNull(inOut, "MInOut should not be null");

		assertEquals(MInOut.MOVEMENTTYPE_VendorReceipts, inOut.getMovementType());
		assertEquals(DocumentEngine.STATUS_Completed, inOut.getDocStatus());
	}
}