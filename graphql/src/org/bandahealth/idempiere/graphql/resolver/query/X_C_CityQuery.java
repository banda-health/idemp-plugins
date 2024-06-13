package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CityDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCity;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CityQuery extends POQuery<MCity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCity.Table_Name;
	}

	public CompletableFuture<MCity> C_City(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCity> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CityDataLoader.DATALOADER_C_City_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCity> C_CityGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
