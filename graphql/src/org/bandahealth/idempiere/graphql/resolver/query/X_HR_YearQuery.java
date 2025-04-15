package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_YearDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Year;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_YearQuery extends POQuery<X_HR_Year> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Year.Table_Name;
	}

	public CompletableFuture<X_HR_Year> HR_Year(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Year> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_YearDataLoader.DATALOADER_HR_Year_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Year> HR_YearGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
