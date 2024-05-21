package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.X_AD_ReplicationTable;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MReplicationTableDataLoader extends X_AD_ReplicationTableDataLoader {
	public static String DATALOADER_AD_Replication_BY_AD_ReplicationStrategy_ID =
			"DATALOADER_AD_Replication_BY_AD_ReplicationStrategy_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Replication_BY_AD_ReplicationStrategy_ID,
				DataLoader.newMappedDataLoader(getByReplicationStrategyIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<X_AD_ReplicationTable>> getByReplicationStrategyIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, X_AD_ReplicationTable::getAD_ReplicationStrategy_ID,
				X_AD_ReplicationTable.COLUMNNAME_AD_ReplicationStrategy_ID, keys);
	}
}
