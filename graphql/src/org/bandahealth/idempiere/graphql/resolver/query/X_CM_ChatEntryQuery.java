package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatEntryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChatEntry;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_CM_ChatEntryQuery extends POQuery<MChatEntry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChatEntry.Table_Name;
	}

	public CompletableFuture<MChatEntry> CM_ChatEntry(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChatEntry> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_CM_ChatEntryDataLoader.DATALOADER_CM_ChatEntry_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChatEntry> CM_ChatEntryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
