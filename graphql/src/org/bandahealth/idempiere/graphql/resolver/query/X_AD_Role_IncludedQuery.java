package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Role_IncludedDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRoleIncluded;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Role_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Role_IncludedQuery extends POQuery<MRoleIncluded> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRoleIncluded.Table_Name;
	}

	public CompletableFuture<MRoleIncluded> AD_Role_Included(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRoleIncluded> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Role_IncludedDataLoader.DATALOADER_AD_Role_Included_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRoleIncluded> AD_Role_IncludedGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
