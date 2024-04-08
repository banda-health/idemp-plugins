package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MLdapProcessorLog;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MLdapProcessorLogDataLoader extends X_AD_LdapProcessorLogDataLoader {
	public static String DATALOADER_AD_LdapProcessorLog_BY_AD_LdapProcessor_ID =
			"DATALOADER_AD_LdapProcessorLog_BY_AD_LdapProcessor_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_LdapProcessorLog_BY_AD_LdapProcessor_ID,
				DataLoader.newMappedDataLoader(getByLdapProcessorIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MLdapProcessorLog>> getByLdapProcessorIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MLdapProcessorLog::getAD_LdapProcessor_ID,
				MLdapProcessorLog.COLUMNNAME_AD_LdapProcessor_ID, keys);
	}
}
