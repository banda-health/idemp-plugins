package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSKeyLayoutDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOSKeyLayout;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_POSKeyLayoutQuery extends POQuery<MPOSKeyLayout> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOSKeyLayout.Table_Name;
	}

	public CompletableFuture<MPOSKeyLayout> C_POSKeyLayout(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPOSKeyLayout> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_POSKeyLayoutDataLoader.DATALOADER_C_POSKeyLayout_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPOSKeyLayout> C_POSKeyLayoutGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
