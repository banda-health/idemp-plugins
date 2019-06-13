package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MProductPrice;
import org.compiere.model.Query;

public class MProductPriceTemplate extends BaseModelTemplate<MProductPrice> {

	private int productId;

	public MProductPriceTemplate(String transactionName, Properties context, int productId) {
		super(transactionName, context);

		this.productId = productId;
	}

	@Override
	protected MProductPrice createInstance() {
		return null;
	}

	@Override
	protected MProductPrice findInstance() {
		return new Query(getContext(), MProductPrice.Table_Name,
				MProductPrice.COLUMNNAME_M_Product_ID + "=" + productId, getTransactionName()).first();
	}
}
