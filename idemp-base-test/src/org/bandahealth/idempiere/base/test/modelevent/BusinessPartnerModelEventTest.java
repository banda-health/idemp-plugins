package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MUser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BusinessPartnerModelEventTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void newPatientHasCorrectInvoiceAndPaymentRules() {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create Patient");
		MBPartner_BH patient = new MBPartner_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		patient.setAD_Org_ID(0);
		patient.setName(valueObject.getStepMsg());
		patient.setDescription(valueObject.getStepMsgLong());
		patient.setIsCustomer(true);
		patient.setBH_IsPatient(true); // the model event currently uses this
		patient.saveEx();

		assertTrue("Is Patient? ", patient.isCustomer());
		assertThat("Should have an Invoice Rule: ", patient.getInvoiceRule(), is(MOrder.INVOICERULE_Immediate));
		assertThat("Should have a Payment Rule: ", patient.getPaymentRule(), is(MOrder.PAYMENTRULE_Cash));

		// should have a user contact
		MUser user = new MUser(patient);
		assertNotNull("Should have a user contact ", user);

		// should have a location
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(patient);
		assertNotNull("Should have a location ", businessPartnerLocation);
	}
}