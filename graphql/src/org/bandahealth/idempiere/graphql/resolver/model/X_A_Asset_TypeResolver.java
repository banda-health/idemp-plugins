package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAssetType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_TypeResolver extends POResolver<MAssetType> implements GraphQLResolver<MAssetType> {


	static Map<String, String> ISDEPRECIABLE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("NX", "6939008f-29e0-49b8-a30b-206b28c0d2b1");
			put("XN", "934235d6-5b13-477f-a2b9-0b194a048d91");
			put("XX", "44c8053c-dead-4cd4-97a8-920ef2aa7919");
			put("XY", "09f9094c-2674-4f58-878b-a32e5a38b4d4");
			put("YX", "3392ad55-541f-4a2e-ba62-c92a28f6421d");
		}
	};
	public CompletableFuture<MRefList_BH> IsDepreciable(MAssetType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsDepreciable())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISDEPRECIABLE_UUIDS_BY_VALUE.get(entity.getIsDepreciable()));
	}

	static Map<String, String> ISINPOSESSION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("NX", "6939008f-29e0-49b8-a30b-206b28c0d2b1");
			put("XN", "934235d6-5b13-477f-a2b9-0b194a048d91");
			put("XX", "44c8053c-dead-4cd4-97a8-920ef2aa7919");
			put("XY", "09f9094c-2674-4f58-878b-a32e5a38b4d4");
			put("YX", "3392ad55-541f-4a2e-ba62-c92a28f6421d");
		}
	};
	public CompletableFuture<MRefList_BH> IsInPosession(MAssetType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsInPosession())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISINPOSESSION_UUIDS_BY_VALUE.get(entity.getIsInPosession()));
	}

	static Map<String, String> ISOWNED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("NX", "6939008f-29e0-49b8-a30b-206b28c0d2b1");
			put("XN", "934235d6-5b13-477f-a2b9-0b194a048d91");
			put("XX", "44c8053c-dead-4cd4-97a8-920ef2aa7919");
			put("XY", "09f9094c-2674-4f58-878b-a32e5a38b4d4");
			put("YX", "3392ad55-541f-4a2e-ba62-c92a28f6421d");
		}
	};
	public CompletableFuture<MRefList_BH> IsOwned(MAssetType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsOwned())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ISOWNED_UUIDS_BY_VALUE.get(entity.getIsOwned()));
	}

}
