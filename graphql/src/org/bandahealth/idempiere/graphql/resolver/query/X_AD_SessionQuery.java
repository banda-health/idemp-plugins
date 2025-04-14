package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SessionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSession;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Session - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SessionQuery extends POQuery<MSession> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSession.Table_Name;
	}

	public CompletableFuture<MSession> AD_Session(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSession> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_SessionDataLoader.DATALOADER_AD_Session_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSession> AD_SessionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
