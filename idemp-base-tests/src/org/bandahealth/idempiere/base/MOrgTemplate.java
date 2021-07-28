package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MOrg;
import org.compiere.model.Query;

public class MOrgTemplate extends BaseModelTemplate<MOrg> {

	public MOrgTemplate(String transactionName, Properties context) {
		super(transactionName, context);
	}

	@Override
	protected MOrg createInstance() {
		MOrg organization = new MOrg(getContext(), 0, getTransactionName());
		organization.setName("Test Organization");
		organization.saveEx();

		commit();

		return organization;
	}

	@Override
	protected MOrg findInstance() {
		return new Query(getContext(), MOrg.Table_Name, "name = 'Test Organization'", getTransactionName()).first();
	}

	@Override
	protected void setFields(MOrg instance) {
	}
}