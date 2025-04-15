package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Process_ParaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SchedulerDataLoader;
import org.compiere.model.MProcessPara;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerPara;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Scheduler_ParaResolver extends POResolver<MSchedulerPara> implements GraphQLResolver<MSchedulerPara> {



	/**
	 * Get Process Parameter.
	 *
	 * @return Process Parameter
	 */
	public CompletableFuture<MProcessPara> AD_Process_Para(MSchedulerPara entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_Para_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProcessPara> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Process_ParaDataLoader.DATALOADER_AD_Process_Para_BY_ID);
		return dataLoader.load(entity.getAD_Process_Para_ID());
	}


	/**
	 * Get Scheduler.
	 *
	 * @return Schedule Processes
	 */
	public CompletableFuture<MScheduler> AD_Scheduler(MSchedulerPara entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Scheduler_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MScheduler> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SchedulerDataLoader.DATALOADER_AD_Scheduler_BY_ID);
		return dataLoader.load(entity.getAD_Scheduler_ID());
	}

}
