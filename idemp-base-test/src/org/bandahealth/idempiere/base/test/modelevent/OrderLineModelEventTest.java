package org.bandahealth.idempiere.base.test.modelevent;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.test.MInOutTemplate;
import org.bandahealth.idempiere.base.test.MOrderLineTemplate;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MInOut;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class OrderLineModelEventTest extends ChuBoePopulateFactoryVO {
	private ChuBoePopulateVO valueObject;

	@IPopulateAnnotation.CanRunBefore
	protected void setUp() throws Exception {
		valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBP(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Removing order lines from order");
		List<MOrderLine_BH> orderLines =
				new Query(valueObject.getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.get_trxName()).setParameters(valueObject.getOrder().get_ID()).list();
		orderLines.forEach(orderLine -> orderLine.deleteEx(true));
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
	}

	@IPopulateAnnotation.CanRun
	public void testReceiveProductHasExpiration() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);

		MOrderLine_BH orderLine = createOrderLine();
		orderLine.setBH_Expiration(new Timestamp(cal.getTimeInMillis()));
		orderLine.saveEx();

		assertNotNull("Receive Product Order Line should not be null", orderLine);
		assertTrue("Attribute Set instance should not be null", orderLine.getM_AttributeSetInstance_ID() > 0);
	}

	public void testReceiveProductHasNoExpiration() throws Exception {
		MOrderLine_BH orderLine = createOrderLine();

		assertNotNull("Receive Product Order Line should not be null", orderLine);
		assertNull("Expiration date should be null", orderLine.getBH_Expiration());
	}

	@IPopulateAnnotation.CanRun
	public void testReceiveProductInvalidExpiration() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);

		MOrderLine_BH orderLine = createOrderLine();
		orderLine.setBH_Expiration(new Timestamp(cal.getTimeInMillis()));

		try {
			orderLine.saveEx();
		} catch (AdempiereException ex) {
			return;
		}

		fail("Expiration should be a future date");
	}

	@IPopulateAnnotation.CanRun
	public void materialReceiptIsCreatedWhenReceiveAnOrder() throws Exception {
		MOrderLine_BH orderLine = createOrderLine();

		assertNotNull("Receive Product Order Line should not be null", orderLine);

		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		String status = valueObject.getOrder().completeIt();
		assertEquals("Should process order successfully", MOrder_BH.DOCACTION_Complete, status);

		MInOut inOut = new Query(valueObject.getCtx(), MInOut.Table_Name, MInOut.COLUMNNAME_C_Order_ID + "=?",
				valueObject.get_trxName()).setParameters(valueObject.getOrder().get_ID()).first();
		assertNotNull("MInOut should not be null", inOut);

		assertEquals(MInOut.MOVEMENTTYPE_VendorReceipts, inOut.getMovementType());
		assertEquals("CO", inOut.getDocStatus());
	}

	private MOrderLine_BH createOrderLine() throws SQLException {
		valueObject.setStepName("Create order line");
		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getOrder());

		orderLine.setDescription(valueObject.getStepMsgLong());
		orderLine.setM_Product_ID(valueObject.getProduct().get_ID());
		orderLine.setQty(new BigDecimal(1));
		orderLine.saveEx();

		commitEx();

		return orderLine;
	}
}