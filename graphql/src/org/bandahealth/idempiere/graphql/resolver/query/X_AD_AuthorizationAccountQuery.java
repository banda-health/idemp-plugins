package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AuthorizationAccountDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAuthorizationAccount;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AuthorizationAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AuthorizationAccountQuery extends POQuery<MAuthorizationAccount> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAuthorizationAccount.Table_Name;
	}

	public CompletableFuture<MAuthorizationAccount> AD_AuthorizationAccount(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAuthorizationAccount> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AuthorizationAccountDataLoader.DATALOADER_AD_AuthorizationAccount_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAuthorizationAccount> AD_AuthorizationAccountGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
