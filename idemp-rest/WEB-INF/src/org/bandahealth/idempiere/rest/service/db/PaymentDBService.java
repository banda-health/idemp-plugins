package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
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

/**
 * Payment DB Functionality
 *
 * @author andrew
 */
public class PaymentDBService extends DocumentDBService<Payment, MPayment_BH> {

	private final String CURRENCY = "KES";
	private final ReferenceListDBService referenceListDBService;
	private PatientDBService patientDBService;
	private EntityMetadataDBService entityMetadataDBService;
	private Map<String, String> dynamicJoins = new HashMap<>() {{
		put(MBPartner_BH.Table_Name, "LEFT JOIN  " + MBPartner_BH.Table_Name + " ON " + MPayment_BH.Table_Name + "." +
				MPayment_BH.COLUMNNAME_C_BPartner_ID + " = " + MBPartner_BH.Table_Name + "." +
				MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

	public PaymentDBService() {
		patientDBService = new PatientDBService();
		entityMetadataDBService = new EntityMetadataDBService();
		referenceListDBService = new ReferenceListDBService();
	}

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_PAYMENTS;
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
		}

		mPayment.setIsActive(entity.getIsActive());

		mPayment.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(mPayment.getC_Payment_UU()));
	}

	@Override
	protected Payment createInstanceWithDefaultFields(MPayment_BH instance) {
		try {
			String nhifType = instance.getBH_NHIF_Type();
			String relationship = instance.getbh_nhif_relationship();
			String claimNumber = instance.getbh_nhif_claim_number();
			String memberId = instance.getbh_nhif_member_id();
			String number = instance.getNHIF_Number();
			String memberName = instance.getbh_nhif_member_name();

			Patient patient = null;
			MBPartner_BH mPatient = patientDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (mPatient != null) {
				patient = new Patient(mPatient.getC_BPartner_UU(), mPatient.getName(), mPatient.getTotalOpenBalance());
			}

			return new Payment(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_Payment_UU(),
					instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(), patient,
					instance.getBH_C_Order_ID(), instance.getPayAmt(), new PaymentType(instance.getTenderType()),
					instance.getDescription(),
					new NHIF(new NHIFType(nhifType), new NHIFRelationship(relationship), claimNumber, memberId, number,
							memberName),
					instance.getDocStatus(),
					DateUtil.parseDateOnly(instance.getDateTrx()), instance.getBH_TenderAmount(), instance);
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
}
