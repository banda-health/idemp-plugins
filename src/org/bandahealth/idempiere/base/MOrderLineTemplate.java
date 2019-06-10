package org.bandahealth.idempiere.base;

import java.math.BigDecimal;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.Query;

public class MOrderLineTemplate extends BaseModelTemplate<MOrderLine_BH> {

	private MOrder_BH order;
	private boolean isSOTrx;

	public MOrderLineTemplate(String transactionName, Properties context, MOrder_BH order, boolean isSOTrx) {
		super(transactionName, context);

		this.order = order;
		this.isSOTrx = isSOTrx;
	}

	@Override
	protected MOrderLine_BH createInstance() {
		int orgId = new MOrgTemplate(getTransactionName(), getContext()).getInstance().get_ID();

		if (order == null) {
			order = new MOrderTemplate(getTransactionName(), getContext(), isSOTrx).getInstance();
		}

		MProduct_BH product = new MProductTemplate(getTransactionName(), getContext(), orgId).getInstance();

		MOrderLine_BH orderLine = new MOrderLine_BH(order);
		orderLine.setM_Product_ID(product.getM_Product_ID());
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
}