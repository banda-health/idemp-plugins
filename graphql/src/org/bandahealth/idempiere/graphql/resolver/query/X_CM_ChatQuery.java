package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChat;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_CM_ChatQuery extends POQuery<MChat> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChat.Table_Name;
	}

	public CompletableFuture<MChat> CM_Chat(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChat> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_CM_ChatDataLoader.DATALOADER_CM_Chat_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChat> CM_ChatGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
