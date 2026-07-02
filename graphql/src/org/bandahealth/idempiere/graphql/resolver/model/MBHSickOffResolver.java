package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHSickOff;
import org.bandahealth.idempiere.base.model.MBHSickOffPrintLog;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHSickOffPrintLogDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHSickOffResolver extends X_BH_SickOffResolver {

	public CompletableFuture<List<MBHSickOffPrintLog>> BH_SickOff_Print_Logs(MBHSickOff entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHSickOffPrintLog>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHSickOffPrintLogDataLoader.DATALOADER_BH_SickOff_Print_Log_BY_BH_SickOff_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
