package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_AcctDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAcct;
import org.compiere.model.MAssetTransfer;
import org.compiere.model.MPeriod;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_TransferResolver extends POResolver<MAssetTransfer> implements GraphQLResolver<MAssetTransfer> {



	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	public CompletableFuture<MAccount> A_Accumdepreciation_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Accumdepreciation_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Accumdepreciation_Acct());
	}


	/**
	 * Get Accumulated Depreciation Account (new).
	 *
	 * @return Accumulated Depreciation Account (new)
	 */
	public CompletableFuture<MAccount> A_Accumdepreciation_New_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Accumdepreciation_New_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Accumdepreciation_New_Acct());
	}


	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	public CompletableFuture<MAccount> A_Asset_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Asset_Acct());
	}


	/**
	 * Get A_Asset_Acct_ID.
	 *
	 * @return A_Asset_Acct_ID
	 */
	public CompletableFuture<MAssetAcct> A_Asset_Acct(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Acct_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_AcctDataLoader.DATALOADER_A_Asset_Acct_BY_ID);
		return dataLoader.load(entity.getA_Asset_Acct_ID());
	}


	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Asset Acct (new).
	 *
	 * @return Asset Acct (new)
	 */
	public CompletableFuture<MAccount> A_Asset_New_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_New_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Asset_New_Acct());
	}

	static Map<String, String> A_CAPVSEXP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Cap", "f494c22f-2ce5-471d-aabb-887f528c60da");
			put("Exp", "4a84ac91-9720-40a2-8529-6a139dabb96a");
		}
	};
	public CompletableFuture<MRefList_BH> A_CapvsExp(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_CapvsExp())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_CAPVSEXP_UUIDS_BY_VALUE.get(entity.getA_CapvsExp()));
	}


	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	public CompletableFuture<MAccount> A_Depreciation_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Acct());
	}


	/**
	 * Get Depreciation Acct (new).
	 *
	 * @return Depreciation Acct (new)
	 */
	public CompletableFuture<MAccount> A_Depreciation_New_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_New_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_New_Acct());
	}


	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	public CompletableFuture<MAccount> A_Disposal_Loss_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Loss_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Disposal_Loss_Acct());
	}


	/**
	 * Get Disposal Loss Acct (new).
	 *
	 * @return Disposal Loss Acct (new)
	 */
	public CompletableFuture<MAccount> A_Disposal_Loss_New_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Loss_New_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Disposal_Loss_New_Acct());
	}


	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	public CompletableFuture<MAccount> A_Disposal_Revenue_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Revenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Disposal_Revenue_Acct());
	}


	/**
	 * Get Disposal Revenue Acct (new).
	 *
	 * @return Disposal Revenue Acct (new)
	 */
	public CompletableFuture<MAccount> A_Disposal_Revenue_New_A(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Revenue_New_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Disposal_Revenue_New_Acct());
	}

	public Boolean A_Transfer_Balance(MAssetTransfer entity, DataFetchingEnvironment environment) {
		return entity.isA_Transfer_Balance();
	}

	public Boolean A_Transfer_Balance_IS(MAssetTransfer entity, DataFetchingEnvironment environment) {
		return entity.isA_Transfer_Balance_IS();
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169");
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260");
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	public Boolean Posted(MAssetTransfer entity, DataFetchingEnvironment environment) {
		return entity.isPosted();
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
	public CompletableFuture<MRefList_BH> PostingType(MAssetTransfer entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(MAssetTransfer entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MAssetTransfer entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
