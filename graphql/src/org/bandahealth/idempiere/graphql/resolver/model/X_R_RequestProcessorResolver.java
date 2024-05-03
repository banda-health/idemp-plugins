package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestTypeDataLoader;
import org.compiere.model.MRequestProcessor;
import org.compiere.model.MRequestType;
import org.compiere.model.MSchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessorResolver extends POResolver<MRequestProcessor> implements GraphQLResolver<MRequestProcessor> {



	/**
	 * Get Schedule.
	 *
	 * @return Schedule
	 */
	public CompletableFuture<MSchedule> AD_Schedule(MRequestProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Schedule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ScheduleDataLoader.DATALOADER_AD_Schedule_BY_ID);
		return dataLoader.load(entity.getAD_Schedule_ID());
	}

	public Boolean Processing(MRequestProcessor entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	public CompletableFuture<MRequestType> R_RequestType(MRequestProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getR_RequestType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequestType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestTypeDataLoader.DATALOADER_R_RequestType_BY_ID);
		return dataLoader.load(entity.getR_RequestType_ID());
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MRequestProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
