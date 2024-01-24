package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_IMP_ProcessorDataLoader;
import org.compiere.model.X_IMP_Processor;
import org.compiere.model.X_IMP_ProcessorParameter;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_ProcessorParameterResolver extends POResolver<X_IMP_ProcessorParameter> implements GraphQLResolver<X_IMP_ProcessorParameter> {



	/**
	 * Get Import Processor.
	 *
	 * @return Import Processor
	 */
	public CompletableFuture<X_IMP_Processor> IMP_Processor(X_IMP_ProcessorParameter entity, DataFetchingEnvironment environment) {
		if (entity.getIMP_Processor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_IMP_Processor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_IMP_ProcessorDataLoader.DATALOADER_IMP_Processor_BY_ID);
		return dataLoader.load(entity.getIMP_Processor_ID());
	}

}
