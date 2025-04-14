package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningRunLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunningRunLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_DunningRunLineQuery extends POQuery<MDunningRunLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunningRunLine.Table_Name;
	}

	public CompletableFuture<MDunningRunLine> C_DunningRunLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDunningRunLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DunningRunLineDataLoader.DATALOADER_C_DunningRunLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDunningRunLine> C_DunningRunLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
