package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_BankAccountDoc;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BankAccountDocResolver extends POResolver<X_C_BankAccountDoc> implements GraphQLResolver<X_C_BankAccountDoc> {



	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(X_C_BankAccountDoc entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Check Print Format.
	 *
	 * @return Print Format for printing Checks
	 */
	public CompletableFuture<X_AD_PrintFormat> Check_PrintFormat(X_C_BankAccountDoc entity, DataFetchingEnvironment environment) {
		if (entity.getCheck_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getCheck_PrintFormat_ID());
	}

	static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293");
			put("K", "68dda00d-c015-498e-b91c-811bab809dab");
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64");
			put("b", "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRule(X_C_BankAccountDoc entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

}
