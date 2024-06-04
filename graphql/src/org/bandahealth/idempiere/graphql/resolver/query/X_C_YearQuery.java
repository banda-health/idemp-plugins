package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_YearDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MYear;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_YearQuery extends POQuery<MYear> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MYear.Table_Name;
	}

	public CompletableFuture<MYear> C_Year(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MYear> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_YearDataLoader.DATALOADER_C_Year_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MYear> C_YearGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
