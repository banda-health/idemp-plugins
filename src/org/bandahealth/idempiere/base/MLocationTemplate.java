package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MLocation;
import org.compiere.model.Query;

public class MLocationTemplate extends BaseModelTemplate<MLocation> {

	private int orgId;

	public MLocationTemplate(String transactionName, Properties context, int orgId) {
		super(transactionName, context);

		this.orgId = orgId;
	}

	@Override
	protected MLocation createInstance() {
		MLocation location = new MLocation(getContext(), 0, getTransactionName());
		location.setAD_Org_ID(orgId);
		location.setAddress1("Test Address 1");
		location.saveEx();

		commit();

		return location;
	}

	@Override
	protected MLocation findInstance() {
		return new Query(getContext(), MLocation.Table_Name, "address1 = 'Test Address 1'", getTransactionName())
				.first();
	}
}