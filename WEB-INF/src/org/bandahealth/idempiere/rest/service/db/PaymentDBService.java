package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBankAccount;
import org.compiere.model.MCurrency;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Payment DB Functionality
 * 
 * @author andrew
 *
 */
public class PaymentDBService extends BaseDBService<Payment, MPayment_BH> {

	private int orderId;
	private int businessPartnerId;
	private final String CURRENCY = "KES";

	public PaymentDBService(int orderId, int businessPartnerId) {
		this.orderId = orderId;
		this.businessPartnerId = businessPartnerId;
	}

	@Override
	public Payment saveEntity(Payment entity) {
		MPayment_BH mPayment = getEntityFromDB(entity.getUuid());
		if (mPayment == null) {
			mPayment = getModelInstance();
		}

		if (orderId > 0) {
			mPayment.setBH_C_Order_ID(orderId);
		}

		mPayment.setC_BPartner_ID(businessPartnerId);

		if (entity.getChargeId() > 0) {
			mPayment.setC_Charge_ID(entity.getChargeId());
		}

		if (entity.getPayAmount().compareTo(BigDecimal.ZERO) > 0) {
			mPayment.setPayAmt(entity.getPayAmount());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getTenderType())) {
			mPayment.setTenderType(entity.getTenderType());
		}

		// get currency
		MCurrency currency = getCurrency();
		if (currency != null) {
			mPayment.setC_Currency_ID(currency.get_ID());
		}

		// get bank account
		MBankAccount bankAccount = getBankAccount();
		if (bankAccount != null) {
			mPayment.setC_BankAccount_ID(bankAccount.get_ID());
		}

		mPayment.setIsActive(entity.isIsActive());
		mPayment.saveEx();

		return createInstanceWithAllFields(getEntityFromDB(mPayment.getC_Payment_UU()));
	}

	@Override
	protected Payment createInstanceWithDefaultFields(MPayment_BH instance) {
		try {
			return new Payment(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Payment_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					instance.getC_BPartner_ID(), instance.getBH_C_Order_ID(), instance.getPayAmt(),
					instance.getTenderType());
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@Override
	protected Payment createInstanceWithAllFields(MPayment_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MPayment_BH getModelInstance() {
		return new MPayment_BH(Env.getCtx(), 0, null);
	}

	/**
	 * Get client's currency in the db
	 * 
	 * @return
	 */
	private MCurrency getCurrency() {
		// first check the currency from the client's accounting schema.
		int currencyId = 0;
		MAcctSchema[] schema = MAcctSchema.getClientAcctSchema(Env.getCtx(), Env.getAD_Client_ID(Env.getCtx()), null);
		if (schema.length > 0) {
			currencyId = schema[0].getC_Currency_ID();
		}

		if (currencyId > 0) {
			return new MCurrency(Env.getCtx(), currencyId, null);
		}

		return new Query(Env.getCtx(), MCurrency.Table_Name, "iso_code = ?", null).setParameters(CURRENCY)
				.setOnlyActiveRecords(true).setClient_ID().first();
	}

	/**
	 * Get bank account
	 * 
	 * @return
	 */
	protected MBankAccount getBankAccount() {
		MBankAccount bankAccount = new Query(Env.getCtx(), MBankAccount.Table_Name, null, null)
				.setOnlyActiveRecords(true).setClient_ID().setOrderBy("IsDefault DESC").first();
		return bankAccount;
	}

	public List<Payment> getPaymentsByOrderId(int orderId) {
		List<Payment> payments = new ArrayList<>();
		List<MPayment_BH> mPayments = new Query(Env.getCtx(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=?", null).setParameters(orderId).setOnlyActiveRecords(true)
						.setClient_ID().list();
		for (MPayment_BH mPayment : mPayments) {
			payments.add(createInstanceWithDefaultFields(mPayment));
		}

		return payments;
	}
}
