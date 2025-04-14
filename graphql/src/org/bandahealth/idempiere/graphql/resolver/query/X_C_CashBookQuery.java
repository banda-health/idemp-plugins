package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashBook;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CashBook - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CashBookQuery extends POQuery<MCashBook> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashBook.Table_Name;
	}

	public CompletableFuture<MCashBook> C_CashBook(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCashBook> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CashBookDataLoader.DATALOADER_C_CashBook_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCashBook> C_CashBookGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
