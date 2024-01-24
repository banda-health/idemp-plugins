package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_BenchmarkDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_HierarchyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_MeasureCalcDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_RatioDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MHierarchy;
import org.compiere.model.MMeasure;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MProjectType;
import org.compiere.model.MRequestType;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.model.X_PA_Ratio;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_MeasureResolver extends POResolver<MMeasure> implements GraphQLResolver<MMeasure> {



	/**
	 * Get Project Type.
	 *
	 * @return Type of the project
	 */
	public CompletableFuture<MProjectType> C_ProjectType(MMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectTypeDataLoader.DATALOADER_C_ProjectType_BY_ID);
		return dataLoader.load(entity.getC_ProjectType_ID());
	}

	static Map<String, String> MEASUREDATATYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "92f9f1ed-782f-4212-bda0-c5a03109c47f");
			put("S", "a727a324-22de-4213-8696-2a37aaddd164");
		}
	};
	public CompletableFuture<MRefList_BH> MeasureDataType(MMeasure entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMeasureDataType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MEASUREDATATYPE_UUIDS_BY_VALUE.get(entity.getMeasureDataType()));
	}

	static Map<String, String> MEASURETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "460a942e-8437-4195-94de-e27c752b9752");
			put("C", "f0b63f0b-2b04-43a2-ba93-10aa95c73fb0");
			put("A", "22adca17-dfc5-466a-a642-eee1ced9b515");
			put("U", "ff4a3f01-b575-4e64-a301-67f31f14ad27");
			put("R", "75dfcc11-cf4d-4a1c-a4ff-ea31f35030ff");
			put("Q", "7b86d06c-e1ea-4a53-8c90-96a2a9e7397d");
			put("P", "1a7a939a-0716-4f97-8883-cf913668d5e8");
		}
	};
	public CompletableFuture<MRefList_BH> MeasureType(MMeasure entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMeasureType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MEASURETYPE_UUIDS_BY_VALUE.get(entity.getMeasureType()));
	}


	/**
	 * Get Benchmark.
	 *
	 * @return Performance Benchmark
	 */
	public CompletableFuture<X_PA_Benchmark> PA_Benchmark(MMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Benchmark_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_Benchmark> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_BenchmarkDataLoader.DATALOADER_PA_Benchmark_BY_ID);
		return dataLoader.load(entity.getPA_Benchmark_ID());
	}


	/**
	 * Get Reporting Hierarchy.
	 *
	 * @return Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */
	public CompletableFuture<MHierarchy> PA_Hierarchy(MMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Hierarchy_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MHierarchy> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_HierarchyDataLoader.DATALOADER_PA_Hierarchy_BY_ID);
		return dataLoader.load(entity.getPA_Hierarchy_ID());
	}


	/**
	 * Get Measure Calculation.
	 *
	 * @return Calculation method for measuring performance
	 */
	public CompletableFuture<MMeasureCalc> PA_MeasureCalc(MMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getPA_MeasureCalc_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMeasureCalc> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_MeasureCalcDataLoader.DATALOADER_PA_MeasureCalc_BY_ID);
		return dataLoader.load(entity.getPA_MeasureCalc_ID());
	}


	/**
	 * Get Ratio.
	 *
	 * @return Performance Ratio
	 */
	public CompletableFuture<X_PA_Ratio> PA_Ratio(MMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Ratio_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_Ratio> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_RatioDataLoader.DATALOADER_PA_Ratio_BY_ID);
		return dataLoader.load(entity.getPA_Ratio_ID());
	}


	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	public CompletableFuture<MRequestType> R_RequestType(MMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getR_RequestType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequestType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestTypeDataLoader.DATALOADER_R_RequestType_BY_ID);
		return dataLoader.load(entity.getR_RequestType_ID());
	}

}
