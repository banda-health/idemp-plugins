package org.bandahealth.idempiere.base;

import java.math.BigDecimal;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.Query;

public class MPaymentTemplate extends BaseModelTemplate<MPayment_BH> {

	private MOrder_BH order;
	private BigDecimal amount;

	public MPaymentTemplate(String transactionName, Properties context, MOrder_BH order, BigDecimal amount) {
		super(transactionName, context);

		this.order = order;
		this.amount = amount;
	}

	@Override
	protected MPayment_BH createInstance() {
		MPayment_BH instance = new MPayment_BH(getContext(), 0, getTransactionName());

		instance.setAD_Org_ID(order.getAD_Org_ID());
		instance.setBH_C_Order_ID(order.get_ID());
		instance.setC_BPartner_ID(order.getC_BPartner_ID());
		instance.setTenderType("X");
		instance.setPayAmt(amount);
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

	@Override
	protected void setFields(MPayment_BH instance) {
		
	}
}
