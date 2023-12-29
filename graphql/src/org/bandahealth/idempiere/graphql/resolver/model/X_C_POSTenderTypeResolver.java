package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.model.X_C_POSTenderType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSTenderTypeResolver extends POResolver<X_C_POSTenderType> implements GraphQLResolver<X_C_POSTenderType> {


	static Map<String, String> TENDERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "d3874573-b7bf-4556-9b9c-3644698c959e");
			put("K", "900adbf9-5069-4f56-9d97-0313c6372af3");
			put("A", "220f3864-24b8-42ba-9a91-a247f4697530");
			put("D", "487227e8-c88e-45ef-8e6d-c0a480fdd0de");
			put("T", "bd6f5227-483d-4bcf-b1fe-a840a3142327");
			put("X", "52c6c5a6-83ce-48c4-b874-721f8cd4e66b");
			put("M", "7a78334e-3494-4d40-a718-c42cb053eea6");
			put("B", "ade64e84-cd1b-43bc-a85c-c17a14963305");
			put("L", "7449ae78-c7d3-463b-921e-62a82a5e1a59");
			put("N", "28617687-cb93-494a-8f03-bc453da32658");
			put("F", "e24511d1-9180-491c-9cc6-354b8a08e1ff");
			put("i", "5b4b4fcf-85c0-4d7c-851d-ab0db2e84b6d");
			put("G", "bb077404-71a4-4348-9afa-2b99ae9e1381");
			put("H", "55df64a7-1c7f-43f2-846b-f542c9cafa45");
			put("O", "4caa3109-804f-4773-8115-9bdb116f329b");
			put("V", "52fc8585-3c61-45b8-a0dd-db10c1e7d79c");
			put("P", "64e8ad21-7c9d-442b-9655-f5223d76140c");
			put("U", "97e54f17-fbae-40de-8dbd-e8ad7f884732");
		}
	};
	public CompletableFuture<MRefList> TenderType_RL(X_C_POSTenderType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTenderType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(TENDERTYPE_UUIDS_BY_VALUE.get(entity.getTenderType()));
	}

}
