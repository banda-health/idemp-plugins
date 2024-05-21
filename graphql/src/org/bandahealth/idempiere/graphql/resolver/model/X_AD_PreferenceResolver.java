package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AllUsers_VDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MForm;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MPreference;
import org.compiere.model.MWindow;
import org.compiere.model.X_AD_AllUsers_V;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Preference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PreferenceResolver extends POResolver<MPreference> implements GraphQLResolver<MPreference> {



	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public CompletableFuture<MForm> AD_Form(MPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Form_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MForm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FormDataLoader.DATALOADER_AD_Form_BY_ID);
		return dataLoader.load(entity.getAD_Form_ID());
	}


	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(MPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() < 0) {
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
	public CompletableFuture<MProcess_BH> AD_Process(MPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<X_AD_AllUsers_V> AD_User(MPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_AllUsers_V> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AllUsers_VDataLoader.DATALOADER_AD_AllUsers_V_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	static Map<String, String> PREFERENCEFOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("W", "d16e365d-8cc1-489e-b909-89054fdf58af");
			put("P", "a9497c99-06dd-40ab-b866-b37d3fb60bc7");
			put("X", "0b1e6c9b-2cc6-4a53-bb47-42dee6f1105d");
			put("I", "4e05c125-8a96-4a0c-8e7a-57781c141f3a");
		}
	};
	public CompletableFuture<MRefList_BH> PreferenceFor(MPreference entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPreferenceFor())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PREFERENCEFOR_UUIDS_BY_VALUE.get(entity.getPreferenceFor()));
	}

}
