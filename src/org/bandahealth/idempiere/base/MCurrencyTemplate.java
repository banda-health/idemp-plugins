package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MAcctSchema;
import org.compiere.model.MCurrency;
import org.compiere.model.Query;

public class MCurrencyTemplate extends BaseModelTemplate<MCurrency> {

	private int orgId;
	private int clientId;

	public MCurrencyTemplate(String transactionName, Properties context, int orgId, int clientId) {
		super(transactionName, context);

		this.orgId = orgId;
		this.clientId = clientId;
	}

	@Override
	protected MCurrency createInstance() {
		MCurrency currency = new MCurrency(getContext(), 0, getTransactionName());
		currency.setISO_Code("KES");
		currency.setDescription("KES");
		currency.setAD_Org_ID(orgId);
		currency.saveEx();

		commit();

		return currency;
	}

	@Override
	protected MCurrency findInstance() {
		// first check the currency from the client's accounting schema.
		int currencyId = 0;
		MAcctSchema[] schema = MAcctSchema.getClientAcctSchema(getContext(), clientId, getTransactionName());
		if (schema.length > 0) {
			currencyId = schema[0].getC_Currency_ID();
		}

		if (currencyId > 0) {
			return new MCurrency(getContext(), currencyId, getTransactionName());
		}

		return new Query(getContext(), MCurrency.Table_Name, "iso_code = 'KES'", getTransactionName()).first();
	}

	@Override
	protected void setFields(MCurrency instance) {
	}

}