package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_FundingModeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_FundingMode;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_FundingMode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_FundingModeQuery extends POQuery<X_A_FundingMode> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_FundingMode.Table_Name;
	}

	public CompletableFuture<X_A_FundingMode> A_FundingMode(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_FundingMode> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_FundingModeDataLoader.DATALOADER_A_FundingMode_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_FundingMode> A_FundingModeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
