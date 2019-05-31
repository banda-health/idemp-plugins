package org.bandahealth.idempiere.base;

import java.math.BigDecimal;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;

public class MOrderLineTemplate extends BaseTemplate<MOrderLine_BH> {

	private String trxName;
	private Properties ctx;
	private boolean isSOTrx;
	private MOrder_BH order;

	public MOrderLineTemplate(MOrder_BH order, String trxName, Properties ctx, boolean isSOTrx) {
		this.order = order;
		this.trxName = trxName;
		this.ctx = ctx;
		this.isSOTrx = isSOTrx;
	}

	@Override
	public MOrderLine_BH getInstance(int... args) {
		int orgId = new MOrgTemplate(trxName, ctx).getInstance().get_ID();

		if (order == null) {
			order = new MOrderTemplate(trxName, ctx, isSOTrx).getInstance();
		}

		MProduct_BH product = new MProductTemplate(trxName, ctx).getInstance(orgId);

		MOrderLine_BH orderLine = new MOrderLine_BH(order);
		orderLine.setM_Product_ID(product.getM_Product_ID());
		orderLine.setQty(new BigDecimal(1));

		return orderLine;
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
