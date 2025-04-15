package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_DepreciationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_DepreciationQuery extends POQuery<MDepreciation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciation.Table_Name;
	}

	public CompletableFuture<MDepreciation> A_Depreciation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepreciation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_DepreciationDataLoader.DATALOADER_A_Depreciation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepreciation> A_DepreciationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
