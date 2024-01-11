package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_PaymentRefDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_PaymentRef_BankAcctResolver extends POResolver<MBHPaymentRefBankAccount> implements GraphQLResolver<MBHPaymentRefBankAccount> {



	/**
	 * Get Reference List.
	 *
	 * @return Reference List based on Table
	 */
	public CompletableFuture<MRefList_BH> AD_Ref_List(MBHPaymentRefBankAccount entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Ref_List_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Ref_List_ID());
	}


	/**
	 * Get BH_PaymentRef.
	 *
	 * @return BH_PaymentRef
	 */
	public CompletableFuture<MBHPaymentRef> BH_PaymentRef(MBHPaymentRefBankAccount entity, DataFetchingEnvironment environment) {
		if (entity.getBH_PaymentRef_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHPaymentRef> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_PaymentRefDataLoader.BH_PaymentRef_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getBH_PaymentRef_ID());
	}

	public Boolean BH_ReferenceList_IsActive(MBHPaymentRefBankAccount entity, DataFetchingEnvironment environment) {
		return entity.isBH_ReferenceList_IsActive();
	}


	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MBHPaymentRefBankAccount entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}

}
