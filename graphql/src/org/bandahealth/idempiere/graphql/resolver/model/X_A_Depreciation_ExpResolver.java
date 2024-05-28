package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_AdditionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_DisposedDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_EntryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MAssetDisposed;
import org.compiere.model.MDepreciationEntry;
import org.compiere.model.MDepreciationExp;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ExpResolver extends POResolver<MDepreciationExp> implements GraphQLResolver<MDepreciationExp> {



	/**
	 * Get A_Account_Number_Acct.
	 *
	 * @return A_Account_Number_Acct
	 */
	public CompletableFuture<MAccount> A_Account_Number_A(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getA_Account_Number_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Account_Number_Acct());
	}


	/**
	 * Get Asset Addition.
	 *
	 * @return Asset Addition
	 */
	public CompletableFuture<MAssetAddition> A_Asset_Addition(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Addition_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAssetAddition> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_AdditionDataLoader.DATALOADER_A_Asset_Addition_BY_ID);
		return dataLoader.load(entity.getA_Asset_Addition_ID());
	}


	/**
	 * Get Asset Disposed.
	 *
	 * @return Asset Disposed
	 */
	public CompletableFuture<MAssetDisposed> A_Asset_Disposed(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Disposed_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAssetDisposed> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_DisposedDataLoader.DATALOADER_A_Asset_Disposed_BY_ID);
		return dataLoader.load(entity.getA_Asset_Disposed_ID());
	}


	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Depreciation Entry.
	 *
	 * @return Depreciation Entry
	 */
	public CompletableFuture<MDepreciationEntry> A_Depreciation_Entry(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Entry_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDepreciationEntry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_EntryDataLoader.DATALOADER_A_Depreciation_Entry_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Entry_ID());
	}

	public static Map<String, String> A_ENTRY_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DEP", "ac52889b-ad80-4c72-8a90-35eaf234de74"); // Depreciation
			put("DIS", "0775c222-fe4d-44bb-9ec1-6bccce458a83"); // Disposals
			put("FOR", "b8f42168-eb32-4eb2-beda-8d7e1f4cc9e6"); // Forecasts
			put("NEW", "1320a810-50d5-4b98-922b-6f04dea06cb8"); // New
			put("SPL", "5695ac1e-1cf6-4ef7-9255-16b9c6780643"); // Splits
			put("TRN", "52189c27-fea7-4c43-a88f-ca2a9b5511a0"); // Transfers
		}
	};
	public CompletableFuture<MRefList_BH> A_Entry_Type(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Entry_Type())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_ENTRY_TYPE_UUIDS_BY_VALUE.get(entity.getA_Entry_Type()));
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Account (credit).
	 *
	 * @return Account used
	 */
	public CompletableFuture<MAccount> CR_Account(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getCR_Account_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getCR_Account_ID());
	}


	/**
	 * Get Account (debit).
	 *
	 * @return Account used
	 */
	public CompletableFuture<MAccount> DR_Account(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (entity.getDR_Account_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getDR_Account_ID());
	}

	public Boolean IsDepreciated(MDepreciationExp entity, DataFetchingEnvironment environment) {
		return entity.isDepreciated();
	}

	public static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "3c9d051c-7b7b-459d-90c5-0925e26c1bcc"); // Actual
			put("B", "07bbb012-66f2-4860-bd6d-dc511618bf4e"); // Budget
			put("E", "c40ae7b1-be06-4291-ac88-59974f74a46d"); // Commitment
			put("S", "6011c5d4-edcc-48f6-ba32-8d820d42dbfb"); // Statistical
			put("R", "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5"); // Reservation
		}
	};
	public CompletableFuture<MRefList_BH> PostingType(MDepreciationExp entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(MDepreciationExp entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MDepreciationExp entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
