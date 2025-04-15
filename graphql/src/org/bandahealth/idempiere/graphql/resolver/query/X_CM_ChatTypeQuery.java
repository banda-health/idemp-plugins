package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChatType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_CM_ChatTypeQuery extends POQuery<MChatType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChatType.Table_Name;
	}

	public CompletableFuture<MChatType> CM_ChatType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChatType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_CM_ChatTypeDataLoader.DATALOADER_CM_ChatType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChatType> CM_ChatTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
