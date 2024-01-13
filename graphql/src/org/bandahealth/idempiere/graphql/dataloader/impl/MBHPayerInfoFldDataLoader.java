package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHPayerInfoFldDataLoader extends X_BH_Payer_Info_FldDataLoader {
	public static String BH_Payer_Info_Fld_BY_PAYER_ID_DATA_LOADER = "BH_Payer_Info_Fld_ByPayerIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(BH_Payer_Info_Fld_BY_PAYER_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByPayerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHPayerInfoFld>> getByPayerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHPayerInfoFld::getBH_Payer_ID,
				MBHPayerInfoFld.COLUMNNAME_BH_Payer_ID, keys);
	}
}
