package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRfQTopicSubscriberOnly;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRfQTopicSubscriberOnlyDataLoader extends X_C_RfQ_TopicSubscriberOnlyDataLoader {
	public static String DATALOADER_C_RfQ_TopicSubscriberOnly_BY_C_RfQ_TopicSubscriber_ID =
			"DATALOADER_C_RfQ_TopicSubscriberOnly_BY_C_RfQ_TopicSubscriber_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_RfQ_TopicSubscriberOnly_BY_C_RfQ_TopicSubscriber_ID,
				DataLoader.newMappedDataLoader(getByRfQTopicSubscriberIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRfQTopicSubscriberOnly>> getByRfQTopicSubscriberIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null,
				MRfQTopicSubscriberOnly::getC_RfQ_TopicSubscriber_ID,
				MRfQTopicSubscriberOnly.COLUMNNAME_C_RfQ_TopicSubscriber_ID, keys);
	}
}
