package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatTypeUpdateDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_CM_ChatTypeUpdate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_CM_ChatTypeUpdateQuery extends POQuery<X_CM_ChatTypeUpdate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatTypeUpdate.Table_Name;
	}

	public CompletableFuture<X_CM_ChatTypeUpdate> CM_ChatTypeUpdate(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_CM_ChatTypeUpdate> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_CM_ChatTypeUpdateDataLoader.DATALOADER_CM_ChatTypeUpdate_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_CM_ChatTypeUpdate> CM_ChatTypeUpdateGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
