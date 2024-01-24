package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.compiere.model.MAcctProcessor;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MSchedule;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AcctProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctProcessorResolver extends POResolver<MAcctProcessor> implements GraphQLResolver<MAcctProcessor> {



	/**
	 * Get Schedule.
	 *
	 * @return Schedule
	 */
	public CompletableFuture<MSchedule> AD_Schedule(MAcctProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Schedule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ScheduleDataLoader.DATALOADER_AD_Schedule_BY_ID);
		return dataLoader.load(entity.getAD_Schedule_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MAcctProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MAcctProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}

	public Boolean Processing(MAcctProcessor entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MAcctProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
