package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.X_BH_Ocl_Originating_Source;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Ocl_Originating_SourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Ocl_Originating_Source - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Ocl_Originating_SourceQuery extends POQuery<X_BH_Ocl_Originating_Source> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_BH_Ocl_Originating_Source.Table_Name;
	}

	public CompletableFuture<X_BH_Ocl_Originating_Source> BH_Ocl_Originating_Source(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_BH_Ocl_Originating_Source> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Ocl_Originating_SourceDataLoader.DATALOADER_BH_Ocl_Originating_Source_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_BH_Ocl_Originating_Source> BH_Ocl_Originating_SourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
