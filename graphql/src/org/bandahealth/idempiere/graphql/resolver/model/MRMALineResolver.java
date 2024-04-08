package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MRMALine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRMALineResolver extends X_M_RMALineResolver {

	public CompletableFuture<List<MInOutLine>> M_InOutLines(MRMALine entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOutLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInOutLineDataLoader.DATALOADER_M_InOutLine_BY_M_RMALine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Product_ID()));
	}
}
