package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MInOut;
import org.compiere.model.Query;

public class MInOutTemplate extends BaseModelTemplate<MInOut> {

	private int orderId;

	public MInOutTemplate(String transactionName, Properties context, int orderId) {
		super(transactionName, context);

		this.orderId = orderId;
	}

	@Override
	protected MInOut createInstance() {
		return null;
	}

	@Override
	protected MInOut findInstance() {
		return new Query(getContext(), MInOut.Table_Name, "c_order_id = " + orderId, getTransactionName()).first();
	}
}