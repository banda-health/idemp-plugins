package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_MeasureCalcDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_RatioDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MRefList;
import org.compiere.model.X_PA_Ratio;
import org.compiere.model.X_PA_RatioElement;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_RatioElementResolver extends POResolver<X_PA_RatioElement> implements GraphQLResolver<X_PA_RatioElement> {



	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public CompletableFuture<MElementValue> Account(X_PA_RatioElement entity, DataFetchingEnvironment environment) {
		if (entity.getAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAccount_ID());
	}


	/**
	 * Get Measure Calculation.
	 *
	 * @return Calculation method for measuring performance
	 */
	public CompletableFuture<MMeasureCalc> PA_MeasureCalc(X_PA_RatioElement entity, DataFetchingEnvironment environment) {
		if (entity.getPA_MeasureCalc_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMeasureCalc> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_MeasureCalcDataLoader.PA_MeasureCalc_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_MeasureCalc_ID());
	}


	/**
	 * Get Ratio.
	 *
	 * @return Performance Ratio
	 */
	public CompletableFuture<X_PA_Ratio> PA_Ratio(X_PA_RatioElement entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Ratio_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_Ratio> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_RatioDataLoader.PA_Ratio_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_Ratio_ID());
	}


	/**
	 * Get Ratio Used.
	 *
	 * @return Performance Ratio Used
	 */
	public CompletableFuture<X_PA_Ratio> PA_RatioUsed(X_PA_RatioElement entity, DataFetchingEnvironment environment) {
		if (entity.getPA_RatioUsed_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_Ratio> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_RatioDataLoader.PA_Ratio_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_RatioUsed_ID());
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
	public CompletableFuture<MRefList> PostingType_RL(X_PA_RatioElement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	static Map<String, String> RATIOELEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R", "11ec6ed4-e9fa-4c96-924b-9a7baedc56fb");
			put("C", "e379a3fa-da0f-4bc8-a3fe-d016f937e92c");
			put("X", "025789a9-7fd5-466a-b00e-ce28ef6bc382");
			put("A", "a963fe93-801d-409e-9bfd-866ba80cc05e");
		}
	};
	public CompletableFuture<MRefList> RatioElementType_RL(X_PA_RatioElement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRatioElementType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(RATIOELEMENTTYPE_UUIDS_BY_VALUE.get(entity.getRatioElementType()));
	}

	static Map<String, String> RATIOOPERAND_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "97e27c57-7ce2-4bf0-9c6e-ed9012ea39d1");
			put("N", "ee462114-1054-437f-828a-a71d03bfab55");
			put("M", "466f66df-4986-4894-8554-a07998191282");
			put("D", "e137d41c-433d-4cf6-9da0-a3263d2aa5b1");
		}
	};
	public CompletableFuture<MRefList> RatioOperand_RL(X_PA_RatioElement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRatioOperand())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(RATIOOPERAND_UUIDS_BY_VALUE.get(entity.getRatioOperand()));
	}

}
