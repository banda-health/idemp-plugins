package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MDiscountSchema;
import org.compiere.model.Query;

public class MDiscountSchemaTemplate extends BaseModelTemplate<MDiscountSchema> {

	public MDiscountSchemaTemplate(String transactionName, Properties context) {
		super(transactionName, context);
	}

	@Override
	protected MDiscountSchema createInstance() {
		MDiscountSchema instance = new MDiscountSchema(getContext(), 0, getTransactionName());
		instance.setName("Test Discount Schema");
		instance.saveEx();

		commit();

		return instance;
	}

	@Override
	protected MDiscountSchema findInstance() {
		return new Query(getContext(), MDiscountSchema.Table_Name, "name = 'Test Discount Schema'",
				getTransactionName()).first();
	}
}