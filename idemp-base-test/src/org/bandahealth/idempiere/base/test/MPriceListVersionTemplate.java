package org.bandahealth.idempiere.base.test;

import java.util.Properties;

import org.compiere.model.MPriceListVersion;
import org.compiere.model.Query;

public class MPriceListVersionTemplate extends BaseModelTemplate<MPriceListVersion> {

	private int priceListId;
	private String name;

	public MPriceListVersionTemplate(String transactionName, Properties context, int priceListId, String name) {
		super(transactionName, context);

		this.priceListId = priceListId;
		this.name = name;
	}

	@Override
	protected MPriceListVersion createInstance() {
		MPriceListVersion priceListVersion = new MPriceListVersion(getContext(), 0, getTransactionName());
		priceListVersion.setName(name);
		priceListVersion.setM_PriceList_ID(priceListId);
		priceListVersion.setM_DiscountSchema_ID(
				new MDiscountSchemaTemplate(getTransactionName(), getContext()).getInstance().get_ID());
		priceListVersion.saveEx();

		commit();

		return priceListVersion;

	}

	@Override
	protected MPriceListVersion findInstance() {
		return new Query(getContext(), MPriceListVersion.Table_Name, "name = ?", getTransactionName())
				.setParameters(name).first();
	}

	@Override
	protected void setFields(MPriceListVersion priceListVersion) {
	}
}
