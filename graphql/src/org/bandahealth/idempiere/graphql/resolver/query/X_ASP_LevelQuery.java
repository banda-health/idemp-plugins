package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_LevelDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Level;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_LevelQuery extends POQuery<X_ASP_Level> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Level.Table_Name;
	}

	public CompletableFuture<X_ASP_Level> ASP_Level(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_ASP_Level> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_ASP_LevelDataLoader.DATALOADER_ASP_Level_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_ASP_Level> ASP_LevelGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
