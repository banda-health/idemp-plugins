package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_LevelDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_Workflow;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Workflow;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for ASP_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_WorkflowResolver extends POResolver<X_ASP_Workflow> implements GraphQLResolver<X_ASP_Workflow> {



	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_ASP_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get ASP Level.
	 *
	 * @return ASP Level
	 */
	public CompletableFuture<X_ASP_Level> ASP_Level(X_ASP_Workflow entity, DataFetchingEnvironment environment) {
		if (entity.getASP_Level_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_ASP_Level> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_ASP_LevelDataLoader.DATALOADER_ASP_Level_BY_ID);
		return dataLoader.load(entity.getASP_Level_ID());
	}

	static Map<String, String> ASP_STATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("H", "864906b8-9311-4af2-9464-434e25fa6f72");
			put("S", "e06c95b8-62c4-4d5d-b9fc-e23c5049489e");
			put("U", "e718a86a-8c1d-490d-9d3f-f1a2dfe6af69");
		}
	};
	public CompletableFuture<MRefList_BH> ASP_Status(X_ASP_Workflow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getASP_Status())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ASP_STATUS_UUIDS_BY_VALUE.get(entity.getASP_Status()));
	}

}
