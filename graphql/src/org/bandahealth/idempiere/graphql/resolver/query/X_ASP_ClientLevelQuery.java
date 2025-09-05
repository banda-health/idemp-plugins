package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_ClientLevelDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_ClientLevel;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_ClientLevelQuery extends POQuery<X_ASP_ClientLevel> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ClientLevel.Table_Name;
	}

	public CompletableFuture<X_ASP_ClientLevel> ASP_ClientLevel(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_ASP_ClientLevel> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_ASP_ClientLevelDataLoader.DATALOADER_ASP_ClientLevel_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_ASP_ClientLevel> ASP_ClientLevelGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
