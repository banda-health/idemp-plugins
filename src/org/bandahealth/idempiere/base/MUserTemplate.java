package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.Query;

public class MUserTemplate extends BaseModelTemplate<MUser_BH> {

	private int orgId;

	public MUserTemplate(String transactionName, Properties context, int orgId) {
		super(transactionName, context);

		this.orgId = orgId;
	}

	@Override
	protected MUser_BH createInstance() {
		MUser_BH salesRep = new MUser_BH(getContext(), 0, getTransactionName());
		salesRep.setName("Test Sales Rep");
		salesRep.setAD_Org_ID(orgId);
		salesRep.saveEx();

		commit();

		return salesRep;
	}

	@Override
	protected MUser_BH findInstance() {
		return new Query(getContext(), MBPartner.Table_Name, "name = 'Test Sales Rep'", getTransactionName()).first();
	}
}