package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChart;
import org.compiere.model.MEntityType;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartResolver extends POResolver<MChart> implements GraphQLResolver<MChart> {


	static Map<String, String> CHARTORIENTATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MChart.CHARTORIENTATION_Horizontal, "e4c14bf1-2522-4d47-9469-ea261017054f");
			put(MChart.CHARTORIENTATION_Vertical, "f158efbb-ddb9-4dd4-b630-adefad4ab103");
		}
	};
	public CompletableFuture<MRefList> ChartOrientation_RL(MChart entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getChartOrientation())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CHARTORIENTATION_UUIDS_BY_VALUE.get(entity.getChartOrientation()));
	}

	static Map<String, String> CHARTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MChart.CHARTTYPE_AreaChart, "4d29bcff-81fc-4a8a-8844-2708847eeed2");
			put(MChart.CHARTTYPE_BarChart, "bfeb4548-7b52-4847-9b56-7529cba194f4");
			put(MChart.CHARTTYPE_StackedAreaChart, "53310de6-2cfd-4cee-bd1a-298e77c5ed9a");
			put(MChart.CHARTTYPE_3DBarChart, "320eebfe-6011-42ce-9698-70bdb8f239fe");
			put(MChart.CHARTTYPE_StackedBarChart, "22572bc7-d1f9-45b0-9adf-5bab4beae5b3");
			put(MChart.CHARTTYPE_3DStackedBarChart, "272e8091-1706-49c2-af6a-d45b6f23d1ef");
			put(MChart.CHARTTYPE_LineChart, "65f73a60-e27d-4f9b-a6f1-6d32ee8b7bd3");
			put(MChart.CHARTTYPE_3DLineChart, "d9cae711-0fdd-4de5-b77e-b9a74ea818f1");
			put(MChart.CHARTTYPE_WaterfallChart, "4ae68689-3f5f-4ba4-b0c8-ec9c3c610986");
			put(MChart.CHARTTYPE_PieChart, "622a1d59-28ed-484c-a6e4-1e01443c2a81");
			put(MChart.CHARTTYPE_3DPieChart, "2070043c-07b7-4f82-8f06-9c7d19ff0d20");
			put(MChart.CHARTTYPE_RingChart, "2afdaa43-fd01-441c-9ff6-2a9fbcd88ff8");
		}
	};
	public CompletableFuture<MRefList> ChartType_RL(MChart entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getChartType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CHARTTYPE_UUIDS_BY_VALUE.get(entity.getChartType()));
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MChart entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

	static Map<String, String> TIMEUNIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MChart.TIMEUNIT_Day, "e1da3032-8970-4e61-8c6c-1732ff2cdf0f");
			put(MChart.TIMEUNIT_Week, "21157769-4f20-454a-b333-6336e1af19e8");
			put(MChart.TIMEUNIT_Month, "8861af0f-d610-4aa7-9644-b61a47f67b53");
			put(MChart.TIMEUNIT_Quarter, "93cc1101-b9be-4cc2-a500-09f1c15780b7");
			put(MChart.TIMEUNIT_Year, "d3384136-4384-42a6-9e14-473d05c608bc");
		}
	};
	public CompletableFuture<MRefList> TimeUnit_RL(MChart entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTimeUnit())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(TIMEUNIT_UUIDS_BY_VALUE.get(entity.getTimeUnit()));
	}

}
