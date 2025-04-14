package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHAllergyDataLoader extends X_BH_AllergyDataLoader {
	public static String DATALOADER_BH_Allergy_BY_C_BPartner_ID = "BH_AllergyByC_BPartnerIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Allergy_BY_C_BPartner_ID,
				DataLoader.newMappedDataLoader(getByBusinessPartnerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHAllergy>> getByBusinessPartnerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHAllergy::getC_BPartner_ID,
				MBHAllergy.COLUMNNAME_C_BPartner_ID, keys);
	}
}
