package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBankAccount;
import org.compiere.model.MCurrency;
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Payment DB Functionality
 * 
 * @author andrew
 *
 */
public class PaymentDBService extends BaseDBService<Payment, MPayment_BH> {

	private final String CURRENCY = "KES";
	private final String TENDER_TYPE = "C_Payment Tender Type";

	public PaymentDBService() {
	}

	public BaseListResponse<Payment> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		return super.getAll(null, null, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	public Payment saveEntity(Payment entity) {
		MPayment_BH mPayment = getEntityFromDB(entity.getUuid());
		if (mPayment == null) {
			mPayment = getModelInstance();
		}

		if (entity.getOrderId() > 0) {
			mPayment.setBH_C_Order_ID(entity.getOrderId());
		}

		mPayment.setC_BPartner_ID(entity.getBusinessPartnerId());

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
					instance.getTenderType(), getTenderTypeName(instance.getTenderType()));
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
	protected Payment createInstanceWithSearchFields(MPayment_BH instance) {
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

		return new Query(Env.getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_ISO_Code + " = ?", null)
				.setParameters(CURRENCY).setOnlyActiveRecords(true).setClient_ID().first();
	}

	/**
	 * Get bank account
	 * 
	 * @return
	 */
	protected MBankAccount getBankAccount() {
		MBankAccount bankAccount = new Query(Env.getCtx(), MBankAccount.Table_Name, null, null)
				.setOnlyActiveRecords(true).setClient_ID().setOrderBy(MBankAccount.COLUMNNAME_IsDefault + " DESC")
				.first();
		return bankAccount;
	}

	/**
	 * Get payments associated with an order
	 * 
	 * @param orderId
	 * @return
	 */
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

	/**
	 * Retrieve tender type name
	 * 
	 * @param value
	 * @return
	 */
	private String getTenderTypeName(String value) {
		/**
		 * SELECT l.name FROM ad_ref_list l JOIN ad_reference r ON l.ad_reference_id =
		 * r.ad_reference_id WHERE l.value = ? AND r.name = 'C_Payment Tender Type'
		 */
		MRefList refList = new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.Table_Name + "." + MRefList.COLUMNNAME_Value + "=? AND " + MReference.Table_Name + "."
						+ MReference.COLUMNNAME_Name + "=?",
				null).addJoinClause(
						"JOIN " + MReference.Table_Name + " ON " + MReference.Table_Name + "."
								+ MReference.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "."
								+ MRefList.COLUMNNAME_AD_Reference_ID)
						.setParameters(value, TENDER_TYPE).setOnlyActiveRecords(true).first();
		if (refList != null) {
			return refList.getName();
		}

		return null;
	}

}
