package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_VisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankTransferDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DepositBatchDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSTenderTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentBatchDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentProcessorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MBankTransfer;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashBook;
import org.compiere.model.MConversionType;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MElementValue;
import org.compiere.model.MPaymentBatch;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.MProject;
import org.compiere.model.X_C_POSTenderType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PaymentResolver extends POResolver<MPayment_BH> implements GraphQLResolver<MPayment_BH> {



	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public CompletableFuture<MBHVisit> BH_Visit(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_VisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(entity.getBH_Visit_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 1) {
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
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Bank Transfer.
	 *
	 * @return Bank Transfer
	 */
	public CompletableFuture<MBankTransfer> C_BankTransfer(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankTransfer_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankTransfer> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankTransferDataLoader.DATALOADER_C_BankTransfer_BY_ID);
		return dataLoader.load(entity.getC_BankTransfer_ID());
	}


	/**
	 * Get Partner Bank Account.
	 *
	 * @return Bank Account of the Business Partner
	 */
	public CompletableFuture<MBPBankAccount> C_BP_BankAccount(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_BankAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPBankAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_BankAccountDataLoader.DATALOADER_C_BP_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BP_BankAccount_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
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
	public CompletableFuture<MCampaign> C_Campaign(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 1) {
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
	public CompletableFuture<MCashBook> C_CashBook(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashBook_ID() < 1) {
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
	public CompletableFuture<MCharge_BH> C_Charge(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 1) {
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
	public CompletableFuture<MConversionType> C_ConversionType(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() < 1) {
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
	public CompletableFuture<MCurrency_BH> C_Currency(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Deposit Batch.
	 *
	 * @return Deposit Batch
	 */
	public CompletableFuture<MDepositBatch> C_DepositBatch(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DepositBatch_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDepositBatch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DepositBatchDataLoader.DATALOADER_C_DepositBatch_BY_ID);
		return dataLoader.load(entity.getC_DepositBatch_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
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
	public CompletableFuture<MInvoice_BH> C_Invoice(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 1) {
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
	public CompletableFuture<MOrder_BH> C_Order(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Payment Batch.
	 *
	 * @return Payment batch for EFT
	 */
	public CompletableFuture<MPaymentBatch> C_PaymentBatch(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentBatch_ID() < 1) {
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
	public CompletableFuture<MPaymentProcessor> C_PaymentProcessor(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentProcessor_ID() < 1) {
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
	public CompletableFuture<X_C_POSTenderType> C_POSTenderType(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_POSTenderType_ID() < 1) {
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
	public CompletableFuture<MProject> C_Project(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}

	public static Map<String, String> CREDITCARDTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "0923716b-9efc-42ed-b1f9-ee1c5c7ca7fa"); // Amex
			put("M", "8b5451f8-2fd2-4745-b9de-f4459ac9265c"); // MasterCard
			put("V", "d89e4a0c-a891-462a-961a-155e00acdd8c"); // Visa
			put("C", "144e87eb-ed8e-4046-a804-bd27f0e5602d"); // ATM
			put("D", "4d14ee27-f39f-4899-aaf0-9b2d1c603563"); // Diners
			put("N", "404ed4d2-a97b-4626-b6ed-273f19e599be"); // Discover
			put("P", "32dc3f71-74c1-4868-9c34-4db70edce0c2"); // Purchase Card
		}
	};
	public CompletableFuture<MRefList_BH> CreditCardType(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCreditCardType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CREDITCARDTYPE_UUIDS_BY_VALUE.get(entity.getCreditCardType()));
	}

	public static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da"); // Complete
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169"); // Approve
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354"); // Reject
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9"); // Post
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3"); // Void
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0"); // Close
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6"); // Reverse - Correct
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8"); // Reverse - Accrual
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf"); // Invalidate
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260"); // Re-activate
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591"); // <None>
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76"); // Prepare
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5"); // Unlock
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0"); // Wait Complete
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	public static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec"); // Drafted
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204"); // Completed
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5"); // Approved
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2"); // Not Approved
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570"); // Voided
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77"); // Invalid
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6"); // Reversed
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e"); // Closed
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2"); // Unknown
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc"); // In Progress
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9"); // Waiting Payment
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6"); // Waiting Confirmation
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	public Boolean IsAllocated(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isAllocated();
	}

	public Boolean IsApproved(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsDelayedCapture(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isDelayedCapture();
	}

	public Boolean IsOnline(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isOnline();
	}

	public Boolean IsOverrideCurrencyRate(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isOverrideCurrencyRate();
	}

	public Boolean IsOverUnderPayment(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isOverUnderPayment();
	}

	public Boolean IsPrepayment(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isPrepayment();
	}

	public Boolean IsReceipt(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isReceipt();
	}

	public Boolean IsReconciled(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isReconciled();
	}

	public Boolean IsSelfService(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

	public Boolean IsVoided(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isVoided();
	}

	public Boolean Posted(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isPosted();
	}

	public Boolean Processed(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public static Map<String, String> R_AVSADDR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "3f444693-7387-4215-aa79-9bbfdc6a05ab"); // Match
			put("N", "204e56c0-775e-4ed8-82d3-9b7c71b98419"); // No Match
			put("X", "2779bac6-1d0b-42b4-ac7e-20e6a8c9b294"); // Unavailable
		}
	};
	public CompletableFuture<MRefList_BH> R_AvsAddr(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getR_AvsAddr())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(R_AVSADDR_UUIDS_BY_VALUE.get(entity.getR_AvsAddr()));
	}

	public static Map<String, String> R_AVSZIP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "3f444693-7387-4215-aa79-9bbfdc6a05ab"); // Match
			put("N", "204e56c0-775e-4ed8-82d3-9b7c71b98419"); // No Match
			put("X", "2779bac6-1d0b-42b4-ac7e-20e6a8c9b294"); // Unavailable
		}
	};
	public CompletableFuture<MRefList_BH> R_AvsZip(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getR_AvsZip())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(R_AVSZIP_UUIDS_BY_VALUE.get(entity.getR_AvsZip()));
	}

	public Boolean R_CVV2Match(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isR_CVV2Match();
	}


	/**
	 * Get Referenced Payment.
	 *
	 * @return Referenced Payment
	 */
	public CompletableFuture<MPayment_BH> Ref_Payment(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getRef_Payment_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getRef_Payment_ID());
	}


	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public CompletableFuture<MPayment_BH> Reversal(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReversal_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getReversal_ID());
	}

	public Boolean Scheduled(MPayment_BH entity, DataFetchingEnvironment environment) {
		return entity.isScheduled();
	}

	public static Map<String, String> TENDERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "d3874573-b7bf-4556-9b9c-3644698c959e"); // Credit or Debit Card
			put("K", "900adbf9-5069-4f56-9d97-0313c6372af3"); // Cheque
			put("A", "220f3864-24b8-42ba-9a91-a247f4697530"); // Direct Deposit
			put("D", "487227e8-c88e-45ef-8e6d-c0a480fdd0de"); // Bank Transfer
			put("T", "bd6f5227-483d-4bcf-b1fe-a840a3142327"); // Account
			put("X", "52c6c5a6-83ce-48c4-b874-721f8cd4e66b"); // Cash
			put("M", "7a78334e-3494-4d40-a718-c42cb053eea6"); // Mobile Money
			put("B", "ade64e84-cd1b-43bc-a85c-c17a14963305"); // Bill Waiver
			put("L", "7449ae78-c7d3-463b-921e-62a82a5e1a59"); // M-TIBA
			put("N", "28617687-cb93-494a-8f03-bc453da32658"); // NHIF
			put("F", "e24511d1-9180-491c-9cc6-354b8a08e1ff"); // Donor Fund
			put("i", "5b4b4fcf-85c0-4d7c-851d-ab0db2e84b6d"); // Linda Mama
			put("G", "bb077404-71a4-4348-9afa-2b99ae9e1381"); // CCC
			put("H", "55df64a7-1c7f-43f2-846b-f542c9cafa45"); // MCH
			put("O", "4caa3109-804f-4773-8115-9bdb116f329b"); // Outreach
			put("V", "52fc8585-3c61-45b8-a0dd-db10c1e7d79c"); // Liason insurance
			put("P", "64e8ad21-7c9d-442b-9655-f5223d76140c"); // PesaPal
			put("U", "97e54f17-fbae-40de-8dbd-e8ad7f884732"); // Jubilee insurance
		}
	};
	public CompletableFuture<MRefList_BH> TenderType(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTenderType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TENDERTYPE_UUIDS_BY_VALUE.get(entity.getTenderType()));
	}

	public static Map<String, String> TRXTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "62ede000-ce9c-48fd-b805-24dfa336bef6"); // Sales
			put("D", "65ae32d1-fb46-4b5c-8b6e-ca692bc9071f"); // Delayed Capture
			put("C", "3ec6abf2-3776-4bc6-b0ad-e26a805e8fa4"); // Credit (Payment)
			put("F", "fa969983-3f23-444e-bb5b-91e584657242"); // Voice Authorization
			put("A", "d70a8f1d-2bdc-4aee-b07c-831aae57eb30"); // Authorization
			put("V", "0778d779-1c5a-47eb-b68e-c94771517f0f"); // Void
		}
	};
	public CompletableFuture<MRefList_BH> TrxType(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTrxType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TRXTYPE_UUIDS_BY_VALUE.get(entity.getTrxType()));
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() < 1) {
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
	public CompletableFuture<MElementValue> User2(MPayment_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
