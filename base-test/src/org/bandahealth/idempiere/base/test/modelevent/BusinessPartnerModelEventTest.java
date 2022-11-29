package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrder;
import org.compiere.model.MUser;

import java.sql.Timestamp;

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
		patient.setBH_Birthday(ChuBoeCreateEntity.getDateOffset(new Timestamp(System.currentTimeMillis()), -3 * 365));
		patient.saveEx();

		assertTrue(patient.isCustomer(), "Is Patient?");
		assertThat("Should have an Invoice Rule: ", patient.getInvoiceRule(), is(MOrder.INVOICERULE_Immediate));
		assertThat("Should have a Payment Rule: ", patient.getPaymentRule(), is(MOrder.PAYMENTRULE_OnCredit));

		// should have a user contact
		MUser user = patient.getContacts(false).length > 0 ? patient.getContacts(false)[0] : null;
		assertNotNull(user, "Should have a user contact ");
		assertThat("Birthdays match", patient.getBH_Birthday(), is(user.getBirthday()));

		// should have a location
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(patient);
		assertNotNull(businessPartnerLocation, "Should have a location ");
	}
}