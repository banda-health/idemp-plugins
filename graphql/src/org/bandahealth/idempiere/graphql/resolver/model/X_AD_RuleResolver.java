package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MRule;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_RuleResolver extends POResolver<MRule> implements GraphQLResolver<MRule> {


	public static Map<String, String> ACCESSLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "3cc495d2-7e46-4d2d-b8b8-a38bfa97fa60"); // Organization
			put("3", "b8062c9f-fb7c-4e91-98ec-0a913a3b367f"); // Client+Organization
			put("4", "6e8bdb2d-b494-401c-b586-7d20727b5eab"); // System only
			put("7", "04c9829a-008e-4a71-9598-224f770491dc"); // All
			put("6", "e05482a2-71be-461d-b522-9cda71a9fa5d"); // System+Client
			put("2", "391e2c9a-b8e5-43b0-895b-eea914023e59"); // Client only
		}
	};
	public CompletableFuture<MRefList_BH> AccessLevel(MRule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccessLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACCESSLEVEL_UUIDS_BY_VALUE.get(entity.getAccessLevel()));
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
	public CompletableFuture<MEntityType> AD_EntityType(MRule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public static Map<String, String> EVENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "1265a219-85d8-4766-b4a7-3de5e2fb51b4"); // Callout
			put("P", "b6e31c63-d49f-46a7-a2e7-109222017f61"); // Process
			put("T", "695202ba-4a04-401c-8d22-6416896cf8e7"); // Model Validator Table Event
			put("D", "4e20ac90-dbb4-43e1-b67f-e079664c6657"); // Model Validator Document Event
			put("L", "27a9b65a-043d-408a-a140-9c13c791f33c"); // Model Validator Login Event
			put("H", "e1246274-d603-476c-890f-edd2962e140f"); // Human Resource & Payroll
			put("M", "3c7b90e5-488c-4445-94b3-aa9eea4f9ece"); // Measure for Performance Analysis
			put("R", "0efdf85b-b260-461e-991f-e1cada7fe522"); // GL Reconciliation
		}
	};
	public CompletableFuture<MRefList_BH> EventType(MRule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEventType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(EVENTTYPE_UUIDS_BY_VALUE.get(entity.getEventType()));
	}

	public static Map<String, String> RULETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "93e8005a-b4fa-49a3-8475-f52a88cf9dc7"); // Aspect Orient Program
			put("S", "fd94dd63-c4b1-4cc8-a933-3b772a9d351d"); // JSR 223 Scripting APIs
			put("R", "c6483fc2-cc06-4053-b1ea-99929ecc27da"); // JSR 94 Rule Engine API
			put("Q", "8ee669bb-c5e7-41dc-a4e1-16cb86ca1c29"); // SQL
		}
	};
	public CompletableFuture<MRefList_BH> RuleType(MRule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRuleType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(RULETYPE_UUIDS_BY_VALUE.get(entity.getRuleType()));
	}

}
