package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SchedulerRecipientDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSchedulerRecipient;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SchedulerRecipientQuery extends POQuery<MSchedulerRecipient> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSchedulerRecipient.Table_Name;
	}

	public CompletableFuture<MSchedulerRecipient> AD_SchedulerRecipient(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSchedulerRecipient> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_SchedulerRecipientDataLoader.DATALOADER_AD_SchedulerRecipient_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSchedulerRecipient> AD_SchedulerRecipientGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
