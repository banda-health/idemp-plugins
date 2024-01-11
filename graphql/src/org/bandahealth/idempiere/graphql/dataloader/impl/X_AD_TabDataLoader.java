package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTab;

/**
 * Data Loader for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TabDataLoader extends PODataLoader<MTab> {
	public static String AD_Tab_BY_ID_DATA_LOADER = "AD_TabByIdDataLoader";
	public static String AD_Tab_BY_UUID_DATA_LOADER = "AD_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTab.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Tab_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Tab_BY_UUID_DATA_LOADER;
	}
}
