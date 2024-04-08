package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MEXPProcessorParameterDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEXPProcessorParameter;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MEXPProcessorResolver extends X_EXP_ProcessorResolver {

	public CompletableFuture<List<MEXPProcessorParameter>> EXP_ProcessorParameters(MEXPProcessor entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MEXPProcessorParameter>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MEXPProcessorParameterDataLoader.DATALOADER_EXP_ProcessorParameter_BY_EXP_Processor_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getEXP_Processor_ID()));
	}
}
