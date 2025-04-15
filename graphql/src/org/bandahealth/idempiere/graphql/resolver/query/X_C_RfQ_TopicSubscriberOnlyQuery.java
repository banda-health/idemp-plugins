package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQ_TopicSubscriberOnlyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQTopicSubscriberOnly;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyQuery extends POQuery<MRfQTopicSubscriberOnly> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQTopicSubscriberOnly.Table_Name;
	}

	public CompletableFuture<MRfQTopicSubscriberOnly> C_RfQ_TopicSubscriberOnly(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQTopicSubscriberOnly> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQ_TopicSubscriberOnlyDataLoader.DATALOADER_C_RfQ_TopicSubscriberOnly_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQTopicSubscriberOnly> C_RfQ_TopicSubscriberOnlyGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
