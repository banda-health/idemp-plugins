package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LdapProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLdapProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_LdapProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_LdapProcessorQuery extends POQuery<MLdapProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLdapProcessor.Table_Name;
	}

	public CompletableFuture<MLdapProcessor> AD_LdapProcessor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLdapProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_LdapProcessorDataLoader.DATALOADER_AD_LdapProcessor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLdapProcessor> AD_LdapProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
