package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRequisitionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRequisitionResolver extends X_M_RequisitionResolver {

	public CompletableFuture<List<MRequisitionLine>> M_RequisitionLines(MRequisition entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRequisitionLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRequisitionLineDataLoader.DATALOADER_M_RequisitionLine_BY_M_Requisition_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Requisition_ID()));
	}
}
