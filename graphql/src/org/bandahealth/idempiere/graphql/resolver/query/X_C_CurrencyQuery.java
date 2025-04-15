package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CurrencyQuery extends POQuery<MCurrency_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCurrency_BH.Table_Name;
	}

	public CompletableFuture<MCurrency_BH> C_Currency(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCurrency_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCurrency_BH> C_CurrencyGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
