package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MRefList;
import org.compiere.model.MTable;
import org.compiere.model.MTree;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeResolver extends POResolver<MTree> implements GraphQLResolver<MTree> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MTree entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Parent Column.
	 *
	 * @return The link column on the parent tab.
	 */
	public CompletableFuture<MColumn> Parent_Column(MTree entity, DataFetchingEnvironment environment) {
		if (entity.getParent_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.AD_Column_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getParent_Column_ID());
	}

	static Map<String, String> TREETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MTree.TREETYPE_Menu, "0dcfd07d-f885-4f79-9194-f256bf1ea807");
			put(MTree.TREETYPE_ElementValue, "014075e9-9b8b-46d5-bb83-f6c29dc0c763");
			put(MTree.TREETYPE_Product, "68e43e9b-c46b-48f0-966f-4a4dedcb84bc");
			put(MTree.TREETYPE_BPartner, "0907c659-2c7f-485e-a236-477b9b849397");
			put(MTree.TREETYPE_Organization, "e21a0bfc-011f-4690-a3ba-eed8d24dae19");
			put(MTree.TREETYPE_BoM, "72d7e237-05ba-447b-bf9f-dbcf2a9bc482");
			put(MTree.TREETYPE_Project, "5540058a-ec17-4cff-a6c6-cb943878e968");
			put(MTree.TREETYPE_SalesRegion, "3de4e109-aed1-4f32-868f-96cba3c91da6");
			put(MTree.TREETYPE_ProductCategory, "14539232-abdd-42bd-b6c3-132d011d2857");
			put(MTree.TREETYPE_Campaign, "bc91ebeb-ba58-49ef-89e4-195f8276a970");
			put(MTree.TREETYPE_Activity, "d3f37af4-117a-4779-8139-07db85a364c5");
			put(MTree.TREETYPE_User1, "35eab149-ef9e-4a9f-ac93-3d5b7574e949");
			put(MTree.TREETYPE_User2, "5aa01eed-2cc8-4355-ade7-66e37738f49a");
			put(MTree.TREETYPE_User3, "af168306-1163-4337-9f29-378a52c87a60");
			put(MTree.TREETYPE_User4, "699f7547-0963-4198-84d9-f043aeeb500d");
			put(MTree.TREETYPE_CMContainer, "2425675e-01d8-4a23-9d66-9d0fcd5a9cdf");
			put(MTree.TREETYPE_CMContainerStage, "8a248f85-1fe8-4b66-81f0-1afaaa4e0305");
			put(MTree.TREETYPE_CMTemplate, "a5aacd18-70dc-4cf6-92b9-cf7867524506");
			put(MTree.TREETYPE_CMMedia, "423bfa47-8441-4403-a0b3-b290a8f98db2");
			put(MTree.TREETYPE_CustomTable, "e3104c45-9a71-4ea1-bd24-9125d33f07db");
		}
	};
	public CompletableFuture<MRefList> TreeType_RL(MTree entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTreeType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(TREETYPE_UUIDS_BY_VALUE.get(entity.getTreeType()));
	}

}
