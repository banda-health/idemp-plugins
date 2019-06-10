package org.bandahealth.idempiere.base.modelevent;

import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MUser;
import org.compiere.util.Env;
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
		MBPartner_BH patient = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), "000001", true,
				"Test Patient").getInstance();

		assertEquals("Is Patient? ", true, patient.isCustomer());
		assertEquals("Should have an Invoice Rule: ", MOrder.INVOICERULE_Immediate, patient.getInvoiceRule());
		assertEquals("Should have a Payment Rule: ", MOrder.PAYMENTRULE_Cash, patient.getPaymentRule());
		assertNotNull("Should have a Price List: ", patient.getM_PriceList_ID());
	}

	@Test
	public void testAfterCreateNewPatientEvent() {
		MBPartner_BH patient = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), "000002", true,
				"Test Patient").getInstance();

		// should have a user contact
		MUser user = new MUser(patient);
		assertNotNull("Should have a user contact ", user);

		// should have a location
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(patient);
		assertNotNull("Should have a location ", businessPartnerLocation);
	}
}