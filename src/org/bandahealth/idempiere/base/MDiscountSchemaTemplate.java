package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MDiscountSchema;
import org.compiere.model.Query;

public class MDiscountSchemaTemplate extends BaseTemplate<MDiscountSchema> {

	private String trxName;
	private Properties ctx;

	public MDiscountSchemaTemplate(String trxName, Properties ctx) {
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MDiscountSchema getInstance(int... args) {
		MDiscountSchema instance = new Query(getCtx(), MDiscountSchema.Table_Name, "name = 'Test Discount Schema'",
				getTrxName()).first();
		if (instance == null) {
			instance = new MDiscountSchema(getCtx(), 0, getTrxName());
			instance.setName("Test Discount Schema");
			instance.saveEx();
		}

		return instance;
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
