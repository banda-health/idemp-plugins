package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCtxHelp;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_CtxHelpQuery extends POQuery<MCtxHelp> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCtxHelp.Table_Name;
	}

	public CompletableFuture<MCtxHelp> AD_CtxHelp(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCtxHelp> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_CtxHelpDataLoader.DATALOADER_AD_CtxHelp_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCtxHelp> AD_CtxHelpGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
