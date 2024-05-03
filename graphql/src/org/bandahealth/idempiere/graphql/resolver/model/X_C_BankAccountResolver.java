package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBank;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountResolver extends POResolver<MBankAccount_BH> implements GraphQLResolver<MBankAccount_BH> {


	static Map<String, String> BANKACCOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "c6fb4b16-162e-4ab0-a613-2a6fb63dbae4");
			put("S", "de51279d-e4d6-4450-8048-093e48e5dd0a");
			put("B", "efdadde5-1f09-4e32-9fff-ab94a7caf845");
			put("D", "0246f122-2d14-4aee-ba91-c72b43d6e85e");
			put("M", "be1ae458-a3aa-4d16-995a-8d23d34b5c08");
		}
	};
	public CompletableFuture<MRefList_BH> BankAccountType(MBankAccount_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBankAccountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankDataLoader.DATALOADER_C_Bank_BY_ID);
		return dataLoader.load(entity.getC_Bank_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MBankAccount_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}

	public Boolean IsDefault(MBankAccount_BH entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

}
