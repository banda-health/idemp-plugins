package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPInstanceLogDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPInstanceParaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProcessParaDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPInstance;
import org.compiere.model.MPInstancePara;
import org.compiere.model.MProcessPara;
import org.compiere.model.X_AD_PInstance_Log;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPInstanceResolver extends X_AD_PInstanceResolver {

	public CompletableFuture<List<MPInstancePara>> AD_PInstance_ParaList(MPInstance entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPInstancePara>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPInstanceParaDataLoader.DATALOADER_AD_PInstance_Para_BY_AD_PInstance_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_PInstance_ID()));
	}

	public CompletableFuture<List<MProcessPara>> AD_Process_ParaList(MPInstance entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProcessPara>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProcessParaDataLoader.DATALOADER_AD_Process_Para_BY_AD_Process_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Process_ID()));
	}

	public CompletableFuture<List<X_AD_PInstance_Log>> AD_PInstance_Logs(MPInstance entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<X_AD_PInstance_Log>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPInstanceLogDataLoader.DATALOADER_AD_PInstance_Log_BY_AD_PInstance_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_PInstance_ID()));
	}
}
