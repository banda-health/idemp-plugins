package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MInOut;
import org.compiere.model.Query;

public class MInOutTemplate extends BaseTemplate<MInOut> {

	private String trxName;
	private Properties ctx;
	private MOrder_BH order;

	public MInOutTemplate(MOrder_BH order, String trxName, Properties ctx) {
		this.order = order;
		this.trxName = trxName;
		this.ctx = ctx;
	}

	@Override
	public MInOut getInstance(int... args) {
		MInOut inOut = new Query(getCtx(), MInOut.Table_Name, "c_order_id = " + order.get_ID(), getTrxName()).first();
		return inOut;
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
