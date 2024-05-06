package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MStatusDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MStatus;
import org.compiere.model.MStatusCategory;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MStatusCategoryResolver extends X_R_StatusCategoryResolver {

	public CompletableFuture<List<MStatus>> R_StatusList(MStatusCategory entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MStatus>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MStatusDataLoader.DATALOADER_R_Status_BY_R_StatusCategory_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getR_StatusCategory_ID()));
	}
}
