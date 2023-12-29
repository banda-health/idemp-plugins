package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductDownload;

/**
 * Data Loader for M_ProductDownload - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductDownloadDataLoader extends PODataLoader<MProductDownload> {
	public static String M_ProductDownload_BY_ID_DATA_LOADER = "M_ProductDownloadByIdDataLoader";
	public static String M_ProductDownload_BY_UUID_DATA_LOADER = "M_ProductDownloadByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductDownload.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ProductDownload_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ProductDownload_BY_UUID_DATA_LOADER;
	}
}
