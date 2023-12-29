package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLanguage;

/**
 * Data Loader for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LanguageDataLoader extends PODataLoader<MLanguage> {
	public static String AD_Language_BY_ID_DATA_LOADER = "AD_LanguageByIdDataLoader";
	public static String AD_Language_BY_UUID_DATA_LOADER = "AD_LanguageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLanguage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Language_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Language_BY_UUID_DATA_LOADER;
	}
}
