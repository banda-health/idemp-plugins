package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetDisposed;

/**
 * Data Loader for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_DisposedDataLoader extends PODataLoader<MAssetDisposed> {
	public static String DATALOADER_A_Asset_Disposed_BY_ID = "A_Asset_DisposedByIdDataLoader";
	public static String DATALOADER_A_Asset_Disposed_BY_UUID = "A_Asset_DisposedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetDisposed.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Disposed_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Disposed_BY_UUID;
	}
}
