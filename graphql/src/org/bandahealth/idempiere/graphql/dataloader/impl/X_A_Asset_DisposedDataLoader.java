package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetDisposed;

/**
 * Data Loader for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DisposedDataLoader extends PODataLoader<MAssetDisposed> {
	public static String A_Asset_Disposed_BY_ID_DATA_LOADER = "A_Asset_DisposedByIdDataLoader";
	public static String A_Asset_Disposed_BY_UUID_DATA_LOADER = "A_Asset_DisposedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetDisposed.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Disposed_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Disposed_BY_UUID_DATA_LOADER;
	}
}
