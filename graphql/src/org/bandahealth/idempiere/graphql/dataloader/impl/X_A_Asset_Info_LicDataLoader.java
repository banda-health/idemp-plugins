package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Info_Lic;

/**
 * Data Loader for A_Asset_Info_Lic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_LicDataLoader extends PODataLoader<X_A_Asset_Info_Lic> {
	public static String A_Asset_Info_Lic_BY_ID_DATA_LOADER = "A_Asset_Info_LicByIdDataLoader";
	public static String A_Asset_Info_Lic_BY_UUID_DATA_LOADER = "A_Asset_Info_LicByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Lic.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Info_Lic_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Info_Lic_BY_UUID_DATA_LOADER;
	}
}
