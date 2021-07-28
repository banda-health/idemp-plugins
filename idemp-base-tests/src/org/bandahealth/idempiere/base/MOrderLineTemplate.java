package org.bandahealth.idempiere.base;

import java.math.BigDecimal;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.Query;

public class MOrderLineTemplate extends BaseModelTemplate<MOrderLine_BH> {

	private MOrder_BH order;
	private int productId;

	public MOrderLineTemplate(String transactionName, Properties context, MOrder_BH order, int productId) {
		super(transactionName, context);

		this.order = order;
		this.productId = productId;
	}

	@Override
	protected MOrderLine_BH createInstance() {
		MOrderLine_BH orderLine = new MOrderLine_BH(order);

		orderLine.setM_Product_ID(productId);
		orderLine.setQty(new BigDecimal(1));
		orderLine.saveEx();

		commit();

		return orderLine;
	}

	@Override
	protected MOrderLine_BH findInstance() {
		if (order != null) {
			return new Query(getContext(), MOrderLine_BH.Table_Name, "c_order_id = " + order.get_ID(),
					getTransactionName()).first();
		}

		return null;
	}

	@Override
	protected void setFields(MOrderLine_BH orderLine) {
	}
}