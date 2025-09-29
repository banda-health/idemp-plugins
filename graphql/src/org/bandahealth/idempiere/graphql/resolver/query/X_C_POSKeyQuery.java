package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSKeyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOSKey;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_POSKeyQuery extends POQuery<MPOSKey> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOSKey.Table_Name;
	}

	public CompletableFuture<MPOSKey> C_POSKey(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPOSKey> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_POSKeyDataLoader.DATALOADER_C_POSKey_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPOSKey> C_POSKeyGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
