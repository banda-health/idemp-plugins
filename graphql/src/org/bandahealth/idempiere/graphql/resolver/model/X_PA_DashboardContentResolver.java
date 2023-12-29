package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChartDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_GoalDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChart;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MGoal;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
import org.compiere.model.MWindow;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ChartDataLoader.AD_Chart_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Chart_ID());
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
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.AD_Process_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<MRole> AD_Role(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRole> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.AD_Role_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Role_ID());
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
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.AD_Window_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	static Map<String, String> GOALDISPLAY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MDashboardContent.GOALDISPLAY_HTMLTable, "2cd129ed-3973-4e05-a770-94af63a68791");
			put(MDashboardContent.GOALDISPLAY_Chart, "4b2f72dc-2ab6-4e4a-9b9a-acf550d12290");
		}
	};
	public CompletableFuture<MRefList> GoalDisplay_RL(MDashboardContent entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getGoalDisplay())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(GOALDISPLAY_UUIDS_BY_VALUE.get(entity.getGoalDisplay()));
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
				environment.getDataLoaderRegistry().getDataLoader(X_PA_GoalDataLoader.PA_Goal_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_Goal_ID());
	}

}
