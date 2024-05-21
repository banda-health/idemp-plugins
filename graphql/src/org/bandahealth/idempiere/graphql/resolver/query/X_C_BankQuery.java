package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBank;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Bank - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankQuery extends POQuery<MBank> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBank.Table_Name;
	}

	public CompletableFuture<MBank> C_Bank(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBank> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankDataLoader.DATALOADER_C_Bank_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBank> C_BankGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
