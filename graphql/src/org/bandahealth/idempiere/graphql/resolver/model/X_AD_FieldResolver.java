package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChartDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Field_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StyleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChart;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MStyle;
import org.compiere.model.MTab;
import org.compiere.model.MValRule;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_FieldResolver extends POResolver<MField_BH> implements GraphQLResolver<MField_BH> {



	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	public CompletableFuture<MChart> AD_Chart(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Chart_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChart> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ChartDataLoader.DATALOADER_AD_Chart_BY_ID);
		return dataLoader.load(entity.getAD_Chart_ID());
	}


	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Field Group.
	 *
	 * @return Logical grouping of fields
	 */
	public CompletableFuture<MFieldGroup_BH> AD_FieldGroup(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_FieldGroup_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MFieldGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FieldGroupDataLoader.DATALOADER_AD_FieldGroup_BY_ID);
		return dataLoader.load(entity.getAD_FieldGroup_ID());
	}


	/**
	 * Get Field Style.
	 *
	 * @return Field CSS Style 
	 */
	public CompletableFuture<MStyle> AD_FieldStyle(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_FieldStyle_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MStyle> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StyleDataLoader.DATALOADER_AD_Style_BY_ID);
		return dataLoader.load(entity.getAD_FieldStyle_ID());
	}


	/**
	 * Get Label Style.
	 *
	 * @return Label CSS Style
	 */
	public CompletableFuture<MStyle> AD_LabelStyle(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_LabelStyle_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MStyle> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StyleDataLoader.DATALOADER_AD_Style_BY_ID);
		return dataLoader.load(entity.getAD_LabelStyle_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() < 1) {
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
	public CompletableFuture<MReference_BH> AD_Reference_Value(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}


	/**
	 * Get Dynamic Validation (Lookup).
	 *
	 * @return Override Dynamic Validation Rule for Lookup Window
	 */
	public CompletableFuture<MValRule> AD_Val_Rule_Lookup(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_Lookup_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_Lookup_ID());
	}

	/**
	 * Get BH_Abbreviation.
	 *
	 * @return An abbreviation for a given name
	 */
	public CompletableFuture<String> BH_Abbreviation(MField_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getBH_Abbreviation);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Field_TrlDataLoader.DATALOADER_AD_Field_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MField_BH.COLUMNNAME_BH_Abbreviation) :
						entity.getBH_Abbreviation());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MField_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Field_TrlDataLoader.DATALOADER_AD_Field_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MField_BH.COLUMNNAME_Description) :
						entity.getDescription());
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
	public CompletableFuture<MEntityType> AD_EntityType(MField_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<String> Help(MField_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Field_TrlDataLoader.DATALOADER_AD_Field_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MField_BH.COLUMNNAME_Help) :
						entity.getHelp());
	}


	/**
	 * Get Included Tab.
	 *
	 * @return Included Tab in this Tab (Master Detail)
	 */
	public CompletableFuture<MTab> Included_Tab(MField_BH entity, DataFetchingEnvironment environment) {
		if (entity.getIncluded_Tab_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getIncluded_Tab_ID());
	}

	public Boolean IsAdvancedField(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isAdvancedField();
	}

	public static Map<String, String> ISALLOWCOPY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsAllowCopy(MField_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsAllowCopy())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISALLOWCOPY_UUIDS_BY_VALUE.get(entity.getIsAllowCopy()));
	}

	public static Map<String, String> ISALWAYSUPDATEABLE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsAlwaysUpdateable(MField_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsAlwaysUpdateable())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISALWAYSUPDATEABLE_UUIDS_BY_VALUE.get(entity.getIsAlwaysUpdateable()));
	}

	public Boolean IsCentrallyMaintained(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isCentrallyMaintained();
	}

	public Boolean IsDefaultFocus(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isDefaultFocus();
	}

	public Boolean IsDisplayed(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isDisplayed();
	}

	public Boolean IsDisplayedGrid(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isDisplayedGrid();
	}

	public Boolean IsEncrypted(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isEncrypted();
	}

	public Boolean IsFieldOnly(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isFieldOnly();
	}

	public Boolean IsHeading(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isHeading();
	}

	public static Map<String, String> ISMANDATORY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsMandatory(MField_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsMandatory())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISMANDATORY_UUIDS_BY_VALUE.get(entity.getIsMandatory()));
	}

	public Boolean IsQuickEntry(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isQuickEntry();
	}

	public Boolean IsQuickForm(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isQuickForm();
	}

	public Boolean IsReadOnly(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isReadOnly();
	}

	public Boolean IsSameLine(MField_BH entity, DataFetchingEnvironment environment) {
		return entity.isSameLine();
	}

	public static Map<String, String> ISSELECTIONCOLUMN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsSelectionColumn(MField_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsSelectionColumn())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISSELECTIONCOLUMN_UUIDS_BY_VALUE.get(entity.getIsSelectionColumn()));
	}

	public static Map<String, String> ISTOOLBARBUTTON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "5803fda0-fda8-4100-85f2-a4fe8142a059"); // Toolbar
			put("N", "eb2f6365-a357-4655-9102-d622360aacce"); // Window
			put("B", "5b8b7285-d4da-4513-8941-a280d501ea19"); // Both
		}
	};
	public CompletableFuture<MRefList_BH> IsToolbarButton(MField_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsToolbarButton())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISTOOLBARBUTTON_UUIDS_BY_VALUE.get(entity.getIsToolbarButton()));
	}

	public static Map<String, String> ISUPDATEABLE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsUpdateable(MField_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsUpdateable())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISUPDATEABLE_UUIDS_BY_VALUE.get(entity.getIsUpdateable()));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MField_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Field_TrlDataLoader.DATALOADER_AD_Field_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MField_BH.COLUMNNAME_Name) :
						entity.getName());
	}

	public static Map<String, String> OBSCURETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("904", "d2adcd7e-cd5e-48a4-8dcc-639eded252f8"); // Obscure Digits but last 4
			put("944", "ebd7e22e-b841-4d27-b7e0-629f8edadd74"); // Obscure Digits but first/last 4
			put("A44", "74a13194-a048-42f9-9496-012d14f26c46"); // Obscure AlphaNumeric but first/last 4
			put("A04", "8d738332-8860-40bb-9ea4-f3c50c9a0102"); // Obscure AlphaNumeric but last 4
		}
	};
	public CompletableFuture<MRefList_BH> ObscureType(MField_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getObscureType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(OBSCURETYPE_UUIDS_BY_VALUE.get(entity.getObscureType()));
	}

	/**
	 * Get Placeholder.
	 *
	 * @return Placeholder
	 */
	public CompletableFuture<String> Placeholder(MField_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholder);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Field_TrlDataLoader.DATALOADER_AD_Field_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MField_BH.COLUMNNAME_Placeholder) :
						entity.getPlaceholder());
	}

}
