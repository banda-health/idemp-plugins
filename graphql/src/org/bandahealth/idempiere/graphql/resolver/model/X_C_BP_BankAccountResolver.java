package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentProcessorDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MBank;
import org.compiere.model.MPaymentProcessor;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_BankAccountResolver extends POResolver<MBPBankAccount> implements GraphQLResolver<MBPBankAccount> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}

	static Map<String, String> BANKACCOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "c6fb4b16-162e-4ab0-a613-2a6fb63dbae4");
			put("S", "de51279d-e4d6-4450-8048-093e48e5dd0a");
			put("B", "efdadde5-1f09-4e32-9fff-ab94a7caf845");
			put("D", "0246f122-2d14-4aee-ba91-c72b43d6e85e");
			put("M", "be1ae458-a3aa-4d16-995a-8d23d34b5c08");
		}
	};
	public CompletableFuture<MRefList_BH> BankAccountType(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBankAccountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BANKACCOUNTTYPE_UUIDS_BY_VALUE.get(entity.getBankAccountType()));
	}

	static Map<String, String> BPBANKACCTUSE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "82b4faf7-4dc5-4ca4-8d38-093aba177001");
			put("B", "dab23e60-29d6-46ea-a2c9-7fb366331716");
			put("D", "d6f3f6a6-c393-4443-a14f-b99bd5b9a7a5");
			put("T", "c028ea3e-3ea1-48a4-a2cf-506ffd32706c");
		}
	};
	public CompletableFuture<MRefList_BH> BPBankAcctUse(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBPBankAcctUse())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BPBANKACCTUSE_UUIDS_BY_VALUE.get(entity.getBPBankAcctUse()));
	}


	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	public CompletableFuture<MBank> C_Bank(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (entity.getC_Bank_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBank> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankDataLoader.C_Bank_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Bank_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	public CompletableFuture<MPaymentProcessor> C_PaymentProcessor(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentProcessorDataLoader.C_PaymentProcessor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_PaymentProcessor_ID());
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
	public CompletableFuture<MRefList_BH> CreditCardType(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCreditCardType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CREDITCARDTYPE_UUIDS_BY_VALUE.get(entity.getCreditCardType()));
	}

	public Boolean IsACH(MBPBankAccount entity, DataFetchingEnvironment environment) {
		return entity.isACH();
	}

	static Map<String, String> R_AVSADDR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "3f444693-7387-4215-aa79-9bbfdc6a05ab");
			put("N", "204e56c0-775e-4ed8-82d3-9b7c71b98419");
			put("X", "2779bac6-1d0b-42b4-ac7e-20e6a8c9b294");
		}
	};
	public CompletableFuture<MRefList_BH> R_AvsAddr(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getR_AvsAddr())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(R_AVSADDR_UUIDS_BY_VALUE.get(entity.getR_AvsAddr()));
	}

	static Map<String, String> R_AVSZIP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "3f444693-7387-4215-aa79-9bbfdc6a05ab");
			put("N", "204e56c0-775e-4ed8-82d3-9b7c71b98419");
			put("X", "2779bac6-1d0b-42b4-ac7e-20e6a8c9b294");
		}
	};
	public CompletableFuture<MRefList_BH> R_AvsZip(MBPBankAccount entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getR_AvsZip())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(R_AVSZIP_UUIDS_BY_VALUE.get(entity.getR_AvsZip()));
	}

}
