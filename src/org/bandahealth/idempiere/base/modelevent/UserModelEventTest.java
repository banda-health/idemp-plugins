package org.bandahealth.idempiere.base.modelevent;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.MUserTemplate;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MUser;
import org.compiere.util.Env;

import test.AdempiereTestCase;

public class UserModelEventTest extends AdempiereTestCase {

	public void testUpdateBusinessPartnerWithUserFields() throws Exception {
		MBPartner_BH bpartner = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), null, false,
				null, false, 0).getInstance();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-01"));
		Timestamp birthday = new Timestamp(cal.getTimeInMillis());
		String email = "test@businesspartner.com";
		String phone = "123456";

		MUser user = new MUserTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), bpartner.get_ID(),
				birthday, email, phone).getInstance();

		boolean reload = bpartner.load(getTrxName());

		assertEquals("Should reload Business Partner", true, reload);
		assertNotNull("User should not be null", user);
		assertEquals("Business Partner should have a birthday", birthday, bpartner.getBH_Birthday());
		assertEquals("Business Partner should have an email", email, bpartner.getBH_EMail());
		assertEquals("Business Partner should have a phone", phone, bpartner.getBH_Phone());
	}
}
