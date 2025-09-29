package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LdapProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLdapProcessorLog;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_LdapProcessorLogQuery extends POQuery<MLdapProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLdapProcessorLog.Table_Name;
	}

	public CompletableFuture<MLdapProcessorLog> AD_LdapProcessorLog(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLdapProcessorLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_LdapProcessorLogDataLoader.DATALOADER_AD_LdapProcessorLog_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLdapProcessorLog> AD_LdapProcessorLogGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
