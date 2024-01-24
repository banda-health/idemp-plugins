package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Tab_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TabResolver extends POResolver<MTab> implements GraphQLResolver<MTab> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Order Column.
	 *
	 * @return Column determining the order
	 */
	public CompletableFuture<MColumn> AD_ColumnSortOrder(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ColumnSortOrder_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_ColumnSortOrder_ID());
	}


	/**
	 * Get Included Column.
	 *
	 * @return Column determining if a Table Column is included in Ordering
	 */
	public CompletableFuture<MColumn> AD_ColumnSortYesNo(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ColumnSortYesNo_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_ColumnSortYesNo_ID());
	}


	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	public CompletableFuture<MCtxHelp> AD_CtxHelp(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_CtxHelp_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCtxHelp> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_CtxHelpDataLoader.DATALOADER_AD_CtxHelp_BY_ID);
		return dataLoader.load(entity.getAD_CtxHelp_ID());
	}


	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public CompletableFuture<MImage> AD_Image(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getAD_Image_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable_BH> AD_Table(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	/**
	 * Get Commit Warning.
	 *
	 * @return Warning displayed when saving
	 */
	public CompletableFuture<String> CommitWarning(MTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getCommitWarning);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Tab_TrlDataLoader.DATALOADER_AD_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTab.COLUMNNAME_CommitWarning));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Tab_TrlDataLoader.DATALOADER_AD_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTab.COLUMNNAME_Description));
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
	public CompletableFuture<MEntityType> AD_EntityType(MTab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean HasTree(MTab entity, DataFetchingEnvironment environment) {
		return entity.isHasTree();
	}

	/**
	 * Get Comment/Help.
	 *
	 * @return Comment or Hint
	 */
	public CompletableFuture<String> Help(MTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Tab_TrlDataLoader.DATALOADER_AD_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTab.COLUMNNAME_Help));
	}


	/**
	 * Get Included Tab.
	 *
	 * @return Included Tab in this Tab (Master Detail)
	 */
	public CompletableFuture<MTab> Included_Tab(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getIncluded_Tab_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getIncluded_Tab_ID());
	}

	public Boolean IsAdvancedTab(MTab entity, DataFetchingEnvironment environment) {
		return entity.isAdvancedTab();
	}

	public Boolean IsInfoTab(MTab entity, DataFetchingEnvironment environment) {
		return entity.isInfoTab();
	}

	public Boolean IsInsertRecord(MTab entity, DataFetchingEnvironment environment) {
		return entity.isInsertRecord();
	}

	public Boolean IsReadOnly(MTab entity, DataFetchingEnvironment environment) {
		return entity.isReadOnly();
	}

	public Boolean IsSingleRow(MTab entity, DataFetchingEnvironment environment) {
		return entity.isSingleRow();
	}

	public Boolean IsSortTab(MTab entity, DataFetchingEnvironment environment) {
		return entity.isSortTab();
	}

	public Boolean IsTranslationTab(MTab entity, DataFetchingEnvironment environment) {
		return entity.isTranslationTab();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Tab_TrlDataLoader.DATALOADER_AD_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTab.COLUMNNAME_Name));
	}


	/**
	 * Get Parent Column.
	 *
	 * @return The link column on the parent tab.
	 */
	public CompletableFuture<MColumn> Parent_Column(MTab entity, DataFetchingEnvironment environment) {
		if (entity.getParent_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getParent_Column_ID());
	}

	public Boolean Processing(MTab entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> TREEDISPLAYEDON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "4b99f0aa-846d-459e-a361-8df1018ea08b");
			put("D", "0a125aed-6b96-41c2-86c7-6b196830dbcc");
			put("M", "8b216882-c0c4-47c1-a2a8-d75721082def");
		}
	};
	public CompletableFuture<MRefList_BH> TreeDisplayedOn(MTab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTreeDisplayedOn())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TREEDISPLAYEDON_UUIDS_BY_VALUE.get(entity.getTreeDisplayedOn()));
	}

}
