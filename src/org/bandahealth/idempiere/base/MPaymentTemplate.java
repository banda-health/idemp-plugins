package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.Query;

public class MPaymentTemplate extends BaseModelTemplate<MPayment_BH> {

	private MOrder_BH order;

	public MPaymentTemplate(String transactionName, Properties context, MOrder_BH order) {
		super(transactionName, context);

		this.order = order;
	}

	@Override
	protected MPayment_BH createInstance() {
		MPayment_BH instance = new MPayment_BH(getContext(), 0, getTransactionName());
		instance.setAD_Org_ID(order.getAD_Org_ID());
		instance.setBH_C_Order_ID(order.get_ID());
		instance.setC_BPartner_ID(order.getC_BPartner_ID());
		instance.setPayAmt(order.getGrandTotal());
		instance.setC_Currency_ID(
				new MCurrencyTemplate(getTransactionName(), getContext(), order.getAD_Org_ID(), order.getAD_Client_ID())
						.getInstance().get_ID());
		instance.setC_BankAccount_ID(new MBankAccountTemplate(getTransactionName(), getContext(), order.getAD_Org_ID(),
				order.getAD_Client_ID()).getInstance().get_ID());
		instance.saveEx(getTransactionName());
		
		commit();

		return instance;
	}

	@Override
	protected MPayment_BH findInstance() {
		return new Query(getContext(), MPayment_BH.Table_Name, "bh_c_order_id = " + order.get_ID(),
				getTransactionName()).first();
	}
}
