package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRfQTopicSubscriberDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRfQTopic;
import org.compiere.model.MRfQTopicSubscriber;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRfQTopicResolver extends X_C_RfQ_TopicResolver {

	public CompletableFuture<List<MRfQTopicSubscriber>> C_RfQ_TopicSubscribers(MRfQTopic entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRfQTopicSubscriber>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRfQTopicSubscriberDataLoader.DATALOADER_C_RfQ_TopicSubscriber_BY_C_RfQ_Topic_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_RfQ_Topic_ID()));
	}
}
