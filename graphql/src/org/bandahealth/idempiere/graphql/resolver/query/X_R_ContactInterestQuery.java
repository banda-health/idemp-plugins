package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_ContactInterestDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MContactInterest;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_ContactInterestQuery extends POQuery<MContactInterest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MContactInterest.Table_Name;
	}

	public CompletableFuture<MContactInterest> R_ContactInterest(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MContactInterest> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_ContactInterestDataLoader.DATALOADER_R_ContactInterest_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MContactInterest> R_ContactInterestGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
