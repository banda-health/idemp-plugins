package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SchedulerDataLoader;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SchedulerLogResolver extends POResolver<MSchedulerLog> implements GraphQLResolver<MSchedulerLog> {



	/**
	 * Get Scheduler.
	 *
	 * @return Schedule Processes
	 */
	public CompletableFuture<MScheduler> AD_Scheduler(MSchedulerLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Scheduler_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MScheduler> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SchedulerDataLoader.DATALOADER_AD_Scheduler_BY_ID);
		return dataLoader.load(entity.getAD_Scheduler_ID());
	}

	public Boolean IsError(MSchedulerLog entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}

}
