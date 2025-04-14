package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_ClassDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_TypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.MCity;
import org.compiere.model.MIFixedAsset;
import org.compiere.model.MLocator;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_FixedAssetResolver extends POResolver<MIFixedAsset> implements GraphQLResolver<MIFixedAsset> {



	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	public CompletableFuture<MAssetClass> A_Asset_Class(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Class_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAssetClass> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_ClassDataLoader.DATALOADER_A_Asset_Class_BY_ID);
		return dataLoader.load(entity.getA_Asset_Class_ID());
	}


	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public CompletableFuture<MAssetGroup> A_Asset_Group(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Group_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAssetGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_GroupDataLoader.DATALOADER_A_Asset_Group_BY_ID);
		return dataLoader.load(entity.getA_Asset_Group_ID());
	}


	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	public CompletableFuture<MAssetType> A_Asset_Type(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Type_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAssetType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_TypeDataLoader.DATALOADER_A_Asset_Type_BY_ID);
		return dataLoader.load(entity.getA_Asset_Type_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	public CompletableFuture<MBPartner_BH> C_BPartnerSR(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartnerSR_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartnerSR_ID());
	}


	/**
	 * Get City.
	 *
	 * @return City
	 */
	public CompletableFuture<MCity> C_City(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_City_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CityDataLoader.DATALOADER_C_City_BY_ID);
		return dataLoader.load(entity.getC_City_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	public static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da"); // Complete
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169"); // Approve
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354"); // Reject
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9"); // Post
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3"); // Void
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0"); // Close
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6"); // Reverse - Correct
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8"); // Reverse - Accrual
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf"); // Invalidate
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260"); // Re-activate
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591"); // <None>
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76"); // Prepare
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5"); // Unlock
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0"); // Wait Complete
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	public Boolean I_IsImported(MIFixedAsset entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MIFixedAsset entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processed(MIFixedAsset entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MIFixedAsset entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
