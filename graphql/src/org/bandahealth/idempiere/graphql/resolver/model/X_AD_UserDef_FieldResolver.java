package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChartDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StyleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardContentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChart;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MStyle;
import org.compiere.model.MUserDefField;
import org.compiere.model.MUserDefTab;
import org.compiere.model.MValRule;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_FieldResolver extends POResolver<MUserDefField> implements GraphQLResolver<MUserDefField> {



	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	public CompletableFuture<MChart> AD_Chart(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Chart_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MChart> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ChartDataLoader.DATALOADER_AD_Chart_BY_ID);
		return dataLoader.load(entity.getAD_Chart_ID());
	}


	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	public CompletableFuture<MField_BH> AD_Field(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Field_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MField_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FieldDataLoader.DATALOADER_AD_Field_BY_ID);
		return dataLoader.load(entity.getAD_Field_ID());
	}


	/**
	 * Get Field Group.
	 *
	 * @return Logical grouping of fields
	 */
	public CompletableFuture<MFieldGroup_BH> AD_FieldGroup(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_FieldGroup_ID() < 0) {
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
	public CompletableFuture<MStyle> AD_FieldStyle(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_FieldStyle_ID() < 0) {
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
	public CompletableFuture<MStyle> AD_LabelStyle(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_LabelStyle_ID() < 0) {
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
	public CompletableFuture<MReference_BH> AD_Reference(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() < 0) {
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
	public CompletableFuture<MReference_BH> AD_Reference_Value(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get User defined Tab.
	 *
	 * @return User defined Tab
	 */
	public CompletableFuture<MUserDefTab> AD_UserDef_Tab(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_UserDef_Tab_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUserDefTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDef_TabDataLoader.DATALOADER_AD_UserDef_Tab_BY_ID);
		return dataLoader.load(entity.getAD_UserDef_Tab_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() < 0) {
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
	public CompletableFuture<MValRule> AD_Val_Rule_Lookup(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_Lookup_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_Lookup_ID());
	}

	public static Map<String, String> ISALWAYSUPDATEABLE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsAlwaysUpdateable(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsAlwaysUpdateable())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISALWAYSUPDATEABLE_UUIDS_BY_VALUE.get(entity.getIsAlwaysUpdateable()));
	}

	public static Map<String, String> ISAUTOCOMPLETE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsAutocomplete(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsAutocomplete())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISAUTOCOMPLETE_UUIDS_BY_VALUE.get(entity.getIsAutocomplete()));
	}

	public static Map<String, String> ISDISPLAYED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsDisplayed(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsDisplayed())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISDISPLAYED_UUIDS_BY_VALUE.get(entity.getIsDisplayed()));
	}

	public static Map<String, String> ISDISPLAYEDGRID_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsDisplayedGrid(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsDisplayedGrid())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISDISPLAYEDGRID_UUIDS_BY_VALUE.get(entity.getIsDisplayedGrid()));
	}

	public static Map<String, String> ISMANDATORY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsMandatory(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsMandatory())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISMANDATORY_UUIDS_BY_VALUE.get(entity.getIsMandatory()));
	}

	public static Map<String, String> ISREADONLY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsReadOnly(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsReadOnly())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISREADONLY_UUIDS_BY_VALUE.get(entity.getIsReadOnly()));
	}

	public static Map<String, String> ISSAMELINE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsSameLine(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsSameLine())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISSAMELINE_UUIDS_BY_VALUE.get(entity.getIsSameLine()));
	}

	public static Map<String, String> ISTOOLBARBUTTON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "5803fda0-fda8-4100-85f2-a4fe8142a059"); // Toolbar
			put("N", "eb2f6365-a357-4655-9102-d622360aacce"); // Window
			put("B", "5b8b7285-d4da-4513-8941-a280d501ea19"); // Both
		}
	};
	public CompletableFuture<MRefList_BH> IsToolbarButton(MUserDefField entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> IsUpdateable(MUserDefField entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsUpdateable())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISUPDATEABLE_UUIDS_BY_VALUE.get(entity.getIsUpdateable()));
	}


	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	public CompletableFuture<MDashboardContent> PA_DashboardContent(MUserDefField entity, DataFetchingEnvironment environment) {
		if (entity.getPA_DashboardContent_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDashboardContent> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_DashboardContentDataLoader.DATALOADER_PA_DashboardContent_BY_ID);
		return dataLoader.load(entity.getPA_DashboardContent_ID());
	}

}
