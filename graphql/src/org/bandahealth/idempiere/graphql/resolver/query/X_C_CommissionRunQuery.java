package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CommissionRunDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommissionRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CommissionRunQuery extends POQuery<MCommissionRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommissionRun.Table_Name;
	}

	public CompletableFuture<MCommissionRun> C_CommissionRun(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCommissionRun> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CommissionRunDataLoader.DATALOADER_C_CommissionRun_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCommissionRun> C_CommissionRunGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
