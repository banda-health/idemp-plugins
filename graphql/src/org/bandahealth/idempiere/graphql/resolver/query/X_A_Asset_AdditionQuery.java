package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_AdditionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetAddition;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_AdditionQuery extends POQuery<MAssetAddition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetAddition.Table_Name;
	}

	public CompletableFuture<MAssetAddition> A_Asset_Addition(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetAddition> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_AdditionDataLoader.DATALOADER_A_Asset_Addition_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetAddition> A_Asset_AdditionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
