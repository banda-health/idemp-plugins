package org.bandahealth.idempiere.base.modelevent;

import org.bandahealth.idempiere.base.AdempiereTestCase;
import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.MOrderTemplate;
import org.bandahealth.idempiere.base.MPriceListTemplate;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.util.Env;

public class OrderModelEventTest extends AdempiereTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());
	}

	public void testBeforeSalesOrderSaveRequest() throws Exception {
		int priceListId = new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
				Env.getAD_Client_ID(getCtx()), true, "Test Order Sales Price List").getInstance().get_ID();

		int bPartnerId = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), null, false,
				"Test Order Patient 1", true, 0, priceListId, 0, false).getInstance().get_ID();
		MOrder_BH order = new MOrderTemplate(getTrxName(), getCtx(), true, Env.getAD_Client_ID(getCtx()), priceListId,
				bPartnerId).getInstance();
		assertNotNull("Should have Sales Rep", order.getSalesRep_ID());
		assertNotNull("Should have DocType", order.getDocTypeID());
		assertNotNull("Should have DocTypeTarget", order.getC_DocTypeTarget_ID());
		assertEquals("Should have similar DocType and DocTypeTarget", true,
				order.getDocTypeID() == order.getC_DocTypeTarget_ID());
	}
}