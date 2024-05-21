package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowProcessorDataLoader;
import org.compiere.model.X_AD_WorkflowProcessor;
import org.compiere.model.X_AD_WorkflowProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WorkflowProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WorkflowProcessorLogResolver extends POResolver<X_AD_WorkflowProcessorLog> implements GraphQLResolver<X_AD_WorkflowProcessorLog> {



	/**
	 * Get Workflow Processor.
	 *
	 * @return Workflow Processor Server
	 */
	public CompletableFuture<X_AD_WorkflowProcessor> AD_WorkflowProcessor(X_AD_WorkflowProcessorLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WorkflowProcessor_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WorkflowProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowProcessorDataLoader.DATALOADER_AD_WorkflowProcessor_BY_ID);
		return dataLoader.load(entity.getAD_WorkflowProcessor_ID());
	}

	public Boolean IsError(X_AD_WorkflowProcessorLog entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}

}
