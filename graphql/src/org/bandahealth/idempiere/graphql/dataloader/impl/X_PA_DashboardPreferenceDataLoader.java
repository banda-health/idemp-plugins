package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDashboardPreference;

/**
 * Data Loader for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardPreferenceDataLoader extends PODataLoader<MDashboardPreference> {
	public static String PA_DashboardPreference_BY_ID_DATA_LOADER = "PA_DashboardPreferenceByIdDataLoader";
	public static String PA_DashboardPreference_BY_UUID_DATA_LOADER = "PA_DashboardPreferenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDashboardPreference.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_DashboardPreference_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_DashboardPreference_BY_UUID_DATA_LOADER;
	}
}
