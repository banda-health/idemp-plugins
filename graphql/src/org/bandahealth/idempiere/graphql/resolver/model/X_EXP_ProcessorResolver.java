package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_Processor_TypeDataLoader;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEXPProcessorType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_ProcessorResolver extends POResolver<MEXPProcessor> implements GraphQLResolver<MEXPProcessor> {



	/**
	 * Get Export Processor Type.
	 *
	 * @return Export Processor Type
	 */
	public CompletableFuture<MEXPProcessorType> EXP_Processor_Type(MEXPProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getEXP_Processor_Type_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MEXPProcessorType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_EXP_Processor_TypeDataLoader.EXP_Processor_Type_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEXP_Processor_Type_ID());
	}

}
