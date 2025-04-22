package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MSystem;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SystemResolver extends POResolver<MSystem> implements GraphQLResolver<MSystem> {


	public Boolean IsAllowStatistics(MSystem entity, DataFetchingEnvironment environment) {
		return entity.isAllowStatistics();
	}

	public Boolean IsAutoErrorReport(MSystem entity, DataFetchingEnvironment environment) {
		return entity.isAutoErrorReport();
	}

	public Boolean IsFailOnBuildDiffer(MSystem entity, DataFetchingEnvironment environment) {
		return entity.isFailOnBuildDiffer();
	}

	public Boolean IsFailOnMissingModelValidator(MSystem entity, DataFetchingEnvironment environment) {
		return entity.isFailOnMissingModelValidator();
	}

	public Boolean IsJustMigrated(MSystem entity, DataFetchingEnvironment environment) {
		return entity.isJustMigrated();
	}

	public Boolean Processing(MSystem entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public static Map<String, String> REPLICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "c829969e-9927-491f-89a8-f200b8d29f57"); // Local
			put("M", "41211ac8-1137-49f5-9efb-7d8e75682a45"); // Merge
			put("R", "959a0839-d0f2-43c5-b8da-d0f1fd76d8dd"); // Reference
			put("B", "1be8a931-6954-4fd9-bc76-e67c6f73fc00"); // Broadcast
		}
	};
	public CompletableFuture<MRefList_BH> ReplicationType(MSystem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReplicationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REPLICATIONTYPE_UUIDS_BY_VALUE.get(entity.getReplicationType()));
	}

	public static Map<String, String> SYSTEMSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "80ee3010-2e49-4aa8-934e-2c5662b1b70d"); // Evaluation
			put("I", "d3239ec8-bbdc-42c3-997b-c3be8d89d914"); // Implementation
			put("P", "1b3201b9-d2a4-4101-a4a0-a53571550f32"); // Production
		}
	};
	public CompletableFuture<MRefList_BH> SystemStatus(MSystem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSystemStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SYSTEMSTATUS_UUIDS_BY_VALUE.get(entity.getSystemStatus()));
	}

}
