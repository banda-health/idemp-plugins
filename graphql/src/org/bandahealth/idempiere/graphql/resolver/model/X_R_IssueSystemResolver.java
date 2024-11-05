package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.X_R_IssueSystem;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueSystemResolver extends POResolver<X_R_IssueSystem> implements GraphQLResolver<X_R_IssueSystem> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_R_IssueSystem entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}

	public static Map<String, String> SYSTEMSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "80ee3010-2e49-4aa8-934e-2c5662b1b70d"); // Evaluation
			put("I", "d3239ec8-bbdc-42c3-997b-c3be8d89d914"); // Implementation
			put("P", "1b3201b9-d2a4-4101-a4a0-a53571550f32"); // Production
		}
	};
	public CompletableFuture<MRefList_BH> SystemStatus(X_R_IssueSystem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSystemStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SYSTEMSTATUS_UUIDS_BY_VALUE.get(entity.getSystemStatus()));
	}

}
