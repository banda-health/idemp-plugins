package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_FundingModeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MDepreciationWorkfile;
import org.compiere.model.X_A_FundingMode;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_WorkfileResolver extends POResolver<MDepreciationWorkfile> implements GraphQLResolver<MDepreciationWorkfile> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Asset Funding Mode.
	 *
	 * @return Asset Funding Mode
	 */
	public CompletableFuture<X_A_FundingMode> A_FundingMode(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
		if (entity.getA_FundingMode_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_A_FundingMode> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_FundingModeDataLoader.DATALOADER_A_FundingMode_BY_ID);
		return dataLoader.load(entity.getA_FundingMode_ID());
	}

	public static Map<String, String> A_TIP_FINANTARE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "1bddac4c-bcc8-4758-8630-d80555b14a62"); // Cofinantare
			put("P", "2d7b24ae-5735-41a6-88f6-7aa5cc143493"); // Proprie
			put("T", "51a1b186-6af4-4373-9788-f9105aa65cfa"); // Terti
		}
	};
	public CompletableFuture<MRefList_BH> A_Tip_Finantare(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Tip_Finantare())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_TIP_FINANTARE_UUIDS_BY_VALUE.get(entity.getA_Tip_Finantare()));
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}

	public Boolean IsDepreciated(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> PostingType(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MDepreciationWorkfile entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
