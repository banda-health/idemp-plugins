package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MBPartnerLocation;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBPartnerLocationDataLoader extends X_C_BPartner_LocationDataLoader {
	public static String C_BPartner_Location_BY_BPARTNER_ID_DATA_LOADER = "C_BPartner_LocationByBPartnerIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(C_BPartner_Location_BY_BPARTNER_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByBusinessPartnerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBPartnerLocation>> getByBusinessPartnerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBPartnerLocation::getC_BPartner_ID,
				MBPartnerLocation.COLUMNNAME_C_BPartner_ID, keys);
	}
}
