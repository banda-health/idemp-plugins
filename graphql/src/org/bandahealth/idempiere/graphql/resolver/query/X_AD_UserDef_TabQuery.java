package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_TabDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefTab;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_UserDef_TabQuery extends POQuery<MUserDefTab> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefTab.Table_Name;
	}

	public CompletableFuture<MUserDefTab> AD_UserDef_Tab(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserDefTab> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDef_TabDataLoader.DATALOADER_AD_UserDef_Tab_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserDefTab> AD_UserDef_TabGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
