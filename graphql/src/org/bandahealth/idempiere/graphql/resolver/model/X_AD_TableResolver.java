package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Table_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MValRule;
import org.compiere.model.MWindow;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TableResolver extends POResolver<MTable_BH> implements GraphQLResolver<MTable_BH> {


	static Map<String, String> ACCESSLEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "3cc495d2-7e46-4d2d-b8b8-a38bfa97fa60");
			put("3", "b8062c9f-fb7c-4e91-98ec-0a913a3b367f");
			put("4", "6e8bdb2d-b494-401c-b586-7d20727b5eab");
			put("7", "04c9829a-008e-4a71-9598-224f770491dc");
			put("6", "e05482a2-71be-461d-b522-9cda71a9fa5d");
			put("2", "391e2c9a-b8e5-43b0-895b-eea914023e59");
		}
	};
	public CompletableFuture<MRefList_BH> AccessLevel(MTable_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccessLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACCESSLEVEL_UUIDS_BY_VALUE.get(entity.getAccessLevel()));
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MTable_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MTable_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
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
	public CompletableFuture<MEntityType> AD_EntityType(MTable_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean IsCentrallyMaintained(MTable_BH entity, DataFetchingEnvironment environment) {
		return entity.isCentrallyMaintained();
	}

	public Boolean IsChangeLog(MTable_BH entity, DataFetchingEnvironment environment) {
		return entity.isChangeLog();
	}

	public Boolean IsDeleteable(MTable_BH entity, DataFetchingEnvironment environment) {
		return entity.isDeleteable();
	}

	public Boolean IsHighVolume(MTable_BH entity, DataFetchingEnvironment environment) {
		return entity.isHighVolume();
	}

	public Boolean IsSecurityEnabled(MTable_BH entity, DataFetchingEnvironment environment) {
		return entity.isSecurityEnabled();
	}

	public Boolean IsView(MTable_BH entity, DataFetchingEnvironment environment) {
		return entity.isView();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MTable_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Table_TrlDataLoader.DATALOADER_AD_Table_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTable_BH.COLUMNNAME_Name));
	}


	/**
	 * Get PO Window.
	 *
	 * @return Purchase Order Window
	 */
	public CompletableFuture<MWindow> PO_Window(MTable_BH entity, DataFetchingEnvironment environment) {
		if (entity.getPO_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getPO_Window_ID());
	}

	public Boolean Processing(MTable_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> REPLICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "c829969e-9927-491f-89a8-f200b8d29f57");
			put("M", "41211ac8-1137-49f5-9efb-7d8e75682a45");
			put("R", "959a0839-d0f2-43c5-b8da-d0f1fd76d8dd");
			put("B", "1be8a931-6954-4fd9-bc76-e67c6f73fc00");
		}
	};
	public CompletableFuture<MRefList_BH> ReplicationType(MTable_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReplicationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REPLICATIONTYPE_UUIDS_BY_VALUE.get(entity.getReplicationType()));
	}

}
