package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPeriod;
import org.compiere.model.MPeriodControl;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PeriodControlResolver extends POResolver<MPeriodControl> implements GraphQLResolver<MPeriodControl> {



	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(MPeriodControl entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
	}

	static Map<String, String> DOCBASETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("GLJ", "1ebaead0-a428-4a01-b5b3-95300caedf4c");
			put("GLD", "1527e2dd-de8b-485d-992b-977b18d3d545");
			put("API", "22254286-4551-4535-8355-803f27481890");
			put("APP", "848c907b-df58-44bd-911c-bc3d6b126c8d");
			put("ARI", "25caf904-65d5-4d39-85ac-52084222ceb5");
			put("ARR", "d3a7478a-3fd5-4d09-916a-bfa18c63d278");
			put("SOO", "73b3b54c-cd72-46bb-b5eb-8febb399d004");
			put("ARF", "f089cb5b-d39d-42c4-ab6c-c3fcb01c0bc7");
			put("MMS", "bd2bdbed-739d-43a3-ac49-4e36f7ffbf0a");
			put("MMR", "e74d23a5-62a2-4de9-b7d0-2b0f1a01597e");
			put("MMM", "5703000d-3ae8-4734-b106-8a37eeeff0f3");
			put("POO", "a2d3f3f8-7fa4-434c-9946-748cbb1ec019");
			put("POR", "01c89c39-47f1-45b3-ba40-bea570103c83");
			put("MMI", "ba281639-53f2-420f-a95f-035a1f8affe7");
			put("APC", "a355c3de-13b9-4396-9e69-c99c8e68a868");
			put("ARC", "afce85df-3624-41d6-adb8-4d4a3d6e4654");
			put("CMB", "f4fbcba7-8612-4f2b-9ad1-8f4375782ff4");
			put("CMC", "10f0c4ce-675b-4c25-ad97-bf3e7122ad8f");
			put("CMA", "a485e645-eb48-417d-aa00-1afbfefd6c7f");
			put("MMP", "1e2b0e68-d97d-47f4-ad8c-b75ddf361872");
			put("MXI", "dccc28e0-5e0e-4bc1-bf46-0e9995dfff11");
			put("MXP", "0ba8fd26-1e79-4b0d-9722-3873cb7a86cd");
			put("PJI", "c948ecfc-36f5-430e-9a23-02c4b3614127");
			put("MOF", "a89f18f0-e253-417b-a1c8-cf7e3483ec67");
			put("MOP", "0e55eb68-2a07-4056-bc6a-102c90880917");
			put("MQO", "efc21acb-0006-4cf1-ae51-764c10010758");
			put("HRP", "2ab90cc0-c44e-44fd-bc45-bb3383ec338c");
			put("DOO", "31c4b671-5bdc-41d1-9e33-319c168111e5");
			put("MCC", "cd368ff2-7110-4475-b854-57448e89376e");
			put("FAA", "fef8f9ac-de6a-4ea9-b117-3a6bcfb2f3d4");
			put("FAD", "98b85394-b7cb-40df-b310-825d53744733");
			put("FDP", "68763ab2-7781-4d0a-88d4-1d70e3f885e7");
		}
	};
	public CompletableFuture<MRefList_BH> DocBaseType(MPeriodControl entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocBaseType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCBASETYPE_UUIDS_BY_VALUE.get(entity.getDocBaseType()));
	}

	static Map<String, String> PERIODACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("O", "2d220135-09be-48c5-a90c-40e44d71cd71");
			put("C", "6beb259f-6741-426f-a76e-5f76578d1710");
			put("P", "019e9f60-00b1-4610-9be6-a23e1527d0a5");
			put("N", "6d8d0aae-1aa8-4566-b719-17be55dbfd30");
			put("D", "115de309-7e7b-42a0-873b-7acf400d3ac3");
		}
	};
	public CompletableFuture<MRefList_BH> PeriodAction(MPeriodControl entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPeriodAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PERIODACTION_UUIDS_BY_VALUE.get(entity.getPeriodAction()));
	}

	static Map<String, String> PERIODSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("O", "22753496-ce7b-4cb2-8aa4-63ae48a20f4c");
			put("C", "70c7284e-a6de-41b1-b9b0-fc21b6b24ea2");
			put("P", "1372bf72-0e91-496b-b554-e2aeaa58cd1a");
			put("N", "83b5a615-686a-4ea2-a87c-dffd45b89c26");
			put("D", "948b0299-f812-4fc7-92b8-9063f7deae6d");
		}
	};
	public CompletableFuture<MRefList_BH> PeriodStatus(MPeriodControl entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPeriodStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PERIODSTATUS_UUIDS_BY_VALUE.get(entity.getPeriodStatus()));
	}

	public Boolean Processing(MPeriodControl entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
