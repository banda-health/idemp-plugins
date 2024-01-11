package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPreference;

/**
 * Data Loader for AD_Preference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PreferenceDataLoader extends PODataLoader<MPreference> {
	public static String AD_Preference_BY_ID_DATA_LOADER = "AD_PreferenceByIdDataLoader";
	public static String AD_Preference_BY_UUID_DATA_LOADER = "AD_PreferenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPreference.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Preference_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Preference_BY_UUID_DATA_LOADER;
	}
}
