package org.bandahealth.idempiere.base.modelevent;

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
import static org.junit.Assert.assertNotNull;

public class BusinessPartnerModelEventTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void newPatientHasCorrectInvoiceAndPaymentRules() {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create Patient");
		MBPartner_BH patient = new MBPartner_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		patient.setAD_Org_ID(0);
		patient.setName(valueObject.getStepMsg());
		patient.setDescription(valueObject.getStepMsgLong());
		patient.setIsCustomer(true);
		patient.saveEx();

		assertThat("Is Patient? ", true, is(patient.isCustomer()));
		assertThat("Should have an Invoice Rule: ", MOrder.INVOICERULE_Immediate, is(patient.getInvoiceRule()));
		assertThat("Should have a Payment Rule: ", MOrder.PAYMENTRULE_Cash, is(patient.getPaymentRule()));
	}

	@IPopulateAnnotation.CanRun
	public void newPatientHasAUserAndLocationAutomaticallyCreated() {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create Patient");
		MBPartner_BH patient = new MBPartner_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		patient.setAD_Org_ID(0);
		patient.setName(valueObject.getStepMsg());
		patient.setDescription(valueObject.getStepMsgLong());
		patient.setIsCustomer(true);
		patient.saveEx();

		// should have a user contact
		MUser user = new MUser(patient);
		assertNotNull("Should have a user contact ", user);

		// should have a location
		MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(patient);
		assertNotNull("Should have a location ", businessPartnerLocation);
	}
}