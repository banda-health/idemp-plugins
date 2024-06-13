package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MessageDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_MessageQuery extends POQuery<MMessage_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMessage_BH.Table_Name;
	}

	public CompletableFuture<MMessage_BH> AD_Message(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMessage_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_MessageDataLoader.DATALOADER_AD_Message_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMessage_BH> AD_MessageGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
