package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_TestDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTest;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for Test - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_TestQuery extends POQuery<MTest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTest.Table_Name;
	}

	public CompletableFuture<MTest> Test(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTest> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_TestDataLoader.DATALOADER_Test_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTest> TestGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
