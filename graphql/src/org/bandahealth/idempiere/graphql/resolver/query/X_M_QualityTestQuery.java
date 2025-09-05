package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_QualityTestDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MQualityTest;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_QualityTestQuery extends POQuery<MQualityTest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MQualityTest.Table_Name;
	}

	public CompletableFuture<MQualityTest> M_QualityTest(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MQualityTest> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_QualityTestDataLoader.DATALOADER_M_QualityTest_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MQualityTest> M_QualityTestGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
