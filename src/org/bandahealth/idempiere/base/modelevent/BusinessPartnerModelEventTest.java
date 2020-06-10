package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.AdempiereTestCase;
import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.MPriceListTemplate;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MUser;
import org.compiere.util.Env;
import org.junit.Test;

public class BusinessPartnerModelEventTest extends AdempiereTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assertNotNull("Context should not be null", getCtx());
	}

	@Test
	public void testCreateNewPatient() {
		MBPartner_BH patient = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), "000001", true,
				"Test Patient 1", false, 0,
				new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
						Env.getAD_Client_ID(getCtx()), true, "Test Patient 1 Sales Price List").getInstance().get_ID(),
				0, false).getInstance();

		assertEquals("Is Patient? ", true, patient.isCustomer());
		assertEquals("Should have an Invoice Rule: ", MOrder.INVOICERULE_Immediate, patient.getInvoiceRule());
		assertEquals("Should have a Payment Rule: ", MOrder.PAYMENTRULE_Cash, patient.getPaymentRule());
		assertNotNull("Should have a Price List: ", patient.getM_PriceList_ID());
	}

	@Test
	public void testAfterCreateNewPatientEvent() {
		MBPartner_BH patient = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), "000002", true,
				"Test Patient 2", false, 0,
				new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
						Env.getAD_Client_ID(getCtx()), true, "Test Patient 1 Sales Price List").getInstance().get_ID(),
				0, false).getInstance();

		// should have a user contact
		MUser user = new MUser(patient);
		assertNotNull("Should have a user contact ", user);

		// should have a location
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(patient);
		assertNotNull("Should have a location ", businessPartnerLocation);
	}

	/*
	 * public void testCheckUniquePatientID() { try { new
	 * MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
	 * "000001", true, "Test Patient 3", false, 0, 0, 0, false).getInstance();
	 * 
	 * new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
	 * "000001", true, "Test Patient 4", false, 0, 0, 0, false).getInstance(); }
	 * catch (AdempiereException ex) { //return; }
	 * 
	 * fail("The Patient ID already exists in the system.");
	 * 
	 * }
	 */
}