package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_ProcessorDataLoader;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEXPProcessorParameter;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_EXP_ProcessorParameterResolver extends POResolver<MEXPProcessorParameter> implements GraphQLResolver<MEXPProcessorParameter> {



	/**
	 * Get Export Processor.
	 *
	 * @return Export Processor
	 */
	public CompletableFuture<MEXPProcessor> EXP_Processor(MEXPProcessorParameter entity, DataFetchingEnvironment environment) {
		if (entity.getEXP_Processor_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MEXPProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_EXP_ProcessorDataLoader.DATALOADER_EXP_Processor_BY_ID);
		return dataLoader.load(entity.getEXP_Processor_ID());
	}

}
