package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryGroupCountryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCountryGroupCountry;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CountryGroupCountryQuery extends POQuery<MCountryGroupCountry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCountryGroupCountry.Table_Name;
	}

	public CompletableFuture<MCountryGroupCountry> C_CountryGroupCountry(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCountryGroupCountry> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CountryGroupCountryDataLoader.DATALOADER_C_CountryGroupCountry_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCountryGroupCountry> C_CountryGroupCountryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
