package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBankTransfer;
import org.compiere.model.MConversionType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BankTransfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BankTransferResolver extends POResolver<MBankTransfer> implements GraphQLResolver<MBankTransfer> {



	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public CompletableFuture<MConversionType> C_ConversionType(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_ID);
		return dataLoader.load(entity.getC_ConversionType_ID());
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
	public CompletableFuture<MRefList_BH> DocAction(MBankTransfer entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> DocStatus(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}


	/**
	 * Get From Bank Account.
	 *
	 * @return From Bank Account
	 */
	public CompletableFuture<MBankAccount_BH> From_C_BankAccount(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getFrom_C_BankAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getFrom_C_BankAccount_ID());
	}


	/**
	 * Get From Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> From_C_BPartner(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getFrom_C_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getFrom_C_BPartner_ID());
	}


	/**
	 * Get From Charge.
	 *
	 * @return From Charge
	 */
	public CompletableFuture<MCharge_BH> From_C_Charge(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getFrom_C_Charge_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getFrom_C_Charge_ID());
	}


	/**
	 * Get From Bank Currency.
	 *
	 * @return From Bank Currency
	 */
	public CompletableFuture<MCurrency_BH> From_C_Currency(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getFrom_C_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getFrom_C_Currency_ID());
	}

	public static Map<String, String> FROM_TENDERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
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
	public CompletableFuture<MRefList_BH> From_TenderType(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFrom_TenderType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FROM_TENDERTYPE_UUIDS_BY_VALUE.get(entity.getFrom_TenderType()));
	}

	public Boolean IsOverrideCurrencyRate(MBankTransfer entity, DataFetchingEnvironment environment) {
		return entity.isOverrideCurrencyRate();
	}

	public Boolean Processed(MBankTransfer entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MBankTransfer entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get To Bank Account.
	 *
	 * @return To Bank Account
	 */
	public CompletableFuture<MBankAccount_BH> To_C_BankAccount(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getTo_C_BankAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getTo_C_BankAccount_ID());
	}


	/**
	 * Get To Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> To_C_BPartner(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getTo_C_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getTo_C_BPartner_ID());
	}


	/**
	 * Get To Charge.
	 *
	 * @return To Charge
	 */
	public CompletableFuture<MCharge_BH> To_C_Charge(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getTo_C_Charge_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getTo_C_Charge_ID());
	}


	/**
	 * Get To Bank Currency.
	 *
	 * @return To Bank Currency
	 */
	public CompletableFuture<MCurrency_BH> To_C_Currency(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getTo_C_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getTo_C_Currency_ID());
	}

	public static Map<String, String> TO_TENDERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
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
	public CompletableFuture<MRefList_BH> To_TenderType(MBankTransfer entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTo_TenderType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TO_TENDERTYPE_UUIDS_BY_VALUE.get(entity.getTo_TenderType()));
	}

}
