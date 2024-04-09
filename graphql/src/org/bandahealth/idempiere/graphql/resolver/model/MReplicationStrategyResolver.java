package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MReplicationTableDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.X_AD_ReplicationTable;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MReplicationStrategyResolver extends X_AD_ReplicationStrategyResolver {

	public CompletableFuture<List<X_AD_ReplicationTable>> AD_ReplicationTableList(MReplicationStrategy entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<X_AD_ReplicationTable>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MReplicationTableDataLoader.DATALOADER_AD_Replication_BY_AD_ReplicationStrategy_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_ReplicationStrategy_ID()));
	}
}
