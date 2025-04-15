package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryGroupDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCountryGroup;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CountryGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CountryGroupQuery extends POQuery<MCountryGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCountryGroup.Table_Name;
	}

	public CompletableFuture<MCountryGroup> C_CountryGroup(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCountryGroup> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CountryGroupDataLoader.DATALOADER_C_CountryGroup_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCountryGroup> C_CountryGroupGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
