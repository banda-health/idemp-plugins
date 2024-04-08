package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MEXPProcessorParameter;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MEXPProcessorParameterDataLoader extends X_EXP_ProcessorParameterDataLoader {
	public static String DATALOADER_EXP_ProcessorParameter_BY_EXP_Processor_ID =
			"DATALOADER_EXP_ProcessorParameter_BY_EXP_Processor_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_EXP_ProcessorParameter_BY_EXP_Processor_ID,
				DataLoader.newMappedDataLoader(getByProcessorIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MEXPProcessorParameter>> getByProcessorIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MEXPProcessorParameter::getEXP_Processor_ID,
				MEXPProcessorParameter.COLUMNNAME_EXP_Processor_ID, keys);
	}
}
