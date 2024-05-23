package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQ_TopicSubscriberDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQTopicSubscriber;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriber - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQ_TopicSubscriberQuery extends POQuery<MRfQTopicSubscriber> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQTopicSubscriber.Table_Name;
	}

	public CompletableFuture<MRfQTopicSubscriber> C_RfQ_TopicSubscriber(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQTopicSubscriber> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQ_TopicSubscriberDataLoader.DATALOADER_C_RfQ_TopicSubscriber_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQTopicSubscriber> C_RfQ_TopicSubscriberGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
