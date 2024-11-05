package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ProcessDataLoader;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_ProcessData;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_ProcessDataResolver extends POResolver<X_AD_WF_ProcessData> implements GraphQLResolver<X_AD_WF_ProcessData> {



	/**
	 * Get Workflow Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	public CompletableFuture<X_AD_WF_Process> AD_WF_Process(X_AD_WF_ProcessData entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Process_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Process> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ProcessDataLoader.DATALOADER_AD_WF_Process_BY_ID);
		return dataLoader.load(entity.getAD_WF_Process_ID());
	}

}
