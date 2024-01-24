package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_A_Asset_Reval_Index;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_IndexResolver extends POResolver<X_A_Asset_Reval_Index> implements GraphQLResolver<X_A_Asset_Reval_Index> {


	static Map<String, String> A_REVAL_CODE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R01", "f9d5c700-9d0a-46c7-bf06-bf22a808b37d");
			put("R02", "678f01f7-e046-4f14-a64e-f8fd86e64ff4");
			put("R03", "374da497-243b-46a1-a10d-5690d37271c5");
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Code(X_A_Asset_Reval_Index entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Code())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_REVAL_CODE_UUIDS_BY_VALUE.get(entity.getA_Reval_Code()));
	}

	static Map<String, String> A_REVAL_MULTIPLIER_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("FAC", "4d179af6-49ab-4e58-907f-ba46f9b7d071");
			put("IND", "a3202410-8fba-4439-95fb-de3a1f32c568");
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Multiplier(X_A_Asset_Reval_Index entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Multiplier())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_REVAL_MULTIPLIER_UUIDS_BY_VALUE.get(entity.getA_Reval_Multiplier()));
	}

}
