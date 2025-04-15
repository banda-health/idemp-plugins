package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningLevelDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunningLevel;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DunningLevelQuery extends POQuery<MDunningLevel> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunningLevel.Table_Name;
	}

	public CompletableFuture<MDunningLevel> C_DunningLevel(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDunningLevel> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DunningLevelDataLoader.DATALOADER_C_DunningLevel_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDunningLevel> C_DunningLevelGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
