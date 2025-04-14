package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMADataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRMA;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_RMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_RMAQuery extends POQuery<MRMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRMA.Table_Name;
	}

	public CompletableFuture<MRMA> M_RMA(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRMA> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_RMADataLoader.DATALOADER_M_RMA_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRMA> M_RMAGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
