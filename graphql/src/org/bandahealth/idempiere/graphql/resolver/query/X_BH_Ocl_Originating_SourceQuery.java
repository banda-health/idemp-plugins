package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHOclOriginatingSource;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Ocl_Originating_SourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Ocl_Originating_Source - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Ocl_Originating_SourceQuery extends POQuery<MBHOclOriginatingSource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHOclOriginatingSource.Table_Name;
	}

	public CompletableFuture<MBHOclOriginatingSource> BH_Ocl_Originating_Source(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHOclOriginatingSource> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Ocl_Originating_SourceDataLoader.DATALOADER_BH_Ocl_Originating_Source_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHOclOriginatingSource> BH_Ocl_Originating_SourceGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
