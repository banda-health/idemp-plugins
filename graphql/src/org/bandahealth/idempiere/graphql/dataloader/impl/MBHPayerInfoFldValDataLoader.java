package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHPayerInfoFldValDataLoader extends X_BH_Payer_Info_Fld_ValDataLoader {
	public static String BH_Payer_Info_Fld_Val_BY_BH_PAYER_INFO_FLD_ID_DATA_LOADER = "BH_Payer_Info_Fld_Val_ByBHHPayerInfoFldIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(BH_Payer_Info_Fld_Val_BY_BH_PAYER_INFO_FLD_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByPayerInformationFieldIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHPayerInfoFldVal>> getByPayerInformationFieldIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHPayerInfoFldVal::getBH_Payer_Info_Fld_ID,
				MBHPayerInfoFldVal.COLUMNNAME_BH_Payer_Info_Fld_ID, keys);
	}
}
