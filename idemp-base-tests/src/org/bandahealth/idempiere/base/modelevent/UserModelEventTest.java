package org.bandahealth.idempiere.base.modelevent;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bandahealth.idempiere.base.AdempiereTestCase;
import org.bandahealth.idempiere.base.MBPartnerTemplate;
import org.bandahealth.idempiere.base.MPriceListTemplate;
import org.bandahealth.idempiere.base.MUserTemplate;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MUser;
import org.compiere.util.Env;

public class UserModelEventTest extends AdempiereTestCase {

	public void testUpdateBusinessPartnerWithUserFields() throws Exception {
		MBPartner_BH bpartner = new MBPartnerTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), null, false,
				"Test Business Partner (User Model)", false, 0,
				new MPriceListTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()),
						Env.getAD_Client_ID(getCtx()), true, "Test User Sales Price List").getInstance().get_ID(),
				0, false).getInstance();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-01"));
		Timestamp birthday = new Timestamp(cal.getTimeInMillis());
		String email = "test@businesspartner.com";
		String phone = "123456";
		String name = "Test User (User Model)";

		MUser user = new MUserTemplate(getTrxName(), getCtx(), Env.getAD_Org_ID(getCtx()), bpartner.get_ID(), birthday,
				email, phone, name).getInstance();

		boolean reload = bpartner.load(getTrxName());

		assertEquals("Should reload Business Partner", true, reload);
		assertNotNull("User should not be null", user);
		assertEquals("Business Partner should have a birthday", birthday, bpartner.getBH_Birthday());
		assertEquals("Business Partner should have an email", email, bpartner.getBH_EMail());
		assertEquals("Business Partner should have a phone", phone, bpartner.getBH_Phone());
	}
}
