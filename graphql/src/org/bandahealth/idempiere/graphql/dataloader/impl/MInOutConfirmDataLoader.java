package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInOutConfirm;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInOutConfirmDataLoader extends X_M_InOutConfirmDataLoader {
	public static String DATALOADER_M_InOutConfirm_BY_M_InOut_ID = "DATALOADER_M_InOutConfirm_BY_M_InOut_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_InOutConfirm_BY_M_InOut_ID,
				DataLoader.newMappedDataLoader(getByInOutIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInOutConfirm>> getByInOutIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOutConfirm::getM_InOut_ID,
				MInOutConfirm.COLUMNNAME_M_InOut_ID, keys);
	}
}
