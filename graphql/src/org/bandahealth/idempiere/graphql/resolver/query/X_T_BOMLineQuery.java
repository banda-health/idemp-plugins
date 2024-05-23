package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_BOMLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_T_BOMLine;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_BOMLineQuery extends POQuery<X_T_BOMLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_BOMLine.Table_Name;
	}

	public CompletableFuture<X_T_BOMLine> T_BOMLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_BOMLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_BOMLineDataLoader.DATALOADER_T_BOMLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_BOMLine> T_BOMLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
