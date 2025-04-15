package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeCounterDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDocTypeCounter;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DocTypeCounterQuery extends POQuery<MDocTypeCounter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDocTypeCounter.Table_Name;
	}

	public CompletableFuture<MDocTypeCounter> C_DocTypeCounter(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDocTypeCounter> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DocTypeCounterDataLoader.DATALOADER_C_DocTypeCounter_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDocTypeCounter> C_DocTypeCounterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
