package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MSchedulerLogDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MSchedulerParaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MSchedulerRecipientDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerLog;
import org.compiere.model.MSchedulerPara;
import org.compiere.model.MSchedulerRecipient;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MSchedulerResolver extends X_AD_SchedulerResolver {

	public CompletableFuture<List<MSchedulerLog>> AD_SchedulerLogs(MScheduler entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MSchedulerLog>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MSchedulerLogDataLoader.DATALOADER_AD_SchedulerLog_BY_AD_Scheduler_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Schedule_ID()));
	}

	public CompletableFuture<List<MSchedulerPara>> AD_Scheduler_ParaList(MScheduler entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MSchedulerPara>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MSchedulerParaDataLoader.DATALOADER_AD_Scheduler_Para_BY_AD_Scheduler_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Schedule_ID()));
	}

	public CompletableFuture<List<MSchedulerRecipient>> AD_SchedulerRecipients(MScheduler entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MSchedulerRecipient>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MSchedulerRecipientDataLoader.DATALOADER_AD_SchedulerRecipient_BY_AD_Scheduler_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Schedule_ID()));
	}
}
