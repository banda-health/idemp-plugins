package org.bandahealth.idempiere.base.modelevent;

import java.sql.Timestamp;
import java.util.Calendar;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.MAttributeSetTemplate;
import org.bandahealth.idempiere.base.MInOutTemplate;
import org.bandahealth.idempiere.base.MOrderLineTemplate;
import org.bandahealth.idempiere.base.MOrderTemplate;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MInOut;
import org.compiere.util.Env;

import test.AdempiereTestCase;

public class OrderLineModelEventTest extends AdempiereTestCase {

	private MOrder_BH order;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());

		order = new MOrderTemplate(getTrxName(), getCtx(), false, Env.getAD_Client_ID(getCtx())).getInstance();
	}

	public void testReceiveProductHasExpiration() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);

		new MAttributeSetTemplate(getTrxName(), getCtx()).getInstance();

		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order).getInstance();
		orderLine.setBH_Expiration(new Timestamp(cal.getTimeInMillis()));
		orderLine.saveEx();

		assertNotNull("Receive Product Order Line should not be null", orderLine);
		assertNotNull("Attribute Set instance should not be null", orderLine.getM_AttributeSetInstance_ID());
	}

	public void testReceiveProductHasNoExpiration() throws Exception {
		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order).getInstance();
		orderLine.saveEx();

		assertNotNull("Receive Product Order Line should not be null", orderLine);
		assertNull("Expiration date should be null", orderLine.getBH_Expiration());
	}

	public void testReceiveProductInvalidExpiration() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);

		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order).getInstance();
		orderLine.setBH_Expiration(new Timestamp(cal.getTimeInMillis()));

		try {
			orderLine.saveEx();
		} catch (AdempiereException ex) {
			return;
		}

		fail("Expiration should be a future date");
	}

	public void testCreateMaterialReceipt() throws Exception {
		MOrderLine_BH orderLine = new MOrderLineTemplate(getTrxName(), getCtx(), order).getInstance();

		assertNotNull("Receive Product Order Line should not be null", orderLine);

		order.setDocAction(MOrder_BH.DOCACTION_Complete);
		String status = order.completeIt();
		assertEquals("Should process order successfully", "CO", status);

		MInOut inOut = new MInOutTemplate(getTrxName(), getCtx(), order.get_ID()).getInstance();
		assertNotNull("MInOut should not be null", inOut);

		assertEquals(MInOut.MOVEMENTTYPE_VendorReceipts, inOut.getMovementType());
		assertEquals("CO", inOut.getDocStatus());
	}
}