package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_I_Payment;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_PaymentResolver extends POResolver<X_I_Payment> implements GraphQLResolver<X_I_Payment> {



	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}

	static Map<String, String> CREDITCARDTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "0923716b-9efc-42ed-b1f9-ee1c5c7ca7fa");
			put("M", "8b5451f8-2fd2-4745-b9de-f4459ac9265c");
			put("V", "d89e4a0c-a891-462a-961a-155e00acdd8c");
			put("C", "144e87eb-ed8e-4046-a804-bd27f0e5602d");
			put("D", "4d14ee27-f39f-4899-aaf0-9b2d1c603563");
			put("N", "404ed4d2-a97b-4626-b6ed-273f19e599be");
			put("P", "32dc3f71-74c1-4868-9c34-4db70edce0c2");
		}
	};
	public CompletableFuture<MRefList_BH> CreditCardType(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCreditCardType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CREDITCARDTYPE_UUIDS_BY_VALUE.get(entity.getCreditCardType()));
	}

	public Boolean I_IsImported(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsApproved(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsDelayedCapture(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isDelayedCapture();
	}

	public Boolean IsOverUnderPayment(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isOverUnderPayment();
	}

	public Boolean IsReceipt(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isReceipt();
	}

	public Boolean IsSelfService(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

	public Boolean Processed(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_Payment entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> TENDERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "d3874573-b7bf-4556-9b9c-3644698c959e");
			put("K", "900adbf9-5069-4f56-9d97-0313c6372af3");
			put("A", "220f3864-24b8-42ba-9a91-a247f4697530");
			put("D", "487227e8-c88e-45ef-8e6d-c0a480fdd0de");
			put("T", "bd6f5227-483d-4bcf-b1fe-a840a3142327");
			put("X", "52c6c5a6-83ce-48c4-b874-721f8cd4e66b");
			put("M", "7a78334e-3494-4d40-a718-c42cb053eea6");
			put("B", "ade64e84-cd1b-43bc-a85c-c17a14963305");
			put("L", "7449ae78-c7d3-463b-921e-62a82a5e1a59");
			put("N", "28617687-cb93-494a-8f03-bc453da32658");
			put("F", "e24511d1-9180-491c-9cc6-354b8a08e1ff");
			put("i", "5b4b4fcf-85c0-4d7c-851d-ab0db2e84b6d");
			put("G", "bb077404-71a4-4348-9afa-2b99ae9e1381");
			put("H", "55df64a7-1c7f-43f2-846b-f542c9cafa45");
			put("O", "4caa3109-804f-4773-8115-9bdb116f329b");
			put("V", "52fc8585-3c61-45b8-a0dd-db10c1e7d79c");
			put("P", "64e8ad21-7c9d-442b-9655-f5223d76140c");
			put("U", "97e54f17-fbae-40de-8dbd-e8ad7f884732");
		}
	};
	public CompletableFuture<MRefList_BH> TenderType(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTenderType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TENDERTYPE_UUIDS_BY_VALUE.get(entity.getTenderType()));
	}

	static Map<String, String> TRXTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "62ede000-ce9c-48fd-b805-24dfa336bef6");
			put("D", "65ae32d1-fb46-4b5c-8b6e-ca692bc9071f");
			put("C", "3ec6abf2-3776-4bc6-b0ad-e26a805e8fa4");
			put("F", "fa969983-3f23-444e-bb5b-91e584657242");
			put("A", "d70a8f1d-2bdc-4aee-b07c-831aae57eb30");
			put("V", "0778d779-1c5a-47eb-b68e-c94771517f0f");
		}
	};
	public CompletableFuture<MRefList_BH> TrxType(X_I_Payment entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTrxType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TRXTYPE_UUIDS_BY_VALUE.get(entity.getTrxType()));
	}

}
