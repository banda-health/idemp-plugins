package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MUserDataLoader extends X_AD_UserDataLoader {
	public static String DATALOADER_AD_User_BY_C_BPartner_ID = "DATALOADER_AD_User_BY_C_BPartner_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_User_BY_C_BPartner_ID,
				DataLoader.newMappedDataLoader(getByBusinessPartnerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MUser_BH>> getByBusinessPartnerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MUser_BH::getC_BPartner_ID,
				MUser_BH.COLUMNNAME_C_BPartner_ID, keys);
	}
}
