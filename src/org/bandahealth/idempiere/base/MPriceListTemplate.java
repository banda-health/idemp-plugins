package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MCurrency;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;

public class MPriceListTemplate extends BaseModelTemplate<MPriceList> {

	private int orgId;

	public MPriceListTemplate(String transactionName, Properties context, int orgId) {
		super(transactionName, context);

		this.orgId = orgId;
	}

	@Override
	protected MPriceList createInstance() {
		MPriceList priceList = new MPriceList(getContext(), 0, getTransactionName());
		priceList.setName("Test Price List");
		priceList.setAD_Org_ID(orgId);
		priceList.setIsDefault(true);

		MCurrency currency = new MCurrencyTemplate(getTransactionName(), getContext(), orgId).getInstance();

		priceList.setC_Currency_ID(currency.get_ID());

		priceList.saveEx();

		new MPriceListVersionTemplate(getTransactionName(), getContext(), priceList.get_ID()).getInstance();

		commit();

		return priceList;
	}

	@Override
	protected MPriceList findInstance() {
		return new Query(getContext(), MPriceList.Table_Name, "name = 'Test Price List'", getTransactionName()).first();
	}
}
