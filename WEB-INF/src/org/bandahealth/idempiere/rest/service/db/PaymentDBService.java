package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.NHIF;
import org.bandahealth.idempiere.rest.model.NHIFRelationship;
import org.bandahealth.idempiere.rest.model.NHIFType;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.model.PaymentType;
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

	private final String CURRENCY = "KES";

	public PaymentDBService() {
	}

	public BaseListResponse<Payment> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		return super.getAll(null, null, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	public Payment saveEntity(Payment entity) {
		MPayment_BH mPayment = getEntityByUuidFromDB(entity.getUuid());
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

		if (entity.getPayAmount() != null && entity.getPayAmount().compareTo(BigDecimal.ZERO) > 0) {
			mPayment.setPayAmt(entity.getPayAmount());
		}

		if (entity.getPaymentType() != null) {
			mPayment.setTenderType(entity.getPaymentType().getValue());
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

		// check nhif
		if (entity.getNhif() != null) {
			if (entity.getNhif().getType() != null) {
				mPayment.set_ValueOfColumn(MPayment_BH.COLUMNAME_BH_NHIF_TYPE, entity.getNhif().getType().getValue());
			}

			if (entity.getNhif().getRelationship() != null) {
				mPayment.set_ValueOfColumn(MPayment_BH.COLUMNNAME_BH_NHIF_RELATIONSHIP,
						entity.getNhif().getRelationship().getValue());
			}

			mPayment.set_ValueOfColumn(MPayment_BH.COLUMNNAME_BH_NHIF_MEMBER_NAME, entity.getNhif().getMemberName());
			mPayment.set_ValueOfColumn(MPayment_BH.COLUMNNAME_NHIF_NUMBER, entity.getNhif().getNumber());
			mPayment.set_ValueOfColumn(MPayment_BH.COLUMNNAME_BH_NHIF_MEMBER_ID, entity.getNhif().getMemberId());
			mPayment.set_ValueOfColumn(NHIF.COLUMNNAME_BH_CLAIM_NUMBER, entity.getNhif().getClaimNumber());
		}

		// check description
		if (entity.getDescription() != null) {
			mPayment.setDescription(entity.getDescription());
		}

		mPayment.setIsActive(entity.isIsActive());

		mPayment.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(mPayment.getC_Payment_UU()));
	}

	@Override
	protected Payment createInstanceWithDefaultFields(MPayment_BH instance) {
		try {
			String nhifType = instance.get_Value(MPayment_BH.COLUMNAME_BH_NHIF_TYPE) != null
					? (String) instance.get_Value(MPayment_BH.COLUMNAME_BH_NHIF_TYPE)
					: null;
			String relationship = instance.get_Value(MPayment_BH.COLUMNNAME_BH_NHIF_RELATIONSHIP) != null
					? (String) instance.get_Value(MPayment_BH.COLUMNNAME_BH_NHIF_RELATIONSHIP)
					: null;
			String claimNumber = instance.get_Value(NHIF.COLUMNNAME_BH_CLAIM_NUMBER) != null
					? (String) instance.get_Value(NHIF.COLUMNNAME_BH_CLAIM_NUMBER)
					: null;
			String memberId = instance.get_Value(MPayment_BH.COLUMNNAME_BH_NHIF_MEMBER_ID) != null
					? (String) instance.get_Value(MPayment_BH.COLUMNNAME_BH_NHIF_MEMBER_ID)
					: null;
			String number = instance.get_Value(MPayment_BH.COLUMNNAME_NHIF_NUMBER) != null
					? (String) instance.get_Value(MPayment_BH.COLUMNNAME_NHIF_NUMBER)
					: null;
			String memberName = instance.get_Value(MPayment_BH.COLUMNNAME_BH_NHIF_MEMBER_NAME) != null
					? (String) instance.get_Value(MPayment_BH.COLUMNNAME_BH_NHIF_MEMBER_NAME)
					: null;

			return new Payment(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Payment_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
					instance.getC_BPartner_ID(), instance.getBH_C_Order_ID(), instance.getPayAmt(),
					new PaymentType(instance.getTenderType()), instance.getDescription(),
					new NHIF(new NHIFType(nhifType), new NHIFRelationship(relationship), claimNumber, memberId, number,
							memberName));
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
	 * Delete payment lines for a given order and not in given subset
	 * 
	 * @param orderId
	 */
	public void deletePaymentLinesByOrder(int orderId, String lineUuids) {
		String whereClause = MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=?";

		if (StringUtil.isNotNullAndEmpty(lineUuids)) {
			whereClause += " AND " + MPayment_BH.COLUMNNAME_C_Payment_UU + " NOT IN(" + lineUuids + ")";
		}

		List<MPayment_BH> mPaymentLines = new Query(Env.getCtx(), MPayment_BH.Table_Name, whereClause, null)
				.setParameters(orderId).setClient_ID().list();
		for (MPayment_BH mPayment : mPaymentLines) {
			mPayment.deleteEx(false);
		}
	}

	/**
	 * Check if an order has any payments
	 * 
	 * @param orderId
	 * @return
	 */
	public boolean checkPaymentExists(int orderId) {
		return new Query(Env.getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_BH_C_Order_ID + " =?", null)
				.setOnlyActiveRecords(true).setClient_ID().setParameters(orderId).match();
	}
}
