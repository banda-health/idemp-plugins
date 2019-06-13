package org.bandahealth.idempiere.base.modelevent;

import org.bandahealth.idempiere.base.MOrderTemplate;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.util.Env;

import test.AdempiereTestCase;

public class OrderModelEventTest extends AdempiereTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());
	}

	public void testBeforeSalesOrderSaveRequest() throws Exception {
		MOrder_BH order = new MOrderTemplate(getTrxName(), getCtx(), true, Env.getAD_Client_ID(getCtx())).getInstance();
		assertNotNull("Should have Sales Rep", order.getSalesRep_ID());
		assertNotNull("Should have DocType", order.getDocTypeID());
		assertNotNull("Should have DocTypeTarget", order.getC_DocTypeTarget_ID());
		assertEquals("Should have similar DocType and DocTypeTarget", true,
				order.getDocTypeID() == order.getC_DocTypeTarget_ID());
	}
}