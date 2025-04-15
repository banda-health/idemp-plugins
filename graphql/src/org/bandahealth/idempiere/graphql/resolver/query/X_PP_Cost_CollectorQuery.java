package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Cost_CollectorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Cost_Collector;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Cost_CollectorQuery extends POQuery<X_PP_Cost_Collector> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_Collector.Table_Name;
	}

	public CompletableFuture<X_PP_Cost_Collector> PP_Cost_Collector(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_Cost_Collector> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Cost_CollectorDataLoader.DATALOADER_PP_Cost_Collector_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_Cost_Collector> PP_Cost_CollectorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
