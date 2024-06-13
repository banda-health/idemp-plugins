package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_IMP_ProcessorDataLoader;
import org.compiere.model.MIMPProcessor;
import org.compiere.model.MIMPProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_ProcessorLogResolver extends POResolver<MIMPProcessorLog> implements GraphQLResolver<MIMPProcessorLog> {



	/**
	 * Get Import Processor.
	 *
	 * @return Import Processor
	 */
	public CompletableFuture<MIMPProcessor> IMP_Processor(MIMPProcessorLog entity, DataFetchingEnvironment environment) {
		if (entity.getIMP_Processor_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MIMPProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_IMP_ProcessorDataLoader.DATALOADER_IMP_Processor_BY_ID);
		return dataLoader.load(entity.getIMP_Processor_ID());
	}

	public Boolean IsError(MIMPProcessorLog entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}

}
