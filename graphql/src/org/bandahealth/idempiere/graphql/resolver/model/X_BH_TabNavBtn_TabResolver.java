package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_TabNavBtnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_TabNavBtn_Tab_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTab;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_TabNavBtn_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_TabNavBtn_TabResolver extends POResolver<MTabNavBtnTab> implements GraphQLResolver<MTabNavBtnTab> {



	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	public CompletableFuture<MTab> AD_Tab(MTabNavBtnTab entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tab_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_ID);
		return dataLoader.load(entity.getAD_Tab_ID());
	}


	/**
	 * Get Tab Navigation Button.
	 *
	 * @return Tab Navigation Button
	 */
	public CompletableFuture<MTabNavBtn> BH_TabNavBtn(MTabNavBtnTab entity, DataFetchingEnvironment environment) {
		if (entity.getBH_TabNavBtn_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTabNavBtn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_TabNavBtnDataLoader.DATALOADER_BH_TabNavBtn_BY_ID);
		return dataLoader.load(entity.getBH_TabNavBtn_ID());
	}

	/**
	 * Get Button Help Text.
	 *
	 * @return The text displayed when a user hovers over the button
	 */
	public CompletableFuture<String> ButtonHelpText(MTabNavBtnTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getButtonHelpText);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_Tab_TrlDataLoader.DATALOADER_BH_TabNavBtn_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtnTab.COLUMNNAME_ButtonHelpText));
	}

	static Map<String, String> BUTTONLOCATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "d9a8be83-c8fc-4042-9077-cb4a598c2a6f");
			put("M", "8f67d9bb-ff36-4927-bc37-ec274ff9fd59");
			put("R", "44d32f3a-c423-42d9-b028-1569133ebfa9");
			put("F", "59ab2ede-baed-4adf-9ca5-e5f932a03f4c");
		}
	};
	public CompletableFuture<MRefList_BH> ButtonLocation(MTabNavBtnTab entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getButtonLocation())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(BUTTONLOCATION_UUIDS_BY_VALUE.get(entity.getButtonLocation()));
	}

	/**
	 * Get Button Text.
	 *
	 * @return The text displayed in the button
	 */
	public CompletableFuture<String> ButtonText(MTabNavBtnTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getButtonText);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_Tab_TrlDataLoader.DATALOADER_BH_TabNavBtn_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtnTab.COLUMNNAME_ButtonText));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MTabNavBtnTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_Tab_TrlDataLoader.DATALOADER_BH_TabNavBtn_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtnTab.COLUMNNAME_Description));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MTabNavBtnTab entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TabNavBtn_Tab_TrlDataLoader.DATALOADER_BH_TabNavBtn_Tab_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MTabNavBtnTab.COLUMNNAME_Name));
	}

}
