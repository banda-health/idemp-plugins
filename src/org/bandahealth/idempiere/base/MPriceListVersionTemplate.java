package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MPriceListVersion;
import org.compiere.model.Query;

public class MPriceListVersionTemplate extends BaseModelTemplate<MPriceListVersion> {

	private int priceListId;

	public MPriceListVersionTemplate(String transactionName, Properties context, int priceListId) {
		super(transactionName, context);

		this.priceListId = priceListId;
	}

	@Override
	protected MPriceListVersion createInstance() {
		MPriceListVersion priceListVersion = new MPriceListVersion(getContext(), 0, getTransactionName());
		priceListVersion.setName("Test Price List Version");
		priceListVersion.setM_PriceList_ID(priceListId);
		priceListVersion.setM_DiscountSchema_ID(
				new MDiscountSchemaTemplate(getTransactionName(), getContext()).getInstance().get_ID());
		priceListVersion.saveEx();

		commit();

		return priceListVersion;

	}

	@Override
	protected MPriceListVersion findInstance() {
		return new Query(getContext(), MPriceListVersion.Table_Name, "name = 'Test Price List Version'",
				getTransactionName()).first();
	}
}
