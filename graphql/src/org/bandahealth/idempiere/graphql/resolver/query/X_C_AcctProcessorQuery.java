package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctProcessor;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AcctProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AcctProcessorQuery extends POQuery<MAcctProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctProcessor.Table_Name;
	}

	public CompletableFuture<MAcctProcessor> C_AcctProcessor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAcctProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AcctProcessorDataLoader.DATALOADER_C_AcctProcessor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAcctProcessor> C_AcctProcessorGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
