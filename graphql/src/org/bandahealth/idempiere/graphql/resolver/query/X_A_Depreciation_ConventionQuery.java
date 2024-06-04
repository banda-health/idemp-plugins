package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_ConventionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationConvention;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Convention - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ConventionQuery extends POQuery<MDepreciationConvention> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationConvention.Table_Name;
	}

	public CompletableFuture<MDepreciationConvention> A_Depreciation_Convention(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepreciationConvention> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_ConventionDataLoader.DATALOADER_A_Depreciation_Convention_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepreciationConvention> A_Depreciation_ConventionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
