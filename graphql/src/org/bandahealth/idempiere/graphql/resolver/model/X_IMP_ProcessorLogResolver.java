package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_IMP_ProcessorDataLoader;
import org.compiere.model.X_IMP_Processor;
import org.compiere.model.X_IMP_ProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_ProcessorLogResolver extends POResolver<X_IMP_ProcessorLog> implements GraphQLResolver<X_IMP_ProcessorLog> {



	/**
	 * Get Import Processor.
	 *
	 * @return Import Processor
	 */
	public CompletableFuture<X_IMP_Processor> IMP_Processor(X_IMP_ProcessorLog entity, DataFetchingEnvironment environment) {
		if (entity.getIMP_Processor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_IMP_Processor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_IMP_ProcessorDataLoader.IMP_Processor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getIMP_Processor_ID());
	}

	public Boolean IsError(X_IMP_ProcessorLog entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}

}
