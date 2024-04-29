package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHPayerInfoFldValSugDataLoader extends X_BH_Payer_Info_Fld_Val_SugDataLoader {
	public static String DATALOADER_BH_Payer_Info_Fld_Val_Sug_By_BH_Payer_Info_Fld_Sug_ID =
			"BH_Payer_Info_Fld_Val_SugByBY_Payer_Info_Fld_SugIDDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Payer_Info_Fld_Val_Sug_By_BH_Payer_Info_Fld_Sug_ID,
				DataLoader.newMappedDataLoader(getByPayerInformationFieldSuggestionIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHPayerInfoFldValSug>> getByPayerInformationFieldSuggestionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHPayerInfoFldValSug::getBH_Payer_Info_Fld_Sug_ID,
				MBHPayerInfoFldValSug.COLUMNNAME_BH_Payer_Info_Fld_Sug_ID, keys);
	}
}
