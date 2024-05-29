package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.compiere.model.MAlertProcessor;
import org.compiere.model.MSchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertProcessorResolver extends POResolver<MAlertProcessor> implements GraphQLResolver<MAlertProcessor> {



	/**
	 * Get Schedule.
	 *
	 * @return Schedule
	 */
	public CompletableFuture<MSchedule> AD_Schedule(MAlertProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Schedule_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MSchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ScheduleDataLoader.DATALOADER_AD_Schedule_BY_ID);
		return dataLoader.load(entity.getAD_Schedule_ID());
	}

	public Boolean Processing(MAlertProcessor entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MAlertProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
