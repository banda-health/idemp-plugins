package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MInvoiceSchedule;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceScheduleResolver extends POResolver<MInvoiceSchedule> implements GraphQLResolver<MInvoiceSchedule> {


	static Map<String, String> INVOICEFREQUENCY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "bf4cbb08-95aa-49e8-8e3b-08cefb38f567");
			put("W", "8420e699-cb99-4ed5-ab74-9fd60f22ce77");
			put("M", "18f0c2b7-8eb6-429e-ab02-396a09ed85a2");
			put("T", "51e4ee52-319d-4bfd-be0b-c6a86c6d69df");
		}
	};
	public CompletableFuture<MRefList> InvoiceFrequency_RL(MInvoiceSchedule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceFrequency())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(INVOICEFREQUENCY_UUIDS_BY_VALUE.get(entity.getInvoiceFrequency()));
	}

	static Map<String, String> INVOICEWEEKDAY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("7", "ad54c61a-75e4-4257-9c70-4e6b1b772686");
			put("1", "a225bd22-7f57-493e-aee5-d0cf71891cd0");
			put("2", "6c7920e4-dc0e-436f-b220-0729aad44bf2");
			put("3", "f0e5917d-cfa7-460c-a0b1-b9610e9506f1");
			put("4", "7862d4ca-778b-4425-974e-6002d925e8d5");
			put("5", "e2bdb391-5b9a-41f9-a3b0-8309e47b299a");
			put("6", "13efb0f3-7cc6-4339-85e5-bcaadf0ca31c");
		}
	};
	public CompletableFuture<MRefList> InvoiceWeekDay_RL(MInvoiceSchedule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceWeekDay())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(INVOICEWEEKDAY_UUIDS_BY_VALUE.get(entity.getInvoiceWeekDay()));
	}

	static Map<String, String> INVOICEWEEKDAYCUTOFF_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("7", "ad54c61a-75e4-4257-9c70-4e6b1b772686");
			put("1", "a225bd22-7f57-493e-aee5-d0cf71891cd0");
			put("2", "6c7920e4-dc0e-436f-b220-0729aad44bf2");
			put("3", "f0e5917d-cfa7-460c-a0b1-b9610e9506f1");
			put("4", "7862d4ca-778b-4425-974e-6002d925e8d5");
			put("5", "e2bdb391-5b9a-41f9-a3b0-8309e47b299a");
			put("6", "13efb0f3-7cc6-4339-85e5-bcaadf0ca31c");
		}
	};
	public CompletableFuture<MRefList> InvoiceWeekDayCutoff_RL(MInvoiceSchedule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceWeekDayCutoff())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(INVOICEWEEKDAYCUTOFF_UUIDS_BY_VALUE.get(entity.getInvoiceWeekDayCutoff()));
	}

}
