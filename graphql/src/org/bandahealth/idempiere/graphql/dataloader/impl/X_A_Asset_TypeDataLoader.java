package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetType;

/**
 * Data Loader for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_TypeDataLoader extends PODataLoader<MAssetType> {
	public static String A_Asset_Type_BY_ID_DATA_LOADER = "A_Asset_TypeByIdDataLoader";
	public static String A_Asset_Type_BY_UUID_DATA_LOADER = "A_Asset_TypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Type_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Type_BY_UUID_DATA_LOADER;
	}
}
