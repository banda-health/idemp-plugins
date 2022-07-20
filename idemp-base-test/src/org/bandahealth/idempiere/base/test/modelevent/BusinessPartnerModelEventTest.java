package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MUser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BusinessPartnerModelEventTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void newPatientHasCorrectInvoiceAndPaymentRules() {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create Patient");
		MBPartner_BH patient = new MBPartner_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		patient.setAD_Org_ID(0);
		patient.setName(valueObject.getStepMessage());
		patient.setDescription(valueObject.getStepMessageLong());
		patient.setIsCustomer(true);
		patient.setBH_IsPatient(true); // the model event currently uses this
		patient.saveEx();

		assertTrue(patient.isCustomer(), "Is Patient?");
		assertThat("Should have an Invoice Rule: ", patient.getInvoiceRule(), is(MOrder.INVOICERULE_Immediate));
		assertThat("Should have a Payment Rule: ", patient.getPaymentRule(), is(MOrder.PAYMENTRULE_Cash));

		// should have a user contact
		MUser user = new MUser(patient);
		assertNotNull(user, "Should have a user contact ");

		// should have a location
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(patient);
		assertNotNull(businessPartnerLocation, "Should have a location ");
	}
}