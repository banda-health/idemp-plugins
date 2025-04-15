package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AlertRecipientDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertRecipient;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AlertRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AlertRecipientQuery extends POQuery<MAlertRecipient> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertRecipient.Table_Name;
	}

	public CompletableFuture<MAlertRecipient> AD_AlertRecipient(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAlertRecipient> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AlertRecipientDataLoader.DATALOADER_AD_AlertRecipient_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAlertRecipient> AD_AlertRecipientGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
