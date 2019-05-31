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
		MBPartner_BH bPartner = new MBPartnerTemplate(getTrxName(), getCtx()).newInstance(Env.getAD_Org_ID(getCtx()));
		bPartner.setBH_PatientID("000001");
		bPartner.setBH_IsPatient(true);
		bPartner.saveEx();

		assertEquals("Is Patient? ", true, bPartner.isCustomer());
		assertEquals("Should have an Invoice Rule: ", MOrder.INVOICERULE_Immediate, bPartner.getInvoiceRule());
		assertEquals("Should have a Payment Rule: ", MOrder.PAYMENTRULE_Cash, bPartner.getPaymentRule());
		assertNotNull("Should have a Price List: ", bPartner.getM_PriceList_ID());
	}

	@Test
	public void testAfterCreateNewPatientEvent() {
		MBPartner_BH bPartner = new MBPartnerTemplate(getTrxName(), getCtx()).newInstance(Env.getAD_Org_ID(getCtx()));
		bPartner.setBH_PatientID("000002");
		bPartner.setBH_IsPatient(true);
		bPartner.saveEx();

		// should have a user contact
		MUser user = new MUser(bPartner);
		assertNotNull("Should have a user contact ", user);

		// should have a location
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(bPartner);
		assertNotNull("Should have a location ", businessPartnerLocation);
	}
}