package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChartDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Column_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MessageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardContentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChart;
import org.compiere.model.MColumn;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MTable;
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
 * Generated ModelResolver for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ColumnResolver extends POResolver<MColumn> implements GraphQLResolver<MColumn> {



	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	public CompletableFuture<MChart> AD_Chart(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Chart_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChart> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ChartDataLoader.DATALOADER_AD_Chart_BY_ID);
		return dataLoader.load(entity.getAD_Chart_ID());
	}


	/**
	 * Get System Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	public CompletableFuture<M_Element> AD_Element(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Element_ID() < 1) {
			return null;
		}
		DataLoader<Integer, M_Element> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ElementDataLoader.DATALOADER_AD_Element_BY_ID);
		return dataLoader.load(entity.getAD_Element_ID());
	}


	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getAD_InfoWindow_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MColumn entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MReference_BH> AD_Reference_Value(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MColumn entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MValRule> AD_Val_Rule_Lookup(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_Lookup_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_Lookup_ID());
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
	public CompletableFuture<MEntityType> AD_EntityType(MColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}


	/**
	 * Get Constraint Message.
	 *
	 * @return Constraint Message
	 */
	public CompletableFuture<MMessage_BH> FKConstraintMsg(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getFKConstraintMsg_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MMessage_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MessageDataLoader.DATALOADER_AD_Message_BY_ID);
		return dataLoader.load(entity.getFKConstraintMsg_ID());
	}

	public static Map<String, String> FKCONSTRAINTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "ad2bedf7-814f-4b7d-ae4e-dac0a8a406f6"); // Do Not Create - Ignore
			put("N", "49ed557e-0170-4594-a65d-fae6e895ffde"); // No Action - Forbid Deletion
			put("C", "e3ef6ea1-87c4-4141-9f5a-882741a167cd"); // Cascade
			put("S", "324b9a18-fc1f-44ba-a1ce-c83e63c7b63b"); // Set Null
			put("M", "c0542a52-fe58-4b87-8bd4-9dc2fe3afa7a"); // Model Cascade
			put("T", "6591e7a2-e8f9-4cd4-9ef2-afea1275e578"); // Model Set Null
			put("O", "8300ca2c-50f9-4882-8776-dfdc949db534"); // Model No Action - Forbid Deletion
		}
	};
	public CompletableFuture<MRefList_BH> FKConstraintType(MColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFKConstraintType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FKCONSTRAINTTYPE_UUIDS_BY_VALUE.get(entity.getFKConstraintType()));
	}

	public Boolean IsAllowCopy(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isAllowCopy();
	}

	public Boolean IsAllowLogging(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isAllowLogging();
	}

	public Boolean IsAlwaysUpdateable(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isAlwaysUpdateable();
	}

	public Boolean IsAutocomplete(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isAutocomplete();
	}

	public static Map<String, String> ISENCRYPTED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "6cc61ac6-b554-4f3e-8438-c8793bb8ca0a"); // Encrypted
			put("N", "3581aa8a-7a64-4485-b0f6-e6948f3d00d7"); // Not Encrypted
		}
	};
	public CompletableFuture<MRefList_BH> IsEncrypted(MColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsEncrypted())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISENCRYPTED_UUIDS_BY_VALUE.get(entity.getIsEncrypted()));
	}

	public Boolean IsHtml(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isHtml();
	}

	public Boolean IsIdentifier(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isIdentifier();
	}

	public Boolean IsKey(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isKey();
	}

	public Boolean IsMandatory(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isMandatory();
	}

	public Boolean IsParent(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isParent();
	}

	public Boolean IsPartitionKey(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isPartitionKey();
	}

	public Boolean IsSecure(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isSecure();
	}

	public Boolean IsSelectionColumn(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isSelectionColumn();
	}

	public static Map<String, String> ISTOOLBARBUTTON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "5803fda0-fda8-4100-85f2-a4fe8142a059"); // Toolbar
			put("N", "eb2f6365-a357-4655-9102-d622360aacce"); // Window
			put("B", "5b8b7285-d4da-4513-8941-a280d501ea19"); // Both
		}
	};
	public CompletableFuture<MRefList_BH> IsToolbarButton(MColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsToolbarButton())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISTOOLBARBUTTON_UUIDS_BY_VALUE.get(entity.getIsToolbarButton()));
	}

	public Boolean IsTranslated(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isTranslated();
	}

	public Boolean IsUpdateable(MColumn entity, DataFetchingEnvironment environment) {
		return entity.isUpdateable();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Column_TrlDataLoader.DATALOADER_AD_Column_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MColumn.COLUMNNAME_Name) :
						entity.getName());
	}


	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	public CompletableFuture<MDashboardContent> PA_DashboardContent(MColumn entity, DataFetchingEnvironment environment) {
		if (entity.getPA_DashboardContent_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDashboardContent> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_DashboardContentDataLoader.DATALOADER_PA_DashboardContent_BY_ID);
		return dataLoader.load(entity.getPA_DashboardContent_ID());
	}

	public static Map<String, String> PARTITIONINGMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R", "d8a5f9ab-574e-4926-93eb-e4a392c36e3c"); // Range
			put("L", "d909c15e-9b97-4171-87bb-7de77cee4eb8"); // List
		}
	};
	public CompletableFuture<MRefList_BH> PartitioningMethod(MColumn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPartitioningMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PARTITIONINGMETHOD_UUIDS_BY_VALUE.get(entity.getPartitioningMethod()));
	}

	/**
	 * Get Placeholder.
	 *
	 * @return Placeholder
	 */
	public CompletableFuture<String> Placeholder(MColumn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholder);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Column_TrlDataLoader.DATALOADER_AD_Column_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MColumn.COLUMNNAME_Placeholder) :
						entity.getPlaceholder());
	}

}
