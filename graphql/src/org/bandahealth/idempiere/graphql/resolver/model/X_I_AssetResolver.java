package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_Table_HeaderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.model.X_I_Asset;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_AssetResolver extends POResolver<X_I_Asset> implements GraphQLResolver<X_I_Asset> {



	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	public CompletableFuture<MAccount> A_Accumdepreciation_A(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Accumdepreciation_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Accumdepreciation_Acct());
	}


	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	public CompletableFuture<MAccount> A_Asset_A(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Asset_Acct());
	}


	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public CompletableFuture<MAssetGroup> A_Asset_Group(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Group_ID() < 0) {
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
	public CompletableFuture<MAsset> A_Asset(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	public CompletableFuture<MAccount> A_Depreciation_A(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Acct());
	}

	static Map<String, String> A_DEPRECIATION_MANUAL_PERIOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PR", "35e7efb6-c084-458c-89e6-bdeeb3757add");
			put("YR", "d34572f8-bbc3-4768-9662-8ae6f48f7398");
		}
	};
	public CompletableFuture<MRefList_BH> A_Depreciation_Manual_Period(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Depreciation_Manual_Period())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_DEPRECIATION_MANUAL_PERIOD_UUIDS_BY_VALUE.get(entity.getA_Depreciation_Manual_Period()));
	}


	/**
	 * Get A_Depreciation_Table_Header_ID.
	 *
	 * @return A_Depreciation_Table_Header_ID
	 */
	public CompletableFuture<X_A_Depreciation_Table_Header> A_Depreciation_Table_Header(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Table_Header_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_A_Depreciation_Table_Header> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_Table_HeaderDataLoader.DATALOADER_A_Depreciation_Table_Header_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Table_Header_ID());
	}

	static Map<String, String> A_REVAL_CAL_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DFT", "c11a5c1d-7b50-4462-92f3-5fd512c7c3f9");
			put("IDF", "82c0032e-1d8f-4001-b365-39f9a8cc2b05");
			put("YBF", "2e54c6d4-f45a-474c-b4ab-6c7679f913dd");
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Cal_Method(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Cal_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_REVAL_CAL_METHOD_UUIDS_BY_VALUE.get(entity.getA_Reval_Cal_Method()));
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}

	public Boolean I_IsImported(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsDepreciated(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isDepreciated();
	}

	public Boolean IsDisposed(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isDisposed();
	}

	public Boolean IsFullyDepreciated(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isFullyDepreciated();
	}

	public Boolean IsInPosession(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isInPosession();
	}

	public Boolean IsOwned(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isOwned();
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() < 0) {
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
	public CompletableFuture<MProduct_BH> M_Product(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "3c9d051c-7b7b-459d-90c5-0925e26c1bcc");
			put("B", "07bbb012-66f2-4860-bd6d-dc511618bf4e");
			put("E", "c40ae7b1-be06-4291-ac88-59974f74a46d");
			put("S", "6011c5d4-edcc-48f6-ba32-8d820d42dbfb");
			put("R", "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5");
		}
	};
	public CompletableFuture<MRefList_BH> PostingType(X_I_Asset entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_Asset entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
