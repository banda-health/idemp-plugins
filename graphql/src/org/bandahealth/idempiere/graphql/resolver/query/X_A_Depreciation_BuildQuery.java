package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_BuildDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationBuild;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_BuildQuery extends POQuery<MDepreciationBuild> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationBuild.Table_Name;
	}

	public CompletableFuture<MDepreciationBuild> A_Depreciation_Build(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepreciationBuild> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_BuildDataLoader.DATALOADER_A_Depreciation_Build_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepreciationBuild> A_Depreciation_BuildGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
