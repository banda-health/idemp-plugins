package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutLineMADataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInOutLineMA;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInOutLineResolver extends X_M_InOutLineResolver {

	public CompletableFuture<List<MInOutLineMA>> M_InOutLineMAList(MInOutLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOutLineMA>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInOutLineMADataLoader.DATALOADER_M_InOutLineMA_BY_M_InOutLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_InOutLine_ID()));
	}
}
