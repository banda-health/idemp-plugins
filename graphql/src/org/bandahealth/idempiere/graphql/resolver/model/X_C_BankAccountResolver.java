package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBank;
import org.compiere.model.MCurrency;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccountResolver extends POResolver<MBankAccount_BH> implements GraphQLResolver<MBankAccount_BH> {


	static Map<String, String> BANKACCOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBankAccount_BH.BANKACCOUNTTYPE_Checking, "c6fb4b16-162e-4ab0-a613-2a6fb63dbae4");
			put(MBankAccount_BH.BANKACCOUNTTYPE_Savings, "de51279d-e4d6-4450-8048-093e48e5dd0a");
			put(MBankAccount_BH.BANKACCOUNTTYPE_Cash, "efdadde5-1f09-4e32-9fff-ab94a7caf845");
			put(MBankAccount_BH.BANKACCOUNTTYPE_Card, "0246f122-2d14-4aee-ba91-c72b43d6e85e");
			put(MBankAccount_BH.BANKACCOUNTTYPE_Mobile, "be1ae458-a3aa-4d16-995a-8d23d34b5c08");
		}
	};
	public CompletableFuture<MRefList> BankAccountType_RL(MBankAccount_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBankAccountType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BANKACCOUNTTYPE_UUIDS_BY_VALUE.get(entity.getBankAccountType()));
	}


	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	public CompletableFuture<MBank> C_Bank(MBankAccount_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Bank_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBank> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankDataLoader.C_Bank_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Bank_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MBankAccount_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}

}
