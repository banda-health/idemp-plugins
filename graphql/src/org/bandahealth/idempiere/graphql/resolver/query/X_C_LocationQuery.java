package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLocation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_LocationQuery extends POQuery<MLocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLocation.Table_Name;
	}

	public CompletableFuture<MLocation> C_Location(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLocation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLocation> C_LocationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
