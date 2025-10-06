package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DepositBatchDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepositBatch;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_DepositBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DepositBatchQuery extends POQuery<MDepositBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepositBatch.Table_Name;
	}

	public CompletableFuture<MDepositBatch> C_DepositBatch(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepositBatch> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DepositBatchDataLoader.DATALOADER_C_DepositBatch_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepositBatch> C_DepositBatchGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
