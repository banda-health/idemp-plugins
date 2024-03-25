package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDashboardPreference;

/**
 * Data Loader for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardPreferenceDataLoader extends PODataLoader<MDashboardPreference> {
	public static String DATALOADER_PA_DashboardPreference_BY_ID = "PA_DashboardPreferenceByIdDataLoader";
	public static String DATALOADER_PA_DashboardPreference_BY_UUID = "PA_DashboardPreferenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDashboardPreference.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_DashboardPreference_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_DashboardPreference_BY_UUID;
	}
}
