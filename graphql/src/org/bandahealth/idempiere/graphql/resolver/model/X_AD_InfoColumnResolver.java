package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoColumn_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StyleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MStyle;
import org.compiere.model.MValRule;
import org.compiere.model.M_Element;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_InfoColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_InfoColumnResolver extends POResolver<MInfoColumn> implements GraphQLResolver<MInfoColumn> {



	/**
	 * Get System Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	public CompletableFuture<M_Element> AD_Element(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Element_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, M_Element> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ElementDataLoader.DATALOADER_AD_Element_BY_ID);
		return dataLoader.load(entity.getAD_Element_ID());
	}


	/**
	 * Get Field Style.
	 *
	 * @return Field CSS Style 
	 */
	public CompletableFuture<MStyle> AD_FieldStyle(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_FieldStyle_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStyle> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StyleDataLoader.DATALOADER_AD_Style_BY_ID);
		return dataLoader.load(entity.getAD_FieldStyle_ID());
	}


	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getAD_InfoWindow_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Value(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoColumn_TrlDataLoader.DATALOADER_AD_InfoColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MInfoColumn.COLUMNNAME_Description));
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
	public CompletableFuture<MEntityType> AD_EntityType(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	/**
	 * Get Comment/Help.
	 *
	 * @return Comment or Hint
	 */
	public CompletableFuture<String> Help(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoColumn_TrlDataLoader.DATALOADER_AD_InfoColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MInfoColumn.COLUMNNAME_Help));
	}

	public Boolean IsAutocomplete(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isAutocomplete();
	}

	public Boolean IsCentrallyMaintained(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isCentrallyMaintained();
	}

	public Boolean IsDisplayed(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isDisplayed();
	}

	public Boolean IsIdentifier(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isIdentifier();
	}

	public Boolean IsKey(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isKey();
	}

	public Boolean IsMandatory(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isMandatory();
	}

	public Boolean IsQueryCriteria(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isQueryCriteria();
	}

	public Boolean IsReadOnly(MInfoColumn entity, DataFetchingEnvironment environment) {
		return entity.isReadOnly();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoColumn_TrlDataLoader.DATALOADER_AD_InfoColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MInfoColumn.COLUMNNAME_Name));
	}

	/**
	 * Get Placeholder.
	 *
	 * @return Placeholder
	 */
	public CompletableFuture<String> Placeholder(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholder);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoColumn_TrlDataLoader.DATALOADER_AD_InfoColumn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MInfoColumn.COLUMNNAME_Placeholder));
	}

	static Map<String, String> QUERYOPERATOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Like", "cd02fd21-8913-4bc7-9ef4-a405069f8665");
			put("=", "1e99d0eb-d4ba-46ad-98be-1e9f0a20d387");
			put(">", "da5910a0-4b7a-4986-ada4-ecba7eb953ad");
			put(">=", "653d78b9-8a2b-40cd-a0f1-c7e8bf5cea1c");
			put("<", "2673aa9f-3efc-4625-9659-9242f8140d8c");
			put("<=", "dc557f72-fae9-463f-86ab-7d078eef739f");
			put("!=", "bc2fee0b-7738-4d57-9d12-e60d55ff2256");
			put("LIKE", "9562f4db-97a9-4df5-99d0-b2f5bc0e2b4c");
		}
	};
	public CompletableFuture<MRefList_BH> QueryOperator(MInfoColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getQueryOperator())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(QUERYOPERATOR_UUIDS_BY_VALUE.get(entity.getQueryOperator()));
	}

}
