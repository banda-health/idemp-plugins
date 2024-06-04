package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LdapAccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLdapAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LdapAccessQuery extends POQuery<MLdapAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLdapAccess.Table_Name;
	}

	public CompletableFuture<MLdapAccess> AD_LdapAccess(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLdapAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_LdapAccessDataLoader.DATALOADER_AD_LdapAccess_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLdapAccess> AD_LdapAccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
