package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MRefList;
import org.compiere.model.X_AD_PrintColor;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_CategoryResolver extends POResolver<MProductCategory_BH> implements GraphQLResolver<MProductCategory_BH> {



	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public CompletableFuture<MAssetGroup> A_Asset_Group(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_GroupDataLoader.A_Asset_Group_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Group_ID());
	}


	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}

	static Map<String, String> BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Product, "305558d1-db4a-456f-9c25-057750949060");
			put(MProductCategory_BH.BH_PRODUCT_CATEGORY_TYPE_Service, "f3c40565-4bb3-4e82-b280-1ad24f6701cd");
		}
	};
	public CompletableFuture<MRefList> BH_Product_Category_Type_RL(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Product_Category_Type())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE.get(entity.getBH_Product_Category_Type()));
	}


	/**
	 * Get Parent Product Category.
	 *
	 * @return Parent Product Category
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category_Parent(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_Parent_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.M_Product_Category_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_Category_Parent_ID());
	}

	static Map<String, String> MMPOLICY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MProductCategory_BH.MMPOLICY_LiFo, "80bfacfa-9e34-4d5c-8388-5cb45e52447a");
			put(MProductCategory_BH.MMPOLICY_FiFo, "b1ed1550-7c2f-402b-b47a-b700929da0f6");
		}
	};
	public CompletableFuture<MRefList> MMPolicy_RL(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMMPolicy())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(MMPOLICY_UUIDS_BY_VALUE.get(entity.getMMPolicy()));
	}

}
