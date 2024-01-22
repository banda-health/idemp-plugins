package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPreference;

/**
 * Data Loader for AD_Preference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PreferenceDataLoader extends PODataLoader<MPreference> {
	public static String DATALOADER_AD_Preference_BY_ID = "AD_PreferenceByIdDataLoader";
	public static String DATALOADER_AD_Preference_BY_UUID = "AD_PreferenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPreference.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Preference_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Preference_BY_UUID;
	}
}
