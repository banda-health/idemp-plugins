package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TaskDataLoader;
import org.compiere.model.MTask;
import org.compiere.model.X_AD_TaskInstance;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_TaskInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TaskInstanceResolver extends POResolver<X_AD_TaskInstance> implements GraphQLResolver<X_AD_TaskInstance> {



	/**
	 * Get OS Task.
	 *
	 * @return Operation System Task
	 */
	public CompletableFuture<MTask> AD_Task(X_AD_TaskInstance entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Task_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TaskDataLoader.DATALOADER_AD_Task_BY_ID);
		return dataLoader.load(entity.getAD_Task_ID());
	}

}
