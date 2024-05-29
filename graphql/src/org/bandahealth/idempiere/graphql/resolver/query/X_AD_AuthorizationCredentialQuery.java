package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AuthorizationCredentialDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAuthorizationCredential;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AuthorizationCredential - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationCredentialQuery extends POQuery<MAuthorizationCredential> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAuthorizationCredential.Table_Name;
	}

	public CompletableFuture<MAuthorizationCredential> AD_AuthorizationCredential(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAuthorizationCredential> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AuthorizationCredentialDataLoader.DATALOADER_AD_AuthorizationCredential_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAuthorizationCredential> AD_AuthorizationCredentialGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
