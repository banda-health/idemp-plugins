package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutLineConfirmDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutConfirm;
import org.compiere.model.MInOutLineConfirm;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInOutConfirmResolver extends X_M_InOutConfirmResolver {

	public CompletableFuture<List<MInOutLineConfirm>> M_InOutLineConfirmList(MInOutConfirm entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOutLineConfirm>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInOutLineConfirmDataLoader.DATALOADER_M_InOutLineConfirm_BY_M_InOutConfirm_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_InOutConfirm_ID()));
	}
}
