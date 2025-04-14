package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccount_ProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankAccountProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankAccount_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BankAccount_ProcessorQuery extends POQuery<MBankAccountProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankAccountProcessor.Table_Name;
	}

	public CompletableFuture<MBankAccountProcessor> C_BankAccount_Processor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBankAccountProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankAccount_ProcessorDataLoader.DATALOADER_C_BankAccount_Processor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBankAccountProcessor> C_BankAccount_ProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
