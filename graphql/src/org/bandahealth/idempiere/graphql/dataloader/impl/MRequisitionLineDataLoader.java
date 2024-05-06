package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRequisitionLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRequisitionLineDataLoader extends X_M_RequisitionLineDataLoader {
	public static String DATALOADER_M_RequisitionLine_BY_M_Requisition_ID =
			"DATALOADER_M_RequisitionLine_BY_M_Requisition_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_RequisitionLine_BY_M_Requisition_ID,
				DataLoader.newMappedDataLoader(getByRequisitionIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRequisitionLine>> getByRequisitionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRequisitionLine::getM_Requisition_ID,
				MRequisitionLine.COLUMNNAME_M_Requisition_ID, keys);
	}
}
