package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MCurrency;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;

public class MPriceListTemplate extends BaseTemplate<MPriceList> {

	private String trxName;
	private Properties ctx;

	public MPriceListTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MPriceList getInstance(int... args) {
		// price list
		MPriceList priceList = new Query(ctx, MPriceList.Table_Name, "name = 'Test Price List'", trxName).first();
		if (priceList == null) {
			priceList = new MPriceList(ctx, 0, trxName);
			priceList.setName("Test Price List");
			priceList.setAD_Org_ID(args[0]);
			priceList.setIsDefault(true);

			MCurrency currency = new MCurrencyTemplate(trxName, ctx).getInstance(args[0]);

			priceList.setC_Currency_ID(currency.get_ID());

			priceList.saveEx();

			new MPriceListVersionTemplate(trxName, ctx).setInstance(priceList.get_ID());

			commit();
		}

		return priceList;
	}

	@Override
	protected String getTrxName() {
		return trxName;
	}

	@Override
	protected Properties getCtx() {
		return ctx;
	}
}
