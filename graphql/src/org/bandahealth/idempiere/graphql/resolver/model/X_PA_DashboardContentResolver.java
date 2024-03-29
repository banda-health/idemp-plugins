package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChartDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StatusLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardContent_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_GoalDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChart;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MGoal;
import org.compiere.model.MStatusLine;
import org.compiere.model.MWindow;
import org.compiere.model.PO;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContentResolver extends POResolver<MDashboardContent> implements GraphQLResolver<MDashboardContent> {



	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	public CompletableFuture<MChart> AD_Chart(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Chart_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChart> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ChartDataLoader.DATALOADER_AD_Chart_BY_ID);
		return dataLoader.load(entity.getAD_Chart_ID());
	}


	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Status Line.
	 *
	 * @return Status Line
	 */
	public CompletableFuture<MStatusLine> AD_StatusLine(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_StatusLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStatusLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StatusLineDataLoader.DATALOADER_AD_StatusLine_BY_ID);
		return dataLoader.load(entity.getAD_StatusLine_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_DashboardContent_TrlDataLoader.DATALOADER_PA_DashboardContent_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MDashboardContent.COLUMNNAME_Description) :
						entity.getDescription());
	}

	static Map<String, String> GOALDISPLAY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "2cd129ed-3973-4e05-a770-94af63a68791");
			put("C", "4b2f72dc-2ab6-4e4a-9b9a-acf550d12290");
			put("G", "38f8439b-0232-4ea6-9e3f-98574b2b7326");
		}
	};
	public CompletableFuture<MRefList_BH> GoalDisplay(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getGoalDisplay())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(GOALDISPLAY_UUIDS_BY_VALUE.get(entity.getGoalDisplay()));
	}

	/**
	 * Get HTML.
	 *
	 * @return HTML
	 */
	public CompletableFuture<String> HTML(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHTML);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_DashboardContent_TrlDataLoader.DATALOADER_PA_DashboardContent_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MDashboardContent.COLUMNNAME_HTML) :
						entity.getHTML());
	}

	public Boolean IsCollapsedByDefault(MDashboardContent entity, DataFetchingEnvironment environment) {
		return entity.isCollapsedByDefault();
	}

	public Boolean IsCollapsible(MDashboardContent entity, DataFetchingEnvironment environment) {
		return entity.isCollapsible();
	}

	public Boolean IsEmbedReportContent(MDashboardContent entity, DataFetchingEnvironment environment) {
		return entity.isEmbedReportContent();
	}

	public Boolean IsMaximizable(MDashboardContent entity, DataFetchingEnvironment environment) {
		return entity.isMaximizable();
	}

	public Boolean IsShowInDashboard(MDashboardContent entity, DataFetchingEnvironment environment) {
		return entity.isShowInDashboard();
	}

	public Boolean IsShowinLogin(MDashboardContent entity, DataFetchingEnvironment environment) {
		return entity.isShowinLogin();
	}

	public Boolean IsShowTitle(MDashboardContent entity, DataFetchingEnvironment environment) {
		return entity.isShowTitle();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_DashboardContent_TrlDataLoader.DATALOADER_PA_DashboardContent_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MDashboardContent.COLUMNNAME_Name) :
						entity.getName());
	}


	/**
	 * Get Goal.
	 *
	 * @return Performance Goal
	 */
	public CompletableFuture<MGoal> PA_Goal(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Goal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MGoal> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_GoalDataLoader.DATALOADER_PA_Goal_BY_ID);
		return dataLoader.load(entity.getPA_Goal_ID());
	}

}
