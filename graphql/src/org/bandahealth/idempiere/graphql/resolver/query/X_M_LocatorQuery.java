package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLocator;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_LocatorQuery extends POQuery<MLocator> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLocator.Table_Name;
	}

	public CompletableFuture<MLocator> M_Locator(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLocator> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLocator> M_LocatorGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
