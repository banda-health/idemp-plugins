package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectLineQuery extends POQuery<MProjectLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectLine.Table_Name;
	}

	public CompletableFuture<MProjectLine> C_ProjectLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProjectLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ProjectLineDataLoader.DATALOADER_C_ProjectLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProjectLine> C_ProjectLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
