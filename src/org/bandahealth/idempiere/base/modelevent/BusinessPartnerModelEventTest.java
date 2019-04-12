package org.bandahealth.idempiere.base.modelevent;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MOrder;
import org.junit.Test;

import test.AdempiereTestCase;

public class BusinessPartnerModelEventTest extends AdempiereTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());
	}

	@Test
	public void testCreateNewPatient() {
		MBPartner_BH  bPartner = new MBPartner_BH(getCtx(), 0, getTrxName());
		bPartner.setName("Joe Blow");
		bPartner.setBH_PatientID("000001");
		bPartner.setBH_IsPatient(true);

		boolean successful = bPartner.save();
		assertEquals("Successfully created patient: ", true, successful);

		MBPartner_BH savedBPartner = (MBPartner_BH) MBPartner_BH.get(getCtx(), bPartner.get_ID());
		assertEquals("Is Patient? ", true, savedBPartner.isCustomer());
		assertEquals("Should have an Invoice Rule: ", MOrder.INVOICERULE_Immediate, savedBPartner.getInvoiceRule());
		assertEquals("Should have a Payment Rule: ", MOrder.PAYMENTRULE_Cash, savedBPartner.getPaymentRule());
		assertNotNull("Should have a Price List: ", savedBPartner.getM_PriceList_ID());
	}

	@Test
	public void testAfterNewEvent() {
		// assertEquals(true, false);
	}

	@Test
	public void testBeforeChangeEvent() {
		// assertEquals(true, false);
	}

	@Test
	public void testAfterChangeEvent() {
		// assertEquals(true, false);
	}
}
