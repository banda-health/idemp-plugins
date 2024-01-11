package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestProcessorDataLoader;
import org.compiere.model.MRequestProcessor;
import org.compiere.model.MRequestProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_RequestProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessorLogResolver extends POResolver<MRequestProcessorLog> implements GraphQLResolver<MRequestProcessorLog> {


	public Boolean IsError(MRequestProcessorLog entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}


	/**
	 * Get Request Processor.
	 *
	 * @return Processor for Requests
	 */
	public CompletableFuture<MRequestProcessor> R_RequestProcessor(MRequestProcessorLog entity, DataFetchingEnvironment environment) {
		if (entity.getR_RequestProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequestProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestProcessorDataLoader.R_RequestProcessor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getR_RequestProcessor_ID());
	}

}
