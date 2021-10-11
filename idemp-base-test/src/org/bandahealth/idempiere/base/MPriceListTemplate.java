package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MCurrency;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;

public class MPriceListTemplate extends BaseModelTemplate<MPriceList> {

	private int orgId;
	private int clientId;
	private boolean isSoPriceList;
	private String name;

	public MPriceListTemplate(String transactionName, Properties context, int orgId, int clientId,
			boolean isSoPriceList, String name) {
		super(transactionName, context);

		this.orgId = orgId;
		this.clientId = clientId;
		this.isSoPriceList = isSoPriceList;
		this.name = name;
	}

	@Override
	protected MPriceList createInstance() {
		MPriceList priceList = new MPriceList(getContext(), 0, getTransactionName());
		priceList.setName(name);
		priceList.setAD_Org_ID(orgId);

		if (isSoPriceList) {
			priceList.setIsSOPriceList(isSoPriceList);
		}

		priceList.setIsDefault(true);

		MCurrency currency = new MCurrencyTemplate(getTransactionName(), getContext(), orgId, clientId).getInstance();

		priceList.setC_Currency_ID(currency.get_ID());

		priceList.saveEx();

		new MPriceListVersionTemplate(getTransactionName(), getContext(), priceList.get_ID(), name + " Version")
				.getInstance();

		commit();

		return priceList;
	}

	@Override
	protected void setFields(MPriceList priceList) {
	}

	@Override
	protected MPriceList findInstance() {
		return new Query(getContext(), MPriceList.Table_Name, "name = ?", getTransactionName()).setParameters(name)
				.first();
	}
}
