package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MCurrency;
import org.compiere.model.Query;

public class MCurrencyTemplate extends BaseModelTemplate<MCurrency> {

	private int orgId;

	public MCurrencyTemplate(String transactionName, Properties context, int orgId) {
		super(transactionName, context);

		this.orgId = orgId;
	}

	@Override
	protected MCurrency createInstance() {
		MCurrency currency = new MCurrency(getContext(), 0, getTransactionName());
		currency.setISO_Code("KE");
		currency.setDescription("KE");
		currency.setAD_Org_ID(orgId);
		currency.saveEx();

		commit();

		return currency;
	}

	@Override
	protected MCurrency findInstance() {
		return new Query(getContext(), MCurrency.Table_Name, "iso_code = 'KE'", getTransactionName()).first();
	}
}