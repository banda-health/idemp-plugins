package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInOutLineConfirm;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInOutLineConfirmDataLoader extends X_M_InOutLineConfirmDataLoader {
	public static String DATALOADER_M_InOutLineConfirm_BY_M_InOutConfirm_ID =
			"DATALOADER_M_InOutLineConfirm_BY_M_InOutConfirm_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_InOutLineConfirm_BY_M_InOutConfirm_ID,
				DataLoader.newMappedDataLoader(getByInOutLineConfirmIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInOutLineConfirm>> getByInOutLineConfirmIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOutLineConfirm::getM_InOutConfirm_ID,
				MInOutLineConfirm.COLUMNNAME_M_InOutConfirm_ID, keys);
	}
}
