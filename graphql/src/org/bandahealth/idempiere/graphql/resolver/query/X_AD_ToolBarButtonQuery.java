package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ToolBarButtonDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MToolBarButton;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ToolBarButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ToolBarButtonQuery extends POQuery<MToolBarButton> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MToolBarButton.Table_Name;
	}

	public CompletableFuture<MToolBarButton> AD_ToolBarButton(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MToolBarButton> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ToolBarButtonDataLoader.DATALOADER_AD_ToolBarButton_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MToolBarButton> AD_ToolBarButtonGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
