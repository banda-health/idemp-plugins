package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
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
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ExpenseTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MExpenseType;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MLocator;
import org.compiere.model.MMailText;
import org.compiere.model.MResource;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.PO;
import org.compiere.model.X_C_SubscriptionType;
import org.compiere.model.X_M_PartType;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ProductResolver extends POResolver<MProduct_BH> implements GraphQLResolver<MProduct_BH> {



	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}

	public int bh_reorder_level(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.getbh_reorder_level();
	}

	public int bh_reorder_quantity(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.getbh_reorder_quantity();
	}


	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	public CompletableFuture<MRevenueRecognition> C_RevenueRecognition(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_RevenueRecognition_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRevenueRecognition> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RevenueRecognitionDataLoader.DATALOADER_C_RevenueRecognition_BY_ID);
		return dataLoader.load(entity.getC_RevenueRecognition_ID());
	}


	/**
	 * Get Subscription Type.
	 *
	 * @return Type of subscription
	 */
	public CompletableFuture<X_C_SubscriptionType> C_SubscriptionType(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_SubscriptionType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_SubscriptionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SubscriptionTypeDataLoader.DATALOADER_C_SubscriptionType_BY_ID);
		return dataLoader.load(entity.getC_SubscriptionType_ID());
	}


	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public CompletableFuture<MTaxCategory> C_TaxCategory(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxCategory_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTaxCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxCategoryDataLoader.DATALOADER_C_TaxCategory_BY_ID);
		return dataLoader.load(entity.getC_TaxCategory_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_TrlDataLoader.DATALOADER_M_Product_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MProduct_BH.COLUMNNAME_Description) :
						entity.getDescription());
	}

	public Boolean Discontinued(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isDiscontinued();
	}

	/**
	 * Get Document Note.
	 *
	 * @return Additional information for a Document
	 */
	public CompletableFuture<String> DocumentNote(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDocumentNote);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_TrlDataLoader.DATALOADER_M_Product_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MProduct_BH.COLUMNNAME_DocumentNote) :
						entity.getDocumentNote());
	}

	public Boolean IsAutoProduce(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isAutoProduce();
	}

	public Boolean IsBOM(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isBOM();
	}

	public Boolean IsDropShip(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isDropShip();
	}

	public Boolean IsExcludeAutoDelivery(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isExcludeAutoDelivery();
	}

	public Boolean IsInvoicePrintDetails(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isInvoicePrintDetails();
	}

	public Boolean IsKanban(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isKanban();
	}

	public Boolean IsManufactured(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isManufactured();
	}

	public Boolean IsOwnBox(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isOwnBox();
	}

	public Boolean IsPhantom(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isPhantom();
	}

	public Boolean IsPickListPrintDetails(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isPickListPrintDetails();
	}

	public Boolean IsPurchased(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isPurchased();
	}

	public Boolean IsSelfService(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

	public Boolean IsSold(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isSold();
	}

	public Boolean IsStocked(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isStocked();
	}

	public Boolean IsSummary(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	public Boolean istoformule(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.istoformule();
	}

	public Boolean IsVerified(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isVerified();
	}

	public Boolean IsWebStoreFeatured(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isWebStoreFeatured();
	}


	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	public CompletableFuture<MAttributeSet_BH> M_AttributeSet(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSet_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSet_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetDataLoader.DATALOADER_M_AttributeSet_BY_ID);
		return dataLoader.load(entity.getM_AttributeSet_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	public CompletableFuture<MFreightCategory> M_FreightCategory(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_FreightCategory_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MFreightCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_FreightCategoryDataLoader.DATALOADER_M_FreightCategory_BY_ID);
		return dataLoader.load(entity.getM_FreightCategory_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Part Type.
	 *
	 * @return Part Type
	 */
	public CompletableFuture<X_M_PartType> M_PartType(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_PartType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_M_PartType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PartTypeDataLoader.DATALOADER_M_PartType_BY_ID);
		return dataLoader.load(entity.getM_PartType_ID());
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_TrlDataLoader.DATALOADER_M_Product_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MProduct_BH.COLUMNNAME_Name) :
						entity.getName());
	}

	public Boolean Processing(MProduct_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public static Map<String, String> PRODUCTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "59dcc5c9-ab37-4f5c-9987-6e2347f50093"); // Item
			put("S", "265e0369-47e4-4be9-b6d5-e344230f5588"); // Service
			put("R", "42694712-fdf0-42ec-aa93-bf19009c3a98"); // Resource
			put("E", "6a973557-0387-4173-8b31-af735b9eeb75"); // Expense type
			put("O", "8de4f3a8-057c-4540-96d8-38369776b2e7"); // Online
			put("A", "a45dcc33-c973-4744-955e-dd24518ef099"); // Asset
		}
	};
	public CompletableFuture<MRefList_BH> ProductType(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProductType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PRODUCTTYPE_UUIDS_BY_VALUE.get(entity.getProductType()));
	}


	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	public CompletableFuture<MMailText> R_MailText(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getR_MailText_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.DATALOADER_R_MailText_BY_ID);
		return dataLoader.load(entity.getR_MailText_ID());
	}


	/**
	 * Get Expense Type.
	 *
	 * @return Expense report type
	 */
	public CompletableFuture<MExpenseType> S_ExpenseType(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getS_ExpenseType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MExpenseType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ExpenseTypeDataLoader.DATALOADER_S_ExpenseType_BY_ID);
		return dataLoader.load(entity.getS_ExpenseType_ID());
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.DATALOADER_S_Resource_BY_ID);
		return dataLoader.load(entity.getS_Resource_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MProduct_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
