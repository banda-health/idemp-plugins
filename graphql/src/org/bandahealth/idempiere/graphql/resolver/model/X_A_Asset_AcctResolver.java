package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_DepreciationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_ConventionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_MethodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_Table_HeaderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAcct;
import org.compiere.model.MDepreciation;
import org.compiere.model.MDepreciationConvention;
import org.compiere.model.MDepreciationMethod;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_AcctResolver extends POResolver<MAssetAcct> implements GraphQLResolver<MAssetAcct> {



	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	public CompletableFuture<MAccount> A_Accumdepreciation_A(MAssetAcct entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAccount> A_Asset_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Asset_Acct());
	}


	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MAssetAcct entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MAccount> A_Depreciation_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Acct());
	}


	/**
	 * Get Depreciation Convention (fiscal).
	 *
	 * @return Depreciation Convention (fiscal)
	 */
	public CompletableFuture<MDepreciationConvention> A_Depreciation_Conv_F(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Conv_F_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDepreciationConvention> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_ConventionDataLoader.DATALOADER_A_Depreciation_Convention_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Conv_F_ID());
	}


	/**
	 * Get Convention Type.
	 *
	 * @return Convention Type
	 */
	public CompletableFuture<MDepreciationConvention> A_Depreciation_Conv(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Conv_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDepreciationConvention> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_ConventionDataLoader.DATALOADER_A_Depreciation_Convention_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Conv_ID());
	}


	/**
	 * Get Depreciation (fiscal).
	 *
	 * @return Depreciation (fiscal)
	 */
	public CompletableFuture<MDepreciation> A_Depreciation_F(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_F_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDepreciation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_DepreciationDataLoader.DATALOADER_A_Depreciation_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_F_ID());
	}


	/**
	 * Get Depreciation.
	 *
	 * @return Depreciation
	 */
	public CompletableFuture<MDepreciation> A_Depreciation(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDepreciation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_DepreciationDataLoader.DATALOADER_A_Depreciation_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_ID());
	}

	public static Map<String, String> A_DEPRECIATION_MANUAL_PERIOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PR", "35e7efb6-c084-458c-89e6-bdeeb3757add"); // Period
			put("YR", "d34572f8-bbc3-4768-9662-8ae6f48f7398"); // Yearly
		}
	};
	public CompletableFuture<MRefList_BH> A_Depreciation_Manual_Period(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Depreciation_Manual_Period())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_DEPRECIATION_MANUAL_PERIOD_UUIDS_BY_VALUE.get(entity.getA_Depreciation_Manual_Period()));
	}


	/**
	 * Get Depreciation Method (fiscal).
	 *
	 * @return Depreciation Method (fiscal)
	 */
	public CompletableFuture<MDepreciationMethod> A_Depreciation_Method_F(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Method_F_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDepreciationMethod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_MethodDataLoader.DATALOADER_A_Depreciation_Method_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Method_F_ID());
	}


	/**
	 * Get Depreciation Method.
	 *
	 * @return Depreciation Method
	 */
	public CompletableFuture<MDepreciationMethod> A_Depreciation_Method(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Method_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDepreciationMethod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_MethodDataLoader.DATALOADER_A_Depreciation_Method_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Method_ID());
	}


	/**
	 * Get A_Depreciation_Table_Header_ID.
	 *
	 * @return A_Depreciation_Table_Header_ID
	 */
	public CompletableFuture<X_A_Depreciation_Table_Header> A_Depreciation_Table_Header(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Table_Header_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_A_Depreciation_Table_Header> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_Table_HeaderDataLoader.DATALOADER_A_Depreciation_Table_Header_BY_ID);
		return dataLoader.load(entity.getA_Depreciation_Table_Header_ID());
	}


	/**
	 * Get Disposal Gain Acct.
	 *
	 * @return Disposal Gain Acct
	 */
	public CompletableFuture<MAccount> A_Disposal_Gain_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Gain_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Disposal_Gain_Acct());
	}


	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	public CompletableFuture<MAccount> A_Disposal_Loss_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Loss_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Disposal_Loss_Acct());
	}


	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	public CompletableFuture<MAccount> A_Disposal_Revenue_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Revenue_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Disposal_Revenue_Acct());
	}


	/**
	 * Get A_Reval_Accumdep_Offset_Cur.
	 *
	 * @return A_Reval_Accumdep_Offset_Cur
	 */
	public CompletableFuture<MAccount> A_Reval_Adep_Offset_Cur_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Reval_Adep_Offset_Cur_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Reval_Adep_Offset_Cur_Acct());
	}


	/**
	 * Get A_Reval_Accumdep_Offset_Prior.
	 *
	 * @return A_Reval_Accumdep_Offset_Prior
	 */
	public CompletableFuture<MAccount> A_Reval_Adep_Offset_Prior_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Reval_Adep_Offset_Prior_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Reval_Adep_Offset_Prior_Acct());
	}

	public static Map<String, String> A_REVAL_CAL_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DFT", "c11a5c1d-7b50-4462-92f3-5fd512c7c3f9"); // Default
			put("IDF", "82c0032e-1d8f-4001-b365-39f9a8cc2b05"); // Inception to date
			put("YBF", "2e54c6d4-f45a-474c-b4ab-6c7679f913dd"); // Year Balances
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Cal_Method(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Cal_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_REVAL_CAL_METHOD_UUIDS_BY_VALUE.get(entity.getA_Reval_Cal_Method()));
	}


	/**
	 * Get Reval Cost Offset Acct.
	 *
	 * @return Reval Cost Offset Acct
	 */
	public CompletableFuture<MAccount> A_Reval_Cost_Offset_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Reval_Cost_Offset_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Reval_Cost_Offset_Acct());
	}


	/**
	 * Get Reval Cost Offset Prior Acct.
	 *
	 * @return Reval Cost Offset Prior Acct
	 */
	public CompletableFuture<MAccount> A_Reval_Cost_Offset_Prior_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Reval_Cost_Offset_Prior_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Reval_Cost_Offset_Prior_Acct());
	}


	/**
	 * Get Reval Depexp Offset Acct.
	 *
	 * @return Reval Depexp Offset Acct
	 */
	public CompletableFuture<MAccount> A_Reval_Depexp_Offset_A(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getA_Reval_Depexp_Offset_Acct() < 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getA_Reval_Depexp_Offset_Acct());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
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
	public CompletableFuture<MRefList_BH> PostingType(MAssetAcct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processing(MAssetAcct entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
