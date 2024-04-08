package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutConfirmDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutConfirm;
import org.compiere.model.MInOutLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInOutResolver extends X_M_InOutResolver {

	public CompletableFuture<List<MInOutConfirm>> M_InOutConfirmList(MInOut_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOutConfirm>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInOutConfirmDataLoader.DATALOADER_M_InOutConfirm_BY_M_InOut_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_InOut_ID()));
	}

	public CompletableFuture<List<MInOutLine>> M_InOutLines(MInOut_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOutLine>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInOutLineDataLoader.DATALOADER_M_InOutLine_BY_M_InOut_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_InOut_ID()));
	}
}
