package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpMsgDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCtxHelpMsg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_CtxHelpMsg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_CtxHelpMsgQuery extends POQuery<MCtxHelpMsg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCtxHelpMsg.Table_Name;
	}

	public CompletableFuture<MCtxHelpMsg> AD_CtxHelpMsg(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCtxHelpMsg> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_CtxHelpMsgDataLoader.DATALOADER_AD_CtxHelpMsg_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCtxHelpMsg> AD_CtxHelpMsgGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
