package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecog_ServiceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecogService;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecog_ServiceQuery extends POQuery<MRevenueRecogService> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecogService.Table_Name;
	}

	public CompletableFuture<MRevenueRecogService> C_RevenueRecog_Service(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRevenueRecogService> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RevenueRecog_ServiceDataLoader.DATALOADER_C_RevenueRecog_Service_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRevenueRecogService> C_RevenueRecog_ServiceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
