package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MDepreciationBuild;
import org.compiere.model.MPeriod;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_BuildResolver extends POResolver<MDepreciationBuild> implements GraphQLResolver<MDepreciationBuild> {



	/**
	 * Get To Asset.
	 *
	 * @return To Asset
	 */
	public CompletableFuture<MAsset> A_End_Asset(MDepreciationBuild entity, DataFetchingEnvironment environment) {
		if (entity.getA_End_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_End_Asset_ID());
	}


	/**
	 * Get From Asset.
	 *
	 * @return From Asset
	 */
	public CompletableFuture<MAsset> A_Start_Asset(MDepreciationBuild entity, DataFetchingEnvironment environment) {
		if (entity.getA_Start_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Start_Asset_ID());
	}


	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(MDepreciationBuild entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
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
	public CompletableFuture<MRefList_BH> PostingType(MDepreciationBuild entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(MDepreciationBuild entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MDepreciationBuild entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
