package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ViewComponentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MViewComponent;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ViewComponent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ViewComponentQuery extends POQuery<MViewComponent> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MViewComponent.Table_Name;
	}

	public CompletableFuture<MViewComponent> AD_ViewComponent(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MViewComponent> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ViewComponentDataLoader.DATALOADER_AD_ViewComponent_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MViewComponent> AD_ViewComponentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
