package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLanguage;

/**
 * Data Loader for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LanguageDataLoader extends PODataLoader<MLanguage> {
	public static String DATALOADER_AD_Language_BY_ID = "AD_LanguageByIdDataLoader";
	public static String DATALOADER_AD_Language_BY_UUID = "AD_LanguageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLanguage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Language_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Language_BY_UUID;
	}
}
