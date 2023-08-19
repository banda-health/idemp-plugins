package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.DocumentType;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.model.PaymentType;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
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
	private BusinessPartnerDBService businessPartnerDBService;
	@Autowired
	protected DocumentTypeDBService documentTypeDBService;

	private final Map<String, String> dynamicJoins = new HashMap<>() {{
		put(MBPartner_BH.Table_Name, "LEFT JOIN  " + MBPartner_BH.Table_Name + " ON " + MPayment_BH.Table_Name + "." +
				MPayment_BH.COLUMNNAME_C_BPartner_ID + " = " + MBPartner_BH.Table_Name + "." +
				MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

	@Override
	int getDocumentProcessId() {
		return MProcess_BH.PROCESSID_PROCESS_PAYMENT;
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	public Payment saveEntity(Payment entity) {
		MDocType_BH documentTypeTarget;
		if (entity.getDocumentType() == null ||
				StringUtil.isNullOrEmpty(entity.getDocumentType().getUuid()) || (documentTypeTarget =
				documentTypeDBService.getEntityByUuidFromDB(entity.getDocumentType().getUuid())) == null) {
			throw new AdempiereException("Document Type is required");
		}

		MPayment_BH mPayment = getEntityByUuidFromDB(entity.getUuid());
		if (mPayment == null) {
			mPayment = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				mPayment.setC_Payment_UU(entity.getUuid());
			}
		}

		mPayment.setC_DocType_ID(documentTypeTarget.get_ID());
		mPayment.setIsReceipt(documentTypeTarget.isSOTrx());

		if (entity.getVisitId() > 0) {
			mPayment.setBH_Visit_ID(entity.getVisitId());
		}

		if (entity.getBusinessPartner() != null) {
			MBPartner_BH bPartner = businessPartnerDBService.getEntityByUuidFromDB(entity.getBusinessPartner().getUuid());
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
	 * @param visitId
	 * @return
	 */
	public List<Payment> getPaymentsByVisitId(int visitId) {
		List<Payment> payments = new ArrayList<>();
		List<MPayment_BH> mPayments = new Query(Env.getCtx(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?", null).setParameters(visitId).setOnlyActiveRecords(true)
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
	 * Delete payment lines for a given visit and not in given subset
	 *
	 * @param visitId
	 */
	public void deletePaymentLinesByVisit(int visitId, String lineUuids) {
		String whereClause = MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?";

		if (StringUtil.isNotNullAndEmpty(lineUuids)) {
			whereClause += " AND " + MPayment_BH.COLUMNNAME_C_Payment_UU + " NOT IN(" + lineUuids + ")";
		}

		List<MPayment_BH> mPaymentLines = new Query(Env.getCtx(), MPayment_BH.Table_Name, whereClause, null)
				.setParameters(visitId).setClient_ID().list();
		mPaymentLines = mPaymentLines.stream().filter(Predicate.not(MPayment_BH::isComplete)).collect(Collectors.toList());
		for (MPayment_BH mPayment : mPaymentLines) {
			// If the payment is completed, reverse accrue it
			if (MPayment_BH.DOCSTATUS_Completed.equals(mPayment.getDocStatus())) {
				ModelUtil.processDocumentOrError(getDocumentProcessId(), mPayment, MPayment_BH.ACTION_Reverse_Accrual);
				mPayment.saveEx();
			} else if (!mPayment.isComplete()) {
				mPayment.deleteEx(false);
			}
		}
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
				businessPartnerIds.isEmpty() ? new HashMap<>() : businessPartnerDBService.getByIds(businessPartnerIds);
		Set<String> tenderTypeValues = dbModels.stream().map(MPayment_BH::getTenderType).collect(Collectors.toSet());
		Map<String, MRefList> tenderTypesByValue = tenderTypeValues.isEmpty() ? new HashMap<>() :
				referenceListDBService.getTypes(MReference_BH.TENDER_TYPE_AD_REFERENCE_UU, tenderTypeValues).stream()
						.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));
		Map<Integer, MDocType_BH> documentTypesById = documentTypeDBService.getByIds(
				dbModels.stream().map(MPayment_BH::getC_DocType_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(payment -> {
			Payment newPayment = new Payment(payment);

			if (businessPartnersById.containsKey(payment.getC_BPartner_ID())) {
				MBPartner_BH businessPartner = businessPartnersById.get(payment.getC_BPartner_ID());
				newPayment.setBusinessPartner(new BusinessPartner(businessPartner));
			}
			if (tenderTypesByValue.containsKey(payment.getTenderType())) {
				newPayment.setPaymentType(new PaymentType(tenderTypesByValue.get(payment.getTenderType())));
			}
			if (documentTypesById.containsKey(payment.getC_DocType_ID())) {
				newPayment.setDocumentType(new DocumentType(documentTypesById.get(payment.getC_DocType_ID())));
			}
			return newPayment;
		}).collect(Collectors.toList());
	}

	@Override
	int getDocumentTypeId(MPayment_BH entity) {
		return entity.getC_DocType_ID();
	}
}
