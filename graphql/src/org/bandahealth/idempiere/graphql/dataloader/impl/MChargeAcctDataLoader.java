package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.X_C_Charge_Acct;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MChargeAcctDataLoader extends X_C_Charge_AcctDataLoader {
	public static String DATALOADER_C_Charge_Acct_BY_C_Charge_ID = "C_Charge_AcctByChargeIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_Charge_Acct_BY_C_Charge_ID,
				DataLoader.newMappedDataLoader(getByChargeIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<X_C_Charge_Acct>> getByChargeIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, X_C_Charge_Acct::getC_Charge_ID,
				X_C_Charge_Acct.COLUMNNAME_C_Charge_ID, keys);
	}
}
