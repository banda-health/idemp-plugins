package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.compiere.model.MPaySelection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaySelection - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaySelectionResolver extends POResolver<MPaySelection> implements GraphQLResolver<MPaySelection> {



	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MPaySelection entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}

	public Boolean IsApproved(MPaySelection entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsOnePaymentPerInvoice(MPaySelection entity, DataFetchingEnvironment environment) {
		return entity.isOnePaymentPerInvoice();
	}

	public Boolean Processed(MPaySelection entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MPaySelection entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
