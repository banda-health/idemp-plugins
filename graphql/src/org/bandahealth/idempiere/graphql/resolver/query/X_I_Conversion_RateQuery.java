package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_Conversion_RateDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_Conversion_Rate;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_Conversion_RateQuery extends POQuery<X_I_Conversion_Rate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Conversion_Rate.Table_Name;
	}

	public CompletableFuture<X_I_Conversion_Rate> I_Conversion_Rate(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_Conversion_Rate> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_Conversion_RateDataLoader.DATALOADER_I_Conversion_Rate_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_Conversion_Rate> I_Conversion_RateGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
