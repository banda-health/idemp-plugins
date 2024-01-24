package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSTenderTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentBatchDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentProcessorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTransactionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashBook;
import org.compiere.model.MConversionType;
import org.compiere.model.MElementValue;
import org.compiere.model.MPaymentBatch;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.MPaymentTransaction;
import org.compiere.model.MProject;
import org.compiere.model.X_C_POSTenderType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentTransactionResolver extends POResolver<MPaymentTransaction> implements GraphQLResolver<MPaymentTransaction> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Partner Bank Account.
	 *
	 * @return Bank Account of the Business Partner
	 */
	public CompletableFuture<MBPBankAccount> C_BP_BankAccount(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPBankAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_BankAccountDataLoader.DATALOADER_C_BP_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BP_BankAccount_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	public CompletableFuture<MCashBook> C_CashBook(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.DATALOADER_C_CashBook_BY_ID);
		return dataLoader.load(entity.getC_CashBook_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public CompletableFuture<MConversionType> C_ConversionType(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_ID);
		return dataLoader.load(entity.getC_ConversionType_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get Payment Batch.
	 *
	 * @return Payment batch for EFT
	 */
	public CompletableFuture<MPaymentBatch> C_PaymentBatch(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentBatch_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentBatch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentBatchDataLoader.DATALOADER_C_PaymentBatch_BY_ID);
		return dataLoader.load(entity.getC_PaymentBatch_ID());
	}


	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	public CompletableFuture<MPaymentProcessor> C_PaymentProcessor(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentProcessorDataLoader.DATALOADER_C_PaymentProcessor_BY_ID);
		return dataLoader.load(entity.getC_PaymentProcessor_ID());
	}


	/**
	 * Get POS Tender Type.
	 *
	 * @return POS Tender Type
	 */
	public CompletableFuture<X_C_POSTenderType> C_POSTenderType(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_POSTenderType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_POSTenderType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSTenderTypeDataLoader.DATALOADER_C_POSTenderType_BY_ID);
		return dataLoader.load(entity.getC_POSTenderType_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
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
	public CompletableFuture<MRefList_BH> CreditCardType(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCreditCardType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(CREDITCARDTYPE_UUIDS_BY_VALUE.get(entity.getCreditCardType()));
	}

	public Boolean IsApproved(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsDelayedCapture(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isDelayedCapture();
	}

	public Boolean IsOnline(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isOnline();
	}

	public Boolean IsReceipt(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isReceipt();
	}

	public Boolean IsSelfService(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

	public Boolean IsVoided(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isVoided();
	}

	public Boolean Processed(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	static Map<String, String> R_AVSADDR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "3f444693-7387-4215-aa79-9bbfdc6a05ab");
			put("N", "204e56c0-775e-4ed8-82d3-9b7c71b98419");
			put("X", "2779bac6-1d0b-42b4-ac7e-20e6a8c9b294");
		}
	};
	public CompletableFuture<MRefList_BH> R_AvsAddr(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getR_AvsAddr())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(R_AVSADDR_UUIDS_BY_VALUE.get(entity.getR_AvsAddr()));
	}

	static Map<String, String> R_AVSZIP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "3f444693-7387-4215-aa79-9bbfdc6a05ab");
			put("N", "204e56c0-775e-4ed8-82d3-9b7c71b98419");
			put("X", "2779bac6-1d0b-42b4-ac7e-20e6a8c9b294");
		}
	};
	public CompletableFuture<MRefList_BH> R_AvsZip(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getR_AvsZip())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(R_AVSZIP_UUIDS_BY_VALUE.get(entity.getR_AvsZip()));
	}

	public Boolean R_CVV2Match(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		return entity.isR_CVV2Match();
	}


	/**
	 * Get Referenced Payment Transaction.
	 *
	 * @return Referenced Payment Transaction
	 */
	public CompletableFuture<MPaymentTransaction> Ref_PaymentTransaction(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getRef_PaymentTransaction_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTransaction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTransactionDataLoader.DATALOADER_C_PaymentTransaction_BY_ID);
		return dataLoader.load(entity.getRef_PaymentTransaction_ID());
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
	public CompletableFuture<MRefList_BH> TenderType(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTenderType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
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
	public CompletableFuture<MRefList_BH> TrxType(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTrxType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(TRXTYPE_UUIDS_BY_VALUE.get(entity.getTrxType()));
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(MPaymentTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
