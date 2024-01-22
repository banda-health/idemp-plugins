package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MUserPreference_BH;

/**
 * Data Loader for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserPreferenceDataLoader extends PODataLoader<MUserPreference_BH> {
	public static String DATALOADER_AD_UserPreference_BY_ID = "AD_UserPreferenceByIdDataLoader";
	public static String DATALOADER_AD_UserPreference_BY_UUID = "AD_UserPreferenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserPreference_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserPreference_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserPreference_BY_UUID;
	}
}
