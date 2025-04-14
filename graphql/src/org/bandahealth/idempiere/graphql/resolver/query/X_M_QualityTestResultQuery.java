package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_QualityTestResultDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MQualityTestResult;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_QualityTestResultQuery extends POQuery<MQualityTestResult> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MQualityTestResult.Table_Name;
	}

	public CompletableFuture<MQualityTestResult> M_QualityTestResult(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MQualityTestResult> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_QualityTestResultDataLoader.DATALOADER_M_QualityTestResult_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MQualityTestResult> M_QualityTestResultGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
