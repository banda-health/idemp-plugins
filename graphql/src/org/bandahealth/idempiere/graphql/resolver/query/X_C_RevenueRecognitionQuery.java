package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecognitionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecognition;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecognitionQuery extends POQuery<MRevenueRecognition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecognition.Table_Name;
	}

	public CompletableFuture<MRevenueRecognition> C_RevenueRecognition(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRevenueRecognition> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RevenueRecognitionDataLoader.DATALOADER_C_RevenueRecognition_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRevenueRecognition> C_RevenueRecognitionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
