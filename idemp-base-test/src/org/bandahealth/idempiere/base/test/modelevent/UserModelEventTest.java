package org.bandahealth.idempiere.base.test.modelevent;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.Query;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserModelEventTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void businessPartnerGetsUpdatedWhenUsersFieldsChange() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create Patient");
		MBPartner_BH patient = new MBPartner_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		patient.setAD_Org_ID(0);
		patient.setName(valueObject.getStepMessage());
		patient.setDescription(valueObject.getStepMessageLong());
		patient.setIsCustomer(true);
		patient.setBH_IsPatient(true); // the BP model event currently uses this
		patient.saveEx();
		commitEx();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-01"));
		Timestamp birthday = new Timestamp(cal.getTimeInMillis());

		valueObject.setStepName("Update Patient User's Details");
		MUser_BH user = new Query(valueObject.getContext(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_C_BPartner_ID + "=?",
				valueObject.getTransactionName()).setParameters(patient.getC_BPartner_ID()).first();
		user.setBirthday(birthday);
		user.setEMail("test@businesspartner.com");
		user.setPhone("123456");
		user.setName("Test User (User Model)");
		user.saveEx();
		commitEx();

		valueObject.setStepName("Reload the patient's details");
		boolean reload = patient.load(valueObject.getTransactionName());

		assertTrue(reload, "Should reload Business Partner");
		assertNotNull(user, "User should not be null");
		assertEquals(user.getBirthday(), patient.getBH_Birthday(), "Business Partner should have a birthday");
		assertEquals(user.getEMail(), patient.getBH_EMail(), "Business Partner should have an email");
		assertEquals(user.getPhone(), patient.getBH_Phone(), "Business Partner should have a phone");
	}
}
