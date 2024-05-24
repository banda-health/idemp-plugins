package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationStrategyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_ReplicationDocument;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ReplicationDocument - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ReplicationDocumentResolver extends POResolver<X_AD_ReplicationDocument> implements GraphQLResolver<X_AD_ReplicationDocument> {



	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	public CompletableFuture<MReplicationStrategy> AD_ReplicationStrategy(X_AD_ReplicationDocument entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReplicationStrategy_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MReplicationStrategy> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReplicationStrategyDataLoader.DATALOADER_AD_ReplicationStrategy_BY_ID);
		return dataLoader.load(entity.getAD_ReplicationStrategy_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_ReplicationDocument entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(X_AD_ReplicationDocument entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}

	public static Map<String, String> REPLICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "c829969e-9927-491f-89a8-f200b8d29f57"); // Local
			put("M", "41211ac8-1137-49f5-9efb-7d8e75682a45"); // Merge
			put("R", "959a0839-d0f2-43c5-b8da-d0f1fd76d8dd"); // Reference
			put("B", "1be8a931-6954-4fd9-bc76-e67c6f73fc00"); // Broadcast
		}
	};
	public CompletableFuture<MRefList_BH> ReplicationType(X_AD_ReplicationDocument entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReplicationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REPLICATIONTYPE_UUIDS_BY_VALUE.get(entity.getReplicationType()));
	}

}
