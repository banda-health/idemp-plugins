package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Chart_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChart;
import org.compiere.model.MEntityType;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ChartResolver extends POResolver<MChart> implements GraphQLResolver<MChart> {


	public static Map<String, String> CHARTORIENTATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("H", "e4c14bf1-2522-4d47-9469-ea261017054f"); // Horizontal
			put("V", "f158efbb-ddb9-4dd4-b630-adefad4ab103"); // Vertical
		}
	};
	public CompletableFuture<MRefList_BH> ChartOrientation(MChart entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getChartOrientation())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CHARTORIENTATION_UUIDS_BY_VALUE.get(entity.getChartOrientation()));
	}

	public static Map<String, String> CHARTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AC", "4d29bcff-81fc-4a8a-8844-2708847eeed2"); // Area Chart
			put("BC", "bfeb4548-7b52-4847-9b56-7529cba194f4"); // Bar Chart
			put("AS", "53310de6-2cfd-4cee-bd1a-298e77c5ed9a"); // Stacked Area Chart
			put("B3", "320eebfe-6011-42ce-9698-70bdb8f239fe"); // 3D Bar Chart
			put("BS", "22572bc7-d1f9-45b0-9adf-5bab4beae5b3"); // Stacked Bar Chart
			put("B4", "272e8091-1706-49c2-af6a-d45b6f23d1ef"); // 3D Stacked Bar Chart
			put("LC", "65f73a60-e27d-4f9b-a6f1-6d32ee8b7bd3"); // Line Chart
			put("L3", "d9cae711-0fdd-4de5-b77e-b9a74ea818f1"); // 3D Line Chart
			put("WC", "4ae68689-3f5f-4ba4-b0c8-ec9c3c610986"); // Waterfall Chart
			put("PC", "622a1d59-28ed-484c-a6e4-1e01443c2a81"); // Pie Chart
			put("P3", "2070043c-07b7-4f82-8f06-9c7d19ff0d20"); // 3D Pie Chart
			put("RC", "2afdaa43-fd01-441c-9ff6-2a9fbcd88ff8"); // Ring Chart
		}
	};
	public CompletableFuture<MRefList_BH> ChartType(MChart entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getChartType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CHARTTYPE_UUIDS_BY_VALUE.get(entity.getChartType()));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MChart entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Chart_TrlDataLoader.DATALOADER_AD_Chart_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MChart.COLUMNNAME_Description) :
						entity.getDescription());
	}

	/**
	 * Get Domain Label.
	 *
	 * @return Label for the domain axis.
	 */
	public CompletableFuture<String> DomainLabel(MChart entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDomainLabel);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Chart_TrlDataLoader.DATALOADER_AD_Chart_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MChart.COLUMNNAME_DomainLabel) :
						entity.getDomainLabel());
	}

	static Map<String, Integer> ENTITYTYPE_IDS_BY_ENTITY_TYPE = new HashMap<>() {
		{
			put("D", 10);
			put("C", 20);
			put("U", 100);
			put("CUST", 110);
			put("A", 200);
			put("EXT", 210);
			put("XX", 220);
			put("EE01", 50000);
			put("EE04", 50001);
			put("EE05", 50003);
			put("EE02", 50005);
			put("WSTORE", 200015);
		}
	};

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MChart entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean IsDisplayLegend(MChart entity, DataFetchingEnvironment environment) {
		return entity.isDisplayLegend();
	}

	public Boolean IsTimeSeries(MChart entity, DataFetchingEnvironment environment) {
		return entity.isTimeSeries();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MChart entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Chart_TrlDataLoader.DATALOADER_AD_Chart_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MChart.COLUMNNAME_Name) :
						entity.getName());
	}

	/**
	 * Get Range Label.
	 *
	 * @return Label for the range axis.
	 */
	public CompletableFuture<String> RangeLabel(MChart entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getRangeLabel);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Chart_TrlDataLoader.DATALOADER_AD_Chart_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MChart.COLUMNNAME_RangeLabel) :
						entity.getRangeLabel());
	}

	public static Map<String, String> TIMEUNIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "e1da3032-8970-4e61-8c6c-1732ff2cdf0f"); // Day
			put("W", "21157769-4f20-454a-b333-6336e1af19e8"); // Week
			put("M", "8861af0f-d610-4aa7-9644-b61a47f67b53"); // Month
			put("Q", "93cc1101-b9be-4cc2-a500-09f1c15780b7"); // Quarter
			put("Y", "d3384136-4384-42a6-9e14-473d05c608bc"); // Year
		}
	};
	public CompletableFuture<MRefList_BH> TimeUnit(MChart entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTimeUnit())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TIMEUNIT_UUIDS_BY_VALUE.get(entity.getTimeUnit()));
	}

}
