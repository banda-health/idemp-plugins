package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.compiere.model.MSchedule;
import org.compiere.model.X_AD_WorkflowProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowProcessorResolver extends POResolver<X_AD_WorkflowProcessor> implements GraphQLResolver<X_AD_WorkflowProcessor> {



	/**
	 * Get Schedule.
	 *
	 * @return Schedule
	 */
	public CompletableFuture<MSchedule> AD_Schedule(X_AD_WorkflowProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Schedule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ScheduleDataLoader.AD_Schedule_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Schedule_ID());
	}

	public Boolean Processing(X_AD_WorkflowProcessor entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(X_AD_WorkflowProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
