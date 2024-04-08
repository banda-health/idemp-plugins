package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MPackageExpDetail;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MPackageExpDetailDataLoader extends X_AD_Package_Exp_DetailDataLoader {
	public static String DATALOADER_AD_Package_Exp_Detail_BY_AD_Package_Exp_ID =
			"DATALOADER_AD_Package_Exp_Detail_BY_AD_Package_Exp_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Package_Exp_Detail_BY_AD_Package_Exp_ID,
				DataLoader.newMappedDataLoader(getByPackageExpIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPackageExpDetail>> getByPackageExpIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPackageExpDetail::getAD_Package_Exp_ID,
				MPackageExpDetail.COLUMNNAME_AD_Package_Exp_ID, keys);
	}
}
