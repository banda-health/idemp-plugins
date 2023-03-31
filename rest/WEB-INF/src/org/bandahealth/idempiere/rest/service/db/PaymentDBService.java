package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.NHIF;
import org.bandahealth.idempiere.rest.model.NHIFRelationship;
import org.bandahealth.idempiere.rest.model.NHIFType;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.model.PaymentType;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBankAccount;
import org.compiere.model.MCurrency;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Payment DB Functionality
 *
 * @author andrew
 */
@Component
public class PaymentDBService extends DocumentDBService<Payment, MPayment_BH> {

	private final String CURRENCY = "KES";
	@Autowired
	private ReferenceListDBService referenceListDBService;
	@Autowired
	private PatientDBService patientDBService;
	private Map<String, String> dynamicJoins = new HashMap<>() {{
		put(MBPartner_BH.Table_Name, "LEFT JOIN  " + MBPartner_BH.Table_Name + " ON " + MPayment_BH.Table_Name + "." +
				MPayment_BH.COLUMNNAME_C_BPartner_ID + " = " + MBPartner_BH.Table_Name + "." +
				MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_PAYMENTS;
	}

	@Override
	int getDocumentProcessId() {
		return MProcess_BH.PROCESSID_PROCESS_PAYMENT;
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	public BaseListResponse<Payment> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.getAll(MPayment_BH.COLUMNNAME_BH_IsServiceDebt + "=?", parameters, pagingInfo, sortJson, filterJson);
	}

	public BaseListResponse<Payment> search(String searchValue, Paging pagingInfo, String sortColumn,
			String sortOrder) {
		List<Object> parameters = new ArrayList<>();

		StringBuilder whereClause = new StringBuilder()
				.append("LOWER(").append(MBPartner_BH.Table_Name).append(".").append(MBPartner_BH.COLUMNNAME_Name)
				.append(") ").append(LIKE_COMPARATOR).append(" ?");
		parameters.add(constructSearchValue(searchValue));

		StringBuilder joinClause = new StringBuilder()
				.append("JOIN ").append(MBPartner_BH.Table_Name).append(" ON ").append(MBPartner_BH.Table_Name)
				.append(".").append(MBPartner_BH.COLUMNNAME_C_BPartner_ID).append("=").append(MPayment_BH.Table_Name)
				.append(".").append(MPayment_BH.COLUMNNAME_C_BPartner_ID);

		return super.search(whereClause.toString(), parameters, pagingInfo, sortColumn, sortOrder,
				joinClause.toString());
	}

	@Override
	public Payment saveEntity(Payment entity) {
		MPayment_BH mPayment = getEntityByUuidFromDB(entity.getUuid());
		if (mPayment == null) {
			mPayment = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				mPayment.setC_Payment_UU(entity.getUuid());
			}
		}

		if (entity.getOrderId() > 0) {
			mPayment.setBH_C_Order_ID(entity.getOrderId());
		} else {
			mPayment.setBH_IsServiceDebt(true);
		}

		if (entity.getPatient() != null) {
			MBPartner_BH bPartner = patientDBService.getEntityByUuidFromDB(entity.getPatient().getUuid());
			if (bPartner != null) {
				mPayment.setC_BPartner_ID(bPartner.get_ID());
			}
		}

		if (entity.getChargeId() > 0) {
			mPayment.setC_Charge_ID(entity.getChargeId());
		}

		if (entity.getPayAmount() != null && entity.getPayAmount().compareTo(BigDecimal.ZERO) >= 0) {
			mPayment.setPayAmt(entity.getPayAmount());
		}
		if (entity.getPayAmount() != null && entity.getPayAmount().compareTo(BigDecimal.ZERO) >= 0) {
			mPayment.setBH_TenderAmount(entity.getTenderAmount());
		}

		if (entity.getPaymentType() != null) {
			// get tender type by value
			MRefList paymentTypeReference = referenceListDBService.getEntityByUuidFromDB(entity.getPaymentType().getUuid());
			if (paymentTypeReference != null) {
				mPayment.setTenderType(paymentTypeReference.getValue());
			}
		}

		// get currency
		MCurrency currency = getCurrency();
		if (currency != null) {
			mPayment.setC_Currency_ID(currency.get_ID());
		}

		// get bank account
		MBankAccount bankAccount = getBankAccount(mPayment);
		if (bankAccount != null) {
			mPayment.setC_BankAccount_ID(bankAccount.get_ID());
		}

		// check nhif
		if (entity.getNhif() != null) {
			if (entity.getNhif().getType() != null) {
				mPayment.setBH_NHIF_Type(entity.getNhif().getType().getValue());
			}

			if (entity.getNhif().getRelationship() != null) {
				mPayment.setbh_nhif_relationship(entity.getNhif().getRelationship().getValue());
			}

			mPayment.setbh_nhif_member_name(entity.getNhif().getMemberName());
			mPayment.setNHIF_Number(entity.getNhif().getNumber());
			mPayment.setbh_nhif_member_id(entity.getNhif().getMemberId());
			mPayment.setbh_nhif_claim_number(entity.getNhif().getClaimNumber());
		}

		// check description
		if (entity.getDescription() != null) {
			mPayment.setDescription(entity.getDescription());
		}

		if (entity.getTransactionDate() != null) {
			mPayment.setDateTrx(DateUtil.getTimestamp(entity.getTransactionDate()));
			mPayment.setDateAcct(DateUtil.getTimestamp(entity.getTransactionDate()));
		}

		mPayment.setIsActive(entity.getIsActive());

		mPayment.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(mPayment.getC_Payment_UU()));
	}

	@Override
	protected Payment createInstanceWithDefaultFields(MPayment_BH instance) {
		return transformData(Collections.singletonList(instance)).get(0);
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
	protected MBankAccount getBankAccount(MPayment_BH payment) {
		// First, get the default bank account that can be used with this payment
		MBankAccount defaultBankAccount =
				new Query(payment.getCtx(), MBankAccount.Table_Name, null, payment.get_TrxName()).setOnlyActiveRecords(true)
						.setClient_ID().setOrderBy("IsDefault DESC").first();

		MBankAccount bankAccountToUse =
				MBankAccount_BH.getBankAccountMappedToRefListValue(payment.getCtx(), payment.get_TrxName(),
						MPayment_BH.TENDERTYPE_AD_Reference_ID, payment.getTenderType());
		if (bankAccountToUse == null) {
			logger.warning("No bank account mapping found for payment rule '" + payment.getTenderType() +
					"'. Using default bank account.");
			bankAccountToUse = defaultBankAccount;
		}
		return bankAccountToUse;
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

		// Batch calls for charges and charge information
		Set<String> paymentTypeValues = mPayments.stream().map(MPayment_BH::getTenderType).collect(Collectors.toSet());

		Map<String, MRefList> paymentTypeReferenceListByValues =
				referenceListDBService.getTypes(MReference_BH.TENDER_TYPE_AD_REFERENCE_UU, paymentTypeValues).stream()
						.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		payments.forEach(payment -> {
			if (paymentTypeReferenceListByValues.containsKey(payment.getTenderType())) {
				payment.setPaymentType(new PaymentType(paymentTypeReferenceListByValues.get(payment.getTenderType())));
			} else {
				payment.setPaymentType(new PaymentType());
			}
		});

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
		mPaymentLines = mPaymentLines.stream().filter(Predicate.not(MPayment_BH::isComplete)).collect(Collectors.toList());
		for (MPayment_BH mPayment : mPaymentLines) {
			// If the payment is completed, just make sure the bh_c_order_id isn't set
			if (mPayment.isComplete()) {
				mPayment.setBH_C_Order_ID(0);
				mPayment.saveEx();
			} else {
				mPayment.deleteEx(false);
			}
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

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment saveAndProcessEntity(Payment entity, String docAction) throws Exception {
		// Payments that have already been processed can't be saved again
		MPayment_BH payment = getEntityByUuidFromDB(entity.getUuid());
		if (payment != null && payment.isComplete()) {
			return processEntity(entity.getUuid(), docAction);
		}
		return super.saveAndProcessEntity(entity, docAction);
	}

	@Override
	public List<Payment> transformData(List<MPayment_BH> dbModels) {
		Set<Integer> businessPartnerIds = dbModels.stream().map(MPayment_BH::getC_BPartner_ID).collect(Collectors.toSet());
		Map<Integer, MBPartner_BH> businessPartnersById =
				businessPartnerIds.isEmpty() ? new HashMap<>() : patientDBService.getByIds(businessPartnerIds);
		Set<String> tenderTypeValues = dbModels.stream().map(MPayment_BH::getTenderType).collect(Collectors.toSet());
		Map<String, MRefList> tenderTypesByValue = tenderTypeValues.isEmpty() ? new HashMap<>() :
				referenceListDBService.getTypes(MReference_BH.TENDER_TYPE_AD_REFERENCE_UU, tenderTypeValues).stream()
						.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));

		return dbModels.stream().map(payment -> {
			Payment newPayment = new Payment(payment);
			newPayment.setNhif(
					new NHIF(new NHIFType(payment.getBH_NHIF_Type()), new NHIFRelationship(payment.getbh_nhif_relationship()),
							payment.getbh_nhif_claim_number(), payment.getbh_nhif_member_id(), payment.getNHIF_Number(),
							payment.getbh_nhif_member_name()));

			if (businessPartnersById.containsKey(payment.getC_BPartner_ID())) {
				MBPartner_BH businessPartner = businessPartnersById.get(payment.getC_BPartner_ID());
				newPayment.setPatient(new Patient(businessPartner.getC_BPartner_UU(), businessPartner.getName(),
						businessPartner.getTotalOpenBalance()));
			}
			if (tenderTypesByValue.containsKey(payment.getTenderType())) {
				newPayment.setPaymentType(new PaymentType(tenderTypesByValue.get(payment.getTenderType())));
			}
			return newPayment;
		}).collect(Collectors.toList());
	}
}
