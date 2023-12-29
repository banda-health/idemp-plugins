package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Info_Ins;

/**
 * Data Loader for A_Asset_Info_Ins - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_InsDataLoader extends PODataLoader<X_A_Asset_Info_Ins> {
	public static String A_Asset_Info_Ins_BY_ID_DATA_LOADER = "A_Asset_Info_InsByIdDataLoader";
	public static String A_Asset_Info_Ins_BY_UUID_DATA_LOADER = "A_Asset_Info_InsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Ins.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Info_Ins_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Info_Ins_BY_UUID_DATA_LOADER;
	}
}
