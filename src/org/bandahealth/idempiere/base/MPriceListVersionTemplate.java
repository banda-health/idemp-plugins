package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MPriceListVersion;
import org.compiere.model.Query;

public class MPriceListVersionTemplate extends BaseTemplate<MPriceListVersion> {

	private String trxName;
	private Properties ctx;

	public MPriceListVersionTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MPriceListVersion getInstance(int... args) {
		MPriceListVersion priceListVersion = new Query(ctx, MPriceListVersion.Table_Name,
				"name = 'Test Price List Version'", trxName).first();
		if (priceListVersion == null) {
			priceListVersion = new MPriceListVersion(ctx, 0, trxName);
			priceListVersion.setName("Test Price List Version");
			priceListVersion.setM_PriceList_ID(args[0]);
			priceListVersion
					.setM_DiscountSchema_ID(new MDiscountSchemaTemplate(getTrxName(), getCtx()).getInstance().get_ID());
			priceListVersion.saveEx();
		}

		return priceListVersion;
	}

	public void setInstance(int priceListId) {
		getInstance(priceListId);
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
