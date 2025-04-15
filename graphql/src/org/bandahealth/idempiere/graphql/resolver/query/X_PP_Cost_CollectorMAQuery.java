package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Cost_CollectorMADataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Cost_CollectorMA;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Cost_CollectorMAQuery extends POQuery<X_PP_Cost_CollectorMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_CollectorMA.Table_Name;
	}

	public CompletableFuture<X_PP_Cost_CollectorMA> PP_Cost_CollectorMA(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_Cost_CollectorMA> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Cost_CollectorMADataLoader.DATALOADER_PP_Cost_CollectorMA_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_Cost_CollectorMA> PP_Cost_CollectorMAGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
