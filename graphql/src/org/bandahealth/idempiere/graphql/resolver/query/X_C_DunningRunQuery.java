package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningRunDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunningRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningRunQuery extends POQuery<MDunningRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunningRun.Table_Name;
	}

	public CompletableFuture<MDunningRun> C_DunningRun(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDunningRun> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DunningRunDataLoader.DATALOADER_C_DunningRun_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDunningRun> C_DunningRunGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
