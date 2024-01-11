package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBOM;
import org.compiere.model.MChangeNotice;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_BOMResolver extends POResolver<MBOM> implements GraphQLResolver<MBOM> {


	static Map<String, String> BOMTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f40468ef-872e-4574-b9b5-bc09de25cd73");
			put("O", "88526daf-69bd-4cb5-af6e-ea120ed2555c");
			put("P", "e422ef8f-51be-49d2-b4bc-51e5626fca87");
			put("S", "db19dec2-6c7f-4896-ae47-c1f7898ae2e0");
			put("F", "c3eaeaa0-6177-4a38-880f-5c34910333f9");
			put("M", "bd5822f8-5b30-4cc4-99e1-998c575dab53");
			put("R", "28a5712a-519d-434c-932f-71a8e4a02d45");
			put("C", "d7036054-47a8-4af4-9045-1892c8a563ad");
			put("K", "3af80a33-db74-4f76-84a4-455286ffdba6");
		}
	};
	public CompletableFuture<MRefList_BH> BOMType(MBOM entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBOMType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BOMTYPE_UUIDS_BY_VALUE.get(entity.getBOMType()));
	}

	static Map<String, String> BOMUSE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "082b2656-8fb0-4e2a-9611-67ed7f9bdbd0");
			put("E", "c4ef1193-68f0-478c-b6bb-e1705fcd99e0");
			put("M", "051be6e2-b091-4e8b-989c-1cb41affbece");
			put("P", "b7cf6bb8-a498-4d35-b129-6059068df61d");
			put("Q", "db8fbc75-98b8-4229-b487-e848f6bec73e");
		}
	};
	public CompletableFuture<MRefList_BH> BOMUse(MBOM entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBOMUse())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BOMUSE_UUIDS_BY_VALUE.get(entity.getBOMUse()));
	}


	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	public CompletableFuture<MChangeNotice> M_ChangeNotice(MBOM entity, DataFetchingEnvironment environment) {
		if (entity.getM_ChangeNotice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.M_ChangeNotice_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_ChangeNotice_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MBOM entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processing(MBOM entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
