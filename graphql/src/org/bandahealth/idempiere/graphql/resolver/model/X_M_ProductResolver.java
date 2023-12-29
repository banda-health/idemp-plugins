package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecognitionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SubscriptionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_FreightCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PartTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ExpenseTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MExpenseType;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MLocator;
import org.compiere.model.MMailText;
import org.compiere.model.MRefList;
import org.compiere.model.MResource;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.X_C_SubscriptionType;
import org.compiere.model.X_M_PartType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductResolver extends POResolver<MProduct_BH> implements GraphQLResolver<MProduct_BH> {


	static Map<String, String> BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MProduct_BH.BH_PRODUCT_CATEGORY_TYPE_Product, "305558d1-db4a-456f-9c25-057750949060");
			put(MProduct_BH.BH_PRODUCT_CATEGORY_TYPE_Service, "f3c40565-4bb3-4e82-b280-1ad24f6701cd");
		}
	};
	public CompletableFuture<MRefList> BH_Product_Category_Type_RL(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Product_Category_Type())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE.get(entity.getBH_Product_Category_Type()));
	}


	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	public CompletableFuture<MRevenueRecognition> C_RevenueRecognition(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_RevenueRecognition_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRevenueRecognition> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RevenueRecognitionDataLoader.C_RevenueRecognition_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_RevenueRecognition_ID());
	}


	/**
	 * Get Subscription Type.
	 *
	 * @return Type of subscription
	 */
	public CompletableFuture<X_C_SubscriptionType> C_SubscriptionType(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_SubscriptionType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_SubscriptionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SubscriptionTypeDataLoader.C_SubscriptionType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_SubscriptionType_ID());
	}


	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public CompletableFuture<MTaxCategory> C_TaxCategory(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxCategory_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTaxCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxCategoryDataLoader.C_TaxCategory_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_TaxCategory_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.C_UOM_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_UOM_ID());
	}


	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	public CompletableFuture<MAttributeSet_BH> M_AttributeSet(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSet_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetDataLoader.M_AttributeSet_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSet_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	public CompletableFuture<MFreightCategory> M_FreightCategory(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_FreightCategory_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MFreightCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_FreightCategoryDataLoader.M_FreightCategory_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_FreightCategory_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.M_Locator_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Part Type.
	 *
	 * @return Part Type
	 */
	public CompletableFuture<X_M_PartType> M_PartType(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_PartType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_PartType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PartTypeDataLoader.M_PartType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_PartType_ID());
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.M_Product_Category_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}

	static Map<String, String> PRODUCTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MProduct_BH.PRODUCTTYPE_Item, "59dcc5c9-ab37-4f5c-9987-6e2347f50093");
			put(MProduct_BH.PRODUCTTYPE_Service, "265e0369-47e4-4be9-b6d5-e344230f5588");
			put(MProduct_BH.PRODUCTTYPE_Resource, "42694712-fdf0-42ec-aa93-bf19009c3a98");
			put(MProduct_BH.PRODUCTTYPE_ExpenseType, "6a973557-0387-4173-8b31-af735b9eeb75");
			put(MProduct_BH.PRODUCTTYPE_Online, "8de4f3a8-057c-4540-96d8-38369776b2e7");
			put(MProduct_BH.PRODUCTTYPE_Asset, "a45dcc33-c973-4744-955e-dd24518ef099");
		}
	};
	public CompletableFuture<MRefList> ProductType_RL(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProductType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PRODUCTTYPE_UUIDS_BY_VALUE.get(entity.getProductType()));
	}


	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	public CompletableFuture<MMailText> R_MailText(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getR_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getR_MailText_ID());
	}


	/**
	 * Get Expense Type.
	 *
	 * @return Expense report type
	 */
	public CompletableFuture<MExpenseType> S_ExpenseType(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getS_ExpenseType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MExpenseType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ExpenseTypeDataLoader.S_ExpenseType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getS_ExpenseType_ID());
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.S_Resource_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getS_Resource_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
