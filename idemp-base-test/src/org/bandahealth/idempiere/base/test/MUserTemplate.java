package org.bandahealth.idempiere.base.test;

import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MUser;
import org.compiere.model.Query;

public class MUserTemplate extends BaseModelTemplate<MUser> {

	private int orgId;
	private int bpartnerId;
	private Timestamp birthday;
	private String email;
	private String phone;
	private String name = "Test User";

	public MUserTemplate(String transactionName, Properties context, int orgId, int bpartnerId, Timestamp birthday,
			String email, String phone, String name) {
		super(transactionName, context);

		this.orgId = orgId;
		this.bpartnerId = bpartnerId;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		if (name != null) {
			this.name = name;
		}
	}

	@Override
	protected MUser createInstance() {
		MUser instance = new MUser(getContext(), 0, getTransactionName());
		instance.setName(name);
		instance.setAD_Org_ID(orgId);
		instance.setBirthday(birthday);
		instance.setEMail(email);
		instance.setPhone(phone);
		if (bpartnerId > 0) {
			instance.setC_BPartner_ID(bpartnerId);
		}

		instance.saveEx();

		commit();

		return instance;
	}

	@Override
	protected MUser findInstance() {
		return new Query(getContext(), MUser.Table_Name, MUser.COLUMNNAME_Name + "='" + name + "'",
				getTransactionName()).first();
	}

	@Override
	protected void setFields(MUser instance) {

	}
}