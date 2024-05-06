package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRfQTopicSubscriber;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRfQTopicSubscriberDataLoader extends X_C_RfQ_TopicSubscriberDataLoader {
	public static String DATALOADER_C_RfQ_TopicSubscriber_BY_C_RfQ_Topic_ID =
			"DATALOADER_C_RfQ_TopicSubscriber_BY_C_RfQ_Topic_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_RfQ_TopicSubscriber_BY_C_RfQ_Topic_ID,
				DataLoader.newMappedDataLoader(getByRfQTopicIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRfQTopicSubscriber>> getByRfQTopicIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRfQTopicSubscriber::getC_RfQ_Topic_ID,
				MRfQTopicSubscriber.COLUMNNAME_C_RfQ_Topic_ID, keys);
	}
}
