package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCountry;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CountryQuery extends POQuery<MCountry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCountry.Table_Name;
	}

	public CompletableFuture<MCountry> C_Country(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCountry> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CountryDataLoader.DATALOADER_C_Country_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCountry> C_CountryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
