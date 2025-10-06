package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOS;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_POSQuery extends POQuery<MPOS> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOS.Table_Name;
	}

	public CompletableFuture<MPOS> C_POS(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPOS> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_POSDataLoader.DATALOADER_C_POS_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPOS> C_POSGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
