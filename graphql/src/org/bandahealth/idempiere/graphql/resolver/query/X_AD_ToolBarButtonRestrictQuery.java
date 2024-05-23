package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ToolBarButtonRestrictDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MToolBarButtonRestrict;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ToolBarButtonRestrict - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ToolBarButtonRestrictQuery extends POQuery<MToolBarButtonRestrict> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MToolBarButtonRestrict.Table_Name;
	}

	public CompletableFuture<MToolBarButtonRestrict> AD_ToolBarButtonRestrict(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MToolBarButtonRestrict> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ToolBarButtonRestrictDataLoader.DATALOADER_AD_ToolBarButtonRestrict_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MToolBarButtonRestrict> AD_ToolBarButtonRestrictGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
