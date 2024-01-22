package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_Category_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAssetGroup;
import org.compiere.model.PO;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_GroupDataLoader.DATALOADER_A_Asset_Group_BY_ID);
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
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.DATALOADER_AD_PrintColor_BY_ID);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}

	static Map<String, String> BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "305558d1-db4a-456f-9c25-057750949060");
			put("S", "f3c40565-4bb3-4e82-b280-1ad24f6701cd");
		}
	};
	public CompletableFuture<MRefList_BH> BH_Product_Category_Type(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Product_Category_Type())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE.get(entity.getBH_Product_Category_Type()));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_Category_TrlDataLoader.DATALOADER_M_Product_Category_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MProductCategory_BH.COLUMNNAME_Description));
	}

	public Boolean IsDefault(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsSelfService(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_Parent_ID());
	}

	static Map<String, String> MMPOLICY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "80bfacfa-9e34-4d5c-8388-5cb45e52447a");
			put("F", "b1ed1550-7c2f-402b-b47a-b700929da0f6");
		}
	};
	public CompletableFuture<MRefList_BH> MMPolicy(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMMPolicy())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(MMPOLICY_UUIDS_BY_VALUE.get(entity.getMMPolicy()));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MProductCategory_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_Category_TrlDataLoader.DATALOADER_M_Product_Category_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MProductCategory_BH.COLUMNNAME_Name));
	}

}
