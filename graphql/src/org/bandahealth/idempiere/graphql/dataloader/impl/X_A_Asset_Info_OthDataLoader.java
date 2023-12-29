package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Info_Oth;

/**
 * Data Loader for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_OthDataLoader extends PODataLoader<X_A_Asset_Info_Oth> {
	public static String A_Asset_Info_Oth_BY_ID_DATA_LOADER = "A_Asset_Info_OthByIdDataLoader";
	public static String A_Asset_Info_Oth_BY_UUID_DATA_LOADER = "A_Asset_Info_OthByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Oth.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Info_Oth_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Info_Oth_BY_UUID_DATA_LOADER;
	}
}
