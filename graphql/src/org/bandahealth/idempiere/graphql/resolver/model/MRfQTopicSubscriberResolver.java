package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRfQTopicSubscriberOnlyDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRfQTopicSubscriber;
import org.compiere.model.MRfQTopicSubscriberOnly;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRfQTopicSubscriberResolver extends X_C_RfQ_TopicSubscriberResolver {

	public CompletableFuture<List<MRfQTopicSubscriberOnly>> C_RfQ_TopicSubscriberOnlyList(MRfQTopicSubscriber entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRfQTopicSubscriberOnly>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MRfQTopicSubscriberOnlyDataLoader.DATALOADER_C_RfQ_TopicSubscriberOnly_BY_C_RfQ_TopicSubscriber_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_RfQ_TopicSubscriber_ID()));
	}
}
