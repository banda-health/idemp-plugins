package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatUpdateDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_CM_ChatUpdate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_CM_ChatUpdateQuery extends POQuery<X_CM_ChatUpdate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatUpdate.Table_Name;
	}

	public CompletableFuture<X_CM_ChatUpdate> CM_ChatUpdate(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_CM_ChatUpdate> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_CM_ChatUpdateDataLoader.DATALOADER_CM_ChatUpdate_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_CM_ChatUpdate> CM_ChatUpdateGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
