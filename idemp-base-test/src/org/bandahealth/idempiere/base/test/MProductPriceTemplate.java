package org.bandahealth.idempiere.base.test;

import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.model.MProductPrice;
import org.compiere.model.Query;

public class MProductPriceTemplate extends BaseModelTemplate<MProductPrice> {

	private int productId;
	private BigDecimal price;
	private int priceListVersionId;

	public MProductPriceTemplate(String transactionName, Properties context, int productId, BigDecimal price,
			int priceListVersionId) {
		super(transactionName, context);

		this.productId = productId;
		this.price = price;
		this.priceListVersionId = priceListVersionId;
	}

	@Override
	protected MProductPrice createInstance() {
		MProductPrice instance = new MProductPrice(getContext(), 0, getTransactionName());
		instance.setM_PriceList_Version_ID(priceListVersionId);
		instance.setM_Product_ID(productId);
		instance.setPriceStd(price);
		instance.saveEx();

		commit();

		return instance;
	}

	@Override
	protected MProductPrice findInstance() {
		String whereClause = MProductPrice.COLUMNNAME_M_PriceList_Version_ID + "=? AND "
				+ MProductPrice.COLUMNNAME_M_Product_ID + "=?";
		
		MProductPrice price = new Query(getContext(), MProductPrice.Table_Name, whereClause, getTransactionName())
				.setParameters(priceListVersionId, productId).first();
		return price;
	}

	@Override
	protected void setFields(MProductPrice instance) {

	}
}
