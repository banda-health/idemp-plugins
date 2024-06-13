package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDocDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BankAccountDoc;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountDocQuery extends POQuery<X_C_BankAccountDoc> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccountDoc.Table_Name;
	}

	public CompletableFuture<X_C_BankAccountDoc> C_BankAccountDoc(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_BankAccountDoc> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankAccountDocDataLoader.DATALOADER_C_BankAccountDoc_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_BankAccountDoc> C_BankAccountDocGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
