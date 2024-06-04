package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_QualityTestDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_Product_QualityTest;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_QualityTestQuery extends POQuery<X_M_Product_QualityTest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_QualityTest.Table_Name;
	}

	public CompletableFuture<X_M_Product_QualityTest> M_Product_QualityTest(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_Product_QualityTest> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_QualityTestDataLoader.DATALOADER_M_Product_QualityTest_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_Product_QualityTest> M_Product_QualityTestGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
