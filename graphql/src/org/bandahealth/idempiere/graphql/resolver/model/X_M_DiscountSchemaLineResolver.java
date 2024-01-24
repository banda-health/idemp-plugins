package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDiscountSchemaLine_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MConversionType;
import org.compiere.model.MDiscountSchema;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DiscountSchemaLineResolver extends POResolver<MDiscountSchemaLine_BH> implements GraphQLResolver<MDiscountSchemaLine_BH> {



	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public CompletableFuture<MConversionType> C_ConversionType(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_ID);
		return dataLoader.load(entity.getC_ConversionType_ID());
	}

	static Map<String, String> LIMIT_BASE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "beb709ae-f3e1-4676-ad84-7797413dabbd");
			put("S", "df8e7198-6afc-4ef9-b554-03ed39c0bad2");
			put("X", "753bc24a-1326-469e-93da-12a2f26a56b7");
			put("F", "f25dcd59-5b86-4c1c-9726-8e67314b4600");
			put("P", "ee848c2c-1648-441e-a33a-c064e6fb0203");
		}
	};
	public CompletableFuture<MRefList_BH> Limit_Base(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLimit_Base())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LIMIT_BASE_UUIDS_BY_VALUE.get(entity.getLimit_Base()));
	}

	static Map<String, String> LIMIT_ROUNDING_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "d947c735-65a8-4b1f-960c-a4d2a63cc663");
			put("N", "279cb596-30b2-4a11-8fdc-37408a37ddfa");
			put("Q", "30879b2a-aba5-4b76-8ca0-bbdbc3414307");
			put("D", "de17b304-e631-449f-9e1a-c8e4d59123ce");
			put("5", "0881dcb9-13a7-4a04-a0fb-16f87149e2bf");
			put("T", "0c47d731-fe62-47b2-9826-cd21cfc037d3");
			put("C", "853bbe37-2507-4937-a6db-14558eeb9074");
			put("9", "3115f091-a1e7-451f-9c89-6d00f106891b");
			put("h", "db44cf2a-5e62-42de-b714-2871757c2d81");
			put("t", "ed450a1b-e56a-4101-be04-2936d85fae0a");
		}
	};
	public CompletableFuture<MRefList_BH> Limit_Rounding(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLimit_Rounding())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LIMIT_ROUNDING_UUIDS_BY_VALUE.get(entity.getLimit_Rounding()));
	}

	static Map<String, String> LIST_BASE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "beb709ae-f3e1-4676-ad84-7797413dabbd");
			put("S", "df8e7198-6afc-4ef9-b554-03ed39c0bad2");
			put("X", "753bc24a-1326-469e-93da-12a2f26a56b7");
			put("F", "f25dcd59-5b86-4c1c-9726-8e67314b4600");
			put("P", "ee848c2c-1648-441e-a33a-c064e6fb0203");
		}
	};
	public CompletableFuture<MRefList_BH> List_Base(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getList_Base())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LIST_BASE_UUIDS_BY_VALUE.get(entity.getList_Base()));
	}

	static Map<String, String> LIST_ROUNDING_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "d947c735-65a8-4b1f-960c-a4d2a63cc663");
			put("N", "279cb596-30b2-4a11-8fdc-37408a37ddfa");
			put("Q", "30879b2a-aba5-4b76-8ca0-bbdbc3414307");
			put("D", "de17b304-e631-449f-9e1a-c8e4d59123ce");
			put("5", "0881dcb9-13a7-4a04-a0fb-16f87149e2bf");
			put("T", "0c47d731-fe62-47b2-9826-cd21cfc037d3");
			put("C", "853bbe37-2507-4937-a6db-14558eeb9074");
			put("9", "3115f091-a1e7-451f-9c89-6d00f106891b");
			put("h", "db44cf2a-5e62-42de-b714-2871757c2d81");
			put("t", "ed450a1b-e56a-4101-be04-2936d85fae0a");
		}
	};
	public CompletableFuture<MRefList_BH> List_Rounding(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getList_Rounding())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LIST_ROUNDING_UUIDS_BY_VALUE.get(entity.getList_Rounding()));
	}


	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> M_DiscountSchema(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_DiscountSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getM_DiscountSchema_ID());
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	static Map<String, String> STD_BASE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "beb709ae-f3e1-4676-ad84-7797413dabbd");
			put("S", "df8e7198-6afc-4ef9-b554-03ed39c0bad2");
			put("X", "753bc24a-1326-469e-93da-12a2f26a56b7");
			put("F", "f25dcd59-5b86-4c1c-9726-8e67314b4600");
			put("P", "ee848c2c-1648-441e-a33a-c064e6fb0203");
		}
	};
	public CompletableFuture<MRefList_BH> Std_Base(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getStd_Base())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(STD_BASE_UUIDS_BY_VALUE.get(entity.getStd_Base()));
	}

	static Map<String, String> STD_ROUNDING_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "d947c735-65a8-4b1f-960c-a4d2a63cc663");
			put("N", "279cb596-30b2-4a11-8fdc-37408a37ddfa");
			put("Q", "30879b2a-aba5-4b76-8ca0-bbdbc3414307");
			put("D", "de17b304-e631-449f-9e1a-c8e4d59123ce");
			put("5", "0881dcb9-13a7-4a04-a0fb-16f87149e2bf");
			put("T", "0c47d731-fe62-47b2-9826-cd21cfc037d3");
			put("C", "853bbe37-2507-4937-a6db-14558eeb9074");
			put("9", "3115f091-a1e7-451f-9c89-6d00f106891b");
			put("h", "db44cf2a-5e62-42de-b714-2871757c2d81");
			put("t", "ed450a1b-e56a-4101-be04-2936d85fae0a");
		}
	};
	public CompletableFuture<MRefList_BH> Std_Rounding(MDiscountSchemaLine_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getStd_Rounding())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(STD_ROUNDING_UUIDS_BY_VALUE.get(entity.getStd_Rounding()));
	}

}
