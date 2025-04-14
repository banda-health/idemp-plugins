package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecognition_RunDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecognitionRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RevenueRecognition_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_RevenueRecognition_RunQuery extends POQuery<MRevenueRecognitionRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecognitionRun.Table_Name;
	}

	public CompletableFuture<MRevenueRecognitionRun> C_RevenueRecognition_Run(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRevenueRecognitionRun> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RevenueRecognition_RunDataLoader.DATALOADER_C_RevenueRecognition_Run_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRevenueRecognitionRun> C_RevenueRecognition_RunGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
