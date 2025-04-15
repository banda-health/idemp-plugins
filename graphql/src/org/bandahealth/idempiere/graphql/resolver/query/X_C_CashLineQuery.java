package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CashLineQuery extends POQuery<MCashLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashLine.Table_Name;
	}

	public CompletableFuture<MCashLine> C_CashLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCashLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CashLineDataLoader.DATALOADER_C_CashLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCashLine> C_CashLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
