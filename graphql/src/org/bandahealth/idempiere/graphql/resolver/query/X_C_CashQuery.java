package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCash;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Cash - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CashQuery extends POQuery<MCash> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCash.Table_Name;
	}

	public CompletableFuture<MCash> C_Cash(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCash> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CashDataLoader.DATALOADER_C_Cash_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCash> C_CashGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
