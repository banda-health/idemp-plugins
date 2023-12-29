package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAssetType;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_TypeResolver extends POResolver<MAssetType> implements GraphQLResolver<MAssetType> {


	static Map<String, String> ISDEPRECIABLE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetType.ISDEPRECIABLE_No, "6939008f-29e0-49b8-a30b-206b28c0d2b1");
			put(MAssetType.ISDEPRECIABLE__DefaultNo, "934235d6-5b13-477f-a2b9-0b194a048d91");
			put(MAssetType.ISDEPRECIABLE__, "44c8053c-dead-4cd4-97a8-920ef2aa7919");
			put(MAssetType.ISDEPRECIABLE__DefaultYes, "09f9094c-2674-4f58-878b-a32e5a38b4d4");
			put(MAssetType.ISDEPRECIABLE_Yes, "3392ad55-541f-4a2e-ba62-c92a28f6421d");
		}
	};
	public CompletableFuture<MRefList> IsDepreciable_RL(MAssetType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsDepreciable())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ISDEPRECIABLE_UUIDS_BY_VALUE.get(entity.getIsDepreciable()));
	}

	static Map<String, String> ISINPOSESSION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetType.ISINPOSESSION_No, "6939008f-29e0-49b8-a30b-206b28c0d2b1");
			put(MAssetType.ISINPOSESSION__DefaultNo, "934235d6-5b13-477f-a2b9-0b194a048d91");
			put(MAssetType.ISINPOSESSION__, "44c8053c-dead-4cd4-97a8-920ef2aa7919");
			put(MAssetType.ISINPOSESSION__DefaultYes, "09f9094c-2674-4f58-878b-a32e5a38b4d4");
			put(MAssetType.ISINPOSESSION_Yes, "3392ad55-541f-4a2e-ba62-c92a28f6421d");
		}
	};
	public CompletableFuture<MRefList> IsInPosession_RL(MAssetType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsInPosession())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ISINPOSESSION_UUIDS_BY_VALUE.get(entity.getIsInPosession()));
	}

	static Map<String, String> ISOWNED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAssetType.ISOWNED_No, "6939008f-29e0-49b8-a30b-206b28c0d2b1");
			put(MAssetType.ISOWNED__DefaultNo, "934235d6-5b13-477f-a2b9-0b194a048d91");
			put(MAssetType.ISOWNED__, "44c8053c-dead-4cd4-97a8-920ef2aa7919");
			put(MAssetType.ISOWNED__DefaultYes, "09f9094c-2674-4f58-878b-a32e5a38b4d4");
			put(MAssetType.ISOWNED_Yes, "3392ad55-541f-4a2e-ba62-c92a28f6421d");
		}
	};
	public CompletableFuture<MRefList> IsOwned_RL(MAssetType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsOwned())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ISOWNED_UUIDS_BY_VALUE.get(entity.getIsOwned()));
	}

}
