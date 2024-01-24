package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_TabNavBtn_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MTab;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_TabNavBtn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_TabNavBtnResolver extends POResolver<MTabNavBtn> implements GraphQLResolver<MTabNavBtn> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	static Map<String, String> BUTTONACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "e06ab065-034a-42cc-959a-3b223ca2887b");
			put("D", "2de1be95-3d2e-48e2-b746-caa857f11530");
			put("G", "f0934168-401b-4ba6-8bf4-91c3bccddf13");
			put("C", "a8c8a61e-2ad8-47cf-9c26-3e3b1be33121");
			put("N", "99e56853-e6ba-42aa-bb87-2efb2b99597d");
			put("U", "27aa215a-5d26-403d-878b-e10bea40571c");
			put("P", "d361faf7-6289-42a7-8b99-607aeab9ddfe");
		}
	};
	public CompletableFuture<MRefList_BH> ButtonAction(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getButtonAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BUTTONACTION_UUIDS_BY_VALUE.get(entity.getButtonAction()));
	}

	/**
	 * Get Button Help Text.
	 *
	 * @return The text displayed when a user hovers over the button
	 */
	public CompletableFuture<String> ButtonHelpText(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getButtonHelpText);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_TrlDataLoader.DATALOADER_BH_TabNavBtn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtn.COLUMNNAME_ButtonHelpText));
	}

	static Map<String, String> BUTTONLOCATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "d9a8be83-c8fc-4042-9077-cb4a598c2a6f");
			put("M", "8f67d9bb-ff36-4927-bc37-ec274ff9fd59");
			put("R", "44d32f3a-c423-42d9-b028-1569133ebfa9");
			put("F", "59ab2ede-baed-4adf-9ca5-e5f932a03f4c");
		}
	};
	public CompletableFuture<MRefList_BH> ButtonLocation(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getButtonLocation())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BUTTONLOCATION_UUIDS_BY_VALUE.get(entity.getButtonLocation()));
	}

	/**
	 * Get Button Text.
	 *
	 * @return The text displayed in the button
	 */
	public CompletableFuture<String> ButtonText(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getButtonText);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_TrlDataLoader.DATALOADER_BH_TabNavBtn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtn.COLUMNNAME_ButtonText));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_TrlDataLoader.DATALOADER_BH_TabNavBtn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtn.COLUMNNAME_Description));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MTabNavBtn entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_TrlDataLoader.DATALOADER_BH_TabNavBtn_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtn.COLUMNNAME_Name));
	}

}
