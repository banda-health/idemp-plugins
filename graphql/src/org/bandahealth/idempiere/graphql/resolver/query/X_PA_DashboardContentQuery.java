package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardContentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDashboardContent;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContentQuery extends POQuery<MDashboardContent> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDashboardContent.Table_Name;
	}

	public CompletableFuture<MDashboardContent> PA_DashboardContent(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDashboardContent> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_DashboardContentDataLoader.DATALOADER_PA_DashboardContent_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDashboardContent> PA_DashboardContentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
