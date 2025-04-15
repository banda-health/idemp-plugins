package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DepositBatchLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepositBatchLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DepositBatchLineQuery extends POQuery<MDepositBatchLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepositBatchLine.Table_Name;
	}

	public CompletableFuture<MDepositBatchLine> C_DepositBatchLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepositBatchLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DepositBatchLineDataLoader.DATALOADER_C_DepositBatchLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepositBatchLine> C_DepositBatchLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
