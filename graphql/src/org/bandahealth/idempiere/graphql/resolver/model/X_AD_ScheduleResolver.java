package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.model.MSchedule;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Schedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ScheduleResolver extends POResolver<MSchedule> implements GraphQLResolver<MSchedule> {


	static Map<String, String> FREQUENCYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MSchedule.FREQUENCYTYPE_Minute, "80320e2a-1a3c-462f-9af1-09c0af1aab5f");
			put(MSchedule.FREQUENCYTYPE_Hour, "817d1ba9-4dbe-4105-8ca5-61cf554ac837");
			put(MSchedule.FREQUENCYTYPE_Day, "6360c9c7-dbf3-4b2f-bd8b-3465a7fde7a7");
		}
	};
	public CompletableFuture<MRefList> FrequencyType_RL(MSchedule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFrequencyType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(FREQUENCYTYPE_UUIDS_BY_VALUE.get(entity.getFrequencyType()));
	}

	static Map<String, String> SCHEDULETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MSchedule.SCHEDULETYPE_Frequency, "1e847fd3-e719-4a8f-b297-1ed3f652f1ee");
			put(MSchedule.SCHEDULETYPE_WeekDay, "6dfb311b-9f12-4599-95cc-d21b064d247b");
			put(MSchedule.SCHEDULETYPE_MonthDay, "30a88b01-15d8-4b62-a0cb-06e37dcc92f6");
			put(MSchedule.SCHEDULETYPE_CronSchedulingPattern, "9602aa31-9065-49bd-b4a4-6ac96166261a");
		}
	};
	public CompletableFuture<MRefList> ScheduleType_RL(MSchedule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getScheduleType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(SCHEDULETYPE_UUIDS_BY_VALUE.get(entity.getScheduleType()));
	}

	static Map<String, String> WEEKDAY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MSchedule.WEEKDAY_Sunday, "ad54c61a-75e4-4257-9c70-4e6b1b772686");
			put(MSchedule.WEEKDAY_Monday, "a225bd22-7f57-493e-aee5-d0cf71891cd0");
			put(MSchedule.WEEKDAY_Tuesday, "6c7920e4-dc0e-436f-b220-0729aad44bf2");
			put(MSchedule.WEEKDAY_Wednesday, "f0e5917d-cfa7-460c-a0b1-b9610e9506f1");
			put(MSchedule.WEEKDAY_Thursday, "7862d4ca-778b-4425-974e-6002d925e8d5");
			put(MSchedule.WEEKDAY_Friday, "e2bdb391-5b9a-41f9-a3b0-8309e47b299a");
			put(MSchedule.WEEKDAY_Saturday, "13efb0f3-7cc6-4339-85e5-bcaadf0ca31c");
		}
	};
	public CompletableFuture<MRefList> WeekDay_RL(MSchedule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getWeekDay())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(WEEKDAY_UUIDS_BY_VALUE.get(entity.getWeekDay()));
	}

}
