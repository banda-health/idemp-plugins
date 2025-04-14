package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_GroupDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetGroup;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_GroupQuery extends POQuery<MAssetGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetGroup.Table_Name;
	}

	public CompletableFuture<MAssetGroup> A_Asset_Group(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetGroup> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_GroupDataLoader.DATALOADER_A_Asset_Group_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetGroup> A_Asset_GroupGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
