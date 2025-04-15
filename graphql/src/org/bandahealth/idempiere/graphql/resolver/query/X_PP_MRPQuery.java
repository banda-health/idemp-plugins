package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_MRPDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_MRP;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_MRPQuery extends POQuery<X_PP_MRP> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_MRP.Table_Name;
	}

	public CompletableFuture<X_PP_MRP> PP_MRP(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_MRP> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_MRPDataLoader.DATALOADER_PP_MRP_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_MRP> PP_MRPGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
